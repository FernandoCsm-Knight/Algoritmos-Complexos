package Arvores.ArvoreAVL;

public class Test {
   public static void main(String[] args) {
      Tree<Integer> tree = new Tree<>();
      tree.add(1);
      tree.add(2);
      tree.add(3);
      tree.add(4);
      tree.add(5);
      tree.add(-1);
      tree.add(-2);
      tree.add(-3);
      tree.add(-4);
      tree.add(-5);

      tree.pop(-2);
      tree.pop(-1);
      tree.pop(3);
      tree.pop(-3);
      System.out.println(tree.getRoot().getObj());
      System.out.println(tree.getRoot().getLeft().getObj() + " " + tree.getRoot().getRight().getObj());
      System.out.println(tree.getRoot().getLeft().getLeft().getObj());
      System.out.println();
      tree.inOrder();
   }
}
