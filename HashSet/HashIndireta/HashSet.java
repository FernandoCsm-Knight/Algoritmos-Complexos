package HashIndireta;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashSet<T> {
   //=====PRIVATE=====//
   private ArrayList<LinkedList<T>> table;
   private int cap = 87;

   //=====CONSTRUCTOR=====//
   public HashSet() {
      this.setTable(new ArrayList<LinkedList<T>>(this.cap));

      for(int i = 0; i < this.table.size(); i++) 
         this.table.set(i, new LinkedList<T>());
   }

   public HashSet(int cap) {
      this.setCapacity(cap);
      this.setTable(new ArrayList<LinkedList<T>>(this.cap));

      for(int i = 0; i < this.table.size(); i++) 
         this.table.set(i, new LinkedList<T>());
   }

   //=====GET=====//
   public ArrayList<LinkedList<T>> getTable() {
      return table;
   }

   public int capacity() {
      return cap;
   }

   //=====SET=====//
   public void setTable(ArrayList<LinkedList<T>> table) {
      this.table = table;
   }

   public void setCapacity(int cap) {
      this.cap = cap;
   }

   //=====METHODS=====//
   //=====ADD=====//
   public void add(T obj) {
      table.get(obj.hashCode() % this.capacity()).add(obj);
   }

   //=====POP=====//
   public void pop(T obj) {
      table.get(obj.hashCode() % this.capacity()).remove(obj);
   }

   //=====CONTAINS=====//
   public Boolean contains(T obj) {
      return table.get(obj.hashCode() % this.capacity()).contains(obj);
   }

   //=====CLEAR=====//
   public void clear() {
      for(int i = 0; i < this.table.size(); i++) 
         this.table.get(i).clear();
   }

}
