package Arvores.ArvoreAVL;

public class Node<T> {
   //=====PRIVATE=====//
   private Node<T> left;
   private Node<T> right;
   private int factor;
   private T obj;

   //=====CONSTRUCTOR=====//
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
   
   //=====GET=====//
   public Node<T> getLeft() {
      return left;
   }
   
   public Node<T> getRight() {
      return right;
   }
   
   public T getObj() {
      return obj;
   }

   public int getFactor() {
      return factor;
   }

   //=====SET=====//
   public void setLeft(Node<T> left) {
      this.left = left;
   }

   public void setRight(Node<T> right) {
      this.right = right;
   }

   public void setObj(T obj) {
      this.obj = obj;
   }

   public void setFactor(int factor) {
      this.factor = factor;
   }

   //=====METODOS=====//
   public static void updateFactor(Node<?> node) {
      node.setFactor(Math.max(Node.factor(node.getLeft()), Node.factor(node.getRight())) + 1);
   }

   public static int factor(Node<?> node) {
      return node == null ? 0 : node.getFactor();
   }

}
