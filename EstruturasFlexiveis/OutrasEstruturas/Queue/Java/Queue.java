package EstruturasFlexiveis.OutrasEstruturas.Queue.Java;

public class Queue<T> {
    //=====PRIVATE=====//
    private Node<T> first;
    private Node<T> last;
    private int length = 0;

    //=====CONSTRUCTORS=====//
    public Queue() {
        this.setFirst(null);
        this.setLast(null);
    }

    @SuppressWarnings("unchecked")
    public Queue(T... arr) {
        for(T obj : arr) 
            enqueue(obj);
    }

    //=====GET=====//
    private Node<T> getFirst() {
        return this.first;
    }

    private Node<T> getLast() {
        return this.last;
    }

    public int size() {
        return this.length;
    }
    
    //=====SET=====//
    private void setFirst(Node<T> first) {
        this.first = first;
    }

    private void setLast(Node<T> last) {
        this.last = last;
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
    
    //=====ENQUEUE=====//
    public void enqueue(T obj) {
        Node<T> node = new Node<>(obj, null);
        
        if(isEmpty()) {
            this.setFirst(node);
            this.setLast(node);
        } else {
            this.getLast().setNext(node);
            this.setLast(node);
        }

        inc();
    }

    //=====DEQUEUE=====//
    public T dequeue() {
        if(isEmpty()) throw new EmptyQueueException();

        T content = this.getFirst().getObj();
        if(this.getFirst() == this.getLast()) {
            this.setFirst(null);
            this.setLast(null);
        } else {
            Node<T> curr = this.getFirst().getNext();
            this.getFirst().setNext(null);
            this.setFirst(curr);
            curr = null;
        }

        dec();
        return content;
    }

    //=====PEEK=====//
    public T peek() {
        return this.getFirst().getObj();
    }

    //=====INVERT=====//
    public void invert() {
        Node<T> curr = this.getLast();

        while(curr != this.getFirst()) {
            curr.setNext(new Node<>(dequeue(), curr.getNext()));
            if(this.getLast() == curr) this.setLast(curr.getNext());
            inc();
        }

        curr = null;
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
