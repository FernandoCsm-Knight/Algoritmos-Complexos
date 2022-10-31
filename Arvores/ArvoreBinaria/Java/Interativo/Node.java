package Arvores.ArvoreBinaria.Java.Interativo;

public class Node<T> {
    //=====PRIVATE=====//
    private T obj;
    private Node<T> left;
    private Node<T> right;
    
    //=====CONSTRUCTOR=====//
    public Node() {
        this(null);
    }

    public Node(T obj) {
        this(obj, null, null);
    }

    public Node(T obj, Node<T> left, Node<T> right) {
        this.setObj(obj);
        this.setLeft(left);
        this.setRight(right);
    }

    //=====GET=====//
    public T getObj() {
        return obj;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    //=====SET=====//
    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

}
