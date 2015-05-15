import java.util.Scanner;

class Ler {
	public static void main(String [] args) {
		String nome;
		int idade;

		Scanner ler = new Scanner (System.in);

		System.out.print("Entre com o nome: ");
		
		nome = ler.nextLine();
		
		System.out.print("Entre com a idade: ");
		
		idade = ler.nextInt();
		
		System.out.println("Nome:" + nome + ", idade :" + idade);
	}
}
