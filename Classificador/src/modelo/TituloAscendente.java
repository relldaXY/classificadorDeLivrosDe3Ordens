package modelo;

import java.util.Comparator;

public class TituloAscendente implements Comparator<Livro> {
	 
    @Override
    public int compare(Livro l1, Livro l2) {
        return l1.getTitulo().compareTo(l2.getTitulo());
    }
    
    
	
}
