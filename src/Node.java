public class Node {
    public final int key, value;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void append(Node node) {
        Node curr = this;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }
}
