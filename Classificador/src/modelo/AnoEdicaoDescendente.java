package modelo;

import java.util.Comparator;

public class AnoEdicaoDescendente implements Comparator<Livro> {
		 
	    public int compare(Livro l1, Livro l2) {
	        return l2.getAnoEdicao() - l1.getAnoEdicao();
	    }

}
