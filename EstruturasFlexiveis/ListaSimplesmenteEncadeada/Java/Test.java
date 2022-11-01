package EstruturasFlexiveis.ListaSimplesmenteEncadeada.Java;

public class Test {
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>("Fernando", "Maria");
        list.add("Campos", 1);
        list.add("Silva", 2);
        list.add("Dal", 3);
        System.out.println(list);
        list.invert();
        System.out.println(list);
    }

}
