package Arvores.ArvoreTrie.Trie;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

public class Tree {
   //=====PRIVATE=====//
   private Node root;

   //=====CONSTRUCTOR=====//
   public Tree() {
      this.setRoot(new Node());
   }

   public Tree(String... arr) {
      this.setRoot(new Node());
      for(String s : arr) add(s);
   }

   //=====GET=====//
   public Node getRoot() {
      return root;
   }

   //=====SET=====//
   public void setRoot(Node root) {
      this.root = root;
   }

   //=====METHODS=====//
   //=====BOOLEAN=====//
   public Boolean isEmpty() {
      return this._isEmpty(this.getRoot());
   }

   private Boolean _isEmpty(Node curr) {
      Boolean value = true;
      for(int i = 0; value && i < Node.size(); i++) 
         value = curr.children[i] == null;
      return value;
   }

   //=====ADD=====//
   public Boolean add(String s) {
      Node curr = this.getRoot();

      for(char c : s.toCharArray()) {
         if(curr.children[c] == null) 
            curr.children[c] = new Node(c);

         curr = curr.children[c];
      }

      curr.setWord(true);
      return true;
   }

   //=====POP=====//
   public Boolean pop(String s) {
      if(s == null || s.isEmpty()) 
         throw new IllegalArgumentException();
         
      Stack<Node> stack = new Stack<>();

      Node curr = this.getRoot();
      for(int i = 0; i < s.length() && curr != null; i++) {
         stack.push(curr);
         curr = curr.children[s.charAt(i)];
      } 
      
      if(curr == null) return false;

      if(curr.isWord() && this._isEmpty(curr)) {
         Node next = curr;
         curr = stack.pop();
         
         while(!curr.isWord() && this._isEmpty(curr) && !stack.isEmpty()) {
            next = curr;
            curr = stack.pop();
         }

         if(next != null) curr.children[next.getChar()] = null;
      } else curr.setWord(false);

      return true;
   }

   //=====CONTAINS=====//
   public Boolean contains(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++) 
         curr = curr.children[s.charAt(i)];

      return curr == null ? false : curr.isWord();
   }

   //=====STARTS_WITH=====//
   public Boolean startsWith(String s) {
      return this._startsWith(s) != null;
   }

   private Node _startsWith(String s) {
      Node curr = this.getRoot();

      for(int i = 0; s != null && i < s.length() && curr != null; i++) 
         curr = curr.children[s.charAt(i)];

      return curr;
   }

   //=====PREFIX=====//
   public void prefix() {
      this.prefix("");
   }

   public void prefix(String s) {
      Node node = this._startsWith(s);
      if(node != null) this.prefix(s, node);
   }

   private void prefix(String s, Node node) {
      if(node.isWord()) System.out.println(s);

      for(int i = 0; i < Node.size(); i++) 
         if(node.children[i] != null)
            this.prefix(s + node.children[i].getChar(), node.children[i]);
   }  
}