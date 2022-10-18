package Sorts.MergeSort;

import Sorts.Utils.Generator;

public class MergeSort {
    
    public static void main(String[] args) {
        double[] arr = new double[1000];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            mergeSort(arr, 0, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void mergeSort(int[] arr, int first, int last) {
        int[] aux = new int[arr.length];
        mergeSort(aux, arr, first, last - 1);
    }

    public static void mergeSort(int[] aux, int[] arr, int first, int last) { 
        if(first < last) {
            int center = (first + last) / 2;

            mergeSort(aux, arr, center + 1, last);
            mergeSort(aux, arr, first, center);
            merge(aux, arr, first, center, last);
        }
    }
 
    public static void merge(int[] aux, int[] arr, int first, int center, int last) {
        for(int i = first; i <= last; i++) aux[i] = arr[i];

        int i = first,
            j = center + 1;

        for(int k = first; k <= last; k++) {
            if(i > center) arr[k] = aux[j++];
            else if(j > last) arr[k] = aux[i++];
            else if(aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static void mergeSort(double[] arr, int first, int last) {
        double[] aux = new double[arr.length];
        mergeSort(aux, arr, first, last - 1);
    }   

    public static void mergeSort(double[] aux, double[] arr, int first, int last) {
        if(first < last) {
            int center = (first + last) / 2;

            mergeSort(aux, arr, center + 1, last);
            mergeSort(aux, arr, first, center);
            merge(aux, arr, first, center, last);
        }   
    }

    public static void merge(double[] aux, double[] arr, int first, int center, int last) {
        for(int i = first; i <= last; i++) aux[i] = arr[i];

        int i = first,
            j = center + 1;

        for(int k = first; k <= last; k++) {
            if(i > center) arr[k] = aux[j++];
            else if(j > last) arr[k] = aux[i++];
            else if(aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }
 
}
