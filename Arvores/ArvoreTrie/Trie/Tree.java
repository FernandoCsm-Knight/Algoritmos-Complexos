package Arvores.ArvoreTrie.Trie;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

public class Tree {
   //=====PRIVATE=====//
   private Node root;

   //=====CONSTRUCT=====//
   public Tree() {
      this.setRoot(new Node());
   }

   //=====GET=====//
   private Node getRoot() {
      return root;
   }

   //=====SET=====//
   private void setRoot(Node root) {
      this.root = root;
   }
   
   //=====METHODS=====//
   //=====ADD=====//
   public void add(String s) {
      Node curr = this.getRoot();

      char c;
      for(int i = 0; i < s.length(); i++) {
         c = s.charAt(i);

         if(curr.children[c] == null) 
            curr.children[c] = new Node(c);
         
         curr = curr.children[c];
      }
      
      curr.setWord(true);
   }

   //=====POP=====//
   public void pop(String s) {
      Stack<Node> stack = new Stack<>();

      Node curr = this.getRoot();
      for(int i = 0; i < s.length() && curr.children[s.charAt(i)] != null; i++) {
         stack.push(curr);
         curr = curr.children[s.charAt(i)];
      } 
      
      Boolean value = true;
      for(int i = 0; value && i < curr.size(); i++) 
         value = curr.children[i] == null;
      
      if(curr.isWord() && value) {
         Node prox = curr;
         curr = stack.pop();

         while(curr != this.getRoot() && !curr.isWord()) {
            prox = curr;
            curr = stack.pop();
         } 

         curr.children[prox.getChar()].setChar('\0');
         curr.children[prox.getChar()] = null;
      } else curr.setWord(false);
   }

   //=====CONTAINS=====//
   public Boolean contains(String s) {
      if(s == null || s.isEmpty()) 
         throw new IllegalArgumentException();
      
      return this.search(s) != null;
   }

   private Node search(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr.children[s.charAt(i)] != null; i++) 
         curr = curr.children[s.charAt(i)];

      return curr.isWord() ? curr : null;
   }

   //=====STARTS_WITH=====//
   public Boolean startsWith(String s) {
      return this._startsWith(s) != null;
   }

   private Node _startsWith(String s) {
      Boolean value = s == null || s.isEmpty();
      Node curr = this.getRoot();

      if(!value) {
         for(int i = 0; i < s.length() && curr.children[s.charAt(i)] != null; i++) 
            curr = curr.children[s.charAt(i)];
      }

      return curr;
   }

   //=====PREFIX=====//
   public void prefix() {
      this.prefix("");
   }

   public void prefix(String s) {
      Node node = this._startsWith(s);
      if(node != this.getRoot()) 
         s = s.substring(0, s.length() - 1);

      this.prefix(s, node);
   }

   private void prefix(String s, Node node) {
      if(node.isWord()) System.out.println(s + node.getChar());

      for(int i = 0; i < node.size(); i++) {
         if(node.children[i] != null) 
            this.prefix(s + node.getChar(), node.children[i]);
      }
   }
}
