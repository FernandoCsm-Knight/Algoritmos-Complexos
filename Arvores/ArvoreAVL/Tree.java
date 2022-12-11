package Arvores.ArvoreAVL;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

public class Tree<T extends Comparable<T>> {
   //=====RPIVATE=====//
   private Node<T> root;

   //=====CONSTRUCTOR=====//
   public Tree() {
      super();
   }

   //=====GET=====//
   public Node<T> getRoot() {
      return root;
   }

   //=====SET=====//
   public void setRoot(Node<T> root) {
      this.root = root;
   }

   //=====METHODS=====//
   //=====BOOLEAN=====//
   public Boolean isEmpty() {
      return this.getRoot() == null;
   }
   
   //=====HEIGHT=====//
   public int height() {
      return this.height(this.getRoot(), 0);
   }

   private int height(Node<T> node, int h) {
      if(node != null) {
         int left = this.height(node.getLeft(), h + 1);
         int right = this.height(node.getRight(), h + 1);
         h = (left > right) ? left : right;
      } else h--;
      return h;
   }

   //=====ADD=====//
   public void add(T obj) {
      if(obj == null) throw new InsertionError();
      this.setRoot(this.add(obj, this.getRoot()));
   }

   private Node<T> add(T obj, Node<T> node) {
      if(node == null) node = new Node<T>(obj);
      else if(obj.compareTo(node.getObj()) < 0) node.setLeft(this.add(obj, node.getLeft()));
      else if(obj.compareTo(node.getObj()) > 0) node.setRight(this.add(obj, node.getRight()));
      else throw new InsertionError();

      return this.balance(node);
   }

   //=====POP=====//
   public void pop(T obj) {
      if(obj == null || this.isEmpty()) throw new RemoveError();
      this.pop(obj, this.getRoot());
   }

   private Node<T> pop(T obj, Node<T> node) {
      if(node == null) throw new RemoveError();
      
      if(obj.compareTo(node.getObj()) < 0) node.setLeft(this.pop(obj, node.getLeft()));
      else if(obj.compareTo(node.getObj()) > 0) node.setRight(this.pop(obj, node.getRight()));
      else if(node.getLeft() == null) node = node.getRight();
      else if(node.getRight() == null) node = node.getLeft();
      else node.setLeft(this.remMaxLeft(node, node.getLeft()));
      
      return this.balance(node);
   }

   private Node<T> remMaxLeft(Node<T> removed, Node<T> curr) {
      if(curr.getRight() == null) {
         removed.setObj(curr.getObj());
         curr = curr.getLeft();
      } else curr.setRight(this.remMaxLeft(removed, curr.getRight()));
      return curr;
   }

   //=====BALANCE=====//
   public Node<T> balance(Node<T> node) {
      int BF = this.balanceFactor(node);
      Node<T> child;

      if(node != null && Math.abs(BF) <= 1) {
         Node.updateFactor(node);
      } else if(BF > 1) {
         child = node.getRight();
         if(this.balanceFactor(child) == -1) node.setRight(this.rotateRight(child));
         node = this.rotateLeft(node);
      } else if(BF < -1) {
         child = node.getLeft();
         if(this.balanceFactor(child) == 1) node.setLeft(this.rotateLeft(child));
         node = this.rotateRight(node);
      }

      return node;
   }

   private int balanceFactor(Node<T> node) {
      return node == null ? 0 : Node.factor(node.getRight()) - Node.factor(node.getLeft());
   }

   //=====ROTATION=====//
   public Node<T> rotateRight(Node<T> node) {
      Node<T> child = node.getLeft();

      node.setLeft(child.getRight());
      child.setRight(node);

      Node.updateFactor(child);
      Node.updateFactor(node);
      return child;
   }

   public Node<T> rotateLeft(Node<T> node) {
      Node<T> child = node.getRight();

      node.setRight(child.getLeft());
      child.setLeft(node);

      Node.updateFactor(child);
      Node.updateFactor(node);
      return child;
   }

   //=====MIN=====// 
   public T min() {
      return min(this.getRoot()).getObj();
   }

   private Node<T> min(Node<T> node) {
      if(node != null)
         while(node.getLeft() != null) 
            node = node.getLeft();
      return node;
   }

   //=====MAX=====//
   public T max() {
      return max(this.getRoot()).getObj();
   }

   private Node<T> max(Node<T> node) {
      if(node != null) 
         while(node.getRight() != null) 
            node = node.getRight();
      return node;
   }

   //=====SEARCH=====//
   public Boolean contains(T obj) {
      return search(obj) != null;
   }

   private Node<T> search(T obj) {
      Node<T> curr = this.getRoot();
      while(curr != null && curr.getObj().compareTo(obj) != 0) {
         if(curr.getObj().compareTo(obj) > 0) curr = curr.getLeft();
         else curr = curr.getRight();
      }

      return curr;
   }

   //=====INORDER=====//
   public void inOrder() {
      Stack<Node<T>> stack = new Stack<>();
      
      Node<T> curr = this.getRoot();
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

   //=====PREORDER=====//
   public void preOrder() {
      Stack<Node<T>> stack = new Stack<>();

      Node<T> curr = this.getRoot();
      while(curr != null || !stack.isEmpty()) {
         if(curr != null) {
            System.out.print(curr.getObj() + " ");
            stack.push(curr);
            curr = curr.getLeft();
         } else {
            curr = stack.pop();
            curr = curr.getRight();
         }
      }

      System.out.println();
   }

   //=====POSORDER=====//
   public void posOrder() {
      this.posOrder(this.getRoot());
      System.out.println();
   }

   private void posOrder(Node<T> node) {
      if(node != null) {
         this.posOrder(node.getLeft());
         System.out.print(node.getObj() + " ");
         this.posOrder(node.getRight());
      }
   }

}
