package Arvores.ArvoreBinaria.Java.Recursivo;

public class Test {
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree aaaaaaaaaa = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(8);
        tree.inOrder();
        tree.preOrder();
        tree.posOrder();

        aaaaaaaaaa.add(5);
        aaaaaaaaaa.add(3);
        aaaaaaaaaa.add(7);
        aaaaaaaaaa.add(1);
        aaaaaaaaaa.add(2);
        aaaaaaaaaa.add(6);
        aaaaaaaaaa.add(8);
        System.out.println(tree.max());
        System.out.println(tree.sum());
        System.out.println(tree.even());
        System.out.println(tree.equals(aaaaaaaaaa));
    }

}
