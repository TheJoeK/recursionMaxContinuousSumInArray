/*
 * Joseph Kelly
 * CSC 345 Recursive max sum calculor
 * Program determine the highest sum of an array recursively
 * (arrays can include negative values)
 */
package maxcontsum_kelly_joseph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class MaxContSum_Kelly_Joseph {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        
        //import file from source folder
        Scanner fileScan = new Scanner(new File("src/List.dat"));
        
        System.out.println("Largest sum of " + "\t\t"+ "The list used");
        System.out.println("consecutive integers");
        
        //while loop to read imported file, create string array, create 
        //int array with length determined by first element of String array
        
        while(fileScan.hasNextLine()){
            
            // variable/ array declaration
            String curLine = fileScan.nextLine();
            
            // .split removes value provided in parentheses -VERY HELPFUL
            String[] allNumbers = curLine.split(",");
            int arrSize = Integer.parseInt(allNumbers[0]);
            int[] numsForSums = new int[arrSize];
            int showMaxSum;
            
            
            
            //fill int array with all elements from imported string array
            

           //start from index 1 (if it exists) from original imported array
           //incrementally add elements to new array (numsForSums)
           //also convert elements from first array to int.
            for(int i=1,k=0;i<allNumbers.length;i++){
                  numsForSums[k++]= Integer.parseInt(allNumbers[i]);
            }
            
            showMaxSum = maxSum(numsForSums);
        

        System.out.println(showMaxSum 
                +"\t\t\t" + Arrays.toString(numsForSums));
        
        } fileScan.close();
        System.out.println();
        
    }
    
    
    //This method returns the maximum contiguous sum
    //--default method that calls recursive method--
    public static int maxSum(int[] aList){
        int daRealMaxSum;
        
        daRealMaxSum= maxContigSum(aList, 0, aList.length);

        return daRealMaxSum;
    }
   
    
    //This method returns the maximum sum from a list stored in an
    //array which begins at cell "start" and ends at cell "end"
    //--the recursive method--
    public static int maxContigSum(int[] alist, int start, int end){
        
        
        int daMaxNumber = 0;
        for (int i = start; i < end; i++) {
            daMaxNumber += alist[i];
        }
        
        
        if (start == alist.length) {
            return daMaxNumber;
        }
        if (end == start) {
            int temp = maxContigSum(alist, start + 1, alist.length);
            if (temp > daMaxNumber) {
                return temp;
            }
            return daMaxNumber;
        }
        else {
            int temp = maxContigSum(alist, start, end - 1);
            if (temp > daMaxNumber) {
                return temp;
            }
            return daMaxNumber;
        }
        }
    }
    

