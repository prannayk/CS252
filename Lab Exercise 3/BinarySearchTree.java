import java.util.*;
import java.lang.*;

class BinarySearchTree extends Object {
    int size;
    Node root;
    private class Node {
        int key;
        String value;
        Node leftChild;
        Node rightChild;

        Node (int key, String value){
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public String toString() {
            return "" + this.key;
        }
        public int getKey(){
            return this.key;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }
    public BinarySearchTree(){
        this.size = 0;
        root = null;
    }
    public void addNode(int key, String value){
        Node t = this.root;
        this.size++;
        boolean flag = true;
        if (this.root == null){   
            root = new Node(key, value);
            return ;
        }
        while (flag){
            if (key < t.getKey()) {
                if (t.leftChild == null){
                    t.leftChild = new Node(key, value);
                    flag = !flag;
                } else {
                    t = t.leftChild;
                }
            } else if (key > t.getKey()) {
                if (t.rightChild == null){
                    t.rightChild = new Node(key, value);
                    flag = !flag;
                } else {
                    t = t.rightChild;
                }
            } else {
                t.setValue(value);
                flag = !flag;
            }
        }
    }
    public Node getReplacementNode(Node n) {
        Node rchild = n.rightChild;
        Node p = n;
        while (rchild.rightChild != null){
            p = rchild;
            rchild = rchild.rightChild;
        }
        p.rightChild=rchild.rightChild;
        return rchild;
    }
    public Node findNode(int key){
        Node t = this.root;
        while (key != t.getKey()){
            if(key < t.getKey())    t = t.leftChild;
            else    t=t.rightChild;
        }
        return t;
    }
    public void remove(int key){
        Node t = this.root;
        Node p = null;
        while (key != t.getKey()){
            p = t;
            if(key < t.getKey())    t = t.leftChild;
            else    t=t.rightChild;
        }
        if ((t.rightChild != null) && (t.leftChild != null)){
            Node r = this.getReplacementNode(t);
            r.leftChild = t.leftChild;
            r.rightChild = t.rightChild;
            if(p.rightChild == t)   p.rightChild = r;
            else    p.leftChild = r;
        } else if (t.leftChild != null) {
            if(p.rightChild == t)   p.rightChild = t.leftChild;
            else    p.leftChild = t.leftChild; 
        } else {
            if(p.rightChild == t)   p.rightChild = t.rightChild;
            else    p.leftChild = t.rightChild;
            
        }
    }
    public void inOrderTraversal(){
        this.inOrder(this.root);
    }
    public void inOrder(Node n){
        if (n == null) return;
        this.inOrder(n.leftChild);
        System.out.println(n.toString());
        this.inOrder(n.rightChild);
    }
    public void reverseInOrderTraversal(){
        this.rinOrder(this.root);
    }
    public void rinOrder(Node n){
        if (n == null) return;
        this.rinOrder(n.rightChild);
        System.out.println(n.toString());
        this.rinOrder(n.leftChild);
    }
    public void preOrderTraversal(){
        this.preOrder(this.root);
    }
    public void preOrder(Node n){
        if (n == null) return;
        System.out.println(n.toString());
        this.preOrder(n.leftChild);
        this.preOrder(n.rightChild);
    }
    public void postOrderTraversal(){
        this.postOrder(this.root);
    }
    public void postOrder(Node n){
        if (n == null) return;
        this.postOrder(n.leftChild);
        this.postOrder(n.rightChild);
        System.out.println(n.toString());
    }
    public static void main(String[] args){
        BinarySearchTree T = new BinarySearchTree();
        T.addNode(13,"sdf");
        T.addNode(4, "sdf");
        T.addNode(57,"ads");
        T.addNode(1,"asd");
        T.addNode(7, "asdf");
        T.addNode(84,"asd");
        T.addNode(34,"as");
        T.inOrderTraversal();
        System.out.println("Pre:");
        T.preOrderTraversal();
        System.out.println("Post:");
        T.postOrderTraversal();
        System.out.println("RevOrder:");
        T.reverseInOrderTraversal();
    }
}
