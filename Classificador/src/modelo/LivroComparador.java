package modelo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LivroComparador implements Comparator<Livro> {
	 
    private List<Comparator<Livro>> listaDeComparadoresDeLivro;
 
    @SafeVarargs
    public LivroComparador(Comparator<Livro>... comparators) {
        this.listaDeComparadoresDeLivro = Arrays.asList(comparators);
    }
 
	@Override
    public int compare(Livro l1, Livro l2) {
        for (Comparator<Livro> comparator : listaDeComparadoresDeLivro) {
            int result = comparator.compare(l1, l2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
