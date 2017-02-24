package modelo;

import java.util.Comparator;

public class AutorAscendente implements Comparator<Livro> {
	 
    @Override
    public int compare(Livro l1, Livro l2) {
        return l1.getAutor().compareTo(l2.getAutor());
    }
}
