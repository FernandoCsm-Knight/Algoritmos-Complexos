package Arvores.ArvoreTrie.Trie;

public class Test {
   
   public static void main(String[] args) {
      Tree tree = new Tree();
      tree.add("Fer");
      tree.add("Fernando");
      tree.add("Fernanda");
      tree.add("Feasdas");
      tree.add("Feqrnlwq");
      tree.add("asdnldqw");
      tree.add("ekrnlnfdsf");
      tree.add("tlesdnqwk");
      tree.prefix("Fer");
      System.out.println();
      System.out.println();

      tree.pop("Fer");
      tree.pop("tlesdnqwk");
      tree.prefix();
   }

}
