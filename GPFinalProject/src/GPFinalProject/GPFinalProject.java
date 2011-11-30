//! GPFinalProject.java
//! TODO "Missing package-info.java file"
import java.util.ArrayList;

import java.util.Collections;

/**
 * Genetic Program Project.
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
public class GPFinalProject {
    /**
     * @param args Default for arguments.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ArrayList<GPCandidate> gpCandidates = new ArrayList<GPCandidate>();

        int numCandidates = 1000;
        int maxNumberOfGenerations = 500000;

        double crossoverHighProbabilityCrossPoint = 0.10;
        double crossoverHighProbabilityRate = 0.90;
        double crossoverRate = 0.20;

        double mutationHighProbabilityCrossPoint = 0.50;
        double mutationHighProbabilityRate = 0.50;
        double mutationRate = 0.05;

        double naturalSelectionHighProbabilityCrossPoint = 0.90;
        double naturalSelectionHighProbabilityRate = 0.90;
        double naturalSelectionRate = 0.000001;

        double [] trainingData = {-5000, -100, -10.0, 0, 10, 25, 100, 5000};
        double [] expectedValues = new double[trainingData.length];

        for (int i = 0; i < expectedValues.length; i++) {
            expectedValues[i] = (trainingData[i] * trainingData[i]) - 1;
        }

        /* Create the candidates */
        for (int i = 0; i < numCandidates; i++) {
            gpCandidates.add(new GPCandidate());
            gpCandidates.get(i).updateFitnessValue(trainingData, expectedValues);
        }

        /* Print them to console */
        for (int i = 0; i < gpCandidates.size(); i++) {
            System.out.println(i + ":" + gpCandidates.get(i).getTopNode().getGPString());
        }

        // When the numbers get small enough the carryovers allow us to meet our required rates when round off errors could happen
        double crossoverCarryOver = 0.0;
        double mutationCarryOver = 0.0;
        double naturalSelectionCarryOver = 0.0;

        for (int i = 0; i < maxNumberOfGenerations; i++) {
            // Need to rank the candidates
            Collections.sort(gpCandidates, new GPFitnessValueComparator());

            // Print out the best one we have
            System.out.println(/*"(" + gpCandidates.size() + ")*/ "Best fitness value of generation: " + i + " is: " + gpCandidates.get(0).getFitnessValue() + "; Candidate is: " + gpCandidates.get(0).getTopNode().getGPString());


            double fitnessValue = gpCandidates.get(0).getFitnessValue();
            if (fitnessValue < 0.000001) {
                System.out.println("Generation:" + i + ": Candidate found.  Error is: " + fitnessValue + " String is: " + gpCandidates.get(0).candidate.getGPString());
                return;
            }

            naturalSelectionCarryOver += gpCandidates.size() * naturalSelectionRate;
            int numNaturalSelections = (int) Math.floor(naturalSelectionCarryOver);
            naturalSelectionCarryOver -= (double) numNaturalSelections;

            /* Natural Selection */
            for (int j = 0; j < numNaturalSelections; j++) {
                double hp = Utilities.getRandomDouble();

                int minimum = 0;
                int maximum = (int) (naturalSelectionHighProbabilityCrossPoint * gpCandidates.size());
                if (hp > naturalSelectionHighProbabilityRate) {
                    minimum = maximum + 1;
                    maximum = gpCandidates.size() - 1;
                }

                int rand1 = Utilities.getRandomNumber(minimum, maximum);
                gpCandidates.remove(rand1);
            }


            /* Crossover */
            crossoverCarryOver += gpCandidates.size() * crossoverRate;
            int numCrossovers = (int) Math.floor(crossoverCarryOver);
            crossoverCarryOver -= (double) numCrossovers;
            for (int j = 0; j < numCrossovers; j++) {
                double hp = Utilities.getRandomDouble();

                int minimum = 0;
                int maximum = (int) (crossoverHighProbabilityCrossPoint * gpCandidates.size());
                if (hp > crossoverHighProbabilityRate) {
                    minimum = maximum + 1;
                    maximum = gpCandidates.size() - 1;
                }

                int rand1 = Utilities.getRandomNumber(minimum, maximum);

                hp = Utilities.getRandomDouble();
                minimum = 0;
                maximum = (int) (crossoverHighProbabilityCrossPoint * gpCandidates.size());
                if (hp > crossoverHighProbabilityRate) {
                    minimum = maximum + 1;
                    maximum = gpCandidates.size() - 1;
                }
                int rand2 = Utilities.getRandomNumber(minimum, maximum);

                GPNode.crossoverNodes(gpCandidates.get(rand1).getTopNode(), gpCandidates.get(rand2).getTopNode());
                gpCandidates.get(rand1).updateFitnessValue(trainingData, expectedValues);
                gpCandidates.get(rand2).updateFitnessValue(trainingData, expectedValues);
            }

            /* Mutation */
            mutationCarryOver += gpCandidates.size() * mutationRate;
            int numMutations = (int) Math.floor(mutationCarryOver);
            mutationCarryOver -= (double) numMutations;
            for (int j = 0; j < numMutations; j++) {
                double hp = Utilities.getRandomDouble();

                int minimum = 0;
                int maximum = (int) (mutationHighProbabilityCrossPoint * gpCandidates.size());
                if (hp > mutationHighProbabilityRate) {
                    minimum = maximum + 1;
                    maximum = gpCandidates.size() - 1;
                }

                int rand1 = Utilities.getRandomNumber(minimum, maximum);
                GPNode.mutateNodes(gpCandidates.get(rand1).getTopNode());
                gpCandidates.get(rand1).updateFitnessValue(trainingData, expectedValues);
            }
        }       
    }
}
