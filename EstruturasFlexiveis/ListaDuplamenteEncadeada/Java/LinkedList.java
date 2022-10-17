package EstruturasFlexiveis.ListaDuplamenteEncadeada.Java;

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
    private Node<T> node(int idx) {
        Node<T> curr;

        if(idx < this.size() / 2) {
            curr = this.getFirst();
            int i = 0;
            while(i < idx) {
                curr = curr.getNext();
                i++;
            }
        } else {
            curr = this.getLast();
            int i = this.size() - 1;
            while(i > idx) {
                curr = curr.getPrev();
                i--;
            }
        }

        return curr;
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public Node<T> getLast() {
        return this.last;
    }

    public int size() {
        return this.length;
    }



    //=====SET=====//
    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public void inc() {
        this.length++;
    }

    public void dec() {
        this.length--;
    }

    //=====METODOS=====//
    public Boolean isEmpty() {
        return this.length == 0;
    }

    //=====ADD=====//
    public void add(T obj) {
        Node<T> node = new Node<>(obj, null, this.getLast());
        
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
            Node<T> curr = node(pos);
            Node<T> node = new Node<>(obj, curr, curr.getPrev());
            curr.getPrev().setNext(node);
            curr.setPrev(node);
            curr = node = null;
            inc();
        }
    }

    //=====INSERT=====//
    public void insert(T obj) {
        Node<T> node = new Node<>(obj, this.getFirst());

        if(isEmpty()) {
            this.setFirst(node);
            this.setLast(node);
        } else {
            this.getFirst().setPrev(node);
            this.setFirst(node);
        }

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
            this.setLast(this.getLast().getPrev());
            this.getLast().getNext().setPrev(null);
            this.getLast().setNext(null);
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
            Node<T> curr = node(pos);
            content = curr.getObj();
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
            curr.setNext(null);
            curr.setPrev(null);
            curr = null;
            dec();
        }
        
        return content;
    }

    public T pop(T obj) {
        if(isEmpty()) throw new EmptyLinkedListException();

        T content = null;
        int pos = search(obj);
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
            this.setFirst(this.getFirst().getNext());
            this.getFirst().getPrev().setNext(null);
            this.getFirst().setPrev(null);
        }

        dec();
        return content;
    }

    //=====SEARCH=====//
    public int search(T obj) {
        Node<T> curr = this.getFirst();
        int i = 0;

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
                if(obj.equals(curr.getObj())) {
                    curr = null;
                    return i;
                }
                curr = curr.getNext();
                i++;                
            }
        }

        curr = null;
        return -1;
    }

    //=====CONTAINS=====//
    public Boolean contains(T obj) {
        Node<T> curr = this.getFirst();
        Boolean value = false;

        if(obj == null) {
            while(!value && curr != null) {
                value = curr.getObj() == null;
                curr = curr.getNext();
            }
        } else {
            while(!value && curr != null) {
                value = obj.equals(curr.getObj());
                curr = curr.getNext();
            }
        }

        curr = null;
        return value;
    }

    //=====REPLACE=====//
    public void replace(T obj, T rep) {
        if(isEmpty()) throw new EmptyLinkedListException();
        int pos = search(obj);

        if(pos >= 0) node(pos).setObj(rep);
    }

    public void replaceAll(T obj, T rep) {
        if(isEmpty()) throw new EmptyLinkedListException();
        int pos = search(obj);

        while(pos >= 0) {
            node(pos).setObj(rep);
            pos = search(obj);
        }
    }

    //=====INVERT=====//
    public void invert() {
        Node<T> i = this.getFirst();
        Node<T> j = this.getLast();
        while(i != j && i.getNext() != j) {
            T aux = i.getObj();
            i.setObj(j.getObj());
            j.setObj(aux);

            i = i.getNext();
            j = j.getPrev();
        }

        i = j = null;
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
