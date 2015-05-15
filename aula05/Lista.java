import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Lista {

  public static void main(String [] args) {
    List<Aluno> lista = new ArrayList<Aluno>();
    
    String nome, opt;
    int idade;
    
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      System.out.print("\n\nEntre com o nome: ");
      nome = scanner.nextLine();
    
      System.out.print("Entre com a idade :");
      idade = scanner.nextInt();
    
      Aluno naluno = new Aluno();
   
      naluno.setNome(nome);
      naluno.setIdade(idade);
    
      lista.add(naluno);

      scanner.nextLine();
    }
    
    Aluno aluno;
    for (int i = 0; i < lista.size(); i++) {
      aluno = lista.get(i);
      
      System.out.println(
        i +
        ") nome: " + aluno.getNome() +
        " idade: " + aluno.getIdade() 
      );
    }
  }
}
