package GPFinalProject;

import java.util.ArrayList;
import java.util.Collections;

public class GPFinalProject 
{

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<GPCandidate> gpCandidates = new ArrayList<GPCandidate>();

		int numCandidates = 5000;
		int maxNumberOfGenerations = 50000;
		
		double [] fitnessPoints = {-5000, -10.0, 0, 10, 25, 101};
		double [] expectedValues = new double[fitnessPoints.length];
		
		for (int i = 0; i < expectedValues.length; i++)
		{
			expectedValues[i] = (fitnessPoints[i]*fitnessPoints[i]) - 1;
		}
		
		
		/* Create the candidates */
		for (int i = 0; i < numCandidates; i++)
		{
			gpCandidates.add(new GPCandidate());
			double fitnessValue = gpCandidates.get(i).updateFitnessValue(fitnessPoints, expectedValues);
		}
		
		/* Print them to console */
		for (int i = 0; i < numCandidates; i++)
		{
			System.out.println(i + ":" + gpCandidates.get(i).getTopNode().GetGPString() );
		}
		
		

		
		
		for (int i = 0; i < maxNumberOfGenerations; i++)
		{
			for (int j = 0; j < numCandidates; j++)
			{
				//double fitnessValue = gpCandidates.get(j).updateFitnessValue(fitnessPoints, expectedValues);
				//System.out.println("Candidate " + j + " has fitness value: " + fitnessValue);
				
				double fitnessValue = gpCandidates.get(j).getFitnessValue();
				if (fitnessValue < 0.01)
				{
					System.out.println("Generation:" + i + "; Candidate:" + j + ": Possible candidate found.  Error is: " + fitnessValue + " String is: " + gpCandidates.get(j).candidate.GetGPString());
					return;
				}
			}
			
			// Print out the best one we have
			System.out.println("Best fitness value of generation: " + i + " is: " + gpCandidates.get(0).getFitnessValue() + "; Candidate is: " + gpCandidates.get(0).getTopNode().GetGPString());
			
			// Need to rank the candidates
			Collections.sort(gpCandidates, new GPFitnessValueComparator());
			
			for (int j = 0; j < 5; j++)
			{
				int rand1 = Utilities.GetRandomNumber(0, 1000);
				int rand2 = Utilities.GetRandomNumber(0, 4000);
			
				GPNode.crossoverNodes(gpCandidates.get(rand1).getTopNode(), gpCandidates.get(rand2).getTopNode());
				gpCandidates.get(rand1).updateFitnessValue(fitnessPoints, expectedValues);
				gpCandidates.get(rand2).updateFitnessValue(fitnessPoints, expectedValues);
			}
			
			int rand1 = Utilities.GetRandomNumber(0, numCandidates-1);
			GPNode.mutateNodes(gpCandidates.get(rand1).getTopNode());
			gpCandidates.get(rand1).updateFitnessValue(fitnessPoints, expectedValues);
		}
		
/*		
		// Cross them over in order (just a robustness test, how this works to be changed later)
		for (int i = 0; i < numCandidates; i+=2)
		{
			GPNode.crossOver(gpCandidates.get(i), gpCandidates.get(i+1));
		}
		
		// Print crossed over candidates to console 
		for (int i = 0; i < numCandidates; i++)
		{
			System.out.println(i + ":" + gpCandidates.get(i).GetGPString() );
		}
		
		// Mutate them (just a robustness test, how this works to be changed later)
		for (int i = 0; i < numCandidates; i++)
		{
			GPNode.mutate(gpCandidates.get(i));
		}
		
		// Print mutated candidates to console 
		for (int i = 0; i < numCandidates; i++)
		{
			System.out.println(i + ":" + gpCandidates.get(i).GetGPString() );
		}
		
		// Evaluation their fitness for a single value (just a demonstration on how to do it, to be changed later) 
		for (int i = 0; i < numCandidates; i++)
		{
			System.out.println(i + ":" + gpCandidates.get(i).EvaluateFitnessValue(20));
		}
*/		
		
		
		
		
/*		
//		Code to manually generate a tree
		GPNodeValue leftBranchLeftValue = new GPNodeValue(5.0);
		GPNodeValue leftBranchRightValue = new GPNodeValue(-7.0);
		GPNodeOperator leftBranch = new GPNodeOperator("/", leftBranchLeftValue, leftBranchRightValue);
		GPNodeValue rightBranchLeftValue = new GPNodeValue("X");
		GPNodeValue rightBranchRightValue = new GPNodeValue(9);
		GPNodeOperator rightBranch = new GPNodeOperator("-", rightBranchLeftValue, rightBranchRightValue);
		GPNodeOperator treeTop = new GPNodeOperator("+", leftBranch, rightBranch);
*/
/*
 		// Setup some trees and test the crossover/mutate on them
		GPNode treeTop = GPNode.generateNode();
		
		System.out.println("Depth: " + treeTop.GetGPDepth());
		System.out.println("Node Count: " + treeTop.GetGPNodeCount());
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Evaluated for X=20: " + treeTop.EvaluateFitnessValue(20));
		GPNode treeTop2 = GPNode.generateNode();
*/		
		/*
		GPNode g1 = treeTop.FindNodeReferenceById(0, treeTop.GetGPNodeCount() >> 1);
		System.out.println(treeTop.GetGPNodeCount() >> 1);
		System.out.println("Found node: " + g1.GetGPString());
		*/
		
		
/*		
 		// Test Crossover and mutate
		System.out.println("*** Crossover Strings Below ***");
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Print String: " + treeTop2.GetGPString());		
		GPNode.crossOver(treeTop, treeTop2);		
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Print String: " + treeTop2.GetGPString());	
		
		
		System.out.println("*** Mutate String Below ***");
		System.out.println("Print String: " + treeTop.GetGPString());
		GPNode.mutate(treeTop);
		System.out.println("Depth: " + treeTop.GetGPDepth());
		System.out.println("Node Count: " + treeTop.GetGPNodeCount());
		System.out.println("Print String: " + treeTop.GetGPString());
*/		
/*		
//		Checkout for the random number generator
		for (int i = 0; i < 20; i++)
		{
			System.out.println(Utilities.GetRandomNumber(6, 14));
		}
*/		
	}

}
