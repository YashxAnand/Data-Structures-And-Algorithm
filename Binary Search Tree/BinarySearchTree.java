public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
        return;
    }

    public void insertNode(Node root, Node node) {

        if (node.data <= root.data) {
            if (root.leftChild == null) {
                root.leftChild = node;
                return;
            }
            this.insertNode(root.leftChild, node);
            return;
        }

        if (root.rightChild == null) {
            root.rightChild = node;
            return;
        }
        this.insertNode(root.rightChild, node);
    }

    public void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> ");
        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);
    }

    public void inorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.leftChild);
        System.out.print(root.data + " -> ");
        inorderTraversal(root.rightChild);
    }

    public void postorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        postorderTraversal(root.leftChild);
        postorderTraversal(root.rightChild);
        System.out.print(root.data + " -> ");
    }

    void findMax(Node root) {
        if (root.rightChild == null) {
            System.out.println(root.data);
            return;
        }

        findMax(root.rightChild);
    }

    void findMin(Node root) {
        if (root.leftChild == null) {
            System.out.println(root.data);
            return;
        }

        findMin(root.leftChild);
    }

    Node findMaxNode(Node root) {

        if (root.rightChild == null) {
            return root;
        }

        return findMaxNode(root.rightChild);
    }

    Node delete(Node root, int data) {
        if (root == null) {
            System.out.println("Node not found");
            return null;
        }

        if (root.data == data) {
            if (root.leftChild == null && root.rightChild == null) {
                return null;
            } else {
                if (root.rightChild != null && root.leftChild == null) {
                    return root.rightChild;
                } else if (root.leftChild != null && root.rightChild == null) {
                    return root.leftChild;
                } else {
                    root.data = findMaxNode(root.leftChild).data;
                    root.setLeftChild(delete(root.leftChild, root.data));
                    return root;
                }
            }
        } else if (root.data < data) {
            root.setRightChild(delete(root.rightChild, data));
        } else {
            root.setLeftChild(delete(root.leftChild, data));
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(new Node(14));
        bst.insertNode(bst.getRoot(), new Node(16));
        bst.insertNode(bst.getRoot(), new Node(18));
        bst.insertNode(bst.getRoot(), new Node(15));
        bst.insertNode(bst.getRoot(), new Node(10));
        bst.insertNode(bst.getRoot(), new Node(7));
        bst.insertNode(bst.getRoot(), new Node(8));
        bst.insertNode(bst.getRoot(), new Node(13));
        bst.insertNode(bst.getRoot(), new Node(16));
        bst.insertNode(bst.getRoot(), new Node(34));
        bst.insertNode(bst.getRoot(), new Node(1));
        bst.insertNode(bst.getRoot(), new Node(116));
        bst.insertNode(bst.getRoot(), new Node(10));
        bst.insertNode(bst.getRoot(), new Node(9));
        bst.setRoot(bst.delete(bst.getRoot(), 10));
        bst.preorderTraversal(bst.getRoot());
    }
}

class Node {
    int data;
    Node leftChild, rightChild;

    public Node(int data) {
        this.data = data;
    }

    void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}