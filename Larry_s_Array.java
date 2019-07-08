package hackerrank_public;

import java.io.*;
import java.util.*;

public class Larry_s_Array {

    public static void main(String[] args) {
    	
    	//insert your array
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i=0; i<t; i++){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j=0; j<n; j++){
                a[j]=scanner.nextInt();
            }
          //check if the previous element is greater than the next one
            bubleSort(a,n);
            // after changing posstions, check if the last but one element is less than the last one
            // if so print "YES", otherwise print "NO"
            System.out.println(a[n-2]<a[n-1]?"YES":"NO");
        }
    }
    
    public static void bubleSort(int[] array, int n){
    	
        for (int i=0; i<n-2; i++){
            for (int j=n-2-1; j>=i; j--){
                while (array[j]>array[j+1]||array[j]>array[j+2]) {
                	// if so, change their possitions
                    rotate(array,j);
                }
            }
        }
    }
    
    public static void rotate(int[] arr, int a){
    	
        int temp = arr[a];
        arr[a] = arr[a+1];
        arr[a+1] = arr[a+2];
        arr[a+2] = temp;
    }
}

