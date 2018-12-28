public class Main {
    public static void main(String[] args) {
        int size1 = 100; // very composite integer
        int size2 = 337; // prime integer
        int size3 = 10001; // very large prime integer

        HashTable table1_1 = new HashTable(size1, HashTable.Scheme.SEPARATE_CHAINING);
        HashTable table1_2 = new HashTable(size1, HashTable.Scheme.OPEN_ADDRESSING);
        HashTable table2_1 = new HashTable(size2, HashTable.Scheme.SEPARATE_CHAINING);
        HashTable table2_2 = new HashTable(size2, HashTable.Scheme.OPEN_ADDRESSING);
        HashTable table3_1 = new HashTable(size3, HashTable.Scheme.SEPARATE_CHAINING);
        HashTable table3_2 = new HashTable(size3, HashTable.Scheme.OPEN_ADDRESSING);

        table1_1.initialize();
        HashFunction.hash(table1_1, HashFunction.Function.MID_SQUARE);
        Stats a1 = table1_1.getStats(); // size 1, separate chaining, mid square
        table2_1.initialize();
        HashFunction.hash(table2_1, HashFunction.Function.MID_SQUARE);
        Stats a2 = table2_1.getStats(); // size 2, separate chaining, mid square
        table3_1.initialize();
        HashFunction.hash(table3_1, HashFunction.Function.MID_SQUARE);
        Stats a3 = table3_1.getStats(); // size 3, separate chaining, mid square

        table1_1.initialize();
        HashFunction.hash(table1_1, HashFunction.Function.KEY_MOD_SIZE);
        Stats b1 = table1_1.getStats(); // size 1, separate chaining, key mod size
        table2_1.initialize();
        HashFunction.hash(table2_1, HashFunction.Function.KEY_MOD_SIZE);
        Stats b2 = table2_1.getStats(); // size 2, separate chaining, key mod size
        table3_1.initialize();
        HashFunction.hash(table3_1, HashFunction.Function.KEY_MOD_SIZE);
        Stats b3 = table3_1.getStats(); // size 3, separate chaining, key mod size

        table1_2.initialize();
        HashFunction.hash(table1_2, HashFunction.Function.MID_SQUARE);
        Stats c1 = table1_2.getStats(); // size 1, open addressing, mid square
        table2_2.initialize();
        HashFunction.hash(table2_2, HashFunction.Function.MID_SQUARE);
        Stats c2 = table2_2.getStats(); // size 2, open addressing, mid square
        table3_2.initialize();
        HashFunction.hash(table3_2, HashFunction.Function.MID_SQUARE);
        Stats c3 = table3_2.getStats(); // size 3, open addressing, mid square

        table1_2.initialize();
        HashFunction.hash(table1_2, HashFunction.Function.KEY_MOD_SIZE);
        Stats d1 = table1_2.getStats(); // size 1, open addressing, key mod size
        table2_2.initialize();
        HashFunction.hash(table2_2, HashFunction.Function.KEY_MOD_SIZE);
        Stats d2 = table2_2.getStats(); // size 2, open addressing, key mod size
        table3_2.initialize();
        HashFunction.hash(table3_2, HashFunction.Function.KEY_MOD_SIZE);
        Stats d3 = table3_2.getStats(); // size 3, open addressing, key mod size

        /*
        a: chaining, mid square
        b: chaining, key mod size
        c: addressing, mid square
        d: addressing, key mod size
         */
        System.out.println("condition A");
        a1.print();
        a2.print();
        a3.print();

        System.out.println("condition B");
        b1.print();
        b2.print();
        b3.print();

        System.out.println("condition C");
        c1.print();
        c2.print();
        c3.print();

        System.out.println("condition D");
        d1.print();
        d2.print();
        d3.print();
    }
}
