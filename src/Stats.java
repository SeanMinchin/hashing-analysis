import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Stats {
    private List<Float> loads;
    private List<Integer> collisions;
    private int totalCollisions;
    private static Set<String> loadValuesToPrint;

    static {
        loadValuesToPrint = Set.of("0.05", "0.10", "0.15", "0.20", "0.25", "0.30", "0.35", "0.40", "0.45", "0.50",
                "0.65", "0.70", "0.75", "0.80", "0.85", "0.90", "0.95");
    }

    public Stats(int capacity) {
        loads = new ArrayList<>(capacity);
        collisions = new ArrayList<>(capacity);
        totalCollisions = 0;
    }

    public void setStats(float loadFactor) {
        loads.add(loadFactor);
        collisions.add(totalCollisions);
    }

    public void updateTotalCollisions() {
        ++totalCollisions;
    }

    public List<Float> getLoads() {
        return loads;
    }

    public List<Integer> getCollisions() {
        return collisions;
    }

    public void print() {
        String prevVal = "a";
        for(int i = 0; i < loads.size(); ++i) {
            Float f = getLoads().get(i);
            String val;
            if(f.toString().length() > 3) {
                val = getLoads().get(i).toString().substring(0, 4);
            } else {
                val = "b";
            }
            if((Stats.loadValuesToPrint.contains(val) || f.equals((float) 1.0)) && !prevVal.equals(val)) {
                System.out.println(getLoads().get(i) + " " + getCollisions().get(i));
                prevVal = val;
            }
        }
    }
}
