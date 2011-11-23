import static org.junit.Assert.*;

import org.junit.Test;

import GPFinalProject.Utilities;


public class GPUtilitiesTest {

	@Test
	// GP-TST-7
	public void testGetRandomNumber() {

		int minimum = 5;
		int maximum = 10;
		for (int i = 0; i < 1000; i++)
		{
			
			int temp = Utilities.GetRandomNumber(minimum, maximum);
			
			if ((temp < minimum) || (temp > maximum))
			{
				fail("Out of range random number generated.  Must have been between: " + minimum + " and: " + maximum + ". Number returned: " + temp);
			}
		}
		
	}

	@Test
	public void testGetRandomDouble() {
		//fail("Not yet implemented");
	}

}
