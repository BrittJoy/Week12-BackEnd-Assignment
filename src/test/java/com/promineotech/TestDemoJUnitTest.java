package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments; //found this solution on junit.org. Needed to include the "static".
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments; // instructions given were to add "org.junit.jupiter.params.provider.Arguments.arguments", but this flagged as an error/was not recognized.
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	/* Step 1-4:
	 * In the setUp() method, create the TestDemo object. This will ensure that a new TestDemo object is created before each test.
	 */
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();

	}

	/* Step 1-4 cont:
	 * Add four parameters to assertThatTwoPositiveNumbersAreAddedCorrectly.
	 * Test the value of expectException. If it is false, assert that when TestDemo.addPositive is called with values a and b, 
	 * that the result is the same as the parameter expected. 
	 * Add the test for the thrown exception in an else clause. Use assertThatThrownBy for this.
	 * As a parameter to assertThatThrownBy, add a Lambda expression with no parameters. 
	 * The Lambda body should be the method call to testDemo.addPositive.
	 * Use the assertion isInstanceOf(IllegalArgumentException.class) to ensure that the correct exception is thrown.
	 * 
	 * Just below the @ParameterizedTest annotation, add the annotation @MethodSource. Pass a single parameter to @MethodSource. 
	 * It must be the fully-qualified (includes package) class name of the test followed by a # sign followed by the name of 
	 * the method that supplies the parameters.
	 * 
	 */
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}

	}
	
	
	/*
	 * Parameter Source Method:
	 * Each parameter set should be wrapped in an arguments() method call.
	 */

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false), arguments(1, 5, 6, false), arguments(-1, 4, 0, true),
				arguments(2, 0, 0, true), arguments(3, 7, 10, false));
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		// Test Cases:

		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(15, 25)).isEqualTo(40);
		assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
		assertThat(testDemo.addPositive(7, 8)).isEqualTo(15);
	}

	/*
	 * Step 3: Write Your Own Method & JUnit Test:
	 * Test for MultiplyPositive method.
	 * 
	 * Using "assertThat" to test what is expected with positive numbers and 
	 * exception testing for numbers that do not fit the parameters.
	 */
	
	@Test
	void assertThatPairsOfPositiveNumbersMultiplyCorrectly() {

		// Positive Case:

		assertThat(testDemo.multiplyPositive(3, 4)).isEqualTo(12);
		assertThat(testDemo.multiplyPositive(5, 6)).isEqualTo(30);

		// Negative Case - Expecting Exception

		assertThatThrownBy(() -> testDemo.multiplyPositive(-3, 4)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.multiplyPositive(-3, 4)).isInstanceOf(IllegalArgumentException.class);

	}

	/*
	 * Step 4: Mocking a Class - TestDemo
	 * 
	 * Test for RandomNumberSquared method. Write a test for randomNumberSquared in TestDemoJUnitTest.java. 
	 * Since you don't know what getRandomInt will return (that's the point of random, after all), 
	 * you will need to mock it out and supply a known value.
	 * 
	 * Using Mockito.spy
	 * 
	 * Use "assertThat" to test that the value returned from randomNumberSquared is equal to 5 squared.
	 */
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		TestDemo testDemo = new TestDemo();
		
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}

}// end of body
