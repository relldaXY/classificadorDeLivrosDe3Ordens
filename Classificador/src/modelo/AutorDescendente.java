package modelo;

import java.util.Comparator;

public class AutorDescendente implements Comparator<Livro> {
	 
    @Override
    public int compare(Livro l1, Livro l2) {
        return l2.getAutor().compareTo(l1.getAutor());
    }
}
