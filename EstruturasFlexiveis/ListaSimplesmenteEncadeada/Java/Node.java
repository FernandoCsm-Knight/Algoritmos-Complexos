package EstruturasFlexiveis.ListaSimplesmenteEncadeada.Java;

public class Node<T> {
    //=====PRIVATE=====//
    private T obj;
    private Node<T> next;

    //=====CONSTRUCTORS=====//
    public Node() {
        this(null, null);
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
