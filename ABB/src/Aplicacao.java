public class Aplicacao {

	public static void main(String[] args) {

		ABB<Aluno> turma = new ABB<>();
		Aluno alunoNovo, alunoRetirar, alunoProcurado;
		
        if (turma.vazia())
            System.out.println("A turma está vazia."); /// Essa mensagem deve ser exibida.
        else
            System.out.println("A turma possui alunos matriculados.");

        try {
        	alunoNovo = new Aluno (5, "Amanda", 85.00);
        	turma.adicionar(alunoNovo);

        	alunoNovo = new Aluno(8, "Uriel", 87.00);
        	turma.adicionar(alunoNovo);

        	alunoNovo = new Aluno(6, "Ivo", 75.00);
        	turma.adicionar(alunoNovo);

        	alunoNovo = new Aluno(3, "Olivia", 90.00);
        	turma.adicionar(alunoNovo);

        	alunoNovo = new Aluno(9, "Evandro", 85.00);
        	turma.adicionar(alunoNovo);

        	alunoNovo = new Aluno(4, "Sônia", 82.00);
        	turma.adicionar(alunoNovo);

        	alunoNovo = new Aluno(6, "Ivo", 75.00);
        	turma.adicionar(alunoNovo); 
        	
        } catch (Exception excecao) {
        	System.out.println(excecao.getMessage());
        	/// Deve ser exibida a mensagem: "O item já foi inserido anteriormente na árvore."
        }

        turma.caminhamentoEmOrdem(); // Amanda - Evandro - Ivo - Olívia - Sônia - Uriel
        
        alunoProcurado = new Aluno(0, "Amanda", 0.0);
        System.out.println(turma.pequisar(alunoProcurado));
        
        alunoProcurado = new Aluno(0, "Evandro", 0.0);
        System.out.println(turma.pequisar(alunoProcurado));
        
        try {
        	alunoRetirar = new Aluno(0, "Benício", 0.0);
        	turma.remover(alunoRetirar); 
        } catch (Exception excecao) {
        	System.out.println(excecao.getMessage()); /// Deve ser exibida a mensagem: "O item a ser removido não foi localizado na árvore!"

        }
        
        alunoRetirar = new Aluno(0, "Amanda", 0.0);
        turma.remover(alunoRetirar);
        
        alunoRetirar = new Aluno(0, "Olivia", 0.0);
        turma.remover(alunoRetirar);
        
        turma.caminhamentoEmOrdem(); // Evandro - Ivo - Sônia - Uriel
        
        alunoRetirar = new Aluno(0, "Sônia", 0.0);
        turma.remover(alunoRetirar);
        
        alunoRetirar = new Aluno(0, "Uriel", 0.0);
        turma.remover(alunoRetirar);
        
        turma.caminhamentoEmOrdem(); // Evandro - Ivo
        
        alunoRetirar = new Aluno(0, "Ivo", 0.0);
        turma.remover(alunoRetirar);
        
        alunoRetirar = new Aluno(0, "Evandro", 0.0);
        turma.remover(alunoRetirar);
        
        try {
        	alunoRetirar = new Aluno(0, "Evandro", 0.0);
        	turma.remover(alunoRetirar); 
        } catch (Exception excecao) {
        	System.out.println(excecao.getMessage()); /// Deve ser exibida a mensagem: "O item a ser removido não foi localizado na árvore!"

        }
	}
}
