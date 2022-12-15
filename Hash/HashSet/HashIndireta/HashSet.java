package Hash.HashSet.HashIndireta;

import java.util.ArrayList;
import EstruturasFlexiveis.ListaDuplamenteEncadeada.Java.LinkedList;

public class HashSet<T extends Comparable<T>> {
   //=====PRIVATE=====//
   private ArrayList<LinkedList<T>> table;
   private int cap = 87;

   //=====CONSTRUCTOR=====//
   public HashSet() {
      this.setTable(new ArrayList<LinkedList<T>>(this.cap));

      for(int i = 0; i < this.capacity(); i++) 
         this.table.add(new LinkedList<T>());
   }

   public HashSet(int cap) {
      this.setCapacity(cap);
      this.setTable(new ArrayList<LinkedList<T>>(this.cap));

      for(int i = 0; i < this.capacity(); i++) 
         this.table.add(new LinkedList<T>());
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
   public Boolean add(T obj) {
      int index = obj.hashCode() % this.capacity();
      Boolean value = obj != null && !table.get(index).contains(obj);
      if(value) table.get(index).add(obj);
      
      return value;
   }

   //=====POP=====//
   public Boolean pop(T obj) {
      int index = obj.hashCode() % this.capacity();
      Boolean value = obj != null && table.get(index).contains(obj);
      if(value) table.get(index).pop(obj);

      return value;
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
