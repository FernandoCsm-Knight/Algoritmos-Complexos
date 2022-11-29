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
            System.out.println(curr.getObj() + " ");
            curr = curr.getRight();
         }
      }

      System.out.println();
   }

}
