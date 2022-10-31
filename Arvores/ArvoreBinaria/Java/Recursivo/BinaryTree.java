package Arvores.ArvoreBinaria.Java.Recursivo;

public class BinaryTree<T extends Comparable<T>> {
    //======PRIVATE=====//
    private Node<T> root;
    private int length = 0;
    private int index = 0;

    //=====CONSTRUCTOR=====//
    public BinaryTree() {
        this.setRoot(null);
    }

    //=====GET=====//
    private Node<T> getRoot() {
        return this.root;
    }

    public int size() {
        return this.length;
    }

    //=====SET=====//
    private void setRoot(Node<T> root) {
        this.root = root;
    }

    private void inc() {
        this.length++;
    }

    //=====METODOS=====//
    //-----ADD-----//
    public void add(T obj) {
        this.add(obj, this.getRoot());
    }

    private void add(T obj, Node<T> node) {
        if(node != null) {
            if(obj.compareTo(node.getObj()) < 0) {
                if(node.getLeft() == null) {
                    node.setLeft(new Node<T>(obj));
                    this.inc();
                } else add(obj, node.getLeft());
            } else if(obj.compareTo(node.getObj()) > 0) {
                if(node.getRight() == null) {
                    node.setRight(new Node<T>(obj)); 
                    this.inc();
                } else add(obj, node.getRight());
            } else throw new InsertionError();
        } else {
            this.setRoot(new Node<T>(obj));
            this.inc();
        }
    }

    //-----INORDER-----//
    public void inOrder() {
        index = 0;
        System.out.print("[");
        this.inOrder(this.getRoot());
        System.out.println("]");
    }

    private void inOrder(Node<T> node) {
        if(node != null) {
            inOrder(node.getLeft());
            index++;
            System.out.print(node.getObj() + (index != this.size() ? ", " : ""));
            inOrder(node.getRight());
        }
    }

    //-----PREORDER-----//
    public void preOrder() {
        index = 0;
        System.out.print("[");
        this.preOrder(this.getRoot());
        System.out.println("]");
    }

    private void preOrder(Node<T> node) {
        if(node != null) {
            index++;
            System.out.print(node.getObj() + (index != this.size() ? ", " : ""));
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    //-----PREORDER-----//
    public void posOrder() {
        index = 0;
        System.out.print("[");
        this.posOrder(this.getRoot());
        System.out.println("]");
    }

    private void posOrder(Node<T> node) {
        if(node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            index++;
            System.out.print(node.getObj() + (index != this.size() ? ", " : ""));
        }
    }

    //-----SEARCH-----//
    public Boolean search(T obj) {
        return this.search(obj, this.getRoot()).getObj() == obj;
    }

    private Node<T> search(T obj, Node<T> node) {
        if(node != null && node.getObj() != obj) {
            if(obj.compareTo(node.getObj()) < 0) node = search(obj, node.getLeft());
            else node = search(obj, node.getRight());
        } 
        
        return node;
    }

    //-----MAX-----//
    public T max() {
        return this.max(this.getRoot());
    }

    private T max(Node<T> node) {
        T content = null;
        if(node != null) {
            if(node.getRight() != null) content = max(node.getRight());
            else content = node.getObj();
        }
        return content;
    }

    //-----MIN-----//
    public T min() {
        return this.min(this.getRoot());
    }

    private T min(Node<T> node) {
        T content = null;
        if(node != null) {
            if(node.getLeft() != null) content = min(node.getLeft());
            else content = node.getObj();
        }
        return content;
    }

    //-----getHeigth-----//
    public int getHeight() {
        return this.getHeight(this.getRoot(), 0);
    }

    private int getHeight(Node<T> node, int h) {
        if(node == null) h--;
        else {
            int left = getHeight(node.getLeft(), h + 1);
            int right = getHeight(node.getRight(), h + 1);
            h = (left > right) ? left : right;
        }
        return h;
    }

    //=====OVERRIDE=====//
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        return (this.getClass() == o.getClass()) ? compare(((BinaryTree<T>)o).getRoot(), this.getRoot()) : false;
    }

    private boolean compare(Node<T> node1, Node<T> node2) {
        Boolean value = node1 != null && node2 != null;
        if(value) {
            value = node1.getObj() == node2.getObj();
            value &= compare(node1.getLeft(), node2.getLeft());
            value &= compare(node1.getRight(), node2.getRight());
        } else if(node1 == null && node2 == null) value = true;
        return value;
    }

}
