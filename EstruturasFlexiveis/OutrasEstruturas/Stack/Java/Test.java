package EstruturasFlexiveis.OutrasEstruturas.Stack.Java;

public class Test {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(stack);
        stack.invert();
        System.out.println(stack);
    }

}
