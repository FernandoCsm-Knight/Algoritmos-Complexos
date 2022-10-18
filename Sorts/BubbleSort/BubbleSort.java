package Sorts.BubbleSort;

import Sorts.Utils.Generator;

/**
 * @author Fernando Campos Silva Dal Maria
 * @version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        double[] arr = new double[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            bubbleSort(arr, 0, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void bubbleSort(int[] arr, int first, int last) {
        for(int i = first; i < last - 1; i++) for(int j = first; j < last - i - 1; j++) if(arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }

    public static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public static void bubbleSort(double[] arr, int first, int last) {
        for(int i = first; i < last - 1; i++) for(int j = 0; j < last - i - 1; j++) if(arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }

    public static void swap(double[] arr, int a, int b) {
        double aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

}