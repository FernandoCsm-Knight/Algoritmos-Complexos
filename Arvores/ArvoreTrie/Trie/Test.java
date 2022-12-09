package Arvores.ArvoreTrie.Trie;

public class Test {

   public static void main(String[] args) {
      Tree tree = new Tree("Fer", "Fernando", "Fernanda");

      tree.prefix();
      System.out.println();
      tree.prefix("Fernan");
   }

}
