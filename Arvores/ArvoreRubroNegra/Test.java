package Arvores.ArvoreRubroNegra;

public class Test {
   
   public static void main(String[] args) {
      Tree<Integer> tree = new Tree<>();
      tree.add(10);
      tree.add(11);
      tree.add(12);
      
      System.out.println(tree.getRoot().getObj() + " => " + tree.getRoot().getColor());
      System.out.println(tree.getRoot().getRight().getObj() + " => " + tree.getRoot().getRight().getColor());
      System.out.println(tree.getRoot().getLeft().getObj() + " => " + tree.getRoot().getLeft().getColor());

      System.out.println();
      tree.inOrder();
   }

}
