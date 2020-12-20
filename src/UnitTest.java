import static org.junit.jupiter.api.Assertions.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;

/**
 * The input 5-digit ZIP code ranges are given in the variables input1 to input4.
 * The expected outputs are given in the variables expectedOutput1 to expectedOutput4.
 * 
 * If you are using the first way to run the codes mentioned in "ReadMe.txt":
 * You can change the test cases to any other cases or add any test cases (line 27 - 31), 
 * please update expectedOutputs with respect to the cases you changed or added (line 40 - 43).
 * 
 * If all test cases are passes, all input 5-digit ZIP code ranges, the actual produced
 * minimum number of ranges, and expected minimum number of ranges are written to a log file
 * named "Inputs And Outputs.txt". The log file is in the folder "..\WilliamsSonoma". 
 * 
 * @author Kevin Jia
 * @class UnitTest  The Unit Test Case class for Unit Testing.
 *                  
 */


public class UnitTest {
	//Input 5-digit ZIP code ranges
	int[][] input1 = {{94133,94133},{94200,94299},{94226,94399}};	
	int[][] input2 = {{94133,94133},{94200,94299},{94600,94699}};
	int[][] input3 = {{90000,90500},{90800,90900},{90100,90600}};
	int[][] input4 = {{49679, 52015},{49800, 50000},{51500, 53479},{45012, 46937},{54012, 59607},
			{45500, 45590},{45999, 47900},{44000, 45000},{43012, 45950}};
	
	//Instantiate an instance of class Solution for processing input 5-digit ZIP code ranges
	Solution sol = new Solution();
	
	//check if the produced minimum number of ranges equal the expected outputs
	@Test
	public void testResult() {
		//Expected outputs
		int[][] expectedOutput1 = {{94133, 94133},{94200, 94399}};
		int[][] expectedOutput2 = {{94133, 94133},{94200, 94299},{94600, 94699}};
		int[][] expectedOutput3 = {{90000, 90600},{90800, 90900}};
		int[][] expectedOutput4 = {{43012, 47900},{49679, 53479},{54012, 59607}};				
		
		//Do the checks
		assertEquals(Arrays.deepToString(expectedOutput1), Arrays.deepToString(sol.minimumRange(input1)));
		assertEquals(Arrays.deepToString(expectedOutput2), Arrays.deepToString(sol.minimumRange(input2)));
		assertEquals(Arrays.deepToString(expectedOutput3), Arrays.deepToString(sol.minimumRange(input3)));
		assertEquals(Arrays.deepToString(expectedOutput4), Arrays.deepToString(sol.minimumRange(input4)));
		
		//Write inputs and outputs to log file
		try {
			FileWriter writeLog = new FileWriter("Inputs And Outputs.txt", true);
			writeLog.write("Input1: " + Arrays.deepToString(input1) + "\r\n");
			writeLog.write("Actual Output1: " + Arrays.deepToString(sol.minimumRange(input1)) + "\r\n");
			writeLog.write("Expected Output1: " + Arrays.deepToString(expectedOutput1) + "\r\n");
			writeLog.write("Input2: " + Arrays.deepToString(input2) + "\r\n");
			writeLog.write("Actual Output2: " + Arrays.deepToString(sol.minimumRange(input2)) + "\r\n");
			writeLog.write("Expected Output2: " + Arrays.deepToString(expectedOutput2) + "\r\n");
			writeLog.write("Input3: " + Arrays.deepToString(input3) + "\r\n");
			writeLog.write("Actual Output3: " + Arrays.deepToString(sol.minimumRange(input3)) + "\r\n");
			writeLog.write("Expected Output3: " + Arrays.deepToString(expectedOutput3) + "\r\n");
			writeLog.write("Input4: " + Arrays.deepToString(input4) + "\r\n");
			writeLog.write("Actual Output4: " + Arrays.deepToString(sol.minimumRange(input4)) + "\r\n");
			writeLog.write("Expected Output4: " + Arrays.deepToString(expectedOutput4) + "\r\n");
			writeLog.write("\r\n");
			writeLog.close();
			}
		catch (IOException e) {
			e.printStackTrace();
			}
	}
}
