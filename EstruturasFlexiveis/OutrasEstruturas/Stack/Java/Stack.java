package EstruturasFlexiveis.OutrasEstruturas.Stack.Java;

public class Stack<T> {
    //=====PRIVATE=====//
    private Node<T> first;
    private int length = 0;

    //=====CONSTRUCTOR=====//
    public Stack() {
        this.setFirst(null);
    }

    @SuppressWarnings("unchecked")
    public Stack(T... arr) {
        for(T obj : arr) 
            this.push(obj);
        invert();
    }

    //=====GET=====//
    private Node<T> getFirst() {
        return this.first;
    }

    public int size() {
        return this.length;
    }

    //=====SET=====//
    private void setFirst(Node<T> first) {
        this.first = first;
    }

    private void inc() {
        this.length++;
    }

    private void dec() {
        this.length--;
    }

    //=====METODOS=====//
    public Boolean isEmpty() {
        return this.size() == 0;
    }

    //=====PUSH=====//
    public void push(T obj) {
        Node<T> node  = new Node<>(obj, this.getFirst());
        this.setFirst(node);
        inc();
    }

    //=====POP=====//
    public T pop() {
        T content = this.getFirst().getObj();
        Node<T> curr = this.getFirst().getNext();
        this.getFirst().setNext(null);
        this.setFirst(curr);
        curr = null;
        dec();
        return content;
    }

    //=====PEEK=====//
    public T peek() {
        return this.getFirst().getObj();
    }

    //=====INVERT=====//
    @SuppressWarnings("unchecked")
    public void invert() {
        Object[] objs = new Object[this.size()];
        
        for(int i = 0; i < objs.length; i++)
            objs[i] = pop();

        for(int i = 0; i < objs.length; i++)
            push((T)objs[i]); 
    }

    //=====OVERRIDE=====//
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node<T> curr = this.getFirst();
        while(curr != null) {
            sb.append(curr.getObj());
            if(curr.getNext() != null) sb.append(", ");
            curr = curr.getNext();
        }
        curr = null;
        return sb.append("]").toString();
    }
}
