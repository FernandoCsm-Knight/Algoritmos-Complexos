package Arvores.ArvoreTrie.TrieHash;

import java.util.HashMap;

public class Node {
   //=====PRIVATE=====//
   public HashMap<Character, Node> children = new HashMap<>();
   private Character c;
   private Boolean isWord = false;

   //=====CONSTRUCTOR=====//
   public Node() {
      this(null);
   }

   public Node(Character c) {
      this.setChar(c);
   }

   //=====GET=====//
   public Character getChar() {
      return c;
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
