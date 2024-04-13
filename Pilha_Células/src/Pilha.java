public class Pilha<T> {

	private Celula<T> topo;
	private Celula<T> fundo;
	
	public Pilha() {
		
		Celula<T> sentinela;
		
		sentinela = new Celula<T>();
		fundo = sentinela;
		topo = sentinela;
	}
	
	private boolean pilhaVazia() {
		
		if (fundo == topo)
			return true;
		else
			return false;
	}
	
	public void empilhar(T item) {
		
		Celula<T> novaCelula;
		
		novaCelula = new Celula<T>(item);
		novaCelula.setProximo(topo);
		topo = novaCelula;
	}
	
	public T desempilhar() throws Exception {
		
		T desempilhado;
		
		if (! pilhaVazia()) {
			desempilhado = topo.getItem();
			topo = topo.getProximo();
			return desempilhado;
		} else
			throw new Exception("Nao foi possível desempilhar "
					+ "o item: a pilha está vazia!");
	}
	
	public T consultarTopo() throws Exception {
		
		if (! pilhaVazia())
			return(topo.getItem());
		else
			throw new Exception("A pilha está vazia!");
	}
}