package GPFinalProject;

import java.util.Comparator;

class GPFitnessValueComparator implements Comparator<GPCandidate> {
    public int compare(GPCandidate gp1, GPCandidate gp2) { 
    	 if (Double.isNaN(gp1.getFitnessValue()))
		 {
    		 return 1;
		 }
    	 if (Double.isNaN(gp2.getFitnessValue()))
		 {
    		 return -1;
		 }
         if (gp1.getFitnessValue() < gp2.getFitnessValue()) return -1;
         if (gp1.getFitnessValue() > gp2.getFitnessValue()) return 1;
         return 0;
    }
}

public class GPCandidate {
	protected GPNode candidate;
	protected double fitnessValue;

	public GPCandidate()
	{
		candidate = GPNode.generateNode();
		fitnessValue = 0.0;
	}
	
	public double updateFitnessValue(double[] x, double[] expected)
	{
		double absSum = 0;
		for (int i = 0; i < x.length; i++)
		{
			double tmp = candidate.EvaluateFitnessValue(x[i]);
			tmp = Math.abs(tmp- expected[i]);
			absSum += tmp;
		}
		fitnessValue = absSum;
		return absSum;
	}		
	
	public double getFitnessValue()
	{
		return fitnessValue;
	}
	
	public GPNode getTopNode()
	{
		return candidate;
	}
	
	
}
