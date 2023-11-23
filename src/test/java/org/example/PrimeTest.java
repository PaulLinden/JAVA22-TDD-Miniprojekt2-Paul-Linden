package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    Prime prime;
    //Test for correct init values
    @Test
    public void testInitValueOfNumberOfPrimes(){
        prime = new Prime();
        assertEquals(0, prime.getNumberOfPrimes());
    }
    @Test
    public void testInitValueOfSum(){
        prime = new Prime();
        assertEquals(0, prime.getSumOfPrimes());
    }
    @Test
    public void testInitSizeOfList(){
        prime = new Prime();
        assertNull(prime.getPrimes());
    }
    //Testing Prime Values
    @Test
    public void testNumberOfPrimes(){
        prime = new Prime(0,10);
        assertEquals(4, prime.getNumberOfPrimes());
    }
    @Test
    public void testPrimeList(){
        prime = new Prime(0,10);
        assertIterableEquals(List.of(2, 3, 5, 7),  prime.getPrimes());
    }
    @Test
    public void testSumOfPrimes(){
        prime = new Prime(0,10);
        assertEquals(17, prime.getSumOfPrimes());
    }
    @Test
    public void testMaxNumberOfPrimes(){
        prime = new Prime(0,1000);
        assertEquals(168, prime.getNumberOfPrimes());
    }
    @Test
    public void testMaxValueOfPrimes(){
        prime = new Prime(0,1000);
        assertEquals(76127, prime.getSumOfPrimes());
    }

    //Test of constructor parameters
    @Test
    public void testConstructorBoundaries(){
        prime = new Prime(0,1000);
        assertTrue(prime.isValidNumbers());
    }
    @Test
    public void testConstructorIsZero(){
        prime = new Prime(0,0);
        assertTrue(prime.isValidNumbers());
    }
    @Test
    public void testConstructorFirstNumberIsNegative(){
        prime = new Prime(-1,1000);
        assertFalse(prime.isValidNumbers());
    }
    @Test
    public void testConstructorLastNumberIsNegative(){
        prime = new Prime(-1,1000);
        assertFalse(prime.isValidNumbers());
    }
    @Test
    public void testConstructorNumberIsTooHigh(){
        prime = new Prime(0,1001);
        assertFalse(prime.isValidNumbers());

        prime = new Prime(1001,1001);
        assertFalse(prime.isValidNumbers());
    }
    @Test
    public void testConstructorNumberIsTooLow(){
        prime = new Prime(11,10);
        assertFalse(prime.isValidNumbers());
    }
    //Test print methods
    @Test
    public void testPrintSum() {
        prime = new Prime(0, 1000);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        prime.printSum(prime.getSumOfPrimes());

        String expectedOutput = "Och den totala summan av dessa primtal är 76127";
        assertEquals(expectedOutput, outContent.toString().trim());

        System.setOut(System.out);
    }
    @Test
    public void testPrintCount() {
        prime = new Prime(0, 1000);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        prime.printCount(prime.getNumberOfPrimes());

        String expectedOutput = "Hej, det finns 168 primtal mellan 0 och 1000!";
        assertEquals(expectedOutput, outContent.toString().trim());

        System.setOut(System.out);
    }
    @Test
    public void testWrongMessage() {
        prime = new Prime();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        prime.wrongMessage();

        String expectedOutput = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedOutput, outContent.toString().trim());

        System.setOut(System.out);
    }
}