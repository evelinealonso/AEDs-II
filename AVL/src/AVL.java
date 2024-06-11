public class AVL<E extends Comparable<E>> extends ABB<E> {

	/**
	 *  Construtor da classe.
	 *  Esse construtor cria uma nova árvore binária de busca AVL vazia.
	 */
    public AVL() {
        super();
    }
    
    /**
    * Método recursivo responsável por adicionar um item à árvore.
    * @param raizArvore: raiz da árvore ou sub-árvore em que o item será adicionado.
    * @param item: item que deverá ser adicionado à árvore.
    * @return a raiz atualizada da árvore ou sub-árvore balanceada AVL em que o item foi adicionado.
    */
    @Override
    protected No<E> adicionar(No<E> raizArvore, E item) {
    	
    	return balancear(super.adicionar(raizArvore, item));
    }
    
    /**
    * Método recursivo responsável por localizar na árvore ou sub-árvore o antecessor do nó que deverá ser retirado. 
    * O antecessor do nó que deverá ser retirado da árvore corresponde
    * ao nó que armazena o item que é o maior, 
    * dentre os itens menores do que o item que deverá ser retirado.
    * Depois de ser localizado na árvore ou sub-árvore, 
    * o antecessor do nó que deverá ser retirado da árvore o substitui.
    * Adicionalmente, a árvore ou sub-árvore balanceada AVL é atualizada com a remoção do antecessor.
    * @param itemRetirar: referência ao nó que armazena o item que deverá ser retirado da árvore.
    * @param raizArvore: raiz da árvore ou sub-árvore em que o antecessor do nó que deverá ser retirado deverá ser localizado.
    * @return a raiz atualizada da árvore ou sub-árvore balanceada AVL após a remoção do antecessor do nó que foi retirado da árvore.
    */
    @Override
    protected No<E> removerNoAntecessor(No<E> itemRetirar, No<E> raizArvore) {
    	
        return balancear(super.removerNoAntecessor(itemRetirar, raizArvore));
    }

    /**
    * Método recursivo responsável por localizar um item na árvore e retirá-lo da árvore.
    * @param raizArvore: raiz da árvore ou sub-árvore da qual o item será retirado.
    * @param itemRemover: item que deverá ser localizado e removido da árvore.
    * @return a raiz atualizada da árvore ou sub-árvore balanceada AVL da qual o item foi retirado.
    */
    @Override
    protected No<E> remover(No<E> raizArvore, E itemRemover) {
    	
    	return balancear(super.remover(raizArvore, itemRemover));
    }

    private No<E> balancear(No<E> raizArvore) {
		
		int fatorBalanceamento;
		int fatorBalanceamentoFilho;
		
		if (raizArvore != null) {
			
			fatorBalanceamento = raizArvore.getFatorBalanceamento();
			
			if (fatorBalanceamento == 2) {
				// árvore desbalanceada à esquerda.
				fatorBalanceamentoFilho = raizArvore.getEsquerda().getFatorBalanceamento();
				if (fatorBalanceamentoFilho == -1)
					// Rotação dupla
					// Rotação simples à esquerda
					raizArvore.setEsquerda(rotacionarEsquerda(raizArvore.getEsquerda()));
				// Rotação simples à direita
				raizArvore = rotacionarDireita(raizArvore);
			} else if (fatorBalanceamento == -2) {
				// árvore desbalanceada à direita.
				fatorBalanceamentoFilho = raizArvore.getDireita().getFatorBalanceamento();
				if (fatorBalanceamentoFilho == 1)
					// Rotação dupla
					// Rotação simples à direita
					raizArvore.setDireita(rotacionarDireita(raizArvore.getDireita()));
				// Rotação simples à esquerda
				raizArvore = rotacionarEsquerda(raizArvore);
			} else
				raizArvore.setAltura();
		}
		return raizArvore;
	}
	
	private No<E> rotacionarDireita(No<E> p) {
		
		No<E> u;
		No<E> filhoEsquerdaDireita;  // triângulo vermelho
		
		u = p.getEsquerda();
		filhoEsquerdaDireita = u.getDireita();
		
		p.setEsquerda(filhoEsquerdaDireita);
		u.setDireita(p);
		
		p.setAltura();
		u.setAltura();
		
		return u;
	}
	
	private No<E> rotacionarEsquerda(No<E> p) {
	
		No<E> z;
		No<E> filhoDireitaEsquerda;  // triângulo vermelho
		
		z = p.getDireita();
		filhoDireitaEsquerda = z.getEsquerda();
		
		p.setDireita(filhoDireitaEsquerda);
		z.setEsquerda(p);
		
		p.setAltura();
		z.setAltura();
		
		return z;
	}
}
