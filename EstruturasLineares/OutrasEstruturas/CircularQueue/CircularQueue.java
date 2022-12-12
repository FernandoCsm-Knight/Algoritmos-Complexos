package EstruturasLineares.OutrasEstruturas.CircularQueue;

public class CircularQueue<T> {
    //=====PRIVATE=====//
    private T[] queue;
    private int first = 0;
    private int length = 0;

    //=====CONSTRUCTOR=====//
    public CircularQueue() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public CircularQueue(int cap) {
        this.queue = (T[])new Object[cap];
    }

    public CircularQueue(T[] arr) {
        this.setQueue(arr);
    }

    //=====SET=====//
    //-----PRIVATE-----//
    private void set(T obj, int p) {
        this.queue[p] = obj;
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void inc() {
        this.length++;
    }

    private void dec() {
        this.length--;
    }

    private void setFirst(int i) {
        this.first = i;
    }

    private void setQueue(T[] arr) {
        this.queue = arr;
    }

    //=====GET=====//
    //-----PRIVATE-----//
    private int getFirst() {
        return this.first;
    }

    private int capacity() {
        return this.queue.length;
    }

    private T get(int p) {
        return this.queue[p];
    }

    //-----PUBLIC-----//
    public int size() {
        return this.length;
    }

    //=====METODOS=====//
    public Boolean isEmpty() {
        return this.size() == 0;
    }

    public Boolean isFull() {
        return this.size() == this.capacity();
    }

    //-----ENQUEUE-----//
    public void enqueue(T obj) {
        if(this.isFull()) 
            throw new ArrayIndexOutOfBoundsException();
            
        this.set(obj, (this.getFirst() + this.size()) % this.capacity());
        this.inc();
    }

    //-----DEQUEUE-----//
    public T dequeue() {
        if(this.isEmpty()) throw new EmptyQueueException();

        T aux = this.peek();
        this.setFirst((this.getFirst() + 1) % this.capacity());
        this.dec();
        return aux;
    }
    
    //-----PEEK-----//
    public T peek() {
        return this.get(this.getFirst());
    }

    //=====SEARCH=====//
    public int search(T obj) {
        if(obj == null) {
            for(int i = 0; i < this.size(); i++) 
                if(this.get((this.getFirst() + i) % this.capacity()) == null) 
                    return i;
        } else {
            for(int i = 0; i < this.size(); i++) 
                if(obj.equals(this.get((this.getFirst() + i) % this.capacity()))) 
                    return i;
        }
        return -1;
    }

    //=====CONTAINS=====//
    public Boolean contains(T obj) {
        Boolean value = false;
        int i = 0;
        if(obj == null) {
            while(i < this.size() && !value) {
                value = this.get((this.getFirst() + i) % this.capacity()) == null;
                i++;
            }
        } else {
            while(i < this.size() && !value) {
                value = obj.equals(this.get((this.getFirst() + i) % this.capacity()));
                i++;
            }
        }
        return value;
    }

    //=====CLEAR=====//
    public void clear() {
        this.setFirst(0);
        this.setLength(0);
        for(int i = 0; i < this.capacity(); i++) 
            this.set(null, i);
    }

    //=====OVERRIDE=====//
    @Override
    public String toString() {
        String s = "[";
        for(int i = 0; i < this.size(); i++) {
            s += this.get((this.getFirst() + i) % this.capacity());
            if(i + 1 != this.size()) s += ", ";
        } s += "]";
        return s;
    }

} 
