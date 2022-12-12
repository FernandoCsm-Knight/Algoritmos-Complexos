package EstruturasLineares.ArrayListJava;

public class Test {

   public static void main(String[] args) {
      ArrayList<String> strs = new ArrayList<>("Fernando", "Henrique", "Sasha", "Samuel", "o último romântico");
      System.out.println(strs);
      System.out.println(strs.capacity());
      
      strs.add("Luna");
      System.out.println(strs);
      System.out.println(strs.capacity());

      strs.pop("Sasha");
      strs.pop();
      strs.pop();
      strs.pop();
      System.out.println(strs);
      System.out.println(strs.capacity());
  }

}
