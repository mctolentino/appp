package java.appp.primes;

public class PrimeGenerator {

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimeNumbers(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static int[] putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int i = 2, j = 0; i < crossedOut.length; i++)
            if (isNotCrossed(i)) result[j++] = i;
        
        return result;
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (isNotCrossed(i)) count++;

        return count;
    }

    private static boolean isNotCrossed(int i) {
        return !crossedOut[i];
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i < maxPrimeFactor + 1; i++) {
            if (isNotCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static int calcMaxPrimeFactor() {
        // We cross out all multiples of p, where p is prime.
        // Thus, all crossed out multiples have p and q for
        // factors. If p > sqrt of the size of the array, then
        // q will never be greater than 1. Thus p is the
        // largest prime factor in the array and is also
        // the iteration limit.
        double maxPrimeFactor = Math.sqrt(crossedOut.length) + 1;
        return (int) maxPrimeFactor;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i)
            crossedOut[multiple] = true;
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }


}
