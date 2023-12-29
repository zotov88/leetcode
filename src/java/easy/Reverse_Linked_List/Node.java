package java.easy.Reverse_Linked_List;

public class Node {

    int val;

    Node next;

    private boolean start = false;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public void add(int val) {
        if (!start) {
            this.val = val;
            start = true;
        } else {
            Node node = new Node(val);
            Node tmp = this;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        Node tmp = this;
        while (tmp != null) {
            sb.append(tmp.val);
            sb.append(tmp.next != null ? ", " : "]");
            tmp = tmp.next;
        }
        return sb.toString();
    }
}

