package Arvores.ArvoreRubroNegra;

public class Node<T> {
   //=====PRIVATE=====//
   private Node<T> left;
   private Node<T> right;
   private Node<T> parent;
   private Boolean color;
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

   public Node(T obj, Node<T> parent) {
      this.setObj(obj);
      this.setParent(parent);
   }

   //=====GET=====//
   public Node<T> getLeft() {
      return left;
   }
   
   public Node<T> getRight() {
      return right;
   }

   public Node<T> getParent() {
      return parent;
   }

   public Boolean getColor() {
      return color;
   }

   public T getObj() {
      return obj;
   }

   //=====SET=====//
   public void setLeft(Node<T> left) {
      this.left = left;
   }

   public void setRight(Node<T> right) {
      this.right = right;
   }

   public void setParent(Node<T> parent) {
      this.parent = parent;
   }

   public void setColor(Boolean color) {
      this.color = color;
   }

   public void setObj(T obj) {
      this.obj = obj;
   }

   //=====METHODS=====//
   public static Boolean color(Node<?> node) {
      return node == null ? false : node.getColor();
   }

   public static void updateColor(Node<?> node) {
      node.setColor(!color(node));
      if(node.getLeft() != null) node.getLeft().setColor(!color(node.getLeft()));
      if(node.getRight() != null) node.getRight().setColor(!color(node.getRight()));
   }

}