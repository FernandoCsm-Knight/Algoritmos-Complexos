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
        int[] out = new int[arr.length],
              count = new int[max(arr, first, last) + 1];

        for(int i = first; i < last; i++) 
            count[arr[i]]++;
        
        for(int i = 0; i < count.length - 1; i++) 
            count[i + 1] += count[i];

        for(int i = last - 1; i >= first; i--) {
            out[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for(int i = first; i < last; i++) 
            arr[i] = out[i];
    }

    public static int max(int[] arr, int first, int last) {
        int max = arr[first];
        for(int i = first + 1; i < last; i++) 
            if(arr[i] > max) max = arr[i];

        return max;
    }

}
