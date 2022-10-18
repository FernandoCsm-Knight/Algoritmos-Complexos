package EstruturasFlexiveis.OutrasEstruturas.Stack.Java;

public class Node<T> {
    //=====PRIVATE=====//
    private Node<T> next;
    private T obj;

    //=====CONSTRUCTOR=====//
    public Node() {
        this(null);
    }

    public Node(T obj) {
        this(obj, null);
    }

    public Node(T obj, Node<T> next) {
        this.setObj(obj);
        this.setNext(next);
    }

    //=====GET=====//
    public T getObj() {
        return this.obj;
    }

    public Node<T> getNext() {
        return this.next;
    }

    //=====SET=====//
    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
