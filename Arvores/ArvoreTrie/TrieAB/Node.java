package Arvores.ArvoreTrie.TrieAB;

import Arvores.ArvoreBinaria.Java.Interativo.BinaryTree;

public class Node implements Comparable<Node> {
   //=====PRIVATE=====//
   public BinaryTree<Node> children = new BinaryTree<>();
   private Character c;
   private Boolean isWord = false;

   //=====CONTRUCTOR=====//
   public Node() {
      this.setChar(null);
   }

   public Node(Character c) {
      this.setChar(c);
   }

   //=====GET=====//
   public BinaryTree<Node> getChild() {
      return children;
   }

   public Character getChar() {
      return c == null ? '\0' : c;
   }

   public Boolean isWord() {
      return isWord;
   }

   //=====SET=====//
   public void setChild(BinaryTree<Node> child) {
      this.children = child;
   }
   
   public void setChar(Character c) {
      this.c = c;
   }

   public void setWord(Boolean isWord) {
      this.isWord = isWord;
   }

   //=====OVERRIDE=====//
   @Override
   public int compareTo(Node node) {
      return  this.getChar() - node.getChar();
   }

   @Override 
   public boolean equals(Object o) {
      return this.getChar() == ((Node)o).getChar();
   }
}
