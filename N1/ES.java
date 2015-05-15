import java.util.Scanner;

public class ES {

	public static void main(String [] args) {
		String nome;
		int idade;

		Scanner scanner = new Scanner(System.in);

		nome = scanner.nextLine();
		idade = scanner.nextInt();

		System.out.println("Nome: " + nome + ", idade: " + idade);
	}
}
