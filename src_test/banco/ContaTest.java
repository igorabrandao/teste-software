package banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContaTest {

	@Test
	public void testDebitarSucesso() throws OperacaoIlegalException{
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10,c.getSaldo(),0.0);
	}

	@Test
	public void testSaqueUltrapassaLimite() throws OperacaoIlegalException{
		Conta c = new Conta ("123", 50.0);
		c.debitar(70);
		assertEquals(-20,c.getSaldo(),0.0);
	}

	@Test(expected=OperacaoIlegalException.class)
	public void testContaNula() throws OperacaoIlegalException{
		Conta c = new Conta(null, 20);
		c.debitar(-30);
	}
}
