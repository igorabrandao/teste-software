package fila;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.OperacaoIlegalException;

public class FilaTest {

	@Test
	public void testInserirComSucesso() throws FilaCheiaException{
		Fila c = new Fila(20);
		Object test = new Object();
		c.insereNaFila(test);
	}
	
	@Test(expected=FilaCheiaException.class)
	public void testInserirFilaCheia() throws FilaCheiaException{
		Fila c = new Fila(20);
		Object test = new Object();
		
		for (int i = 0; i <= 20; i++) {
			c.insereNaFila(test);
		}
	}
}
