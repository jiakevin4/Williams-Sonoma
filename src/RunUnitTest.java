import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Unit Test cases in class UnitTest are run in this file.
 * 
 * The result of Unit Tests and information of any failed cases are
 * written to a log file named "Inputs And Outputs.txt" and printed in the Console.
 * The log file is in the folder "..\WilliamsSonoma". 
 * 
 * @author Kevin Jia
 * @class RunUnitTest  Test runner class for Unit Test.
 * 
 */


public class RunUnitTest {

	public static void main(String[] args) {
		//Execute test cases
		Result unitTestResult = JUnitCore.runClasses(UnitTest.class);		
		
		//Write the result of Unit Tests, and print any failed cases
		try {
			//Write time stamp
			FileWriter writeLog = new FileWriter("Inputs And Outputs.txt", true);
			Date currentDateTime = new Date();
			writeLog.write("Produced the minimum number of ranges at: " + currentDateTime.toString() + "\r\n" + "\r\n");
        	
			//Write and print any failed cases
			for(Failure fail: unitTestResult.getFailures()) {
				System.out.println("Failed Test Case: " + fail.toString());
				writeLog.write("Failed Test Case: " + fail.toString() + "\r\n");
			}
    		
        	//Write and print result of Unit Test
			System.out.println("All Test Cases Passed: " + unitTestResult.wasSuccessful());
			writeLog.write("All Test Cases Passed: " + unitTestResult.wasSuccessful() + "\r\n");
			writeLog.write("\r\n\r\n");
			writeLog.close();
        }
		catch (IOException e) {
        	e.printStackTrace();
        }
	}
}
