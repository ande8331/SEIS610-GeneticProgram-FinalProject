import java.io.*;
import java.util.HashMap;

/**
 * Description.
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
public class Config {
    // instance variables - replace the example below with your own
    private HashMap<String, String> _dictionary;

    // Constants
    private final String MAX_GENERATION_COUNT = "MAX_GENERATION_COUNT";
    private final String INITIAL_POPULATION_SIZE = "INITIAL_POPULATION_SIZE";
    private final String MAX_INITIAL_DEPTH = "MAX_INITIAL_DEPTH";
    private final String LIST_OF_TRAINING_DATA = "LIST_OF_TRAINING_DATA";
    private final String MUTATION_RATE = "MUTATION_RATE";
    private final String MUTATION_HIGH_PROBABILITY_CROSS_POINT = "MUTATION_HIGH_PROBABILITY_CROSS_POINT";
    private final String MUTATION_HIGH_PROBABILITY_RATE = "MUTATION_HIGH_PROBABILITY_RATE";
    private final String CROSSOVER_RATE = "CROSSOVER_RATE";
    private final String CROSSOVER_HIGH_PROBABILITY_CROSS_POINT = "CROSSOVER_HIGH_PROBABILITY_CROSS_POINT";
    private final String CROSSOVER_HIGH_PROBABILITY_RATE = "CROSSOVER_HIGH_PROBABILITY_RATE";
    private final String NATURAL_SELECTION_RATE = "NATURAL_SELECTION_RATE";
    private final String NATURAL_SELECTION_PROBABILITY_CROSSOVER_POINT = "NATURAL_SELECTION_PROBABILITY_CROSSOVER_POINT";
    private final String NATURAL_SELECTION_PROBABILITY_CROSSOVER_RATE = "NATURAL_SELECTION_PROBABILITY_CROSSOVER_RATE";
    private final String OPERATOR_PROBABILITY = "OPERATOR_PROBABILITY";
    private final String VARIABLE_X_PROBABILITY = "VARIABLE_X_PROBABILITY";
    private final String CONSTANT_MINIMUM_VALUE = "CONSTANT_MINIMUM_VALUE";
    private final String CONSTANT_MAXIMUM_VALUE = "CONSTANT_MAXIMUM_VALUE";
    private final String GENETIC_MODEL = "GENETIC_MODEL";
    private final String TIME_LIMITATION = "TIME_LIMITATION";
    private final String RANDOM_MINIMUM = "RANDOM_MINIMUM";
    private final String RANDOM_MAXIMUM = "RANDOM_MAXIMUM";

    /**
     * Constructor for objects of class Config
     */
    public Config() {
        // initialise instance variables
    }

    /**
     * Initialize the data from a file.
     * @param fileLocation Location of the text file.
     * @param delimiter split character.
     * @exception FileNotFoundException
     * @exception IOException
     */
    public void initializeData(final String fileLocation, final String delimiter) throws FileNotFoundException, IOException
    {
        String[] splitResults = null;

        if (!(new File(fileLocation)).exists()) {
            throw new FileNotFoundException("Config File Not found!");
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String line = null;

            if (_dictionary == null) {
                _dictionary = new HashMap<String, String>();
            }

            while ((line = reader.readLine()) != null) {
                splitResults = line.split(delimiter);
                _dictionary.put(splitResults[0], splitResults[1]);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Access to MaxGenerationCount.
     * @return MaxGenerationCount.
     */
    public int getMaxGenerationCount() {
        if (_dictionary.containsKey(MAX_GENERATION_COUNT)) {
            return (Integer.parseInt(_dictionary.get(MAX_GENERATION_COUNT)));
        }

        return (0);
    }

    /**
     * Access to InitialPopulationSize.
     * @return InitialPopulationSize.
     */
    public int getInitialPopulationSize() {
        if (_dictionary.containsKey(INITIAL_POPULATION_SIZE)) {
            return (Integer.parseInt(_dictionary.get(INITIAL_POPULATION_SIZE)));
        }

        return (0);
    }

    /**
     * Access to MaxInitialDepth.
     * @return MaxInitialDepth.
     */
    public int getMaxInitialDepth() {
        if (_dictionary.containsKey(MAX_INITIAL_DEPTH)) {
            return (Integer.parseInt(_dictionary.get(MAX_INITIAL_DEPTH)));
        }

        return (0);
    }

    /**
     * Access to ListOfTrainingData.
     * @return ListOfTrainingData.
     */
    public int getListOfTrainingData() {
        if (_dictionary.containsKey(LIST_OF_TRAINING_DATA)) {
            return (Integer.parseInt(_dictionary.get(LIST_OF_TRAINING_DATA)));
        }

        return (0);
    }

    /**
     * Access to MutationRate.
     * @return MutationRate.
     */
    public float getMutationRate() {
        if (_dictionary.containsKey(MUTATION_RATE)) {
            return (Float.parseFloat(_dictionary.get(MUTATION_RATE)));
        }

        return (0);
    }

    /**
     * Access to MutationHighProbabilityCrossPoint.
     * @return MutationHighProbabilityCrossPoint.
     */
    public int getMutationHighProbabilityCrossPoint() {
        if (_dictionary.containsKey(MUTATION_HIGH_PROBABILITY_CROSS_POINT)) {
            return (Integer.parseInt(_dictionary.get(MUTATION_HIGH_PROBABILITY_CROSS_POINT)));
        }

        return (0);
    }

    /**
     * Access to MutationHighProbabilityRate.
     * @return MutationHighProbabilityRate.
     */
    public float getMutationHighProbabilityRate() {
        if (_dictionary.containsKey(MUTATION_HIGH_PROBABILITY_RATE)) {
            return (Float.parseFloat(_dictionary.get(MUTATION_HIGH_PROBABILITY_RATE)));
        }

        return (0);
    }

    /**
     * Access to CrossOverRate.
     * @return CrossOverRate.
     */
    public float getCrossOverRate() {
        if (_dictionary.containsKey(CROSSOVER_RATE)) {
            return (Float.parseFloat(_dictionary.get(CROSSOVER_RATE)));
        }

        return (0);
    }

    /**
     * Access to CrossOverHighProbabilityPoint.
     * @return CrossOverHighProbabilityPoint.
     */
    public int getCrossOverHighProbabilityPoint() {
        if (_dictionary.containsKey(CROSSOVER_HIGH_PROBABILITY_CROSS_POINT)) {
            return (Integer.parseInt(_dictionary.get(CROSSOVER_HIGH_PROBABILITY_CROSS_POINT)));
        }

        return (0);
    }

    /**
     * Access to CrossOverHighProbabilityRate.
     * @return CrossOverHighProbabilityRate.
     */
    public float getCrossOverHighProbabilityRate() {
        if (_dictionary.containsKey(CROSSOVER_HIGH_PROBABILITY_RATE)) {
            return (Float.parseFloat(_dictionary.get(CROSSOVER_HIGH_PROBABILITY_RATE)));
        }

        return (0);
    }

    /**
     * Access to NaturalSelectionRate.
     * @return NaturalSelectionRate.
     */
    public float getNaturalSelectionRate() {
        if (_dictionary.containsKey(NATURAL_SELECTION_RATE)) {
            return (Float.parseFloat(_dictionary.get(NATURAL_SELECTION_RATE)));
        }

        return (0);
    }

    /**
     * Access to NaturalSelectionProbabilityCrossOverPoint.
     * @return NaturalSelectionProbabilityCrossOverPoint.
     */
    public int getNaturalSelectionProbabilityCrossOverPoint() {
        if (_dictionary.containsKey(NATURAL_SELECTION_PROBABILITY_CROSSOVER_POINT)) {
            return (Integer.parseInt(_dictionary.get(NATURAL_SELECTION_PROBABILITY_CROSSOVER_POINT)));
        }

        return (0);
    }    

    /**
     * Access to NaturalSelectionProbabilityCrossOverRate.
     * @return NaturalSelectionProbabilityCrossOverRate.
     */
    public float getNaturalSelectionProbabilityCrossOverRate() {
        if (_dictionary.containsKey(NATURAL_SELECTION_PROBABILITY_CROSSOVER_RATE)) {
            return (Float.parseFloat(_dictionary.get(NATURAL_SELECTION_PROBABILITY_CROSSOVER_RATE)));
        }

        return (0);
    }

    /**
     * Access to OperatorProbability.
     * @return OperatorProbability.
     */
    public int getOperatorProbability() {
        if (_dictionary.containsKey(OPERATOR_PROBABILITY)) {
            return (Integer.parseInt(_dictionary.get(OPERATOR_PROBABILITY)));
        }

        return (0);
    }

    /**
     * Access to VariableXProbability.
     * @return VariableXProbability.
     */
    public int getVariableXProbability() {
        if (_dictionary.containsKey(VARIABLE_X_PROBABILITY)) {
            return (Integer.parseInt(_dictionary.get(VARIABLE_X_PROBABILITY)));
        }

        return (0);
    }

    /**
     * Access to ConstantMinimumValue.
     * @return ConstantMinimumValue.
     */
    public int getConstantMinimumValue() {
        if (_dictionary.containsKey(CONSTANT_MINIMUM_VALUE)) {
            return (Integer.parseInt(_dictionary.get(CONSTANT_MINIMUM_VALUE)));
        }

        return (0);
    }

    /**
     * Access to ConstantMaximumValue.
     * @return ConstantMaximumValue.
     */
    public int getConstantMaximumValue() {
        if (_dictionary.containsKey(CONSTANT_MAXIMUM_VALUE)) {
            return (Integer.parseInt(_dictionary.get(CONSTANT_MAXIMUM_VALUE)));
        }

        return (0);
    }

    /**
     * Access to GeneticModel.
     * @return GeneticModel.
     */
    public String getGeneticModel() {
        if (_dictionary.containsKey(GENETIC_MODEL)) {
            return (_dictionary.get(GENETIC_MODEL));
        }

        return (null);
    }
}
