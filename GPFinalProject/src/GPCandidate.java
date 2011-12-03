import java.util.Comparator;


/**
 * Comparators the fitness value.
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
class GPFitnessValueComparator implements Comparator<GPCandidate> {
    /**
     * Compares fitness values.
     * @param gp1    Parameter description.
     * @param gp2    Parameter description.
     * @return Result
     */
    public int compare(final GPCandidate gp1, final GPCandidate gp2) {
        if (Double.isNaN(gp1.getFitnessValue())) {
            return (1);
        }
        if (Double.isNaN(gp2.getFitnessValue())) {
            return (-1);
        }
        if (gp1.getFitnessValue() < gp2.getFitnessValue()) {
            return (-1);
        }
        if (gp1.getFitnessValue() > gp2.getFitnessValue()) {
            return (1);
        }
        return (0);
    }
}

/**
 * Genetic Program Candidate.
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
public class GPCandidate {
    /**
     * The candidate.
     */
    protected GPNode candidate;
    /**
     * The candidates fitness value.
     */
    protected double fitnessValue;

    /**
     * Constructor.
     */
    public GPCandidate() {
        candidate = GPNode.generateNode();
        fitnessValue = 0.0;
    }

    /**
     * Update fitness values.
     * @param x        Parameters description.
     * @param expected Parmater description.
     * @return Result.
     */
    public double updateFitnessValue(final double[] x, final double[] expected) {
        double absSum = 0;
        for (int i = 0; i < x.length; i++) {
            double tmp = candidate.evaluateFitnessValue(x[i]);
            tmp = Math.abs(tmp - expected[i]);
            absSum += tmp;
        }
        fitnessValue = absSum;
        return (absSum);
    }

    /**
     * Access the fitnessValue.
     * @return fitnessValue.
     */
    public double getFitnessValue() {
        return (fitnessValue);
    }

    /**
     * Access the top node.
     * @return candidate.
     */
    public GPNode getTopNode() {
        return (candidate);
    }
}

