package hackerrank_public;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Absolute_Permutation {

    // Complete the absolutePermutation function below.
	static int[] absolutePermutation(int n, int k) {
        int[] res = new int[n];
        int t = 1;
        for (int i = 0, j = 0; i < n; i++, j++) {
        	//the result array has it`s elements consecutive from k to k
        	/*first k elements are greater than i, the next k elements are less than i 
        	  here is where t make diference  (1 means elements are greater than k,
        	  -1 means that elements are less than k)*/
            if (j == k) {
                t *= -1;
                j = 0;
            }

            int value = i + 1 + k * t;
            //if value is not between 1 and n, return -1, meaning that values isn`t part of our array range
            if (value < 1 || value > n) {
                return new int[]{-1};
            }
            res[i] = value;
        }
        return res;
    }	 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATh"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
