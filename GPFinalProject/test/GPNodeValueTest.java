import static org.junit.Assert.*;

import org.junit.Test;



public class GPNodeValueTest {

	@Test
	public void testEvaluateFitnessValue() {
		GPNodeValue tester = new GPNodeValue(1);
		assertEquals("Result of against value 1 with passed in 0", 1, tester.evaluateFitnessValue(0), .01);
		assertEquals("Result of against value 1 with passed in 10", 1, tester.evaluateFitnessValue(10), .01);

		tester = new GPNodeValue(0);
		assertEquals("Result of against value 0 with passed in -5", 0, tester.evaluateFitnessValue(-5), .01);
		assertEquals("Result of against value 0 with passed in 5", 0, tester.evaluateFitnessValue(5), .01);

		tester = new GPNodeValue(-1);
		assertEquals("Result of against value -1 with passed in -20", -1, tester.evaluateFitnessValue(-20), .01);
		assertEquals("Result of against value -1 with passed in 17", -1, tester.evaluateFitnessValue(17), .01);

		tester = new GPNodeValue(13);
		assertEquals("Result of against value 13 with passed in 2", 13, tester.evaluateFitnessValue(2), .01);
		assertEquals("Result of against value 13 with passed in 10", 13, tester.evaluateFitnessValue(10), .01);
	
		tester = new GPNodeValue(-12);
		assertEquals("Result of against value -12 with passed in -7", -12, tester.evaluateFitnessValue(-7), .01);
		assertEquals("Result of against value -12 with passed in 8", -12, tester.evaluateFitnessValue(8), .01);

		tester = new GPNodeValue("X");
		assertEquals("Result of against value X with passed in -4", -4, tester.evaluateFitnessValue(-4), .01);
		assertEquals("Result of against value X with passed in 0", 0, tester.evaluateFitnessValue(0), .01);
		assertEquals("Result of against value X with passed in 14", 14, tester.evaluateFitnessValue(14), .01);
	}

	@Test
	public void testGetGPDepth() {
		GPNodeValue tester = new GPNodeValue(-8);
		assertEquals("Result of depth test", 0, tester.getGPDepth());
		
		tester = new GPNodeValue("X");
		assertEquals("Result of depth test", 0, tester.getGPDepth());
	}

	@Test
	public void testGetGPNodeCount() {
		GPNodeValue tester = new GPNodeValue(4);
		assertEquals("Result of node count test", 1, tester.getGPNodeCount());
		
		tester = new GPNodeValue("X");
		assertEquals("Result of node count test", 1, tester.getGPNodeCount());
	}

	@Test
	public void testGetGPString() {
		GPNodeValue tester = new GPNodeValue(1);
		assertEquals("Result of GetGPString on 1", "1", tester.getGPString());

		tester = new GPNodeValue(17);
		assertEquals("Result of GetGPString on 17", "17", tester.getGPString());

		tester = new GPNodeValue(-21);
		assertEquals("Result of GetGPString on -21", "-21", tester.getGPString());

		tester = new GPNodeValue("X");
		assertEquals("Result of GetGPString on X", "X", tester.getGPString());
	}

	@Test
	public void testGPNodeValueDouble() {
		GPNodeValue tester = new GPNodeValue(1);
		assertEquals("Result of construct node with value of 1", "1", tester.getGPString());
		assertEquals("Result of construct node with value of 1", 1, tester.evaluateFitnessValue(4), 0.01);

		tester = new GPNodeValue(-3);
		assertEquals("Result of construct node with value of -3", "-3", tester.getGPString());
		assertEquals("Result of construct node with value of -3", -3, tester.evaluateFitnessValue(4), 0.01);	

		tester = new GPNodeValue(17);
		assertEquals("Result of construct node with value of 17", "17", tester.getGPString());
		assertEquals("Result of construct node with value of 17", 17, tester.evaluateFitnessValue(4), 0.01);	
	}

	@Test
	public void testGPNodeValueString() {
		GPNodeValue tester = new GPNodeValue("X");
		assertEquals("Result of construct node with value of X", "X", tester.getGPString());
		assertEquals("Result of construct node with value of X", 4, tester.evaluateFitnessValue(4), 0.01);
		assertEquals("Result of construct node with value of X", -14, tester.evaluateFitnessValue(-14), 0.01);	

	}
}
