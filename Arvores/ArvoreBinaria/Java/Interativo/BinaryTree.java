package Arvores.ArvoreBinaria.Java.Interativo;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

import java.util.HashSet;

public class BinaryTree<T extends Comparable<T>> {
    //=====PRIVATE=====//
    private Node<T> root;

    //=====CONSTRUCTOR=====//
    public BinaryTree() {
        this.setRoot(null);
    }

    //=====GET=====//
    private Node<T> getRoot() {
        return this.root;
    }

    //=====SET=====//
    private void setRoot(Node<T> root) {
        this.root = root;
    }

    //=====METODOS=====//
    public Boolean isEmpty() {
        return this.getRoot() == null;
    }

    //-----ADD-----//
    public void add(T obj) {
        Node<T> node = new Node<>(obj);

        if(this.isEmpty()) this.setRoot(node);
        else {
            Node<T> prev = null;
            Node<T> curr = this.getRoot();

            while(curr != null) {
                if(obj.compareTo(curr.getObj()) < 0) {
                    prev = curr;
                    curr = curr.getLeft();
                } else if(obj.compareTo(curr.getObj()) > 0) {
                    prev = curr;
                    curr = curr.getRight();
                } else throw new InsertionError();
            }

            if(obj.compareTo(prev.getObj()) < 0) prev.setLeft(node);
            else prev.setRight(node);
        }
    }

    //-----SEARCH-----//
    public Boolean search(T obj) {
        Node<T> curr = this.getRoot();
        while(curr != null && obj.compareTo(curr.getObj()) != 0) {
            if(obj.compareTo(curr.getObj()) < 0) curr = curr.getLeft();
            else curr = curr.getRight();
        }

        return curr != null;
    }

    //-----INORDER-----//
    public void inOrder() {
        Node<T> curr = this.getRoot();

        Stack<Node<T>> stack = new Stack<>(); 
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
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

    //-----PREORDER-----//
    public void preOrder() {
        Node<T> curr = this.getRoot();

        Stack<Node<T>> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
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

    //-----POSORDER-----//
    public void posOrder() {
        Node<T> curr = this.getRoot();

        HashSet<Node<T>> hash = new HashSet<>();
        while(curr != null && !hash.contains(curr)) {
            if(curr.getLeft() != null && !hash.contains(curr.getLeft())) {
                curr = curr.getLeft();
            } else if(curr.getRight() != null && !hash.contains(curr.getRight())) {
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