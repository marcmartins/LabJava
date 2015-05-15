import java.util.Scanner;

class App {

  public static void main(String [] args)
  {
    String nome;
    int idade;
    
    Scanner s = new Scanner(System.in);
 
    System.out.print("Digite o nome:");
    nome = s.nextLine();
    
    System.out.print("Entre com a idade:");
    idade = s.nextInt();
    
    Aluno aluno = new Aluno();
    
    aluno.setNome(nome);
    aluno.setIdade(idade);
    
    System.out.println("Nome:" + aluno.getNome() + 
      ", Idade:" + aluno.getIdade());
  }
}
