package Arvores.ArvoreTrie.Trie;

public class Node {
   //=====PRIVATE=====//
   private Character c;
   private Boolean isWord;
   private final int size = 255;
   
   //=====PUBLIC=====//
   public Node[] children;

   //=====CONSTRUCTOR=====//
   public Node() {
      this(null);
   }

   public Node(Character c) {
      this.setChar(c);
      this.setChildren(new Node[size]);
      this.setWord(false);
   }

   //=====GET=====//
   public int size() {
      return size;
   }

   public Boolean isWord() {
      return this.isWord;
   }

   public Character getChar() {
      return  this.c == null ? '\0' : c;
   }

   //=====SET=====//
   public void setChildren(Node[] children) {
      this.children = children;
   }

   public void setWord(Boolean isWord) {
      this.isWord = isWord;
   }

   public void setChar(Character c) {
      this.c = c;
   }
}
