package EstruturasFlexiveis.ListaSimplesmenteEncadeada.Java;

public class LinkedList<T> {
    //=====PRIVATE=====//
    private int length = 0;
    private Node<T> first;
    private Node<T> last;

    //=====CONSTRUCTOR=====//
    public LinkedList() {
        this.setFirst(null);
        this.setLast(null);
    }

    @SuppressWarnings("unchecked")
    public LinkedList(T... arr) {
        for(T obj : arr)
            add(obj);
    }

    //=====GET=====//
    //-----PRIVATE-----//
    private Node<T> getFirst() {
        return this.first;
    }

    private Node<T> getLast() {
        return this.last;
    }

    private Node<T> node(int idx) {
        if(idx < 0 || idx > this.size()) throw new IndexOutOfBoundsException();

        Node<T> curr;
        if(idx == this.size() - 1) curr = this.getLast();
        else {
            curr = this.getFirst();
            int i = 0;  
            while(i < idx) {
                curr = curr.getNext();
                i++;
            }
        }
        
        return curr;
    }

    //-----PUBLIC-----//
    public int size() {
        return this.length;
    }

    public void inc() {
        this.length++;
    }

    public void dec() {
        this.length--;
    }
 
    //=====SET=====//
    private void setFirst(Node<T> first) {
        this.first = first;
    }

    private void setLast(Node<T> last) {
        this.last = last;
    }

    //=====METODOS=====//
    public Boolean isEmpty() {
        return this.size() == 0;
    }

    //=====ADD=====//
    public void add(T obj) {
        Node<T> node = new Node<>(obj);

        if(isEmpty()) {
            this.setFirst(node);
            this.setLast(node);
        } else {
            this.getLast().setNext(node);
            this.setLast(node);
        }
        inc();
    }

    public void add(T obj, int pos) {
        if(pos < 0 || pos > this.size()) throw new IndexOutOfBoundsException();

        if(pos == 0) insert(obj);
        else if(pos == this.size()) add(obj); 
        else {
            Node<T> curr = node(pos - 1); 
            curr.setNext(new Node<>(obj, curr.getNext()));
            curr = null;
            inc();
        }
    }

    //=====INSERT=====//
    public void insert(T obj) {
        Node<T> node = new Node<>(obj, this.getFirst());
        if(isEmpty()) {
            this.setFirst(node);
            this.setLast(node);
        } else this.setFirst(node);
        node = null;
        inc();
    }

    //=====POP=====//
    public T pop() {
        if(isEmpty()) throw new EmptyLinkedListException();

        T content = this.getLast().getObj();
        if(this.getFirst() == this.getLast()) {
            this.setFirst(null);
            this.setLast(null);
        } else {
            Node<T> curr = this.node(this.size() - 2);
            curr.setNext(null);
            this.setLast(curr);
            curr = null;
        }

        dec();
        return content;
    }

    public T pop(int pos) {
        if(pos < 0 || pos >= this.size()) throw new IndexOutOfBoundsException();
        if(isEmpty()) throw new EmptyLinkedListException();

        T content;
        if(pos == 0) content = del();
        else if(pos == this.size() - 1) content = pop();
        else {
            Node<T> curr = this.node(pos - 1);
            Node<T> rem = curr.getNext();
            content = rem.getObj();
            curr.setNext(rem.getNext());
            rem.setNext(null);
            curr = rem = null;
            dec();
        }

        return content;
    }

    public T pop(T obj) {
        if(isEmpty()) throw new EmptyLinkedListException();

        T content = null;
        int pos = this.search(obj);
        if(pos >= 0) content = pop(pos);
        return content;
    }

    //=====DEL=====//
    public T del() {
        if(isEmpty()) throw new EmptyLinkedListException();

        T content = this.getFirst().getObj();
        if(this.getFirst() == this.getLast()) {
            this.setFirst(null);
            this.setLast(null);
        } else {
            Node<T> curr = this.getFirst();
            this.setFirst(curr.getNext());
            curr.setNext(null);
            curr = null;
        }

        dec();
        return content;
    }

    //=====SEARCH=====//
    public int search(T obj) {
        if(isEmpty()) throw new EmptyLinkedListException();

        int i = 0;
        Node<T> curr = this.getFirst();
        if(obj == null) {
            while(curr != null) {
                if(curr.getObj() == null) {
                    curr = null;
                    return i;
                }
                curr = curr.getNext();
                i++;
            }
        } else {
            while(curr != null) {
                if(curr.getObj().equals(obj)) {
                    curr = null;
                    return i;
                }
                curr = curr.getNext();
                i++;
            }
        }

        return -1;
    }

    //=====CONTAINS=====//
    public Boolean contains(T obj) {
        if(isEmpty()) throw new EmptyLinkedListException();

        Boolean value = false;
        Node<T> curr = this.getFirst();
        if(obj == null) {
            while(!value && curr != null) {
                value = curr.getObj() == null;
                curr = curr.getNext();
            }
        } else {
            while(!value && curr != null) {
                value = curr.getObj().equals(obj);
                curr = curr.getNext();
            }
        }

        curr = null;
        return value;
    }

    //=====REPLACE=====//
    public void replace(T obj, T rep) {
        if(isEmpty()) throw new EmptyLinkedListException();
        int pos = this.search(obj);

        if(pos >= 0) this.node(pos).setObj(rep);
    }

    public void replaceAll(T obj, T rep) {
        if(isEmpty()) throw new EmptyLinkedListException();
        int pos = this.search(obj);

        while(pos >= 0) {
            this.node(pos).setObj(rep);
            pos = this.search(obj);
        }
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
        sb.append("]");
        return sb.toString();
    }
}
