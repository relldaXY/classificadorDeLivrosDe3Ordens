package modelo;

public class Livro {
	
	
	private String titulo;
	private String autor;
	private int anoEdicao;
	private int id;
	
	public Livro(int id, String titulo, String autor, int anoEdicao) {
	   this.titulo = titulo;
	   this.autor = autor;
	   this.anoEdicao = anoEdicao;
	   this.id = id;
	}
	 
	public int getId(){
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(int anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public String toString() {
	        return String.format("%d\t%s\t%s\t%d\n",id, titulo, autor, anoEdicao);
	}
	

}
