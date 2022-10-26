package Arvores.ArvoreBinaria.Java.Recursivo;

public class Node<T extends Comparable<T>> {
    //=====PRIVATE=====//
    private Node<T> left;
    private Node<T> right;
    private T obj;

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
    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getObj() {
        return obj;
    }
    
    //=====SET=====//
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
