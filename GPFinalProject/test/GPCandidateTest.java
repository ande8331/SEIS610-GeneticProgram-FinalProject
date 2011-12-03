

import static org.junit.Assert.*;

import org.junit.Test;


public class GPCandidateTest {

	@Test
	public void testGetFitnessValue() {
		GPNodeValue leftleft = new GPNodeValue("X");
		GPNodeValue leftright = new GPNodeValue("X");
		GPNodeOperator left = new GPNodeOperator("*", leftleft, leftright);
		
		GPNodeValue rightleft = new GPNodeValue("X");
		GPNodeValue rightright = new GPNodeValue(2);
		GPNodeOperator right = new GPNodeOperator("/", rightleft, rightright);
		
		GPNodeOperator top = new GPNodeOperator("-", left, right);
		
		GPCandidate freeloader = new GPCandidate();
		freeloader.candidate = top;
		double fitnessValues[] = {2, 5, 50};
		double expected[] = {10,10,10};
		double result = freeloader.updateFitnessValue(fitnessValues, expected);
		
		assertEquals("Evaluate fitness of (x*x) - (X/2) when X=2, 5, 60:", 2484.5, result, 0.0001);	
	}
}
