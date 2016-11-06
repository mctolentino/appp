package appp.primes;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneratePrimesTest {

    @Test
    public void testPrimes() {
        int[] nullArray = PrimeGenerator.generatePrimeNumbers(0);
        assertEquals(0, nullArray.length);

        int[] minArray = PrimeGenerator.generatePrimeNumbers(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);

        int[] threeArray = PrimeGenerator.generatePrimeNumbers(3);
        assertEquals(2, threeArray.length);
        assertEquals(2, threeArray[0]);
        assertEquals(3, threeArray[1]);

        int[] centArray = PrimeGenerator.generatePrimeNumbers(100);
        assertEquals(25, centArray.length);
        assertEquals(97, centArray[24]);
    }

    public void testExhaustive() {
        for (int i = 2; i < 500; i++)
            verifyPrimeList(PrimeGenerator.generatePrimeNumbers(i));
    }

    private void verifyPrimeList(int[] list) {
        for (int i : list)
            verifyPrime(list[i]);
    }

    private void verifyPrime(int n) {
        for (int factor = 2; factor < n; factor++)
            Assert.assertTrue(n % factor != 0);
    }


}
