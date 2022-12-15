package Hash.HashMap;

import java.util.ArrayList;
import EstruturasFlexiveis.ListaDuplamenteEncadeada.Java.LinkedList;

public class HashMap<K extends Comparable<K>, V> {
   //=====PRIVATE=====//
   private int cap = 100;
   private int length = 0;
   private ArrayList<LinkedList<Node<K, V>>> list;

   //=====CONSTRUCTOR=====//
   public HashMap() {
      this.setList(new ArrayList<LinkedList<Node<K, V>>>(this.capacity()));
      
      for(int i = 0; i < this.capacity(); i++) 
         this.getList().add(new LinkedList<Node<K, V>>());
   }

   public HashMap(int cap) {
      this.setCapacity(cap);
      this.setList(new ArrayList<LinkedList<Node<K, V>>>(this.capacity()));

      for(int i = 0; i < this.capacity(); i++) 
         this.getList().add(new LinkedList<Node<K, V>>());
   }

   //=====GET=====//
   private ArrayList<LinkedList<Node<K, V>>> getList() {
      return list;
   }

   public int capacity() {
      return cap;
   }

   public int size() {
      return length;
   }

   //=====SET=====//
   private void setCapacity(int cap) {
      this.cap = cap;
   }

   private void setLength(int length) {
      this.length = length;
   }

   private void setList(ArrayList<LinkedList<Node<K, V>>> list) {
      this.list = list;
   }

   //=====METHODS=====//
   //=====BOOLEAN=====//
   public Boolean isEmpty() {
      return this.getList().isEmpty();
   }

   //=====HASH=====//
   private int hash(K key) {
      return key.hashCode() % this.capacity();
   }

   //=====ADD=====//
   public Boolean add(K key, V value) {
      int index = this.hash(key);
      Node<K, V> node = new Node<>(key, value);

      Boolean response = !this.getList().get(index).contains(node);
      if(response) {
         this.getList().get(index).add(node);
         this.setLength(this.size() + 1);
      }

      return response;
   }

   //=====POP=====//
   public Boolean pop(K key, V value) {
      int index = this.hash(key);
      Node<K, V> node = new Node<>(key, value);

      Boolean response = this.getList().get(index).contains(node);
      if(response) {
         this.getList().get(index).pop(node); 
         this.setLength(this.size() - 1);
      }

      return response;
   }

   //=====CONTAINS=====//
   public Boolean contains(K key, V value) {
      int index = this.hash(key);

      return this.getList().get(index).contains(new Node<K, V>(key, value));
   }

   //=====CLEAR=====//
   public void clear() {
      this.getList().clear();
      this.setList(new ArrayList<LinkedList<Node<K, V>>>(this.capacity()));

      for(int i = 0; i < this.capacity(); i++) 
         this.getList().add(new LinkedList<Node<K, V>>());
   }

   //=====OVERRIDE=====//
   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();

      for(int i = 0; i < this.getList().size(); i++) 
         sb.append(i + " => " + this.getList().get(i).toString() + '\n');

      return sb.toString();
   }
}
