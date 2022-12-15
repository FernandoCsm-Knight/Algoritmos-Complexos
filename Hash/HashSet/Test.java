package Hash.HashSet;

import Hash.HashSet.HashDiretaComReserva.HashSet;

public class Test {

   public static void main(String[] args) {
      HashSet<Integer> hash = new HashSet<>();

      System.out.println(hash.capacity());
      System.out.println(hash.getTable().size());

      System.out.println(hash.add(1));
      System.out.println(hash.add(2));
      System.out.println(hash.add(3));
      System.out.println(hash.add(3));
      
      System.out.println(hash.pop(3));
      System.out.println(hash.add(3));
   }

}