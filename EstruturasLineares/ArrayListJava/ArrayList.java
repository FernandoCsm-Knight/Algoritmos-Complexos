package EstruturasLineares.ArrayListJava;

public class ArrayList<T> {
    // =====PRIVATE=====//
    private static final int DOWNGRADE = 4;

    private T[] list;
    private int length = 0;
    private Boolean dynamic = true;

    // =====CONSTRUCTORS=====//
    public ArrayList() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int cap) {
        this.setList((T[]) new Object[cap]);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(T... arr) {
        this(true, arr);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(Boolean dynamic, T... arr) {
        this.setDynamic(dynamic);
        this.setList((T[]) new Object[arr.length]);
        this.addAll(arr);
    }

    // =====GET=====//
    public T[] getList() {
        return this.list;
    }

    public int size() {
        return this.length;
    }

    public int capacity() {
        return this.list.length;
    }

    public T get(int idx) {
        if (idx < 0 || idx > this.size())
            throw new IndexOutOfBoundsException();
        return this.list[idx];
    }

    public Boolean isDynamic() {
        return this.dynamic;
    }

    // =====SET=====//
    // -----PRIVATE-----//
    private void setList(T[] l) {
        this.list = l;
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

    private void set(T obj, int p) {
        this.list[p] = obj;
    }

    // -----PUBLIC-----//
    public void setDynamic(Boolean value) {
        this.dynamic = value;
    }

    // =====METODOS=====//
    public Boolean isEmpty() {
        return this.size() == 0;
    }

    public Boolean isFull() {
        return this.size() == this.capacity();
    }

    // =====GROW=====//
    @SuppressWarnings("unchecked")
    private void grow() {
        T[] arr = (T[]) new Object[this.capacity() * 2];
        for (int i = 0; i < this.size(); i++)
            arr[i] = this.get(i);

        this.setList(arr);
    }

    // =====SHRINK=====//
    @SuppressWarnings("unchecked")
    private void shrink() {
        T[] arr = (T[]) new Object[this.capacity() / 2];
        for (int i = 0; i < this.size(); i++)
            arr[i] = this.get(i);

        this.setList(arr);
    }

    // =====ADD=====//
    public void add(T obj) {
        if (this.isFull()) {
            if (this.isDynamic())
                this.grow();
            else
                throw new FullArrayListException();
        }

        set(obj, this.size());
        inc();
    }

    public void add(T obj, int p) {
        if (this.isFull()) {
            if (this.isDynamic())
                this.grow();
            else
                throw new FullArrayListException();
        }
        if (p < 0 || p >= this.size())
            throw new IndexOutOfBoundsException();

        for (int i = this.size(); i > p; i--)
            set(this.get(i - 1), i);
        set(obj, p);
        inc();
    }

    public void addAll(T[] arr) {
        if ((this.capacity() - this.size()) < arr.length) {
            if (this.isDynamic())
                this.grow();
            else
                throw new FullArrayListException();
        }

        for (int i = 0; i < arr.length; i++)
            this.add(arr[i]);
    }

    // =====INSERT=====//
    public void insert(T obj) {
        if (this.isFull()) {
            if (this.isDynamic())
                this.grow();
            else
                throw new FullArrayListException();
        }

        for (int i = this.size(); i > 0; i--)
            set(this.get(i - 1), i);
        set(obj, 0);
        inc();
    }

    // =====POP=====//
    public T pop() {
        if (this.isEmpty())
            throw new EmptyArrayListException();

        dec();
        if (this.isDynamic() && this.size() <= this.capacity() / DOWNGRADE)
            this.shrink();
        return this.get(this.size());
    }

    public T pop(int idx) {
        if (this.isEmpty())
            throw new EmptyArrayListException();
        if (idx < 0 || idx >= this.size())
            throw new IndexOutOfBoundsException();

        T aux = this.get(idx);
        for (int i = idx; i < this.size() - 1; i++)
            this.set(this.get(i + 1), i);
        dec();
        if (this.isDynamic() && this.size() <= this.capacity() / DOWNGRADE)
            this.shrink();
        return aux;
    }

    public T pop(T obj) {
        if (this.isEmpty())
            throw new EmptyArrayListException();

        int idx = search(obj);
        T aux = null;
        if (idx >= 0) {
            aux = this.get(idx);
            for (int i = idx; i < this.size() - 1; i++)
                this.set(this.get(i + 1), i);
            dec();
            if (this.isDynamic() && this.size() <= this.capacity() / DOWNGRADE)
                this.shrink();
        }
        return aux;
    }

    // =====REMOVE=====//
    public T remove() {
        if (this.isEmpty())
            throw new EmptyArrayListException();

        T aux = this.get(0);
        for (int i = 0; i < this.size() - 1; i++)
            this.set(this.get(i + 1), i);
        dec();
        if (this.isDynamic() && this.size() <= this.capacity() / DOWNGRADE)
            this.shrink();
        return aux;
    }

    // =====SEARCH=====//
    public int search(T obj) {
        if (obj == null) {
            for (int i = 0; i < this.size(); i++)
                if (this.get(i) == null)
                    return i;
        } else {
            for (int i = 0; i < this.size(); i++)
                if (obj.equals(this.get(i)))
                    return i;
        }

        return -1;
    }

    // =====CONTAINS=====//
    public Boolean contains(T obj) {
        Boolean value = false;
        int i = 0;
        if (obj == null) {
            while (i < this.size() && !value) {
                value = this.get(i) == null;
                i++;
            }
        } else {
            while (i < this.size() && !value) {
                value = obj.equals(this.get(i));
                i++;
            }
        }

        return value;
    }

    // =====CLEAR=====//
    public void clear() {
        this.setLength(0);
        for(int i = 0; i < this.capacity(); i++)
            this.set(null, i);
    }

    // =====OVERRIDE=====//
    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < this.size(); i++) {
            s += this.get(i);
            if (i != this.size() - 1)
                s += ", ";
        }
        s += "]";
        return s;
    }

}
