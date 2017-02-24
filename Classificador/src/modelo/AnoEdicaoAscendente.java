package modelo;

import java.util.Comparator;

public class AnoEdicaoAscendente implements Comparator<Livro> {
		 
	    public int compare(Livro l1, Livro l2) {
	        return l1.getAnoEdicao() - l2.getAnoEdicao();
	    }

}

