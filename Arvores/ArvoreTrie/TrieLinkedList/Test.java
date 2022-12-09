package Arvores.ArvoreTrie.TrieLinkedList;

public class Test {
   
   public static void main(String[] args) {
      Tree tree = new Tree("Fer", "Fernando", "Fernanda");

      tree.prefix();
      System.out.println();
      tree.prefix("Fernan");
   }

}
