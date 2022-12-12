package Arvores.ArvoreBinaria.Java.Interativo;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);

        tree.inOrder();
        tree.posOrder();
        System.out.println(tree.contains(80));
        System.out.println(tree.size());
        System.out.println(Arrays.toString(tree.toArray()));
    }
}