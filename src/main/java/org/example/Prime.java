package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * This program counts the sum and the number of prime (int) numbers in interval 0-1000
 */
public class Prime {

    private List<Integer> primes;
    private int sumOfPrimes = 0;
    private int numberOfPrimes = 0;
    private boolean isValidNumbers;

    public Prime() {}
    public Prime(int firstNumber, int lastNumber) {
        if (firstNumber < 0 || lastNumber < firstNumber || lastNumber > 1000) {
            isValidNumbers = false;
        } else {
            isValidNumbers = true;
            primes = new ArrayList<>();
            calculatePrimes(firstNumber, lastNumber);
            numberOfPrimes = primes.size();
        }
    }

    //Getters and Setters
    public boolean isValidNumbers() {
        return isValidNumbers;
    }

    public int getNumberOfPrimes() {
        return numberOfPrimes;
    }

    public int getSumOfPrimes() {
        return sumOfPrimes;
    }

    public void setSumOfPrimes(int sumOfPrimes) {
        this.sumOfPrimes = sumOfPrimes;
    }

    //Method for validating if number is prime or not
    private boolean numIsPrime(int current) {
        if (current < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(current); i++) {
            /* iterate from 2 up to the square root of the number
            to determine if it is divisible */
            if (current % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Recursive method for gathering primes
    private void calculatePrimes(int current, int stop) {

        if (current > stop) {
            setSumOfPrimes(sumOfPrimes);
        } else if (numIsPrime(current)) {
            primes.add(current);
            sumOfPrimes += current;
            calculatePrimes(current + 1, stop);
        } else {
            calculatePrimes(current + 1, stop);
        }
    }

    //Collection of primes
    public List<Integer> getPrimes() {
        return primes;
    }

    //Print messages
    public void printCount(int numberOfPrimes) {
        System.out.println("Hej, det finns " + numberOfPrimes + " primtal mellan 0 och 1000!");
    }
    public void printSum(int sumOfPrimes) {
        System.out.println("Och den totala summan av dessa primtal är " + sumOfPrimes);
    }
    public void wrongMessage(){
        System.out.println("Hoppsan, fel intervall angivet!");
    }

    public static void main(String[] args) {
        Prime prime = new Prime(0, 1000);

        if (prime.isValidNumbers) {
            prime.printCount(prime.numberOfPrimes);
            prime.printSum(prime.sumOfPrimes);
        } else {
            prime.wrongMessage();
        }
    }
}
