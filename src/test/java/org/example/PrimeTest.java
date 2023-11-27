package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Prime class")
class PrimeTest {

    Prime prime;

    @AfterEach
    @DisplayName("Test succeeded")
    public void testSucceed(){
        System.out.println("Test succeeded");
    }

    @Test
    @DisplayName("Testing initial value of number of Primes")
    public void testInitValueOfNumberOfPrimes(){
        prime = new Prime();
        assertEquals(0, prime.getNumberOfPrimes());
    }
    @Test
    @DisplayName("Testing initial value of the sum of Primes")
    public void testInitValueOfSum(){
        prime = new Prime();
        assertEquals(0, prime.getSumOfPrimes());
    }
    @Test
    @DisplayName("Testing initial value of list")
    public void testInitList(){
        prime = new Prime();
        assertNull(prime.getPrimes());
    }


    @Test
    @DisplayName("Testing that correct amount of Primes are added")
    public void testNumberOfPrimes(){
        prime = new Prime(0,10);
        assertEquals(4, prime.getNumberOfPrimes());
    }
    @Test
    @DisplayName("Testing that correct Primes are added to list")
    public void testPrimeList(){
        prime = new Prime(0,10);
        assertIterableEquals(List.of(2, 3, 5, 7),  prime.getPrimes());
    }
    @Test
    @DisplayName("Testing that sum of primes are correct")
    public void testSumOfPrimes(){
        prime = new Prime(0,10);
        assertEquals(17, prime.getSumOfPrimes());
    }
    @Test
    @DisplayName("Testing that the maximal numbers of primes are correct")
    public void testMaxNumberOfPrimes(){
        prime = new Prime(0,1000);
        assertEquals(168, prime.getNumberOfPrimes());
    }
    @Test
    @DisplayName("Testing that the maximal sum of primes are correct")
    public void testMaxValueOfPrimes(){
        prime = new Prime(0,1000);
        assertEquals(76127, prime.getSumOfPrimes());
    }


    @Test
    @DisplayName("Testing that the lowest start value and highest end value in constructor are correct")
    public void testConstructorBoundaries(){
        prime = new Prime(0,1000);
        assertTrue(prime.isValidNumbers());
    }
    @Test
    @DisplayName("Testing that constructor parameters both are zero")
    public void testConstructorIsZero(){
        prime = new Prime(0,0);
        assertTrue(prime.isValidNumbers());
    }
    @Test
    @DisplayName("Testing that constructor parameters don't take negative number")
    public void testConstructorFirstNumberIsNegative(){
        prime = new Prime(-1,-1);
        assertFalse(prime.isValidNumbers());
    }

    @Test
    @DisplayName("Testing that constructor parameter dont take to high numbers")
    public void testConstructorNumberIsTooHigh(){
        prime = new Prime(1001,1001);
        assertFalse(prime.isValidNumbers());
    }

    @Test
    @DisplayName("Testing that start value cant be bigger then end value in constructor")
    public void testConstructorNumberIsTooLow(){
        prime = new Prime(11,10);
        assertFalse(prime.isValidNumbers());
    }


    @Test
    @DisplayName("Testing that print message of sum is correct")
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
    @DisplayName("Testing that print message of sum is correct")
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
    @DisplayName("Testing that print message of wrong message is correct")
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