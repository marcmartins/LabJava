class Aluno extends Pessoa {

	private double nota;

	public void setNota(double nota)
	{
		this.nota = nota;
	}

	public double getNota()
	{
		return nota;
	}

	public static void main(String [] args)
	{

		Aluno p = new Aluno();

		p.setNome("Marcos");
		p.setIdade(30);
		p.setNota(7.5);

		System.out.println("aluno: " + p.getNome()
			+ ", idade : " + p.getIdade()
			+ ", nota : " + p.getNota());
	}
}
