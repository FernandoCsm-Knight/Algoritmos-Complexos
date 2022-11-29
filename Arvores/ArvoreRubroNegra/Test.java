package Arvores.ArvoreRubroNegra;

public class Test {
   
   public static void main(String[] args) {
      System.out.println(tree.getRoot().getObj() + " => " + tree.getRoot().getColor());
      System.out.println(tree.getRoot().getRight().getObj() + " => " + tree.getRoot().getRight().getColor());
      System.out.println(tree.getRoot().getLeft().getObj() + " => " + tree.getRoot().getLeft().getColor());
   }

}
