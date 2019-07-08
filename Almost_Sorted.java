package hackerrank_public;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Almost_Sorted {

	// Complete the almostSorted function below.
	static void almostSorted(int[] arr) {
	    //   First of all I needed to ints to count indexes later on   (i1 and i2)
	    // and I also needed to clone and sort the first array. "arrS" and "arrR" are
	    // there for later use in reversing and swapping.
	    int i1 = 0;
	    int i2 = arr.length-1;
	    int[] arrSorted = arr.clone();
	    int[] arrS;
	    int[] arrR;
	    Arrays.sort(arrSorted);

	    //  This decisional structure first checks if the array is sorted, if it is not
	    // it goes on to getting the indexes (i1 and i2) at which the original array (arr)
	    // differs from the sorted array (arrSorted)
	    if( Arrays.equals(arr, arrSorted) ){
	        System.out.println("yes");
	    }else{
	        //  This loop will find the first differing index - i1
	        for (int i = 0; i <= arr.length-1; i++){
	            if(arr[i]!=arrSorted[i]){
	                i1 = i;
	                i= arr.length;
	            }
	        }
	        //  This loop will find the second differing index - i2
	        for (int i = arr.length-1; i >= 0; i--){
	            if(arr[i]!=arrSorted[i]){
	                i2 = i;
	                i= -1;
	            }
	        }

	        //  Now I needed to assign values to the swap and/or sorted array/s
	        // The methods for them are declared lower in the code. Both of them use
	        // an iterative approach.
	        arrS = swap(arr, i1, i2);
	        arrR = reverse(arr, i1, i2);

	        //  Only for debugging purposes, the commented out lines print to screen
	        // the arrays "arrS" and "arrR".
	        /*
	        System.out.println("i1 = "+i1+"; i2 = "+i2+";\nSwap: ");
	        for(int x : arrS){
	            System.out.print(x);
	        }
	        System.out.println("\nReverse: ");
	        for(int x : arrR){
	            System.out.print(x);
	        }
	        System.out.println();*/

	        //  And now this nested decisional structure will handle the printing to screen.
	        // In order to check equality beetween arrR (reversed), arrS(sorted) and arrSorted
	        // I used the method 'equals' from the 'Arrays' class from Java.util.*.
	        if(Arrays.equals(arrR, arrSorted) && Arrays.equals(arrS, arrSorted)){
	            System.out.println("yes\nswap "+(i1+1)+" "+(i2+1));
	        }else if(Arrays.equals(arrS, arrSorted)){
	            System.out.println("yes\nswap "+(i1+1)+" "+(i2+1));
	        }else if(Arrays.equals(arrR, arrSorted)){
	            System.out.println("yes\nreverse "+(i1+1)+" "+(i2+1));
	        }else{
	            System.out.println("no");
	        }
	    }
	}
	//an iterative approach for a swap method
	static int[] swap(int[] arr, int i1, int i2){
	    //result array
	    int[] rez = new int[arr.length];
	    //iterate from 0 to i1
	    for(int i = 0; i < i1; i++){
	        rez[i] = arr[i];}
	    //swap i1 with i2
	    rez[i1] = arr[i2];
	    //from i1 to i2
	    for(int i = (i1+1); i < (i2); i++){
	        rez[i] = arr[i];}
	    //swap i2 with i1
	    rez[i2] = arr[i1];
	    //from i2 to end of array
	    for(int i = (i2+1); i < arr.length; i++){
	        rez[i] = arr[i];}
	    return rez;
	}
	//an iterative approach for a reverse method
	static int[] reverse(int[] arr, int i1, int i2){
	    int[] rez = arr.clone();
	    //iterate from i2 to i1 while assigning values from an incrementing y
	    for(int i = i2, y = i1; i>=i1; i--){
	        rez[i] = arr[y++];
	    }
	    return rez;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	    int n = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    int[] arr = new int[n];

	    String[] arrItems = scanner.nextLine().split(" ");
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    for (int i = 0; i < n; i++) {
	        int arrItem = Integer.parseInt(arrItems[i]);
	        arr[i] = arrItem;
	    }

	    almostSorted(arr);

	    scanner.close();
	}
}
    



