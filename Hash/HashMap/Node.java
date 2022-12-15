package Hash.HashMap;

public class Node<K extends Comparable<K>, V> implements Comparable<Node<K, V>>{
   //=====PRIVATE=====//
   private K key;
   private V value;

   //=====CONSTRUCTOR=====//
   public Node() {
      this(null, null);
   }

   public Node(K key, V value) {
      this.setKey(key);
      this.setValue(value);
   }
   
   //=====GET=====//
   public K getKey() {
      return key;
   }

   public V getValue() {
      return value;
   }

   //=====SET=====//
   public void setKey(K key) {
      this.key = key;
   }

   public void setValue(V value) {
      this.value = value;
   }

   //=====OVERRIDE=====//
   @Override
   public int compareTo(Node<K, V> node) {
      return this.getKey().compareTo(node.getKey());
   }

   @Override
   @SuppressWarnings("unchecked")
   public boolean equals(Object o) {
      return o.getClass() == this.getClass() ? ((Node<K, V>)o).getKey().equals(this.getKey()) && ((Node<K, V>)o).getValue().equals(this.getValue()) : false;
   }

   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("(" + this.getKey() + ") => ");
      sb.append(this.getValue());
      return sb.toString();
   }
}
