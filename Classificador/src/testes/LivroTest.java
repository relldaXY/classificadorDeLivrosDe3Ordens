package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Livro;

public class LivroTest {

	@Test
	public void gettituloTerceiroLivro() {
		Livro l1 = new Livro(1,"Java How To Program", "Deitel & Deitel", 2007);
		Livro l2 = new Livro(2,"Patterns Of Enterprise Application Architecture","Martin Fowler", 2002);
		Livro l3 = new Livro(3,"Head First Design Patterns", "Elisabeth Freeman", 2004);
		Livro l4 = new Livro(4,"Internet & World Wibe Web: How To Program","Deitel & Deitel", 2007 );
		
		String titulo = l3.getTitulo();
		
		assertEquals("Head First Design Patterns", titulo);
	}
	
	@Test
	public void getAutorSegundoLivro() {
		Livro l1 = new Livro(1,"Java How To Program", "Deitel & Deitel", 2007);
		Livro l2 = new Livro(2,"Patterns Of Enterprise Application Architecture","Martin Fowler", 2002);
		Livro l3 = new Livro(3,"Head First Design Patterns", "Elisabeth Freeman", 2004);
		Livro l4 = new Livro(4,"Internet & World Wibe Web: How To Program","Deitel & Deitel", 2007 );
		
		String autor = l2.getAutor();
		
		assertEquals("Martin Fowler", autor);
	}
	
	@Test
	public void getAnoEdicaoQuartoLivro() {
		Livro l1 = new Livro(1,"Java How To Program", "Deitel & Deitel", 2007);
		Livro l2 = new Livro(2,"Patterns Of Enterprise Application Architecture","Martin Fowler", 2002);
		Livro l3 = new Livro(3,"Head First Design Patterns", "Elisabeth Freeman", 2004);
		Livro l4 = new Livro(4,"Internet & World Wibe Web: How To Program","Deitel & Deitel", 2007 );
		
		int ano = l4.getAnoEdicao();
		
		assertEquals(2007, ano);
	}

}
