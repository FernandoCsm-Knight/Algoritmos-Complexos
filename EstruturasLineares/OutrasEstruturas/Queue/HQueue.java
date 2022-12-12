package EstruturasLineares.OutrasEstruturas.Queue;

import EstruturasLineares.ArrayListJava.ArrayList;

public class HQueue<T> extends ArrayList<T> {
    //=====CONSTRUCTOR=====//
    public HQueue() {
        super();
    }

    //=====METODOS=====//
    //-----ENQUEUE-----//
    public void enqueue(T obj) {
        this.add(obj);
    }

    //-----DEQUEUE-----//
    public T dequeue() {
        return this.remove();
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
