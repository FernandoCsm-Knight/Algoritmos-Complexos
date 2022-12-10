package Arvores.ArvoreTrie.TrieAB;

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
   //=====BOOLEAN=====//
   public Boolean isEmpty() {
      return this.getRoot().children.isEmpty();
   }

   //=====ADD=====//
   public void add(String s) {
      Node curr = this.getRoot(), node;

      for(int i = 0; i < s.length() && curr != null; i++) {
         node = new Node(s.charAt(i));
         if(!curr.children.contains(node))
            curr.children.add(node);
            
         curr = curr.children.get(node);
      }

      curr.setWord(true);
   }

   //=====CONTAINS=====//
   public Boolean contains(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++) 
         curr = curr.children.get(new Node(s.charAt(i)));

      return curr == null ? false : curr.isWord();
   }

   //=====STARTS_WITH=====//
   public Boolean startsWith(String s) {
      return this._startsWith(s) != null;
   }

   public Node _startsWith(String s) {
      Node curr = this.getRoot();

      for(int i = 0; i < s.length() && curr != null; i++) 
         curr = curr.children.get(new Node(s.charAt(i)));

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

   public void prefix(String s, Node curr) {
      if(curr.isWord()) System.out.println(s);

      Object[] obj = curr.children.toArray();
      Node[] arr = new Node[obj.length];
      for(int i = 0; i < arr.length; i++)
         arr[i] = (Node)obj[i];

      for(int i = 0; i < arr.length; i++) 
         this.prefix(s + arr[i].getChar(), arr[i]);
   }

}
