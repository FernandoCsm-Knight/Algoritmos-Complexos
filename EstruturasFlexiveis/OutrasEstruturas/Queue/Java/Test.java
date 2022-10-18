package EstruturasFlexiveis.OutrasEstruturas.Queue.Java;

public class Test {
    
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(queue);
        queue.invert();
        System.out.println(queue);
    }

}
