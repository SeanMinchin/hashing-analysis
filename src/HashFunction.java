import java.util.Random;

public class HashFunction {
    private static final Random random;

    static {
        random = new Random();
    }

    public enum Function {
        KEY_MOD_SIZE,
        MID_SQUARE,
    }

    public static void hash(HashTable hashTable, Function f) {
        while(hashTable.getCapacity() != hashTable.getSize()) {
            int key = random.nextInt(3*hashTable.getCapacity());
            int value;
            switch(f) {
                case KEY_MOD_SIZE:
                    value = key % hashTable.getCapacity();
                    hashTable.insert(new Node(key, value));
                    break;
                case MID_SQUARE:
                    String keySquared = String.valueOf(key * key);
                    int middleDigits;
                    if(keySquared.length() == 1 || keySquared.length() == 2) {
                        middleDigits = Integer.valueOf(keySquared);
                    } else {
                        middleDigits = Integer.valueOf(keySquared.substring(1, keySquared.length()-1));
                    }
                    value = middleDigits % hashTable.getCapacity();
                    hashTable.insert(new Node(key, value));
                    break;
            }
        }
    }
}
