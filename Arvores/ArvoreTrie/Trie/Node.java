package Arvores.ArvoreTrie.Trie;

public class Node {
   //=====PRIVATE=====//
   private static final int size = 255;
   public Node[] children;
   private Character c;
   private Boolean isWord = false;

   //=====CONSTRUCTOR=====//
   public Node() {
      this(null);
   }

   public Node(Character c) {
      this.children = new Node[size];
      this.setChar(c);
   }

   //=====GET=====//
   public static int size() {
      return size;
   }

   public Character getChar() {
      return c == null ? '\0' : c;
   }

   public Boolean isWord() {
      return isWord;
   }

   //=====SET=====//
   public void setChar(Character c) {
      this.c = c;
   }

   public void setWord(Boolean isWord) {
      this.isWord = isWord;
   }

}
