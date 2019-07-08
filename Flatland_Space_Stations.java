package hackerrank_public;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Flatland_Space_Stations {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
    	
    	//order space stations 
    	Arrays.sort(c);
    	
    	//select max distance between first city and first space station and between last city and last space station
    	int max=c[0];
    	int max_2=n-c[c.length-1]-1;
    	max=Math.max(max, max_2);
    	
    	// case 1: number of space stations is equal with number of cities
    	if(n==c.length) {max=0;} 
    	
    	//case 2: there is only one space stations
    	else if(c.length==1) {
    		max=Math.max(n-c[c.length-1]-1, c[0]);
    	}
    	
    	//case 3: number of space stations is less than number of cities
    	else {
    		for(int i=0; i<c.length-1; i++) {
        		max_2=(c[i+1]-c[i])/2;
        		max=Math.max(max, max_2);
        	}
    	}	  	 	
    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
