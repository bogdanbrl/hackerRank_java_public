package hackerrank_public;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Cavity_Map {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
   	  	
    	String [] newGrid=new String [grid.length];
    	newGrid[0]=grid[0];
    	newGrid[newGrid.length-1]=grid[grid.length-1];
    	for(int i=1; i<grid.length-1; i++) {
    		newGrid[i]=""+grid[i].charAt(0);
    		for(int j=1; j<grid.length-1; j++) {  
    			//check out if element is greater 
    				if(((grid[i-1].charAt(j)-48)<(grid[i].charAt(j)-48)) &&
    					((grid[i].charAt(j-1)-48)<(grid[i].charAt(j)-48)) &&
    					((grid[i+1].charAt(j)-48)<(grid[i].charAt(j)-48)) &&
    					((grid[i].charAt(j+1)-48)<(grid[i].charAt(j)-48))) 
    				{					
    					newGrid[i]=newGrid[i]+"X";
    				} else {
    					newGrid[i] = newGrid[i]+grid[i].charAt(j);
    				}  			
    		}
    		newGrid[i] = newGrid[i] + grid[i].charAt( grid[i].length()-1 );
    	}   	
    	return newGrid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
