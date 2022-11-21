package Arvores.ArvoreAVL;

public class Test {
   public static void main(String[] args) {
      Tree<Integer> tree = new Tree<>();

      tree.add(5);
      tree.add(2);
      tree.add(3);
      tree.add(1);
      tree.add(7);
      tree.add(6);
      tree.add(8);

      tree.inOrder();
      
      tree.pop(3);
      tree.pop(5);

      tree.inOrder();
      System.out.println(tree.getRoot().getObj());
   }
}
