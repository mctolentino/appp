package appp.primes;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneratePrimesTest {

    @Test
    public void testPrimes(){
        int[] nullArray = GeneratePrimes.generatePrimeNumbers(0);
        assertEquals(0, nullArray.length);

        int[] minArray = GeneratePrimes.generatePrimeNumbers(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);

        int[] threeArray = GeneratePrimes.generatePrimeNumbers(3);
        assertEquals(2, threeArray.length);
        assertEquals(2, threeArray[0]);
        assertEquals(3, threeArray[1]);

        int[] centArray = GeneratePrimes.generatePrimeNumbers(100);
        assertEquals(25, centArray.length);
        assertEquals(97, centArray[24]);
    }
}
