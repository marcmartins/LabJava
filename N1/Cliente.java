public class Cliente {
	private String nome;
	private char genero;
	private boolean casado;

	public void setNome(String nome) { this.nome = nome; }
	public void setGenero(char genero) { this.genero = genero; }
	public void setEstaCasado(boolean casado) { this.casado = casado; }
	
	public String getNome() { return nome; }
	public char getGenero() { return genero; }
	public boolean getEstaCasado() { return casado; }
}
