package Sorts.QuickSort;

import Sorts.Utils.Generator;

public class QuickSort {

    public static void main(String[] args) {
        double[] arr = new double[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            quickSort(arr, 0, arr.length - 1);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void quickSort(int[] arr, int first, int last) {
        if(first < last) {
            int p = partition(arr, first, last);

            quickSort(arr, p, last);
            quickSort(arr, first, p - 1);
        }
    }

    public static int partition(int[] arr, int first, int last) {
        int p = arr[(first + last) / 2],
            i = first,
            j = last;

        while(i <= j) {
            while(arr[i] < p) i++;
            while(arr[j] > p) j--;
            if(i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    public static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public static void quickSort(double[] arr, int first, int last) {
        if(first < last) {
            int p = partition(arr, first, last);

            quickSort(arr, p, last);
            quickSort(arr, first, p - 1);
        }
    }

    public static int partition(double[] arr, int first, int last) {
        double p = arr[(first + last) / 2];

        int i = first,
            j = last;
        
        while(i <= j) {
            while(arr[i] < p) i++;
            while(arr[j] > p) j--;
            if(i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    public static void swap(double[] arr, int a, int b) {
        double aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

}