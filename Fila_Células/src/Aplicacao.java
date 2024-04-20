import java.time.LocalDateTime;

public class Aplicacao {

	public static void main(String[] args) throws InterruptedException {
		
		Cliente cli;
        Fila<Cliente> filaLanchonete;

        filaLanchonete = new Fila<Cliente>();
        cli = new Cliente("John", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(10);
        cli = new Cliente("Charles", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(10);
        cli = new Cliente("Mary", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);

        cli = filaLanchonete.desenfileirar();
        System.out.println("O cliente " + cli.getNome() + " foi atendido."); // John
	}
}
