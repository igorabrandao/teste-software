package param;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculoImpostoRendaTest
{
	// Parameterized test attributes
	private double salary;
	private double expectedTax;
	
	@Parameters(name = "{index}: CalculaImpostoTest({0})")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] 
		{
			// Limit values class 01 (0%)
			{-1, -1},				// Case-Test-id: 1
			{0, 0},					// Case-Test-id: 2
			{1, 1},					// Case-Test-id: 2
			{1200.99, 1200.99},		// Case-Test-id: 3
			
			// Limit values class 02 (10%)
			{1201, 1321.10},		// Case-Test-id: 4
			{1201.99, 1322.18},		// Case-Test-id: 5
			{4999.99, 5499.98},		// Case-Test-id: 6
			{5000, 5500},			// Case-Test-id: 7
			
			// Limit values class 03 (15%)
			{5000.99, 5501.08},		// Case-Test-id: 8
			{5001, 5751.15},		// Case-Test-id: 9
			{9999.99, 11499.98},	// Case-Test-id: 10
			{10000.99, 11501.13},	// Case-Test-id: 11
			
			// Limit values class 04 (20%)
			{10001, 12001.2},		// Case-Test-id: 12
			{10001.99, 12002.38},	// Case-Test-id: 13
		});
	}
	
	/**
	 * Pass the class parameters
	 * 
	 * @param salary
	 * @param expectedTax
	 */
	public CalculoImpostoRendaTest(double salary, double expectedTax) {
		// Pass the values to parameterized attributes 
		this.salary = salary;
		this.expectedTax = expectedTax;
	}
	
	@Test
	public void CalculaImpostoTest() {
		// Expected tax variable
		double expectedTax = 0.0;
		
		// Case of test
		expectedTax = CalculoImpostoRenda.calculaImposto(this.salary);
		
		// Check the result
		assertEquals(this.expectedTax, (expectedTax+this.salary), 0.0);
	}
}