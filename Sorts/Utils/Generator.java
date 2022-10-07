package Sorts.Utils;

import java.util.Random;

/**
 * @author Fernando Campos Silva Dal Maria
 * @version 1.0
 */
public class Generator {
    
    private static Random r = new Random();

    public static void generate(int[] arr, int range) {
        for(int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(range);
    }

    public static void generate(double[] arr, int range) {
        for(int i = 0; i < arr.length; i++)
            arr[i] = r.nextDouble() * range;
    }

    public static Boolean verify(int[] arr) {
        Boolean value = true;
        for(int i = 0; value && i < arr.length - 1; i++) 
            value = arr[i] <= arr[i + 1];
        return value;
    }

    public static Boolean verify(int[] arr, int first, int last) {
        Boolean value = true;
        for(int i = first; value && i < last - 1; i++) 
            value = arr[i] <= arr[i + 1]; 
        return value;
    }

    public static Boolean verify(double[] arr) {
        Boolean value = true;
        for(int i = 0; value && i < arr.length - 1; i++) 
            value = arr[i] <= arr[i + 1];
        return value;
    }

    public static Boolean verify(double[] arr, int first, int last) {
        Boolean value = true;
        for(int i = first; value && i < last - 1; i++) 
            value = arr[i] <= arr[i + 1]; 
        return value;
    }

}
