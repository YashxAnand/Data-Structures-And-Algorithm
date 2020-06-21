public class LinkedList {
    public static void main(String[] args) {
        Node head = new Node("Yash", "Anand", 123);
        head.insertBack(new Node("Rahul", "Anand", 456));
        head.insertBack(new Node("Akshay", "Anand", 789));
        head = head.insertFront(new Node("Lakshay", "Anand", 789));
        head.insertBack(new Node("Akshay", "Anand", 789));
        // head.display();
        head = head.removeFront();
        head = head.removeFront();
        head.display();
    }
}

class Node {
    Employee data;
    Node next;

    Node(String firstname, String lastname, int id) {
        data = new Employee(firstname, lastname, id);
        next = null;
    }

    void insertBack(Node node) {
        Node temp = this;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
    }

    Node insertFront(Node node) {
        node.next = this;
        return node;
    }

    Node removeEnd() {

        if (this.next == null) {
            return null;
        }

        Node temp = this;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return this;
    }

    Node removeFront() {
        if (this.next == null) {
            return null;
        }

        return this.next;
    }

    void display() {
        Node temp = this;
        while (temp != null) {
            System.out.println(temp.data.getData());
            temp = temp.next;
        }
    }
}

class Employee {
    private String firstname;
    private String lastname;
    private int id;

    Employee(String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    String getData() {
        return "{ Firstname:" + this.firstname + ", Lastname:" + this.lastname + ", ID:" + this.id + " }";
    }
}