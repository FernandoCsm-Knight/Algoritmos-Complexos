package Sorts.HeapSort;

import Sorts.Utils.Generator;

public class HeapSort {
    
    public static void main(String[] args) {
        double[] arr = new double[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            heapSort(arr, 0, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void heapSort(int[] arr, int first, int last) {
        for(int i = (last - 1) / 2; i >= first; i--) 
            heapify(arr, i, last - 1);
        
        for(int i = last - 1; i >= first; i--) {
            swap(arr, first, i);
            heapify(arr, first, i - 1);
        }
    }

    public static void heapify(int[] arr, int first, int last) {
        int aux = arr[first],
            son = first * 2 + 1;

        while(son <= last) {
            if(son < last && arr[son] < arr[son + 1]) son++;

            if(arr[son] > aux) {
                arr[first] = arr[son];
                first = son;
                son = first * 2 + 1;
            } else son = last + 1;
        }   

        arr[first] = aux;
    }

    public static void heapSort(double[] arr, int first, int last) {
        for(int i = (last + 1) / 2; i >= first; i--)
            heapify(arr, i, last - 1);

        for(int i = last - 1; i >= first; i--) {
            swap(arr, first, i);
            heapify(arr, first, i - 1);
        }
    }

    public static void heapify(double[] arr, int first, int last) {
        double aux = arr[first];
        int son = first * 2 + 1;

        while(son <= last) {
            if(son < last && arr[son] < arr[son + 1]) son++;

            if(arr[son] > aux) {
                arr[first] = arr[son];
                first = son;
                son = first * 2 + 1;
            } else son = last + 1;
        }

        arr[first] = aux;
    }

    public static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public static void swap(double[] arr, int a, int b) {
        double aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

}
