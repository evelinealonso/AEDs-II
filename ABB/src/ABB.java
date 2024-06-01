import java.util.NoSuchElementException;

public class ABB<E extends Comparable<E>> {

	private No<E> raiz; // referência à raiz da árvore.

    /// Construtor da classe.
    /// Esse construtor cria uma nova árvore binária de busca vazia. Para isso, esse método atribui null à raiz da árvore.
    public ABB() {
        raiz = null;
    }

    /// Método booleano que indica se a árvore está vazia ou não.
    /// Retorna: 
    /// verdadeiro: se a raiz da árvore for null, o que significa que a árvore está vazia.
    /// falso: se a raiz da árvore não for null, o que significa que a árvore não está vazia.
    public Boolean vazia() {
        return (this.raiz == null);
    }

    private E pesquisar(No<E> raizArvore, E procurado) {
    	
    	int comparacao;
    	
    	if (raizArvore == null)
    		/// Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e então o item não foi encontrado.
    		throw new NoSuchElementException("O item não foi localizado na árvore!");
    	
    	comparacao = procurado.compareTo(raizArvore.getItem());
    	
    	if (comparacao == 0)
    		/// O item procurado foi encontrado.
    		return raizArvore.getItem();
    	else if (comparacao < 0)
    		/// Se o item procurado for menor do que o item armazenado na raiz da árvore:
            /// pesquise esse item na sub-árvore esquerda.    
    		return pesquisar(raizArvore.getEsquerda(), procurado);
    	else
    		/// Se o item procurado for maior do que o item armazenado na raiz da árvore:
            /// pesquise esse item na sub-árvore direita.
    		return pesquisar(raizArvore.getDireita(), procurado);
    }
    
    public E pesquisar(E procurado) {
    	return pesquisar(this.raiz, procurado);
    }
    
    /// Método recursivo responsável por adicionar um item à árvore.
    /// Parâmetro "raizArvore": raiz da árvore ou sub-árvore em que o item será adicionado.
    /// Parâmetro "item": item que deverá ser adicionado à árvore.
    /// Retorna a raiz atualizada da árvore ou sub-árvore em que o item foi adicionado.
    private No<E> adicionar(No<E> raizArvore, E item) {
    	
    	int comparacao;
    	
        /// Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e então um novo item é inserido.
        if (raizArvore == null)
            raizArvore = new No<>(item);
        else {
        	comparacao = item.compareTo(raizArvore.getItem());
        
        	if (comparacao < 0)
        		/// Se o item que deverá ser inserido na árvore for menor do que o item armazenado na raiz da árvore:
        		/// adicione esse novo item à sub-árvore esquerda; e atualize a referência para a sub-árvore esquerda modificada. 
        		raizArvore.setEsquerda(adicionar(raizArvore.getEsquerda(), item));
        	else if (comparacao > 0)
        		/// Se o item que deverá ser inserido na árvore for maior do que o item armazenado na raiz da árvore:
        		/// adicione esse novo item à sub-árvore direita; e atualize a referência para a sub-árvore direita modificada.
        		raizArvore.setDireita(adicionar(raizArvore.getDireita(), item));
        	else
        		/// O item armazenado na raiz da árvore é igual ao novo item que deveria ser inserido na árvore.
        		throw new RuntimeException("O item já foi inserido anteriormente na árvore.");
        }
        
        /// Retorna a raiz atualizada da árvore ou sub-árvore em que o item foi adicionado.
        return raizArvore;
    }

    /// Método que encapsula a adição recursiva de itens à árvore.
    /// Parâmetro "item": item que deverá ser inserido na árvore.
    public void adicionar(E item) {
        /// Chama o método recursivo "adicionar", que será responsável por adicionar, o item passado como parâmetro, à árvore.
        /// O método "adicionar" recursivo receberá, como primeiro parâmetro, a raiz atual da árvore; e, como segundo parâmetro, 
    	/// o item que deverá ser adicionado à árvore.
        /// Por fim, a raiz atual da árvore é atualizada, com a raiz retornada pelo método "adicionar" recursivo.
        this.raiz = adicionar(this.raiz, item);
    }
    
    public void caminhamentoEmOrdem() {
    	
    	if (vazia())
    		throw new IllegalStateException("A árvore está vazia!");
    	
    	caminhamentoEmOrdem(this.raiz);
    }
    
    private void caminhamentoEmOrdem(No<E> raizArvore) {
    	if (raizArvore != null) {
    		caminhamentoEmOrdem(raizArvore.getEsquerda());
    		System.out.println(raizArvore.getItem());
    		caminhamentoEmOrdem(raizArvore.getDireita());
    	}
    }
    
