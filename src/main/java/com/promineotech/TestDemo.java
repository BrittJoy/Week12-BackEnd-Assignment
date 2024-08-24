package com.promineotech;

import java.util.Random;

public class TestDemo {

	/*
	 * Step 1-2: Create a Class named "Test Demo" and instance method "addPositive"
	 *  If both parameters are positive (greater than zero) return the sum of the parameters. 
	 *  If either parameter is zero or negative, throw an IllegalArgumentException with the message "Both parameters
	 *   must be positive!". IllegalArgumentException is in the java.lang package so you won't need an import statement.
	 */
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	/*
	 * Step 3: Create Your Own Method & JUnit Test
	 * 
	 * Method multiplies two positive integers.
	 * 
	 * @param 1: a is the first positive integer
	 * 
	 * @param 2: b is the second positive integer
	 * 
	 * @return: product of a and b
	 * 
	 * @throws: IllegalArgumentException if a or b is negative or equal to 0
	 * 
	 */

	public int multiplyPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both numbers must be positive!");
		}

		return a * b;
	}

	/*
	 * Step 4: Mocking a Class - TestDemo
	 * 
	 * Generates a random integer between 1 and 10. Method has package visibility
	 * for testing.
	 */

	public int getRandomInt() {
		Random random = new Random();

		return random.nextInt(10) + 1; // generates random number between 1 and 10
	}

	/*
	 * Squares a random integer obtained from the getRandomInt method.
	 */

	public int randomNumberSquared() {

		int randomInt = getRandomInt();

		return randomInt * randomInt; // return the square of the number
	}

	
	
} // end of class body
