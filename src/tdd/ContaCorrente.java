package tdd;

import java.util.ArrayList;

public class ContaCorrente {

	private String codigo = "";
	private int saldo = 0;
	private String correntista = "";

	ArrayList<Deposito> depositos = new ArrayList();


	public ContaCorrente() {}

	public ContaCorrente(int p_saldo) { 
		this.saldo = p_saldo;
	}

	public ContaCorrente(String correntista) { 
		this.correntista = correntista;
	}
	
	public ContaCorrente(String correntista, int p_saldo) { 
		this.correntista = correntista;
		this.saldo = p_saldo;
	}

	public int saldo() {
		return this.saldo;
	}

	public int creditar(Deposito deposito) {
		depositos.add(deposito);
		this.saldo += deposito.valor;
		return this.saldo;
	}

	public String extrato() {
		String extrato = "Conta de " + this.correntista + "\n" +
				"Saldo Inicial $" + this.saldo + "\n" +
				"Saldo Final $" + this.saldo + "\n";

		if (depositos.size() > 0) {
			for (int i=0; i<depositos.size(); i++) {
				extrato += this.depositos.get(i).data + "\tDeposito\t$" + this.depositos.get(i).valor;
			}
		} else {
			extrato += "Nenhuma trasacao realizada\n";
		}
		
		return extrato;
	}
}