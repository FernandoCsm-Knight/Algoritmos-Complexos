package Sorts.ShellSort;

import Sorts.Utils.Generator;

public class ShellSort {

    public static void main(String[] args) {
        double[] arr = new double[100];
        
        for(int i = 0; i < 100; i++) {
            Generator.generate(arr, 10000);
            shellSort(arr, arr.length);
            System.out.println(Generator.verify(arr)); 
        }
    }

    public static void shellSort(int[] arr, int last) {
        int h = 1;
        while(h < last / 3)
            h = 3 * h + 1;
        
        while(h > 0) {
            for(int i = h; i < last; i++) {
                int aux = arr[i];
                int j = i;
                while(j >= h && aux < arr[j - h]) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = aux;
            }
            h = (h - 1) / 3;
        }
    }

    public static void shellSort(double[] arr, int last) {
        int h = 1;
        while(h < last) 
            h = 3 * h + 1;
        
        while(h > 0) {
            for(int i = h; i < last; i++) {
                double aux = arr[i];
                int j = i;
                while(j >= h && aux < arr[j - h]) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = aux; 
            }
            h = (h - 1) / 3;
        }
    }

}
