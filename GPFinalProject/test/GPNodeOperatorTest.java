import static org.junit.Assert.*;

import org.junit.Test;

import GPFinalProject.GPNodeOperator;
import GPFinalProject.GPNodeValue;


public class GPNodeOperatorTest {

	@Test
	public void testDivideByZero() {
		GPNodeValue left = new GPNodeValue(10);
		GPNodeValue right = new GPNodeValue(0);
		GPNodeOperator top = new GPNodeOperator("/", left, right);
		assertEquals("Result of against 10 divide by 0", Double.MAX_VALUE, top.EvaluateFitnessValue(-5), .01);
	}

	@Test 
	// GP-TST-2
	// GP-TST-3
	// GP-TST-4
	// GP-TST-5
	public void GPNodeOperator() {
		GPNodeValue left = new GPNodeValue(-10);
		GPNodeValue right = new GPNodeValue(7);
		GPNodeOperator top = new GPNodeOperator("+", left, right);
		assertEquals("Result creating plus node with -10 and 7", -3, top.EvaluateFitnessValue(-5), .01);

		top = new GPNodeOperator("-", left, right);
		assertEquals("Result creating minus node with -10 and 7", -17, top.EvaluateFitnessValue(-5), .01);

		top = new GPNodeOperator("*", left, right);
		assertEquals("Result creating multiply node with -10 and 7", -70, top.EvaluateFitnessValue(-5), .01);
		
		top = new GPNodeOperator("/", left, right);
		assertEquals("Result creating divide node with -10 and 7", -1.42857143, top.EvaluateFitnessValue(-5), .01);
	}
	
	public void testEvaluateFitnessValue() {
	}
	
	@Test
	public void testGetGPDepth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGPNodeCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGPString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindNodeReferenceById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGPNodeOperator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLeftNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRightNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLeftNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRightNode() {
		fail("Not yet implemented");
	}

}
