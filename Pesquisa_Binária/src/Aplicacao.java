public class Aplicacao {

	public static void main(String[] args) {
		ContaCorrente cc;
	    Lista<ContaCorrente> lista;

	    lista = new Lista<>(5);

	    cc = new ContaCorrente("John", 36, 707);
	    cc.depositar(500.00);
	    lista.inserir(cc, 0);
	    
	    cc = new ContaCorrente("Charles", 45, 801);
	    cc.depositar(800.00);
	    lista.inserir(cc, 0);
	    
	    cc = new ContaCorrente("Mary", 71, 917);
	    cc.depositar(1000.00);
	    lista.inserir(cc, 0);
	    
	    cc = new ContaCorrente("Michael", 71, 917);
	    cc.depositar(1000.00);
	    lista.inserir(cc, 1);
	    
	    cc = new ContaCorrente("Susan", 71, 917);
	    cc.depositar(1000.00);
	    lista.inserir(cc, 1);
	    
	    lista.ordenar();
	   
	    try {
	    	cc = new ContaCorrente("John", 0, 0);
	    	System.out.println("Pesquisando a conta-corrente de John");
		    System.out.println("Conta-corrente encontrada: " + lista.pesquisar(cc) + "\n");
		    
		    cc = new ContaCorrente("Thomas", 0, 0);
		    System.out.println("Pesquisando a conta-corrente de Thomas");
		    System.out.println("Conta-corrente encontrada: " + lista.pesquisar(cc) + "\n");
	    } catch (Exception excecao) {
	    	System.out.println(excecao.getMessage());
	    }
	}
}
