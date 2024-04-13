public class Pilha<E> {

	private E[] pilha;
	private int topo;

	public Pilha(int tamanho) {
		
		pilha = (E[]) new Object[tamanho];
		topo = 0;
	}
	
	private boolean pilhaVazia() {
		
		if (topo == 0)
			return true;
		else
			return false;
	}
	
	private boolean pilhaCheia() {
		
		if (topo == pilha.length)
			return true;
		else
			return false;
	}
	
	public void empilhar(E item) throws Exception{
		
		if (! pilhaCheia()) {
			pilha[topo] = item;
			topo++;
		} else
			throw new Exception("Nao foi possivel empilhar "
					+ "o item: a pilha está cheia!");
	}
	
	public E desempilhar() throws Exception {
		
		if (! pilhaVazia()) {
			topo--;
			return pilha[topo];
		} else
			throw new Exception("Nao foi possivel desempilhar "
					+ "o item: a pilha está vazia!");
	}

	public E consultarTopo() throws Exception {
		
		if (! pilhaVazia()) {
			return pilha[topo-1];
		} else
			throw new Exception("Nao há nenhum item na pilha!");
	}
}