package EstruturasFlexiveis.ListaDuplamenteEncadeada.Java;

public class Node<T> {
    //=====PRIVATE=====//
    private T obj;
    private Node<T> next;
    private Node<T> prev;

    //=====CONSTRUCTOR=====//
    public Node() {
        this(null);
    }

    public Node(T obj) {
        this(obj, null);
    }

    public Node(T obj, Node<T> next) {
        this(obj, next, null);
    }

    public Node(T obj, Node<T> next, Node<T> prev) {
        this.setPrev(prev);
        this.setNext(next);
        this.setObj(obj);
    }

    //=====GET=====//
    public T getObj() {
        return obj;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    //=====SET=====//
    public void setObj(T obj) {
        this.obj = obj;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

}
