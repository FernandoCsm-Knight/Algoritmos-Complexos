package Arvores.ArvoreBinaria.Java.Recursivo;

public class Test {
    
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(8);

        tree.pop(2);
        tree.pop(6);
        tree.pop(7);

        tree.inOrder();
        System.out.println(tree.size());
    }

}
