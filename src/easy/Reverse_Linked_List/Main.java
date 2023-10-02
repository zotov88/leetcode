package easy.Reverse_Linked_List;

public class Main {
    public static void main(String[] args) {
        Node list = new Node();
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(reverseList(list));
    }

    private static Node reverseList(Node list) {
        Node result = null;
        while (list != null) {
            Node tmp = list.next;
            list.next = result;
            result = list;
            list = tmp;
        }
        return result;
    }
}
