public class HashTable {
    private Node[] table;
    private final int capacity;
    private int size;
    private Stats stats;
    private Scheme scheme;

    public enum Scheme {
        SEPARATE_CHAINING,
        OPEN_ADDRESSING
    }

    public HashTable(int capacity, Scheme scheme) {
        table = new Node[capacity];
        stats = new Stats(capacity);
        this.capacity = capacity;
        this.size = 0;
        this.scheme = scheme;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    private float getLoadFactor() {
        return (float)size/(float)capacity;
    }

    public void insert(Node node) {
        if(table[node.value].key == -1) {
            table[node.value] = node;
        } else {
            stats.updateTotalCollisions();
            switch (scheme) {
                case SEPARATE_CHAINING:
                    table[node.value].append(node);
                    break;
                case OPEN_ADDRESSING:
                    for(int i = 0; i < table.length; ++i) {
                        if(table[node.value].key == -1) {
                            table[i] = node;
                        }
                    }
                    break;
            }
        }
        ++size;
        stats.setStats(getLoadFactor());
    }

    public void initialize() {
        for(int i = 0; i < table.length; ++i) {
            table[i] = new Node(-1,-1); // set each table key to -1 for reference/comparison while inserting
        }
    }

    public Stats getStats() {
        return this.stats;
    }
}
