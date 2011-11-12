import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Write a description of class Config here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Config
{
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
    public Config() 
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  delimiter split character
     * @return     Function Array
     */
    public void initializeData(String fileLocation, String delimiter) throws FileNotFoundException, IOException
    {
       String[] splitResults = null;
        
       if (!(new File(fileLocation)).exists())
       {
            throw new FileNotFoundException("Config File Not found!");
       }
            
       try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String line = null;
            
            if (_dictionary == null)
            {
                _dictionary = new HashMap<String, String>();
            }
        
            while((line = reader.readLine()) != null)
            {
                splitResults = line.split(delimiter);
                _dictionary.put(splitResults[0], splitResults[1]);
            }
		} 
		catch (IOException e) 
		{
		    throw e;
		}
    }
    
    public int getMaxGenerationCount()
    {
        if (_dictionary.containsKey(MAX_GENERATION_COUNT))
        {
            return Integer.parseInt(_dictionary.get(MAX_GENERATION_COUNT));
        }
        
        return 0;
    }
    
    public int getInitialPopulationSize()
    {
        if (_dictionary.containsKey(INITIAL_POPULATION_SIZE))
        {
            return Integer.parseInt(_dictionary.get(INITIAL_POPULATION_SIZE));
        }
        
        return 0;
    }
    
    public int getMaxInitialDepth()
    {
        if (_dictionary.containsKey(MAX_INITIAL_DEPTH))
        {
            return Integer.parseInt(_dictionary.get(MAX_INITIAL_DEPTH));
        }
        
        return 0;
    }
    
    public int getListOfTrainingData()
    {
        if (_dictionary.containsKey(LIST_OF_TRAINING_DATA))
        {
            return Integer.parseInt(_dictionary.get(LIST_OF_TRAINING_DATA));
        }
        
        return 0;
    }
    
    public float getMutationRate()
    {
        if (_dictionary.containsKey(MUTATION_RATE))
        {
            return Float.parseFloat(_dictionary.get(MUTATION_RATE));
        }
        
        return 0;
    }

    public int getMutationHighProbabilityCrossPoint()
    {
        if (_dictionary.containsKey(MUTATION_HIGH_PROBABILITY_CROSS_POINT))
        {
            return Integer.parseInt(_dictionary.get(MUTATION_HIGH_PROBABILITY_CROSS_POINT));
        }
        
        return 0;
    }
    
    public float getMutationHighProbabilityRate()
    {
        if (_dictionary.containsKey(MUTATION_HIGH_PROBABILITY_RATE))
        {
            return Float.parseFloat(_dictionary.get(MUTATION_HIGH_PROBABILITY_RATE));
        }
        
        return 0;
    }
    
    public float getCrossOverRate()
    {
        if (_dictionary.containsKey(CROSSOVER_RATE))
        {
            return Float.parseFloat(_dictionary.get(CROSSOVER_RATE));
        }
        
        return 0;
    }
    
    public int getCrossOverHighProbabilityPoint()
    {
        if (_dictionary.containsKey(CROSSOVER_HIGH_PROBABILITY_CROSS_POINT))
        {
            return Integer.parseInt(_dictionary.get(CROSSOVER_HIGH_PROBABILITY_CROSS_POINT));
        }
        
        return 0;
    }
    
    public float getCrossOverHighProbabilityRate()
    {
        if (_dictionary.containsKey(CROSSOVER_HIGH_PROBABILITY_RATE))
        {
            return Float.parseFloat(_dictionary.get(CROSSOVER_HIGH_PROBABILITY_RATE));
        }
        
        return 0;
    }
    
    public float getNaturalSelectionRate()
    {
        if (_dictionary.containsKey(NATURAL_SELECTION_RATE))
        {
            return Float.parseFloat(_dictionary.get(NATURAL_SELECTION_RATE));
        }
        
        return 0;
    }
    
    public int getNaturalSelectionProbabilityCrossOverPoint()
    {
        if (_dictionary.containsKey(NATURAL_SELECTION_PROBABILITY_CROSSOVER_POINT))
        {
            return Integer.parseInt(_dictionary.get(NATURAL_SELECTION_PROBABILITY_CROSSOVER_POINT));
        }
        
        return 0;
    }    

    public float getNaturalSelectionProbabilityCrossOverRate()
    {
        if (_dictionary.containsKey(NATURAL_SELECTION_PROBABILITY_CROSSOVER_RATE))
        {
            return Float.parseFloat(_dictionary.get(NATURAL_SELECTION_PROBABILITY_CROSSOVER_RATE));
        }
        
        return 0;
    }

    public int getOperatorProbability()
    {
        if (_dictionary.containsKey(OPERATOR_PROBABILITY))
        {
            return Integer.parseInt(_dictionary.get(OPERATOR_PROBABILITY));
        }
        
        return 0;
    }
    
    public int getVariableXProbability()
    {
        if (_dictionary.containsKey(VARIABLE_X_PROBABILITY))
        {
            return Integer.parseInt(_dictionary.get(VARIABLE_X_PROBABILITY));
        }
        
        return 0;
    }

    public int getConstantMinimumValue()
    {
        if (_dictionary.containsKey(CONSTANT_MINIMUM_VALUE))
        {
            return Integer.parseInt(_dictionary.get(CONSTANT_MINIMUM_VALUE));
        }
        
        return 0;
    }
    
    public int getConstantMaximumValue()
    {
        if (_dictionary.containsKey(CONSTANT_MAXIMUM_VALUE))
        {
            return Integer.parseInt(_dictionary.get(CONSTANT_MAXIMUM_VALUE));
        }
        
        return 0;
    }
    
    public String getGeneticModel()
    {
        if (_dictionary.containsKey(GENETIC_MODEL))
        {
            return _dictionary.get(GENETIC_MODEL);
        }
        
        return null;
    }
    
    public int getTimeLimitation()
    {
        if (_dictionary.containsKey(TIME_LIMITATION))
        {
            return Integer.parseInt(_dictionary.get(TIME_LIMITATION));
        }
        
        return 0;
    }
    
    public int getRandomMinimum()
    {
        if (_dictionary.containsKey(RANDOM_MINIMUM))
        {
            return Integer.parseInt(_dictionary.get(RANDOM_MINIMUM));
        }
        
        return 0;
    }
    
    public int getRandomMaximum()
    {
        if (_dictionary.containsKey(RANDOM_MAXIMUM))
        {
            return Integer.parseInt(_dictionary.get(RANDOM_MAXIMUM));
        }
        
        return 0;
    }
}
