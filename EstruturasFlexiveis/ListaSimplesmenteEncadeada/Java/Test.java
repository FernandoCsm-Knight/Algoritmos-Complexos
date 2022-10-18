package EstruturasFlexiveis.ListaSimplesmenteEncadeada.Java;

public class Test {
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>("Fernando", "Maria");
        list.add("Fernando", 1);
        list.add("Silva", 2);
        list.add("Fernando", 3);
        System.out.println(list);
        list.replaceAll("Fernando", "Rodrigo");
        System.out.println(list);
    }

}
