package EstruturasLineares.OutrasEstruturas.Pilha;

import EstruturasLineares.ArrayListJava.ArrayList;

public class HStack<T> extends ArrayList<T> {
    //=====CONSTRUCTOR=====//
    public HStack() {
        super();
    }

    //=====METODOS=====//
    //-----PUSH-----//
    public void push(T obj) {
        this.add(obj);
    }

    //-----POP-----//
    public T pop() {
        return this.pop();
    }

    //-----PEEK-----//
    public T peek() {
        return this.get(this.size() - 1);
    }

    //-----CLEAR-----//
    public void clear() {
        this.clear();
    }
    
}
