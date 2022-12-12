package Arvores.ArvoreTrie.TrieLinkedList;

import java.util.LinkedList;

public class Node {
   //=====PRIVATE=====//
   public LinkedList<Node> children = new LinkedList<>();
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
   public LinkedList<Node> getChildren() {
      return children;
   }

   public Character getChar() {
      return c == null ? '\0' : c;
   }

   public Node get(Character c) {
      for(Node node : children) 
         if(node.getChar() == c) 
            return node;
      return null;
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
