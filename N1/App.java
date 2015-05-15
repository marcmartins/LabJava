import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {

	private static List<Cliente> listaDeClientes;

	public static void cadastrar() {
		Cliente cliente = new Cliente();
		Scanner scanner = new Scanner(System.in);

		System.out.print("nome: ");
		cliente.setNome(scanner.nextLine());

		System.out.print("genero: ");
		cliente.setGenero(scanner.nextLine().charAt(0));

		System.out.print("casado: ");
		cliente.setEstaCasado(scanner.nextBoolean());

		listaDeClientes.add(cliente);
	}

	public static void listar() {
		Cliente cliente;
		for (int i = 0; i < listaDeClientes.size(); i++) {
			cliente = listaDeClientes.get(i);
			System.out.println(
				"nome: " + cliente.getNome() +
				" genero: " + cliente.getGenero() +
				" casado: " + cliente.getEstaCasado()
			);
		}
	}

	public static void gravarRegistroEmArquivo() throws IOException {
		File file = new File("./registro.txt");
		FileWriter writer = new FileWriter(file);

		Cliente cliente;
		for (int i = 0; i < listaDeClientes.size(); i++) {
			cliente = listaDeClientes.get(i);
			writer.write(
				"nome: " + cliente.getNome() +
				" genero: " + cliente.getGenero() +
				" casado: " + cliente.getEstaCasado()
			);
		}
		writer.close();
				
	}

	public static void main(String [] args) throws IOException {
		listaDeClientes = new ArrayList<Cliente>();
		Scanner scanner = new Scanner(System.in);

		int opt;
		do {
			System.out.print(
				"\n\n*** Menu do sistema ***\n\n" +
				"0) Cadastrar um usuario.\n" +
				"1) Listar registro de usuarios.\n" +
				"2) Salvar registro de usuarios.\n" +
				"3) Sair." +
				"\n>"
			);

			opt = scanner.nextInt();

			switch(opt) {
			case 0: cadastrar(); 
				break;
			case 1: listar(); 
				break;
			case 2: gravarRegistroEmArquivo(); 
				break;
			case 3: break;
			default: System.out.println("*** Opcao invalida ***");
				break;
			}
		} while (opt != 3);
			
	}
}
