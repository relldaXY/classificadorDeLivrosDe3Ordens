package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Excecoes.SortingServiceException;

public class ClassificadorDeLivros<T> {
	
	private List<Livro> livrosArmazenadosNoServicoDeSelecao;//livros armazenados no servico de classificacao
	private List<Livro> listaDeLivros;                      //livros para serem classificados
	private int idclass;
		
	
	
	public ClassificadorDeLivros(){
		livrosArmazenadosNoServicoDeSelecao = new ArrayList<Livro>();
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(1,"Java How To Program", "Deitel & Deitel", 2007));
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(2,"Patterns Of Enterprise Application Architecture","Martin Fowler", 2002));
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(3,"Head First Design Patterns", "Elisabeth Freeman", 2004));
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(4,"Internet & World Wibe Web: How To Program","Deitel & Deitel", 2007));
        idclass = 5;
		
		listaDeLivros = new ArrayList<Livro>();
	}

	public List<Livro> getLivrosArmazenadosNoServicoDeSelecao() {
		return livrosArmazenadosNoServicoDeSelecao;
	}
	
	public List<Livro> getListaDeLivrosClassificados(){
		return listaDeLivros;
	}
	
	public void atualizarLivrosParaClassificar(){
		listaDeLivros = new ArrayList<Livro>(livrosArmazenadosNoServicoDeSelecao);
	}
	
	public void apagarListaDeLivrosArmazenados(){
		livrosArmazenadosNoServicoDeSelecao = new ArrayList<Livro>();
		idclass = 1;
	}
	
	public void reiniciarListaComLivrosPreSelecionados(){
		livrosArmazenadosNoServicoDeSelecao = new ArrayList<Livro>();
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(1,"Java How To Program", "Deitel & Deitel", 2007));
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(2,"Patterns Of Enterprise Application Architecture","Martin Fowler", 2002));
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(3,"Head First Design Patterns", "Elisabeth Freeman", 2004));
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(4,"Internet & World Wibe Web: How To Program","Deitel & Deitel", 2007));
        idclass = 5;
	}
		
	public void adicionaLivro(String titulo, String autor, int ano){
		livrosArmazenadosNoServicoDeSelecao.add(new Livro(this.idclass, titulo, autor, ano));
		this.idclass++;
		JOptionPane.showMessageDialog(null, "Livro Adicionado com sucesso", "Adicao de Livro", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public DefaultTableModel mostrarOsLivrosArmazenadosNoServicoDeSelecao(){
		String colunas [] = {"Id", "Titulo","Autor","Ano"};
		DefaultTableModel modeloArmazenar = new DefaultTableModel(null, colunas);
		String dados [] = new String[4];
		
		int iteracoes = this.livrosArmazenadosNoServicoDeSelecao.size();
		
		
		for(int i = 0; i<iteracoes; i++){
			dados[0]= String.valueOf(livrosArmazenadosNoServicoDeSelecao.get(i).getId());
			dados[1]= livrosArmazenadosNoServicoDeSelecao.get(i).getTitulo();
			dados[2]= livrosArmazenadosNoServicoDeSelecao.get(i).getAutor();
			dados[3]= String.valueOf(livrosArmazenadosNoServicoDeSelecao.get(i).getAnoEdicao());
					
			modeloArmazenar.addRow(dados);
		}
		
		return modeloArmazenar;
	}
	
	public DefaultTableModel mostrarOsLivrosClassificados(){
		String colunas [] = {"Id", "Titulo","Autor","Ano"};
		DefaultTableModel modeloCadastro = new DefaultTableModel(null, colunas);
		String dados [] = new String[4];
		
		
		int iteracoes = this.listaDeLivros.size();
				
		for(int i = 0; i<iteracoes; i++){
			dados[0]= String.valueOf(listaDeLivros.get(i).getId());
			dados[1]= listaDeLivros.get(i).getTitulo();
			dados[2]= listaDeLivros.get(i).getAutor();
			dados[3]= String.valueOf(listaDeLivros.get(i).getAnoEdicao());
					
			modeloCadastro.addRow(dados);
		}
		
		return modeloCadastro;
	}
			
	public void classificarLivros(int s1, int s2, int s3) throws SortingServiceException{
	
	int codigoDeSelecao = buscarCodigoDeSelecao(s1,s2,s3);
	
	if(codigoDeSelecao > 99){
		if(codigoDeSelecao >= 100 && codigoDeSelecao < 200){
			if(codigoDeSelecao >= 100 && codigoDeSelecao<110){
				if(codigoDeSelecao == 100 || codigoDeSelecao == 101){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 102){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 103){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 104){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 105){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 106){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=110 && codigoDeSelecao<120){
				if(codigoDeSelecao == 110 || codigoDeSelecao == 111){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 112){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 113){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 114){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 115){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 116){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=120 && codigoDeSelecao<130){
				if(codigoDeSelecao == 120 || codigoDeSelecao == 122){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 121){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 123){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 124){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 125){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 126){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=130 && codigoDeSelecao<140){
				if(codigoDeSelecao == 130 || codigoDeSelecao == 133){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 131){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 132){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 134){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 135){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 136){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=140 && codigoDeSelecao<150){
				if(codigoDeSelecao == 140 || codigoDeSelecao == 144){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 141){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 142){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 143){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 145){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 146){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=150 && codigoDeSelecao<160){
				if(codigoDeSelecao == 150 || codigoDeSelecao == 155){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 151){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 152){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 153){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 154){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 156){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >= 160 && codigoDeSelecao<170){
				if(codigoDeSelecao == 160 || codigoDeSelecao == 166){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 161){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 162){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 163){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 164){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 165){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
		}
		else if(codigoDeSelecao >=200 && codigoDeSelecao <300){
			if(codigoDeSelecao >= 200 && codigoDeSelecao<210){
				if(codigoDeSelecao == 200 || codigoDeSelecao == 202){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 201){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 203){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 204){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 205){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 206){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=210 && codigoDeSelecao<220){
				if(codigoDeSelecao == 210 || codigoDeSelecao == 211){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 212){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 213){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 214){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 215){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 216){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=220 && codigoDeSelecao<230){
				if(codigoDeSelecao == 220 || codigoDeSelecao == 222){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 221){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 223){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 224){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 225){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 226){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=230 && codigoDeSelecao<240){
				if(codigoDeSelecao == 230 || codigoDeSelecao == 233){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 231){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 232){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 234){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 235){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 236){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=240 && codigoDeSelecao<250){
				if(codigoDeSelecao == 240 || codigoDeSelecao == 244){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 241){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 242){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 243){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 245){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 246){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=250 && codigoDeSelecao<260){
				if(codigoDeSelecao == 250 || codigoDeSelecao == 255){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 251){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 252){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 253){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 254){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 256){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >= 260 && codigoDeSelecao<270){
				if(codigoDeSelecao == 260 || codigoDeSelecao == 266){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 261){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 262){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 263){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 264){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 265){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
		}
		else if(codigoDeSelecao >=300 && codigoDeSelecao <400){
			if(codigoDeSelecao >= 300 && codigoDeSelecao<310){
				if(codigoDeSelecao == 300 || codigoDeSelecao == 303){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 301){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 302){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 304){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 305){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 306){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=310 && codigoDeSelecao<320){
				if(codigoDeSelecao == 310 || codigoDeSelecao == 311){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 312){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 313){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 314){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 315){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 316){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=320 && codigoDeSelecao<330){
				if(codigoDeSelecao == 320 || codigoDeSelecao == 323){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 321){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 322){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 324){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 325){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 326){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=330 && codigoDeSelecao<340){
				if(codigoDeSelecao == 330 || codigoDeSelecao == 333){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 331){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 332){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 334){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 335){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 336){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=340 && codigoDeSelecao<350){
				if(codigoDeSelecao == 340 || codigoDeSelecao == 344){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 341){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 342){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 343){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 345){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 346){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=350 && codigoDeSelecao<360){
				if(codigoDeSelecao == 350 || codigoDeSelecao == 355){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 351){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 352){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 353){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 354){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 356){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >= 360 && codigoDeSelecao<370){
				if(codigoDeSelecao == 360 || codigoDeSelecao == 366){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 361){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 362){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 363){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 364){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 365){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
			
		}
		else if(codigoDeSelecao >=400 && codigoDeSelecao <500){
			if(codigoDeSelecao >= 400 && codigoDeSelecao<410){
				if(codigoDeSelecao == 400 || codigoDeSelecao == 404){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 401){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 402){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 403){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 405){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 406){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=410 && codigoDeSelecao<420){
				if(codigoDeSelecao == 410 || codigoDeSelecao == 411){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 412){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 413){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 414){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 415){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 416){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=420 && codigoDeSelecao<430){
				if(codigoDeSelecao == 420 || codigoDeSelecao == 422){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 421){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 422){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 424){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 425){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 426){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=430 && codigoDeSelecao<440){
				if(codigoDeSelecao == 430 || codigoDeSelecao == 433){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 431){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 432){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 434){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 435){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 436){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=440 && codigoDeSelecao<450){
				if(codigoDeSelecao == 440 || codigoDeSelecao == 444){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 441){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 442){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 443){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 445){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 446){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=450 && codigoDeSelecao<460){
				if(codigoDeSelecao == 450 || codigoDeSelecao == 455){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 451){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 452){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 453){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 454){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 456){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >= 460 && codigoDeSelecao<470){
				if(codigoDeSelecao == 460 || codigoDeSelecao == 466){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 461){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 462){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 463){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 464){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 465){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
		}
		else if(codigoDeSelecao >=500 && codigoDeSelecao <600){
			if(codigoDeSelecao >= 500 && codigoDeSelecao<510){
				if(codigoDeSelecao == 500 || codigoDeSelecao == 505){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 501){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 502){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 503){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 504){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 506){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=510 && codigoDeSelecao<520){
				if(codigoDeSelecao == 510 || codigoDeSelecao == 511){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 512){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 513){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 514){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 515){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 516){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=520 && codigoDeSelecao<530){
				if(codigoDeSelecao == 520 || codigoDeSelecao == 522){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 521){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 523){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 524){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 525){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 526){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=530 && codigoDeSelecao<540){
				if(codigoDeSelecao == 530 || codigoDeSelecao == 533){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 531){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 532){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 534){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 535){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 536){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=540 && codigoDeSelecao<550){
				if(codigoDeSelecao == 540 || codigoDeSelecao == 545){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 541){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 542){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 543){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 544){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 546){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=550 && codigoDeSelecao<560){
				if(codigoDeSelecao == 550 || codigoDeSelecao == 555){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 551){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 552){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 553){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 554){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 556){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >= 560 && codigoDeSelecao<570){
				if(codigoDeSelecao == 560 || codigoDeSelecao == 566){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 561){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 562){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 563){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 564){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 565){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
		}
		else if(codigoDeSelecao >=600 && codigoDeSelecao <700){
			if(codigoDeSelecao >= 600 && codigoDeSelecao<610){
				if(codigoDeSelecao == 600 || codigoDeSelecao == 606){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 601){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 602){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 603){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 604){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 605){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
			else if(codigoDeSelecao >=610 && codigoDeSelecao<620){
				if(codigoDeSelecao == 610 || codigoDeSelecao == 611){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 612){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 613){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 614){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 615){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 616){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=620 && codigoDeSelecao<630){
				if(codigoDeSelecao == 620 || codigoDeSelecao == 622){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 621){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 623){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 624){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 625){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 626){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=630 && codigoDeSelecao<640){
				if(codigoDeSelecao == 630 || codigoDeSelecao == 633){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 631){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 632){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 634){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 635){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 636){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=640 && codigoDeSelecao<650){
				if(codigoDeSelecao == 640 || codigoDeSelecao == 644){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 641){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 642){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 643){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 645){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 646){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >=650 && codigoDeSelecao<660){
				if(codigoDeSelecao == 650 || codigoDeSelecao == 655){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
				else if(codigoDeSelecao == 651){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 652){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 653){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 654){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 656){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
				}
			}
			else if(codigoDeSelecao >= 660 && codigoDeSelecao<670){
				if(codigoDeSelecao == 660 || codigoDeSelecao == 666){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente()));
				}
				else if(codigoDeSelecao == 561){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
				}
				else if(codigoDeSelecao == 562){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
				}
				else if(codigoDeSelecao == 563){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
				}
				else if(codigoDeSelecao == 564){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
				}
				else if(codigoDeSelecao == 565){
					Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
				}
			}
		}
	}
	else if(codigoDeSelecao > 9 && codigoDeSelecao <99){
		if(codigoDeSelecao<20){
			if(codigoDeSelecao == 10 || codigoDeSelecao == 11){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == 12){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 13){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorAscendente()));
			}
			else if(codigoDeSelecao == 14){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 15){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoAscendente()));
			}
			else if(codigoDeSelecao == 16){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente(),criaObjetoAnoEdicaoDescendente()));
			}
		}
		else if(codigoDeSelecao>=20 && codigoDeSelecao<30){
			if(codigoDeSelecao == 20 || codigoDeSelecao == 22){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 21){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == 23){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorAscendente()));
				
			}
			else if(codigoDeSelecao == 24){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 25){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoAscendente()));
			}
			else if(codigoDeSelecao == 26){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente(),criaObjetoAnoEdicaoDescendente()));
			}
		}
		else if(codigoDeSelecao>=30 && codigoDeSelecao<40){
			if(codigoDeSelecao == 30 || codigoDeSelecao == 33){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente()));
			}
			else if(codigoDeSelecao == 31){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == 32){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 34){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 35){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoAscendente()));
			}
			else if(codigoDeSelecao == 36){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente(),criaObjetoAnoEdicaoDescendente()));
			}
		}
		else if(codigoDeSelecao>=40 && codigoDeSelecao<50){
			if(codigoDeSelecao == 40 || codigoDeSelecao == 44){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 41){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == 42){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 43){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAutorAscendente()));
			}
			else if(codigoDeSelecao == 45){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoAscendente()));
			}
			else if(codigoDeSelecao == 46){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente(),criaObjetoAnoEdicaoDescendente()));
			}
		}
		else if(codigoDeSelecao>=50 && codigoDeSelecao<60){
			if(codigoDeSelecao == 50 || codigoDeSelecao == 55){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente()));
			}
			else if(codigoDeSelecao == 51){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == 52){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 53){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorAscendente()));
			}
			else if(codigoDeSelecao == 54){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 56){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente(),criaObjetoAnoEdicaoDescendente()));
			}
		}
		else{
			if(codigoDeSelecao == 60 || codigoDeSelecao == 66){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),null));
			}
			else if(codigoDeSelecao == 61){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == 62){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 63){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorAscendente()));
			}
			else if(codigoDeSelecao == 64){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 65){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente(),criaObjetoAnoEdicaoAscendente()));
			}
			
		}
	}
	else if(codigoDeSelecao < 9){
		if(codigoDeSelecao >=4){
			if(codigoDeSelecao == 4){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorDescendente()));
			}
			else if(codigoDeSelecao == 5){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoAscendente()));
			}
			else{
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAnoEdicaoDescendente()));
			}
			}
		else{
			if(codigoDeSelecao == 3){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoAutorAscendente()));
			}
			else if(codigoDeSelecao == 2){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloDescendente()));
			}
			else if(codigoDeSelecao == 1){
				Collections.sort( listaDeLivros, new LivroComparador(criaObjetoTituloAscendente()));
			}
			else if(codigoDeSelecao == -1){//para entrada null
				Collections.sort(listaDeLivros, null);
				throw new SortingServiceException("Entrada null");
			}
			else if(codigoDeSelecao == -2){//para entrada empty
				Collections.sort(listaDeLivros, new LivroComparador());
				throw new SortingServiceException("Entrada Empty");
			}	
			}
	}
	
	
	
	}
	
	private int buscarCodigoDeSelecao(int s1, int s2, int s3){

		int codigoS1 = s1*100;
		int codigoS2 = s2*10;
		int codigoS3 = s3;
		int codigoDeSelecao = codigoS1 + codigoS2 + codigoS3;
		
		return codigoDeSelecao;
	}
	
	
	private TituloAscendente criaObjetoTituloAscendente(){
		return new TituloAscendente();
	}
	
	private TituloDescendente criaObjetoTituloDescendente(){
		return new TituloDescendente();
	}
	
	private AutorAscendente criaObjetoAutorAscendente(){
		return new AutorAscendente();
	}
	
	private AutorDescendente criaObjetoAutorDescendente(){
		return new AutorDescendente();
	}
	
	private AnoEdicaoAscendente criaObjetoAnoEdicaoAscendente(){
		return new AnoEdicaoAscendente();
	}
	
	private AnoEdicaoDescendente criaObjetoAnoEdicaoDescendente(){
		return new AnoEdicaoDescendente();
	}
	
}
	
	

