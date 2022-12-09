package Arvores.ArvoreTrie.Trie;

public class Test {

   public static void main(String[] args) {
      Tree tree = new Tree("Fer", "Fernando", "Fernanda", "Max", "Do", "Val", "Mchado");

      tree.prefix();
      System.out.println();
      tree.prefix("Fernan");
      System.out.println();
      tree.prefix("Ma");
      System.out.println();
      tree.prefix("Mal");
      System.out.println();
      tree.prefix("M");
   }

}
