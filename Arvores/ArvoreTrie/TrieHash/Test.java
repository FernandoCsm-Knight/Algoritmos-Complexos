package Arvores.ArvoreTrie.TrieHash;

public class Test {
   
   public static void main(String[] args) {
      Tree tree = new Tree("Fer", "Fernando", "Fernanda", "Talles", "Tall", "Ian", "Ivan", "Itan");

      tree.pop("Ivan");

      tree.prefix();
      System.out.println();
      tree.prefix("Fernan");
      System.out.println();
      tree.prefix("I");
      System.out.println();
      tree.prefix("Ia");
   }

}
