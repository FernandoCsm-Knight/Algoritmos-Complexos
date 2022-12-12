package EstruturasFlexiveis.OutrasEstruturas.Matrix.Java;

public class Node<T> {
    //=====PRIVATE=====//
    private T obj;
    private Node<T> top;
    private Node<T> bottom;
    private Node<T> left;
    private Node<T> right;

    //=====CONSTRUCTOR=====//
    public Node() {
        this(null);
    }

    public Node(T obj) {
        this(obj, null, null, null, null);
    }

    public Node(T obj, Node<T> top, Node<T> bottom, Node<T> left, Node<T> right) {
        this.setObj(obj);
        this.setTop(top);
        this.setBottom(bottom);
        this.setLeft(left);
        this.setRight(right);
    }

    //=====GET=====//
    public T getObj() {
        return obj;
    }
    
    public Node<T> getTop() {
        return top;
    }

    public Node<T> getBottom() {
        return bottom;
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
    
    public void setTop(Node<T> top) {
        this.top = top;
    }

    public void setBottom(Node<T> bottom) {
        this.bottom = bottom;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
    
}
