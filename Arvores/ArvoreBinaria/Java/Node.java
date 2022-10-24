package Arvores.ArvoreBinaria.Java;

public class Node {
    //=====PRIVATE=====//
    private Node left;
    private Node right;
    private int obj;

    //=====CONSTRUCTOR=====//
    public Node() {
        this(null);
    }

    public Node(Integer obj) {
        this(obj, null, null);
    }

    public Node(Integer obj, Node left, Node right) {
        this.setObj(obj);
        this.setLeft(left);
        this.setRight(right);
    }
    
    //=====GET=====// 
    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Integer getObj() {
        return obj;
    }
    
    //=====SET=====//
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

}
