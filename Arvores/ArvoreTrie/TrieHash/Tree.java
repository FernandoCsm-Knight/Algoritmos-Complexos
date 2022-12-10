package Arvores.ArvoreTrie.TrieHash;

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
   public Boolean isEmpty() {
      return this.getRoot().children.isEmpty();
   }

   //=====ADD=====//
   public void add(String s) {
      Node curr = this.getRoot();

      for(char c : s.toCharArray()) {
         if(!curr.children.containsKey(c)) 
            curr.children.put(c, new Node(c));
         
         curr = curr.children.get(c);
      }

      curr.setWord(true);
   }

   //=====POP=====//
   public void pop(String s) {
      if(s == null || s.isEmpty())
         throw new IllegalArgumentException();
      
      Stack<Node> stack = new Stack<>();
   
      Node curr = this.getRoot();
      for(int i = 0; i < s.length() && curr != null; i++) {
         stack.push(curr);
         curr = curr.children.get(s.charAt(i));
      }

      if(curr != null) {
         if(curr.isWord() && curr.children.isEmpty()) {
            Node next = curr;
            curr = stack.pop();
            
            while(!curr.isWord() && curr.children.isEmpty() && !stack.isEmpty()) {
               next = curr;
               curr = stack.pop();
            }

            if(next != null) curr.children.remove(next.getChar());
         } else curr.setWord(false);
      }
   } 

   //=====CONTAINS=====//
   public Boolean contains(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++) 
         curr = curr.children.get(s.charAt(i));
      
      return curr == null ? false : curr.isWord();
   }

   //=====STARTS_WITH=====//
   public Boolean startsWith(String s ) {
      return this._startsWith(s) != null;
   }

   public Node _startsWith(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++)
         curr = curr.children.get(s.charAt(i));

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

      for(Node node : curr.children.values())
         this.prefix(s + node.getChar(), node);
   }
}
