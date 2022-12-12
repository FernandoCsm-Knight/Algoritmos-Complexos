package EstruturasLineares.OutrasEstruturas.Pilha;

import EstruturasLineares.ArrayListJava.ArrayList;

public class IStack<T> {
    //=====PRIVATE=====//
    private ArrayList<T> list;

    //=====CONSTRUCTOR=====//
    public IStack() {
        this.setList(new ArrayList<T>());
    }

    public IStack(int cap) {
        this.setList(new ArrayList<T>(cap));
    }

    public IStack(T[] arr) {
        this.setList(new ArrayList<T>(arr));
    }
 
    //=====DESTRUCTOR=====//
    public void finalize() {
        this.setList(null);
    }

    //=====SET=====//
    //-----PRIVATE-----//
    private void setList(ArrayList<T> l) {
        this.list = l;
    }

    //=====GET=====//
    //-----PRIVATE-----//
    private ArrayList<T> getList() {
        return this.list;
    }

    //-----PUBLIC-----//
    public int size() {
        return this.list.size();
    }

    //=====METODOS=====//
    public Boolean isEmpty() {
        return this.getList().isEmpty();
    }

    public Boolean isFull() {
        return this.getList().isFull();
    }

    //-----PUSH-----//
    public void push(T obj) {
        this.getList().add(obj);
    }

    //-----POP-----//
    public T pop() {
        return this.getList().pop();
    }

    //-----PEEK-----//
    public T peek() {
        return this.getList().get(this.size() - 1);
    }

    //-----CLEAR-----//
    public void clear() {
        this.getList().clear();
    }

    //=====OVERRIDE=====//
    @Override
    public String toString() {
        String s = "[";
        for(int i = 0; i < this.size(); i++) {
            s += this.getList().get(i);
            if(i < this.size() - 1) s += ", ";
        } s += "]";
        return s;
    }
}
