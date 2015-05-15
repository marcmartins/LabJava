import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;

class App {

	private static List<Aluno> lista_;
	private static String N_REGISTRO = "./alunos.txt";

	public static void adicionar() {
		Aluno aluno = new Aluno();
		Scanner scanner = new Scanner(System.in);

		System.out.print("\n\n*** Adicionar um novo aluno ***\n\n");

		System.out.print("Nome do aluno..: ");
		aluno.setNome(scanner.nextLine());

		System.out.print("Idade do aluno.: ");
		aluno.setIdade(scanner.nextInt());

		System.out.print("\n\n*** Aluno adicionado ***\n\n");

		lista_.add(aluno);
	}

	public static void listar() {
	
		System.out.print("\n\n*** Lista de alunos cadastrados ***\n\n");

		Aluno aluno;

		for (int i = 0; i < lista_.size(); i++) {
			aluno = lista_.get(i);

			System.out.println(
				i +
				") Nome : " + aluno.getNome() +
				" Idade : " + aluno.getIdade()
				);
		}

		System.out.print("\n\n*** Fim da listagem ***\n\n");
	}

	public static void salvar() throws IOException {

		System.out.print("\n\n*** Salvando registro de alunos em " + N_REGISTRO + " ***\n\n");

		File file = new File(N_REGISTRO);
		FileWriter writer = new FileWriter(file);

		Aluno aluno;

		for (int i = 0; i < lista_.size(); i++) {
			aluno = lista_.get(i);
	
			writer.write(
				i + 
				") Nome : " + aluno.getNome() +
				" Idade : " + aluno.getIdade() 
				);
		}
		
		writer.close();
		
		System.out.print("\n\n*** " + lista_.size() + " Registro(s) de aluno(s) salvo ***\n\n");
	}

	public static void carregar() {


		try {
			FileReader reader = new FileReader(N_REGISTRO);

			BufferedReader buffer = new BufferedReader(reader);

			String linha = buffer.readLine();

			while (linha != null) {
				System.out.println(linha);
			
				linha = buffer.readLine();
			}
		
			reader.close();
		} catch (IOException e) {
			System.err.printf("Erro: %s\n", e.getMessage());
		}
	}

	public static void main(String [] args) throws IOException {

		int opt;

		lista_ = new ArrayList<Aluno>();

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print(
				"\n\n" +
				"Menu do sistema\n" +
				"***************\n\n" +
				"0) Adicionar um novo usuario.\n" +
				"1) Listar registro de usuarios.\n" +
				"2) Salvar registro de usuarios.\n" +
				"3) Ler registro de usuarios.\n" +
				"4) Sair do sistema.\n\n" +
				">"
				);

			opt = scanner.nextInt();

			switch (opt) {
			case 0:
				adicionar();
				break;

			case 1:
				listar();
				break;
			case 2:
				salvar();
				break;
			case 3:
				carregar();
				break;
			case 4: break;
			default:
				System.err.print("\n\nErro: opcao invalida\n\n");
				break;
			}

		} while (opt != 4);	
			
	}

}
