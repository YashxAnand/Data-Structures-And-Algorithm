public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(Node head) {
        head.setPrev(null);
        head.setNext(null);
        this.head = head;
        this.tail = head;
        size = 1;
    }

    void addToEnd(Node node) {
        if (size == 1) {
            tail = node;
            tail.next = null;
            tail.prev = head;
            head.next = tail;
            size++;
            return;
        }

        tail.next = node;
        node.setPrev(tail);
        node.setNext(null);
        tail = node;
        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(new Node(23));
        dll.addToEnd(new Node(12));
        dll.addToEnd(new Node(12));
        dll.addToEnd(new Node(12));
        dll.display();
    }
}

class Node {
    int data;
    Node prev, next;

    void setPrev(Node prev) {
        this.prev = prev;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Node(int data) {
        this.data = data;
    }
}