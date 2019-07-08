package hackerrank_public;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FormingMagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
               
        int changes=1000;
        int changes_2=0;
        ArrayList <int [][]>magicSquares = new ArrayList<int [][]>();
    
        //we can create 8 magic squares following the rules
        int [][] values1 = { {8,3,4}, {1,5,9}, {6,7,2},};
        int [][] values2 = { {4,3,8}, {9,5,1}, {2,7,6},};
        int [][] values3 = { {8,1,6}, {3,5,7}, {4,9,2},};
        int [][] values4 = { {4,9,2}, {3,5,7}, {8,1,6},};
        int [][] values5 = { {6,7,2}, {1,5,9}, {8,3,4},};
        int [][] values6 = { {2,7,6}, {9,5,1}, {4,3,8},};
        int [][] values7 = { {6,1,8}, {7,5,3}, {2,9,4},};
        int [][] values8 = { {2,9,4}, {7,5,3}, {6,1,8},};
        
        magicSquares.add(values1);
        magicSquares.add(values2);
        magicSquares.add(values3);
        magicSquares.add(values4); 
        magicSquares.add(values5);
        magicSquares.add(values6);
        magicSquares.add(values7);
        magicSquares.add(values8);
        
        //check if your imput matches partial any model from those 8 magic patterns 
        int n=0;       
        while(n<8){
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                                     
                     if(s[i][j]!=magicSquares.get(n)[i][j]) {                                                
                          changes_2=changes_2+Math.abs(magicSquares.get(n)[i][j]-s[i][j]);                    }
                }                
            }
            if(changes_2<changes) {changes=changes_2;}
            changes_2=0;            
            n++;
        }       
        return changes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}