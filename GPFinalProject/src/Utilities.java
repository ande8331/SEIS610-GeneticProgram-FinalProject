import java.util.Random;
/**
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
public class Utilities {

    //public Utilities{    }
    /**
     * Gets a random number between two parameters.
     * @param minimumNum The minimum number possible generated.
     * @param maximumNum The maximum number possible generated.
     * @return Output
     */
    public static int getRandomNumber(final int minimumNum, final int maximumNum) {

        int diff = (maximumNum - minimumNum) + 1;

        if (diff < 1) {
            return (0);
        }
        Random rand = new Random();
        int output = rand.nextInt(diff);
        output += minimumNum;
        return (output);
    }
    /**
     * Gets random number.
     * @return A double value GT 0.0 and LT 1.0
     */
    public static double getRandomDouble() {
        return (Math.random());
    }
}

