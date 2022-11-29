package Arvores.ArvoreRubroNegra;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

public class Tree<T extends Comparable<T>> {
   //=====PRIVATE=====//
   private Node<T> root;

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
         h = left > right ? left : right;
      } else h--;

      return h;
   }

   //=====ADD=====//
   public void add(T obj) {
      if(obj == null) throw new InsertionError();
      Node<T> prev = null,
              curr = this.getRoot();
      
      while(curr != null) {
         prev = curr;
         if(obj.compareTo(curr.getObj()) < 0)
            curr = curr.getLeft();
         else if(obj.compareTo(curr.getObj()) > 0)
            curr = curr.getRight();
         else throw new InsertionError();
      }

      Node<T> node = new Node<T>(obj, prev);
      node.setColor(true);

      if(prev == null) this.setRoot(node);
      else if(obj.compareTo(prev.getObj()) < 0) prev.setLeft(node);
      else prev.setRight(node);

      this.balance(node);
   }

   //=====BALANCE=====//
   private void balance(Node<T> node) {
      Node<T> uncle;
      while(Node.color(node.getParent())) {
         if(node.getParent() == node.getParent().getParent().getLeft()) {

            uncle = node.getParent().getParent().getRight();
            if(Node.color(uncle)) {
               node.getParent().getParent().setColor(true);
               node.getParent().setColor(false);
               uncle.setColor(false);
               node = node.getParent().getParent();
            } else {
               if(node == node.getParent().getRight()) {
                  node = node.getParent();
                  this.rotateLeft(node);
               }
               
               node.getParent().setColor(false);
               node.getParent().getParent().setColor(true);
               this.rotateRight(node.getParent().getParent());
            }

         } else {

            uncle = node.getParent().getParent().getLeft();
            if(Node.color(uncle)) {
               node.getParent().getParent().setColor(true);
               node.getParent().setColor(false);
               uncle.setColor(false);
               node = node.getParent().getParent();
            } else {
               if(node == node.getParent().getLeft()) {
                  node = node.getParent();
                  this.rotateRight(node);
               }  

               node.getParent().setColor(false);
               node.getParent().getParent().setColor(true);
               this.rotateLeft(node.getParent().getParent());
            }

         }
      }

      this.getRoot().setColor(false);
   }

   //=====ROTATION=====//
   private void rotateLeft(Node<T> node) {
      Node<T> child = node.getRight();
      node.setRight(child.getLeft());

      if(child.getLeft() != null) child.getLeft().setParent(node);

      child.setParent(node.getParent());
      if(node.getParent() == null) this.setRoot(child);
      else if(node.getParent().getLeft() == node) node.getParent().setLeft(child);
      else node.getParent().setRight(child);

      child.setLeft(node);
      node.setParent(child);
   }

   private void rotateRight(Node<T> node) {
      Node<T> child = node.getLeft();
      node.setLeft(child.getRight());

      if(child.getRight() != null) child.getRight().setParent(node);

      child.setParent(node.getParent());
      if(node.getParent() == null) this.setRoot(child);
      else if(node.getParent().getLeft() == node) node.getParent().setLeft(child);
      else node.getParent().setRight(child);

      child.setRight(node);
      node.setParent(child);
   }

   //=====CONTAINS=====//
   public Boolean contains(T obj) {
      return (obj == null) ? false : this.search(obj) != null;
   }

   private Node<T> search(T obj) {
      Node<T> curr = this.getRoot();
      while(curr != null && obj.compareTo(curr.getObj()) != 0) {
         if(obj.compareTo(curr.getObj()) < 0) curr = curr.getLeft();
         else curr = curr.getRight();
      }

      return curr;
   }

   //=====MAX=====//
   public T max() {
      return this.max(this.getRoot()).getObj();
   }

   private Node<T> max(Node<T> node) {
      if(node != null)
         while(node.getRight() != null) 
            node = node.getRight();
      return node;
   }

   //=====MIN=====//
   public T min() {
      return this.min(this.getRoot()).getObj();
   }

   private Node<T> min(Node<T> node) {
      if(node != null)
         while(node.getLeft() != null)
            node = node.getLeft();
      return node;
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

}
