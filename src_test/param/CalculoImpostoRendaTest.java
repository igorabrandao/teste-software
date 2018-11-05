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
			/**
			 * Case Tests
			 * 
			 * Note: they are located in "Casos de Teste" spreadsheet
			 */
			{1201, 1321.10},		// Case-Test-id: 1
			{5000, 5500},			// Case-Test-id: 2
			{5001, 5751.15},		// Case-Test-id: 3
			{10000, 11500},			// Case-Test-id: 4
			{10001, 12001.2},		// Case-Test-id: 5
			{900, 900},				// Case-Test-id: 6
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
		assertEquals(this.expectedTax, (this.salary * expectedTax), 0.0);
	}
}