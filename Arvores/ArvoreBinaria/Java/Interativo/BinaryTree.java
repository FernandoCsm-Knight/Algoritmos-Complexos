package Arvores.ArvoreBinaria.Java.Interativo;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

import java.util.HashSet;

public class BinaryTree<T extends Comparable<T>> {
    // =====PRIVATE=====//
    private Node<T> root;

    // =====CONSTRUCTOR=====//
    public BinaryTree() {
        this.setRoot(null);
    }

    // =====GET=====//
    private Node<T> getRoot() {
        return this.root;
    }

    public T get(T obj) {
        return this.search(obj) == null ? null : this.search(obj).getObj();
    } 

    // =====SET=====//
    private void setRoot(Node<T> root) {
        this.root = root;
    }

    // =====METODOS=====//
    // -----BOOLEAN-----//
    public Boolean isEmpty() {
        return this.getRoot() == null;
    }

    // -----LENGTH-----//
    public int size() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> curr = this.getRoot();

        int len = 0;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
                len++;
            } else {
                curr = stack.pop();
                curr = curr.getRight();
            }
        }

        return len;
    }

    // -----ADD-----//
    public void add(T obj) {
        Node<T> node = new Node<>(obj);

        if (this.isEmpty())
            this.setRoot(node);
        else {
            Node<T> prev = null;
            Node<T> curr = this.getRoot();

            while (curr != null) {
                if (obj.compareTo(curr.getObj()) < 0) {
                    prev = curr;
                    curr = curr.getLeft();
                } else if (obj.compareTo(curr.getObj()) > 0) {
                    prev = curr;
                    curr = curr.getRight();
                } else
                    throw new InsertionError();
            }

            if (obj.compareTo(prev.getObj()) < 0)
                prev.setLeft(node);
            else
                prev.setRight(node);
        }
    }

    // -----POP-----//
    public void pop(T obj) {
        if (this.isEmpty() || obj == null)
            throw new InsertionError();

        Node<T> curr = this.getRoot(), prev = null;
        while (curr != null && obj.compareTo(curr.getObj()) != 0) {
            prev = curr;
            if (obj.compareTo(curr.getObj()) < 0)
                curr = curr.getLeft();
            else
                curr = curr.getRight();
        }

        if (prev == null) {

            if (curr.getLeft() == null)
                this.setRoot(curr.getRight());
            else if (curr.getRight() == null)
                this.setRoot(curr.getLeft());
            else
                remMaxRight(curr);

        } else {

            if (curr.getLeft() == null) {

                if (prev.getRight() == curr)
                    prev.setRight(curr.getRight());
                else
                    prev.setLeft(curr.getRight());

            } else if (curr.getRight() == null) {

                if (prev.getRight() == curr)
                    prev.setRight(curr.getLeft());
                else
                    prev.setLeft(curr.getLeft());

            } else
                remMaxRight(curr);

        }
    }

    private void remMaxRight(Node<T> removed) {
        Node<T> curr = removed.getLeft(), prev = null;
        while (curr.getRight() != null) {
            prev = curr;
            curr = curr.getRight();
        }

        removed.setObj(curr.getObj());
        if (prev != null)
            prev.setRight(curr.getLeft());
        else
            removed.setLeft(curr.getLeft());
    }

    // -----CONTAINS-----//
    public Boolean contains(T obj) {
        return this.search(obj) != null;
    }

    private Node<T> search(T obj) {
        Node<T> curr = this.getRoot();
        while(curr != null && obj.compareTo(curr.getObj()) != 0) {
            if(obj.compareTo(curr.getObj()) < 0) 
                curr = curr.getLeft();
            else 
                curr = curr.getRight();
        }

        return curr;
    }

    // -----TOARRAY-----//
    public Object[] toArray() {
        Stack<Node<T>> stack = new Stack<>();
        Object[] arr = new Object[this.size()];

        int i = 0;
        Node<T> curr = this.getRoot();
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                arr[i++] = curr.getObj();
                curr = curr.getRight();
            }
        }
        
        return arr;
    }

    // -----INORDER-----//
    public void inOrder() {
        Node<T> curr = this.getRoot();

        Stack<Node<T>> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                System.out.print(curr.getObj() + " ");
                curr = curr.getRight();
            }
        }
        System.out.println();
    }

    // -----PREORDER-----//
    public void preOrder() {
        Node<T> curr = this.getRoot();

        Stack<Node<T>> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                System.out.print(curr.getObj() + " ");
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                curr = curr.getRight();
            }
        }
        System.out.println();
    }

    // -----POSORDER-----//
    public void posOrder() {
        Node<T> curr = this.getRoot();

        HashSet<Node<T>> hash = new HashSet<>();
        while (curr != null && !hash.contains(curr)) {
            if (curr.getLeft() != null && !hash.contains(curr.getLeft())) {
                curr = curr.getLeft();
            } else if (curr.getRight() != null && !hash.contains(curr.getRight())) {
                curr = curr.getRight();
            } else {
                hash.add(curr);
                System.out.print(curr.getObj() + " ");
                curr = this.getRoot();
            }
        }
        System.out.println();
    }

}