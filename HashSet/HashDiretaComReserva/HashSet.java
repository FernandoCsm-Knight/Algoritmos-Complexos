package HashSet.HashDiretaComReserva;

import java.util.ArrayList;

public class HashSet<T extends Comparable<T>> {
   //=====PRIVATE=====//
   private ArrayList<T> table;
   private int cap = 90;
   private int sup = 10;

   //=====CONSTRUCTOR=====//
   public HashSet() {
      this.setTable(new ArrayList<T>(this.capacity() + this.getSup()));
   }

   public HashSet(int cap) {
      this.setCapacity((int)Math.ceil(cap * 0.9));
      this.setSup((int)Math.ceil(cap * 0.1));
      this.setTable(new ArrayList<T>(this.capacity() + this.getSup()));
   }

   //=====GET=====//
   private int getSup() {
      return sup;
   }

   public int capacity() {
      return cap;
   }

   //=====SET=====//
   private void setTable(ArrayList<T> table) {
      this.table = table;
   }

   private void setCapacity(int cap) {
      this.cap = cap;
   }

   private void setSup(int sup) {
      this.sup = sup;
   }

   //=====METHOD=====//
   //=====ADD=====//
   public Boolean add(T obj) {
      if(obj == null) throw new InsertionError();
      Boolean response = true;

      int index = obj.hashCode() % this.capacity();
      if(this.table.get(index) == null) this.table.set(index, obj);
      else if(obj.compareTo(this.table.get(index)) != 0) {
         int i = 0;
         Boolean value = false;
         
         while(!value && i < this.getSup() && this.table.get(this.capacity() + i) != null) {
            value = obj.compareTo(this.table.get(this.capacity() + i)) == 0;
            i++;
         }

         if(!value && i < this.getSup()) this.table.set(this.capacity() + i, obj);
         response = !value;
      } else response = false;
      
      return response;
   }

   //=====POP=====//
   public Boolean pop(T obj) {
      if(obj == null) throw new RemoveError();
      Boolean response = true;

      int index = obj.hashCode()  % this.capacity();
      if(this.table.get(index) == null) response = false;
      else if(obj.compareTo(this.table.get(index)) == 0) this.table.set(index, null);
      else {
         int i = 0;
         Boolean value = false;

         while(!value && i < this.getSup() && this.table.get(this.capacity() + i) != null) {
            value = obj.compareTo(this.table.get(this.capacity() + i)) == 0;
            i++;
         }

         if(value) this.table.set(this.capacity() + i - 1, null);
         response = value;
      }

      return response;
   }

   //=====CONTAINS=====//
   public Boolean contains(T obj) {
      Boolean response = false;
      
      if(obj != null) {
         int index = obj.hashCode() % this.capacity();
         if(this.table.get(index) != null) {
            if(obj.compareTo(this.table.get(index)) == 0) response = true;      
            else {
               int i = 0;
               Boolean value = false;

               while(!value && i < this.getSup() && this.table.get(this.capacity() + i) != null) {
                  value =  obj.compareTo(this.table.get(this.capacity() + i)) == 0;
                  i++;
               }

               response = value;
            }
         }
      } 

      return response;
   }

   //=====CLEAR=====//
   public void clear() {
      this.table.clear();
   }
}
