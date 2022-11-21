package Arvores.ArvoreAVL;

public class Node<T> {
   private Node<T> left;
   private Node<T> right;
   private T obj;

   public Node() {
      this(null);   
   }

   public Node(T obj) {
      this(obj, null, null);
   }

   public Node(T obj, Node<T> left, Node<T> right) {
      this.setObj(obj);
      this.setLeft(left);
      this.setRight(right);
   }
   
   public Node<T> getLeft() {
      return left;
   }
   
   public Node<T> getRight() {
      return right;
   }
   
   public T getObj() {
      return obj;
   }

   public void setLeft(Node<T> left) {
      this.left = left;
   }

   public void setRight(Node<T> right) {
      this.right = right;
   }

   public void setObj(T obj) {
      this.obj = obj;
   }

}