    /// Método recursivo responsável por localizar na árvore ou sub-árvore o antecessor do nó que deverá ser retirado. 
    /// O antecessor do nó que deverá ser retirado da árvore corresponde
    /// ao nó que armazena o item que é o maior, 
    /// dentre os itens menores do que o item que deverá ser retirado.
    /// Depois de ser localizado na árvore ou sub-árvore, 
    /// o antecessor do nó que deverá ser retirado da árvore o substitui.
    /// Adicionalmente, a árvore ou sub-árvore é atualizada com a remoção do antecessor.
    /// Parâmetro "itemRetirar": referência ao nó que armazena o item que deverá ser retirado da árvore.
    /// Parâmetro "raizArvore": raiz da árvore ou sub-árvore em que o antecessor do nó que deverá ser retirado deverá ser localizado.
    /// Retorna: raiz atualizada da árvore ou sub-árvore após a remoção do antecessor do nó que foi retirado da árvore.
    private No<E> removerNoAntecessor(No<E> itemRetirar, No<E> raizArvore) {
        /// Se o antecessor do nó que deverá ser retirado da árvore ainda não foi encontrado...
        if (raizArvore.getDireita() != null)
            /// Pesquise o antecessor na sub-árvore direita.
            raizArvore.setDireita(removerNoAntecessor(itemRetirar, raizArvore.getDireita()));
        else {
        	/// O antecessor do nó que deverá ser retirado da árvore foi encontrado e deverá substitui-lo.
            itemRetirar.setItem(raizArvore.getItem());
            /// A raiz da árvore ou sub-árvore é atualizada com os descendentes à esquerda do antecessor.
            /// Ou seja, retira-se o antecessor da árvore.
            raizArvore = raizArvore.getEsquerda();
        }
        return raizArvore;
    }

    /// Método recursivo responsável por localizar um item na árvore e retirá-lo da árvore.
    /// Parâmetro "raizArvore": raiz da árvore ou sub-árvore da qual o item será retirado.
    /// Parâmetro "itemRemover": item que deverá ser localizado e removido da árvore.
    /// Retorna a raiz atualizada da árvore ou sub-árvore da qual o item foi retirado.
    private No<E> remover(No<E> raizArvore, E itemRemover) {
    	
    	int comparacao;
    	
        /// Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e o item, que deveria ser retirado dessa árvore, não foi encontrado.
        /// Nesse caso, deve-se lançar uma exceção.
        if (raizArvore == null) 
        	throw new NoSuchElementException("O item a ser removido não foi localizado na árvore!");
        
        comparacao = itemRemover.compareTo(raizArvore.getItem());
        
        if (comparacao == 0) {
            /// O item armazenado na raiz da árvore corresponde ao item que deve ser retirado dessa árvore.
            /// Ou seja, o item que deve ser retirado da árvore foi encontrado.
        	if (raizArvore.getDireita() == null)
        		/// O nó da árvore que será retirado não possui descendentes à direita.
                /// Nesse caso, os descendentes à esquerda do nó que está sendo retirado da árvore passarão a ser descendentes do nó-pai do nó que está sendo retirado.
                raizArvore = raizArvore.getEsquerda();
            else if (raizArvore.getEsquerda() == null)
                /// O nó da árvore que será retirado não possui descendentes à esquerda.
                /// Nesse caso, os descendentes à direita do nó que está sendo retirado da árvore passarão a ser descendentes do nó-pai do nó que está sendo retirado.
                raizArvore = raizArvore.getDireita();
            else
            	/// O nó que está sendo retirado da árvore possui descendentes à esquerda e à direita.
                /// Nesse caso, o antecessor do nó que está sendo retirado é localizado na sub-árvore esquerda desse nó. 
                /// O antecessor do nó que está sendo retirado da árvore corresponde
                /// ao nó que armazena o item que é o maior, 
                /// dentre os itens menores do que o item do nó que está sendo retirado.
                /// Depois de ser localizado na sub-árvore esquerda do nó que está sendo retirado, 
                /// o antecessor desse nó o substitui.
                /// A sub-árvore esquerda do nó que foi retirado é atualizada com a remoção do antecessor.
                raizArvore.setEsquerda(removerNoAntecessor(raizArvore, raizArvore.getEsquerda()));
        } else if (comparacao < 0)
        	/// Se o item que deverá ser localizado e retirado da árvore for menor do que o item armazenado na raiz da árvore:
        	/// pesquise e retire esse item da sub-árvore esquerda.
            raizArvore.setEsquerda(remover(raizArvore.getEsquerda(), itemRemover));
        else
        	/// Se o item que deverá ser localizado e retirado da árvore for maior do que o item armazenado na raiz da árvore:
        	/// pesquise e retire esse item da sub-árvore direita.
            raizArvore.setDireita(remover(raizArvore.getDireita(), itemRemover));
         
        /// Retorna a raiz atualizada da árvore ou sub-árvore da qual o item foi retirado.
        return raizArvore;
    }

    /// Método que encapsula a remoção recursiva de um item da árvore.
    /// Parâmetro "itemRemover": item que deverá ser localizado e removido da árvore.
    public void remover(E itemRemover) {
        /// Chama o método recursivo "remover", que será responsável por pesquisar o item passado como parâmetro na árvore e retirá-lo da árvore.
        /// O método "remover" recursivo receberá, como primeiro parâmetro, a raiz atual da árvore; 
    	/// e, como segundo parâmetro, o item que deverá ser localizado e retirado dessa árvore.
    	/// Por fim, a raiz atual da árvore é atualizada, com a raiz retornada pelo método "remover" recursivo.
        this.raiz = remover(this.raiz, itemRemover);
    }
}
