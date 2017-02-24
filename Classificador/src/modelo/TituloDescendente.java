package modelo;

import java.util.Comparator;

public class TituloDescendente implements Comparator<Livro> {
	 
    @Override
    public int compare(Livro l1, Livro l2) {
        return l2.getTitulo().compareTo(l1.getTitulo());
    }

}
