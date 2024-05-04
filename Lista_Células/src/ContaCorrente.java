public class ContaCorrente {

	private String titular;
	private int agencia;
	private int numConta;
	private double saldo;
	
	public ContaCorrente(String titular, int agencia, int numConta) {
		this.setTitular(titular);
		this.setAgencia(agencia);
		this.setNumConta(numConta);
		this.saldo = 0.0;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	// se o valor a ser creditado, passado como parâmetro para esse método, for positivo: 
	// incrementa o saldo da conta-corrente com o valor de crédito informado.
    public void depositar(double credito) {
        if (credito <= 0)
        	throw new IllegalArgumentException("O valor a ser creditado deve ser positivo.");

        saldo = saldo + credito;
    }

    // se a quantia a ser sacada, passada como parâmetro para esse método, for positiva, 
    // e houver saldo suficiente: decrementa, do saldo atual da conta-corrente, 
    // a quantia informada.
    public void sacar(double quantia) {
        
    	if (quantia <= 0)
        	throw new IllegalArgumentException("O valor a ser sacado deve ser positivo.");
        
        if ((saldo - quantia) < 0)
            throw new RuntimeException("Não há saldo suficiente em conta-corrente para esse saque.");
        
        saldo = saldo - quantia;    
    }
    
    public String toString() {
    	return ("Titular: " + this.titular + "\nAgência: " + this.agencia + 
    			"\nNúmero da conta-corrente: " + this.numConta + "\nSaldo: " + this.saldo);
    }
}