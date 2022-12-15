package Hash.HashMap;

public class Test {
   
   public static void main(String[] args) {
      HashMap<Character, String> hash = new HashMap<>();

      hash.add('F', "Fernando");
      hash.add('A', "Augusto");
      hash.add('F', "Fabio");
      hash.add('F', "Felipe");
      hash.add('B', "Bernanrdo");
      
      System.out.println(hash);
      System.out.println(hash.contains('F', "Felipe"));
      System.out.println(hash.contains('F', "Fernando"));
      System.out.println(hash.contains('A', "Augusto"));
      System.out.println();
      System.out.println(hash.contains('B', "Augusto"));
      System.out.println(hash.contains('C', "Carlos"));
      System.out.println(hash.contains('F', "Fatima"));
   }

}
