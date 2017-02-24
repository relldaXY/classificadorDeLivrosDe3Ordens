package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AutorAscendente;
import modelo.AutorDescendente;
import modelo.Livro;

public class AutorDescendenteTest {

	@Test
	public void testeCompareToOrdenamentoDescendenteAutor() {
		AutorDescendente a  = new AutorDescendente();
		
		Livro l1 = new Livro(1,"Java How To Program", "Deitel & Deitel", 2007);
		Livro l2 = new Livro(2,"Patterns Of Enterprise Application Architecture","Martin Fowler", 2002);
		Livro l3 = new Livro(3,"Head First Design Patterns", "Elisabeth Freeman", 2004);
		Livro l4 = new Livro(4,"Internet & World Wibe Web: How To Program","Deitel & Deitel", 2007 );
		
		int autor = a.compare(l1, l3);
		
		assertEquals(1, autor);
	}

}
