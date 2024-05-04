public class Aplicacao {

	public static void main(String[] args) {
		ContaCorrente cc;
	    ListaDuplamenteEncadeada<ContaCorrente> lista;

	    lista = new ListaDuplamenteEncadeada<>();

	    cc = new ContaCorrente("John", 36, 707);
	    cc.depositar(500.00);
	    lista.inserirFinal(cc);
	    
	    cc = new ContaCorrente("Charles", 45, 801);
	    cc.depositar(800.00);
	    lista.inserirFinal(cc);
	    
	    cc = new ContaCorrente("Mary", 71, 917);
	    cc.depositar(1000.00);
	    lista.inserirFinal(cc);
	    
	    cc = lista.removerFinal();
	    System.out.println("Conta-corrente removida:");
	    System.out.println(cc.toString()); // Mary
	    
	    cc = lista.removerFinal();
	    System.out.println("Conta-corrente removida:");
	    System.out.println(cc.toString()); // Charles
	}

}
