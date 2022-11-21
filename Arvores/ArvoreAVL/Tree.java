package Arvores.ArvoreAVL;

import java.util.Stack;

public class Tree<T extends Comparable<T>> {
   //=====PRIVATE=====//
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

   //=====METODOS=====//
   //-----BOOLEAN-----//
   public Boolean isEmpty() {
      return this.getRoot() == null;
   }

   //-----ADD-----//
   public void add(T obj) {
      if(obj == null) throw new InsertionError();
      Node<T> curr = this.getRoot();
      Node<T> parent = null;

      while(curr != null) {
         parent = curr;
         if(obj.compareTo(curr.getObj()) < 0) curr = curr.getLeft();
         else if(obj.compareTo(curr.getObj()) > 0) curr = curr.getRight();
         else throw new InsertionError();
      }
      
      if(parent != null) {
         if(obj.compareTo(parent.getObj()) < 0) parent.setLeft(new Node<T>(obj));
         else parent.setRight(new Node<T>(obj));
      } else this.setRoot(new Node<T>(obj));
      curr = parent = null;
   }

   //-----POP-----//
   public void pop(T obj) {
      if(this.isEmpty() || obj == null) throw new InsertionError();

      Node<T> curr = this.getRoot(), prev = null;
      while(curr != null && obj.compareTo(curr.getObj()) != 0) {
         prev = curr;
         if(obj.compareTo(curr.getObj()) < 0) curr = curr.getLeft();
         else curr = curr.getRight();
      }

      if(prev == null) {
      
         if(curr.getLeft() == null) this.setRoot(curr.getRight());
         else if(curr.getRight() == null) this.setRoot(curr.getLeft());
         else remMaxRight(curr);
      
      } else {

         if(curr.getLeft() == null) {

            if(prev.getRight() == curr) prev.setRight(curr.getRight());
            else prev.setLeft(curr.getRight());
            
         } else if(curr.getRight() == null) {
   
            if(prev.getRight() == curr) prev.setRight(curr.getLeft());
            else prev.setLeft(curr.getLeft());
            
         } else remMaxRight(curr);

      } 
   }
   
   private void remMaxRight(Node<T> removed) {
      Node<T> curr = removed.getLeft(), prev = null;
      while(curr.getRight() != null) {
         prev = curr;
         curr = curr.getRight();
      }

      removed.setObj(curr.getObj());
      if(prev != null) prev.setRight(curr.getLeft());
      else removed.setLeft(curr.getLeft());
   }

   //-----MIN-----// 
   public T min() {
      return min(this.getRoot()).getObj();
   }

   private Node<T> min(Node<T> node) {
      if(node != null)
         while(node.getLeft() != null) 
            node = node.getLeft();
      return node;
   }

   //-----MAX-----//
   public T max() {
      return max(this.getRoot()).getObj();
   }

   private Node<T> max(Node<T> node) {
      if(node != null) 
         while(node.getRight() != null) 
            node = node.getRight();
      return node;
   }

   //-----SEARCH-----//
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

   //-----INORDER-----//
   public void inOrder() {
      Stack<Node<T>> stack = new Stack<>();
      
      Node<T> curr = this.getRoot();
      while(curr != null || !stack.isEmpty()) {
         if(curr != null) {
            stack.add(curr);
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
      Stack<Node<T>> stack = new Stack<>();

      Node<T> curr = this.getRoot();
      while(curr != null || !stack.isEmpty()) {
         if(curr != null) {
            System.out.print(curr.getObj() + " ");
            stack.add(curr);
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
      Stack<Node<T>> stack = new Stack<>();

      Node<T> curr = this.getRoot();
      if(curr == null) return;
      Node<T> prev = null;
      stack.add(curr);
      while(!stack.isEmpty()) {
         curr = stack.peek();

         if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
            if(curr.getLeft() != null) stack.add(curr.getLeft());
            else if(curr.getRight() != null) stack.add(curr.getRight());
            else {
               stack.pop(); 
               System.out.print(curr.getObj() + " ");
            } 
         } else if(curr.getLeft() == prev) {
            if(curr.getRight() != null) stack.add(curr.getRight());
            else {
               stack.pop();
               System.out.print(curr.getObj() + " ");
            }
         } else if(curr.getRight() == prev) {
            stack.pop();
            System.out.print(curr.getObj() + " ");
         }

         prev = curr;
      }
      System.out.println();
   }
} 