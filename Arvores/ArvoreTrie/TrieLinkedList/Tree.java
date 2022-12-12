package Arvores.ArvoreTrie.TrieLinkedList;

import EstruturasFlexiveis.OutrasEstruturas.Stack.Java.Stack;

public class Tree {
   //====PRIVATE=====//
   private Node root;

   //=====CONSTRUCTOR=====//
   public Tree() {
      this.setRoot(new Node());
   }

   public Tree(String... arr) {
      this.setRoot(new Node());
      for(String s : arr) this.add(s);
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
      return this.getRoot().children.isEmpty();
   }

   //=====ADD=====//
   public Boolean add(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length(); i++) {
         if(curr.get(s.charAt(i)) == null) 
            curr.children.add(new Node(s.charAt(i)));
         
         curr = curr.get(s.charAt(i));
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
         curr = curr.get(s.charAt(i));
      }

      if(curr == null) return false;

      if(curr.isWord() && curr.children.isEmpty()) {
         Node next = curr;
         curr = stack.pop();

         while(!curr.isWord() && curr.children.isEmpty() && !stack.isEmpty()) {
            next = curr;
            curr = stack.pop();
         }
         
         if(next != null) curr.children.remove(curr.children.indexOf(next));
      } else curr.setWord(false);

      return true;
   }

   //=====CONTAINS=====//
   public Boolean contains(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++) 
         curr = curr.get(s.charAt(i));

      return curr == null ? false : curr.isWord();
   }

   //=====STARTS_WITH=====//
   public Boolean startsWith(String s) {
      return this._startsWith(s) != null;
   }

   private Node _startsWith(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++) 
         curr = curr.get(s.charAt(i));

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

   private void prefix(String s, Node curr) {
      if(curr.isWord()) System.out.println(s);

      for(Node node : curr.children) 
         this.prefix(s + node.getChar(), node);
   }  
}
