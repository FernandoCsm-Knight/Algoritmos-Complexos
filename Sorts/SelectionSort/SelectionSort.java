package Sorts.SelectionSort;

import Sorts.Utils.Generator;

public class SelectionSort {
    
    public static void main(String[] args) {
        double[] arr = new double[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            selectionSort(arr, 0, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void selectionSort(int[] arr, int first, int last) {
        int min;
        for(int i = first; i < last - 1; i++) {
            min = i;
            for(int j = i + 1; j < last; j++) 
                if(arr[j] < arr[min]) min = j;
                
            if(i != min) swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public static void selectionSort(double[] arr, int first, int last) {
        int min;
        for(int i = first; i < last - 1; i++) {
            min = i;
            for(int j = i + 1; j < last; j++)
                if(arr[j] < arr[min]) min = j;
            
            if(i != min) swap(arr, i, min);
        }
    }

    public static void swap(double[] arr, int a, int b) {
        double aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
