import java.util.NoSuchElementException;

public class TabelaHash<K, V extends Comparable<V>> {

	private Lista<K, V>[] tabelaHash; /// tabela que referenciará todas as listas lineares encadeadas.
								/// Nesse caso, estamos utilizando uma tabela hash com endereçamento em separado,
								/// ou seja, os itens são armazenados em listas lineares encadeadas.

	private int capacidade; /// tamanho da tabela hash.
	                        /// deve ser um número primo grande para diminuirmos a probabilidade de colisões.

	/// Construtor da classe.
	/// Esse método é responsável por inicializar a tabela hash que trabalha com endereçamento em separado.
	/// Assim, esse método atribui, ao atributo capacidade, dessa classe, o valor passado por meio do parâmetro capacidade.
	/// Esse método também cria um vetor, de tamanho capacidade, de listas lineares; e o atribui ao atributo tabelaHash.
	/// Adicionalmente, cada posição do vetor é inicializada com uma lista encadeada vazia.
	/// Parâmetro "capacidade": tamanho da tabela hash. 
	@SuppressWarnings("unchecked")
	public TabelaHash(int capacidade) {
		
		this.capacidade = capacidade;
		this.tabelaHash = (Lista<K, V>[]) new Lista[this.capacidade]; 
		
		for (int i = 0; i < this.capacidade; i++)
			this.tabelaHash[i] = new Lista<>();
	}
	
	/// Esse método implementa a função de transformação da tabela hash, 
	/// ou seja, calcula a posição, na tabela hash, em que o item,
	/// que possui a chave informada por meio do parâmetro chave, deve ser encontrado.
	/// A função de transformação utilizada corresponde ao resto da divisão do hashCode de chave pelo tamanho da tabela hash.
	/// Parâmetro "chave": chave da qual desejamos saber a posição na tabela hash.
	/// Retorna a posição que o item, cuja chave corresponde a que foi passada como parâmetro para esse método, 
	/// deve ocupar na tabela hash.
	private int funcaoHash(K chave) {
		return Math.abs(chave.hashCode() % this.capacidade);
	}
	
	/// Método responsável por inserir um novo item na tabela hash.
	/// Não é permitido inserir, nessa tabela hash, mais de um item com uma mesma chave.
	/// Parâmetro "chave": chave do item que deve ser inserido na tabela hash.
	/// Parâmetro "item": referência ao item que deve ser inserido na tabela hash.
	/// Retorna a posição na tabela hash em que o novo item foi inserido.
	public int inserir(K chave, V item) {
		
		/// cálculo da posição da tabela hash em que o novo item deverá ser armazenado.
		int posicao = funcaoHash(chave);
		
		/// pesquisa o item, passado como parâmetro para esse método, na lista encadeada 
		/// associada à posição, da tabela hash, em que esse novo item deverá ser adicionado.
		/// Se o item não for localizado, 
		/// ele é inserido no início da lista encadeada 
		/// associada à posição, da tabela hash, em que esse novo item será localizado. 
		try {
			this.tabelaHash[posicao].pesquisar(chave);
			throw new IllegalArgumentException("O item já havia sido inserido anteriormente na tabela hash!");
		} catch (NoSuchElementException excecao) {
			this.tabelaHash[posicao].inserirFinal(chave, item);
			return posicao;
		}
	}
	
	/// Método responsável por localizar, na tabela hash, o item
	/// cuja chave corresponde à que foi passada como parâmetro para esse método.
	/// Parâmetro "chave": chave do item que deve ser localizado na tabela hash.
	/// Retorna uma referência ao item encontrado.
	/// O método lança uma exceção caso o item não tenha sido localizado na tabela hash.
	public V pesquisar(K chave) {
		
		/// cálculo da posição da tabela hash em que o item deve estar armazenado.
		int posicao = funcaoHash(chave);
				
		/// pesquisa o item, cuja chave foi passada como parâmetro para esse método,
		/// na lista encadeada associada à posição, da tabela hash, em que esse item deve estar armazenado.
		return this.tabelaHash[posicao].pesquisar(chave);
	}
	
	/// Método responsável por remover, da tabela hash, o item
	/// cuja chave corresponde à que foi passada como parâmetro para esse método.
	/// Parâmetro "chave": chave do item que deve ser removido da tabela hash.
	/// Retorna uma referência ao item removido.
	/// O método lança uma exceção caso o item não tenha sido localizado na tabela hash.
	public V remover(K chave) {
		
		/// cálculo da posição da tabela hash em que o item deve estar armazenado.
		int posicao = funcaoHash(chave);
		
		/// remove o item, cuja chave foi passada como parâmetro para esse método,
		/// da lista encadeada associada à posição, da tabela hash, em que esse item deve estar armazenado.	
		return this.tabelaHash[posicao].remover(chave);
	}
	
	/// Método responsável por imprimir todo o conteúdo da tabela hash.
	/// É impresso o índice da tabela hash e seu correspondente conteúdo.
	/// Se a posição da tabela hash estiver vazia, é impressa uma mensagem explicativa.
	/// Caso contrário, para todos os itens, armazenados na lista encadeada 
	/// associada a uma posição da tabela hash, são impressos seus dados.
	public void imprimir(){
	
		for (int i = 0; i < this.capacidade; i++) {
			System.out.println("Posição[" + i + "]: ");
			if (this.tabelaHash[i].vazia())
				System.out.println("vazia");
			else
				this.tabelaHash[i].imprimir();
		}
	}
}
