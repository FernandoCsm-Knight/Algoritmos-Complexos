package Arvores.ArvoreBinaria.Java.Recursivo;

public class BinaryTree {
    //======PRIVATE=====//
    private Node root;
    private int length = 0;
    private int i = 0;
    
    //=====CONSTRUCTOR=====//
    public BinaryTree() {
        this.setRoot(null);
    }

    //=====GET=====//
    public Node getRoot() {
        return this.root;
    }

    public Integer get() {
        return this.root.getObj();
    }

    //=====SET=====//
    private void setRoot(Node root) {
        this.root = root;
    }

    private void inc() {
        this.length++;
    }

    public int size() {
        return this.length;
    }
    
    //=====METODOS=====//
    //-----ADD-----//
    public void add(Integer obj) {
        this.setRoot(add(obj, this.getRoot()));
        inc();
    }

    private Node add(Integer obj, Node node) {
        if(node == null) node = new Node(obj);
        else if(obj > node.getObj()) node.setRight(add(obj, node.getRight()));
        else if(obj < node.getObj()) node.setLeft(add(obj, node.getLeft()));
        else throw new InsertionError();
        return node;
    }

    //-----POP-----//
    public int pop(int obj) {
        Node node = pop(obj, this.getRoot());
        this.setRoot(node);
        return node.getObj();
    }

    private Node pop(int obj, Node node) {
        if(node == null) throw new IndexOutOfBoundsException();
        else if(node.getObj() > obj) node.setRight(pop(obj, node.getRight()));
        else if(node.getObj() < obj) node.setLeft(pop(obj, node.getLeft()));
        else if(node.getRight() == null) node = node.getLeft();
        else if(node.getLeft() == null) node = node.getRight();
        else node.setLeft(bigger(node, node.getLeft()));
        return node;
    }

    private Node bigger(Node node1, Node node2) {
        if(node2.getRight() == null) {
            node1.setObj(node2.getObj());
            node2 = node2.getLeft();
        } else node2.setRight(bigger(node1, node2.getRight()));
        return node2;
    }

    //-----INORDER-----//
    public void inOrder() {
        i = 0;
        System.out.print("[");
        inOrder(this.getRoot());
        System.out.println("]");
    }

    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.getLeft());
            i++;
            System.out.print(node.getObj() + (i != this.size() ? ", " : ""));
            inOrder(node.getRight());
        }
    }

    //-----PREORDER-----//
    public void preOrder() {
        i = 0;
        System.out.print("[");
        preOrder(this.getRoot());
        System.out.println("]");
    }

    public void preOrder(Node node) {
        if(node != null) {
            i++;
            System.out.print(node.getObj() + (i != this.size() ? ", " : ""));
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    //-----POSORDER-----//
    public void posOrder() {
        i = 0;
        System.out.print("[");
        posOrder(this.getRoot());
        System.out.println("]");
    }

    public void posOrder(Node node) {
        if(node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            i++;
            System.out.print(node.getObj() + (node.getObj() + (i != this.size() ? ", " : "")));
        }
    }

    //-----SEARCH-----//
    public Boolean search(Integer obj) {
        return search(obj, root);
    }

    private Boolean search(Integer obj, Node node) {
        Boolean value;
        if(node == null) value = false;
        else if(obj == node.getObj()) value = true;
        else if(obj > node.getObj()) value = search(obj, node.getRight());
        else value = search(obj, node.getLeft());
        return value;
    }

    //-----GETALTURAA-----//
    public int getHeigth() {
        return getHeigth(this.getRoot(), 0);
    }

    private int getHeigth(Node node, int h) {
        if(node == null) h--;
        else {
            int left = getHeigth(node.getLeft(), h + 1);
            int right = getHeigth(node.getRight(), h + 1);
            h = (left > right) ? left : right;
        }   
        return h;
    }

    //-----MAX-----//
    public int max() {
        return max(this.getRoot());
    }

    private int max(Node node) {
        int h;
        if(node.getRight() == null) h = node.getObj();
        else h = max(node.getRight());
        return h;
    }

    //-----MIN-----//
    public int min() {
        return min(this.getRoot());
    }

    public int min(Node node) {
        int l;
        if(node.getLeft() == null) l = node.getObj();
        else l = min(node.getLeft());
        return l;
    }

    //-----SUM-----//
    public long sum() {
        return sum(this.getRoot());
    }

    private long sum(Node node) {
        long s = 0;
        if(node != null) {
            s += sum(node.getLeft());
            s += sum(node.getRight());
            s += node.getObj();
        } 
        return s;
    }

    //-----EVEN-----//
    public int even() {
        return even(this.getRoot(), 0);
    }

    private int even(Node node, int num) {
        if(node != null) {
            if(node.getObj() % 2 == 0) num++;
            num = even(node.getLeft(), num);
            num = even(node.getRight(), num);
        }
        return num;
    }

    //-----ODD-----//
    public int odd() {
        return odd(this.getRoot(), 0);
    }

    private int odd(Node node, int num) {
        if(node != null) {
            if(node.getObj() % 2 != 0) num++;
            num = odd(node.getLeft(), num);
            num = odd(node.getRight(), num);
        }
        return num;
    }

    //=====OVERRIDE=====//
    @Override 
    public boolean equals(Object obj) {
        return (obj.getClass() == this.getClass()) ? compare(((BinaryTree)obj).getRoot(), this.getRoot()) : false;        
    }

    private Boolean compare(Node node1, Node node2) {
        Boolean value = false;
        if(node1 != null && node2 != null) {
            value = node1.getObj() == node2.getObj();
            value &= compare(node1.getLeft(), node2.getLeft());
            value &= compare(node1.getRight(), node2.getRight());
        } else if(node1 == null && node2 == null) value = true;
        else value = false;
        return value;
    }

}
