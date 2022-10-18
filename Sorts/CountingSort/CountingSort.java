package Sorts.CountingSort;

import Sorts.Utils.Generator;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            countingSort(arr, 0, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void countingSort(int[] arr, int first, int last) {
        int[] aux = new int[max(arr, first, last) + 1];

        for(int i = first; i < last; i++) 
            aux[arr[i]]++;
        
        for(int i = 0, k = first; i < aux.length; i++)
            for(int j = aux[i]; j > 0; j--)
                arr[k++] = i;
    }

    public static int max(int[] arr, int first, int last) {
        int i = arr[first];
        for(int j = first + 1; j < last; j++) 
            if(arr[j] > i) i = arr[j];
        return i;
    }

}
