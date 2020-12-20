import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

/**
 * The algorithm for producing the minimum number of ranges required to represent the same restrictions 
 * as the input 5-digit ZIP code ranges is given in the steps below:
 * 
 * Step 1: sort the input ZIP codes ranges with respect to lower bounds.
 * 
 * Step 2: merge the input ZIP codes ranges into a list named resultList. If resultlist is empty, add first 
 * ZIP codes range to it. After the first ZIP range is inserted, merge the rest ZIP codes ranges as follows. If the lower 
 * bound of the ZIP codes range to be inserted is larger than upper bound of resultlist, add it to resultlist directly.
 * If the ZIP codes range to be inserted overlaps with resultlist, update the upper bound of resultlist to the larger
 * value between the upper bound of the ZIP codes range and the upper bound of resultlist. Repeat step2 until all ZIP codes
 * ranges are merged into resultList, the final resultList is the minimum number of ranges required to represent the same restrictions.
 * 
 * Time complexity of this algorithm is O(NlogN), space complexity of this algorithm is O(logN).
 * 
 * 
 * If you are using the second way to run the codes mentioned in "ReadMe.txt":
 * Test cases are given in the main method with variable names as input1 to input4, the produced minimum number of ranges
 * are stored in the variables result1 to result4. You may change them to any other test cases, please make sure all test cases 
 * are 2D arrays. If you need to add more test case variables, please also add new result variables and add the codes for
 * writing inputs and outputs to the log file "Inputs And Outputs.txt" (line 81 - 102). The log file is in the folder "..\WilliamsSonoma".
 * 
 * 
 * @author Kevin Jia
 * 
 * @class Solution  Produces the minimum number of ranges required to represent the same restrictions 
 *                  as the input 5-digit ZIP code ranges. The input codes ranges, the actual produced
 *                  minimum number of ranges, and expected minimum number of ranges are also written to 
 *                  a log file named "Inputs And Outputs.txt".
 *  
 * @method minimumRange  Method for processing the input 5-digit ZIP code ranges and return the minimum number
 *                       of ranges required to represent the same restrictions
 *                       
 * @param ZIPRange  input 5-digit ZIP code ranges, represented by a 2D array
 * 
 * @return  The minimum number of ranges required to represent the same restrictions, represented by a 2D array
 */


public class Solution {
	
	public static void main(String[] args) {
		//Inputs for testing
		int[][] input1 = {{94133,94133},{94200,94299},{94226,94399}};
		int[][] input2 = {{94133,94133},{94200,94299},{94600,94699}};
		int[][] input3 = {{90000,90500},{90800,90900},{90100,90600}};
		int[][] input4 = {{49679, 52015},{49800, 50000},{51500, 53479},{45012, 46937},{54012, 59607},
				{45500, 45590},{45999, 47900},{44000, 45000},{43012, 45950}};
		
		//Expected outputs
		int[][] expectedOutput1 = {{94133, 94133},{94200, 94399}};
		int[][] expectedOutput2 = {{94133, 94133},{94200, 94299},{94600, 94699}};
		int[][] expectedOutput3 = {{90000, 90600},{90800, 90900}};
		int[][] expectedOutput4 = {{43012, 47900},{49679, 53479},{54012, 59607}};	
		
		//Produced minimum number of ranges represented by arrays
		int[][] result1;
		int[][] result2;
		int[][] result3;
		int[][] result4;
		
		//Call method minimumRange to return the minimum number of ranges, print them in Console,
		//and write the results to log file
		Solution sol = new Solution();
		result1 = sol.minimumRange(input1);
		result2 = sol.minimumRange(input2);
		result3 = sol.minimumRange(input3);
		result4 = sol.minimumRange(input4);
		System.out.println("Produced minimum number of ranges of input 1: " + Arrays.deepToString(result1));
		System.out.println("Produced minimum number of ranges of input 2: " + Arrays.deepToString(result2));
		System.out.println("Produced minimum number of ranges of input 3: " + Arrays.deepToString(result3));
		System.out.println("Produced minimum number of ranges of input 4: " + Arrays.deepToString(result4));
        
        //Write inputs and outputs to log file with a time stamp
        try {
        	FileWriter writeLog = new FileWriter("Inputs And Outputs.txt", true);
        	Date currentDateTime = new Date();
        	writeLog.write("Produced the minimum number of ranges at: " + currentDateTime.toString() + "\r\n" + "\r\n");
        	writeLog.write("Input1: " + Arrays.deepToString(input1) + "\r\n");
        	writeLog.write("Output1: " + Arrays.deepToString(result1) + "\r\n");
        	writeLog.write("Expected Output1: " + Arrays.deepToString(expectedOutput1) + "\r\n");
        	writeLog.write("Input2: " + Arrays.deepToString(input2) + "\r\n");
        	writeLog.write("Output2: " + Arrays.deepToString(result2) + "\r\n");
        	writeLog.write("Expected Output2: " + Arrays.deepToString(expectedOutput2) + "\r\n");
        	writeLog.write("Input3: " + Arrays.deepToString(input3) + "\r\n");
        	writeLog.write("Output3: " + Arrays.deepToString(result3) + "\r\n");
        	writeLog.write("Expected Output3: " + Arrays.deepToString(expectedOutput3) + "\r\n");
        	writeLog.write("Input4: " + Arrays.deepToString(input4) + "\r\n");
        	writeLog.write("Output4: " + Arrays.deepToString(result4) + "\r\n");
        	writeLog.write("Expected Output4: " + Arrays.deepToString(expectedOutput4) + "\r\n");
        	writeLog.write("\r\n" + "\r\n");
        	writeLog.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
    
	//Method for processing the input 5-digit ZIP code ranges and return the minimum number of ranges required to represent the same restrictions
	public int[][] minimumRange(int[][] ZIPRange){		
		//First Step: sort the ZIP codes ranges with respect to lower bounds
		Arrays.sort(ZIPRange, (ZIP1, ZIP2) -> ZIP1[0] - ZIP2[0]);
				
		//Second Step: merge ZIP codes ranges with respect to the algorithm in the above Javadoc
		LinkedList<int[]> resultList = new LinkedList<int[]>();
		
		for(int i = 0; i < ZIPRange.length; i++) {
			//Add ZIP range to result list if result list is empty
			if((resultList.isEmpty())) {
				resultList.add(ZIPRange[i]);
			}
			//Add ZIP range to result list if lower bound of ZIP range is larger than upper bound of result list
			else if(ZIPRange[i][0] > resultList.getLast()[1]) {
				resultList.add(ZIPRange[i]);
			}
			//Merge ZIP range to result list if it overlaps with result list
			else {
				resultList.getLast()[1] = Math.max(ZIPRange[i][1], resultList.getLast()[1]);
			}
		}
		
		//Final returned array
		int[][] resultArray = new int[resultList.size()][];
		
		resultArray = resultList.toArray(resultArray);
		return resultArray;
	}
}
