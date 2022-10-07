package Sorts.InsertionSort;

import Sorts.Utils.Generator;

public class InsertionSort {
    
    public static void main(String[] args) {
        double[] arr = new double[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            insertionSort(arr, 0, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void insertionSort(int[] arr, int first, int last) {
        for(int i = first + 1; i < last; i++) {
            int aux = arr[i],
                j = i;
            while(j > first && arr[j - 1] > aux) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = aux;
        }
    }

    public static void insertionSort(double[] arr, int first, int last) {
        for(int i = first + 1; i < last; i++) {
            double aux = arr[i];
            int j = i;
            while(j > first && arr[j - 1] > aux) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = aux;
        }
    }

}
