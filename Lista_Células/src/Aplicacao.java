public class Aplicacao {

	public static void main(String[] args) {
		ContaCorrente cc;
	    Lista<ContaCorrente> lista;

	    lista = new Lista<>();

	    cc = new ContaCorrente("John", 36, 707);
	    cc.depositar(500.00);
	    lista.inserir(cc, 0);
	    
	    cc = new ContaCorrente("Charles", 45, 801);
	    cc.depositar(800.00);
	    lista.inserir(cc, 0);
	    
	    cc = new ContaCorrente("Mary", 71, 917);
	    cc.depositar(1000.00);
	    lista.inserir(cc, 2);
	    
	    cc = lista.remover(1);
	    System.out.println("Conta-corrente removida:");
	    System.out.println(cc.toString()); // John
	    
	    cc = lista.remover(1);
	    System.out.println("Conta-corrente removida:");
	    System.out.println(cc.toString()); // Mary
	}

}
