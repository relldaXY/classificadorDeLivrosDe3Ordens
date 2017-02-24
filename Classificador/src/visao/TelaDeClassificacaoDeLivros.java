package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.SortingServiceException;
import modelo.ClassificadorDeLivros;
import modelo.Livro;
import modelo.TituloAscendente;

public class TelaDeClassificacaoDeLivros extends JFrame {
	
	private JLabel jtituloGeral;
	private JLabel jtituloLivro;
	private JLabel jautorLivro;
	private JLabel janoLivro;
	private JLabel jclienteDesejar;
	private JLabel jlivrosInseridos;
	private JLabel jclienteEscolheLivro;
	private JLabel jescolhaModoDaSelecao;
	private JLabel jopcao1;
	private JLabel jopcao2;
	private JLabel jopcao3;
	private JLabel jlivrosClassificados;
	private JLabel jopcaoNull;
	private JLabel jopcaoEmpty;
	
	private JButton JbtnEntradaNull;
	private JButton JbtnEntradaEmpty;
	private JButton JbtnApagarCampos;
	private JButton JbtnEnviarAoServicoDeSelecao;
	private JButton JbtnClassificarLivros;
	private JButton JbtnApagarListaDeArmazenamento;
	private JTextField jtextTitulo;
	private JTextField jtextAutor;
	private JTextField jtextAno;
	
	private String[] titulosTabela = {"Id", "Titulo","Autor","Ano"};
	
	private String[] titulosTabelaClassificada = {"Id", "Titulo", "Autor", "Ano"};
	
	private JTable tblParaSelecao;
	private JScrollPane scrParaSelecao;
	private DefaultTableModel modeloParaSelecao;
	
	private JComboBox modoDeSelecao1;
	private String [] opcoes1 = {"Selecione","Titulo Ascendente","Titulo Descendente","Autor Ascendente","Autor Descendente","Ano Ascendente","Ano Descendente"};
	
	private JComboBox modoDeSelecao2;
	private String [] opcoes2 = {"Selecione","Titulo Ascendente","Titulo Descendente","Autor Ascendente","Autor Descendente","Ano Ascendente","Ano Descendente"};
	
	private JComboBox modoDeSelecao3;
	private String [] opcoes3 = {"Selecione","Titulo Ascendente","Titulo Descendente","Autor Ascendente","Autor Descendente","Ano Ascendente","Ano Descendente"};
	
	private JTable tblClassificada;
	private JScrollPane scrClassificada;
	private DefaultTableModel modeloClassificada;
	
	private JButton JbtnApagarListas;
	private JButton JbtnReiniciarLista;
	
	ClassificadorDeLivros classificador;
	
	public TelaDeClassificacaoDeLivros(){
		JFrame tela = new JFrame();
		classificador = new ClassificadorDeLivros();
		
		
		tela.setTitle("Tela de Classificacao De Livros");
		tela.setSize(1000, 700);
		tela.setLayout(null); 
		tela.setResizable(false);
		tela.setVisible(true);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jopcaoNull = new JLabel("Entrar com opcao null");
		jopcaoNull.setFont(new Font("Arial", Font.BOLD, 14));
		jopcaoNull.setForeground(Color.BLUE);
		jopcaoEmpty = new JLabel("Entrar com opcao empty");
		jopcaoEmpty.setFont(new Font("Arial", Font.BOLD, 14));
		jopcaoEmpty.setForeground(Color.BLUE);
		
		JbtnEntradaNull = new JButton("Entrada Null");
		JbtnEntradaEmpty = new JButton("Entrada Empty");
		JbtnApagarListas = new JButton("Apagar Lista");
		JbtnReiniciarLista = new JButton("Reiniciar lista com livros pre-selecionados");
		
		JbtnClassificarLivros = new JButton("Classificar Livros");
		JbtnApagarCampos = new JButton("Apagar campos");
		JbtnEnviarAoServicoDeSelecao = new JButton("Enviar ao servico de classificacao");
		jtextTitulo = new JTextField();
		jtextAutor = new JTextField();
		jtextAno = new JTextField();
		jtituloGeral = new JLabel("Tela de Classificacao de Livros");
		jtituloGeral.setFont(new Font("Arial", Font.BOLD, 16));
		jtituloGeral.setForeground(Color.BLACK);
		jtituloLivro = new JLabel("Titulo");
		jautorLivro = new JLabel("Autor");
		janoLivro = new JLabel("Ano");
		jclienteDesejar = new JLabel("Os livros podem ser inseridos manualmente nos campos abaixo");
		jlivrosInseridos = new JLabel("Livros recebidos pelo servico de selecao");
		jlivrosInseridos.setFont(new Font("Arial", Font.BOLD, 14));
		jlivrosInseridos.setForeground(Color.BLUE);
		jclienteEscolheLivro = new JLabel("Selecao dos livros pelo Cliente");
		jclienteEscolheLivro.setFont(new Font("Arial", Font.BOLD, 14));
		jclienteEscolheLivro.setForeground(Color.BLUE);
		jescolhaModoDaSelecao = new JLabel("Escolha do Modo de Ordenacao");
		jescolhaModoDaSelecao.setFont(new Font("Arial", Font.BOLD, 14));
		jescolhaModoDaSelecao.setForeground(Color.BLUE);
		
		jlivrosClassificados = new JLabel("Tabela de Livros Classificados");
		jlivrosClassificados.setFont(new Font("Arial", Font.BOLD, 14));
		jlivrosClassificados.setForeground(Color.BLUE);
		
		modeloParaSelecao = new DefaultTableModel(null, titulosTabela);
		tblParaSelecao = new JTable(modeloParaSelecao);
		scrParaSelecao = new JScrollPane(tblParaSelecao);
		
		jopcao1 = new JLabel("Opcao 1");
		jopcao2 = new JLabel("Opcao 2");
		jopcao3 = new JLabel("Opcao 3");
		
		modoDeSelecao1 = new JComboBox(opcoes1);
		modoDeSelecao2 = new JComboBox(opcoes2);
		modoDeSelecao3 = new JComboBox(opcoes3);
		
		modeloClassificada = new DefaultTableModel(null, titulosTabelaClassificada);
		tblClassificada = new JTable(modeloClassificada);
		scrClassificada = new JScrollPane(tblClassificada);
		
		
		//adicionando ao JFrame
		tela.add(JbtnEnviarAoServicoDeSelecao);
		tela.add(jtextTitulo);
		tela.add(jtextAutor);
		tela.add(jtextAno);
		tela.add(jtituloGeral);
		tela.add(jtituloLivro);
		tela.add(jautorLivro);
		tela.add(janoLivro);
		tela.add(jclienteDesejar);
		tela.add(JbtnApagarCampos);
		tela.add(jlivrosInseridos);
		tela.add(jclienteEscolheLivro);
		
		tela.add(scrParaSelecao);
		tela.add(jescolhaModoDaSelecao);
		
		tela.add(jopcao1);
		tela.add(jopcao2);
		tela.add(jopcao3);
		
		tela.add(modoDeSelecao1);
		tela.add(modoDeSelecao2);
		tela.add(modoDeSelecao3);
		
		tela.add(JbtnClassificarLivros);
		
		tela.add(scrClassificada);
		
		tela.add(jlivrosClassificados);
		tela.add(jopcaoNull);
		tela.add(jopcaoEmpty);
		
		tela.add(JbtnEntradaNull);
		tela.add(JbtnEntradaEmpty);
		tela.add(JbtnApagarListas);
		tela.add(JbtnReiniciarLista);
		//posicionando elementos
		jtituloGeral.setBounds(370, 10, 400, 50);
		JbtnEnviarAoServicoDeSelecao.setBounds(180, 150, 350, 30);
		JbtnApagarCampos.setBounds(580,150, 150, 30 );
		jtextTitulo.setBounds(130, 110, 250, 30);
		jtextAutor.setBounds(450, 110, 250, 30);
		jtextAno.setBounds(770, 110, 70, 30);
		jtituloLivro.setBounds(80, 110, 50, 30);
		jautorLivro.setBounds(400, 110, 40, 30);
		janoLivro.setBounds(730, 110, 30, 30);
		jclienteDesejar.setBounds(80, 70, 600, 50);
		jlivrosInseridos.setBounds(50, 180, 450, 50);
		jclienteEscolheLivro.setBounds(50, 40, 450, 50);
		
		JbtnReiniciarLista.setBounds(390, 190, 360, 30);
		JbtnApagarListas.setBounds(770, 190, 130, 30);
		scrParaSelecao.setBounds(80, 230, 820, 120);
		jescolhaModoDaSelecao.setBounds(50, 340 , 300, 50);
		
		jopcao1.setBounds(100,420, 60, 20 );
		jopcao2.setBounds(100,450, 60, 20 );
		jopcao3.setBounds(100,480, 60, 20 );
		
		modoDeSelecao1.setBounds(170,420,140,20);
		modoDeSelecao2.setBounds(170,450,140,20);
		modoDeSelecao3.setBounds(170,480,140,20);
		
		JbtnClassificarLivros.setBounds(100, 380, 210, 30);
		scrClassificada.setBounds(80, 550, 820, 120);
		
		JbtnEntradaNull.setBounds(390, 380,210, 30 );
		JbtnEntradaEmpty.setBounds(680, 380, 210, 30);
		jlivrosClassificados.setBounds(350, 510, 450, 30);
		jopcaoNull.setBounds(400, 340, 300, 50);
		jopcaoEmpty.setBounds(690, 340, 300, 50);
		
		mostrarLivrosArmazenadosNoServicoDeSelecao();
		
	
		
		JbtnApagarCampos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnApagarCamposActionPerformed(evt);
			}
		});
		
		JbtnEnviarAoServicoDeSelecao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					btnEnviarAoServicoDeClassificacaoActionPerformed(evt);
			}	
		});
		
		JbtnClassificarLivros.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnClassificarLivrosActionPerformed(evt);
			}
		});
		
		JbtnEntradaEmpty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnEntradaEmptyActionPerformed(evt);
			}
		});
		
		JbtnEntradaNull.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					btnEntradaNullActionPerformed(evt);
						
			}
		});
		
		JbtnApagarListas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					btnApagarListasActionPerformed(evt);
						
			}
		});
		
		JbtnReiniciarLista.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					btnReiniciarListaActionPerformed(evt);
						
			}
		});
		
	}
	
	private void btnReiniciarListaActionPerformed(ActionEvent evt){
		classificador.reiniciarListaComLivrosPreSelecionados();
		mostrarLivrosArmazenadosNoServicoDeSelecao();
	}
	
	private void btnApagarListasActionPerformed(ActionEvent evt){
		classificador.apagarListaDeLivrosArmazenados();
		mostrarLivrosArmazenadosNoServicoDeSelecao();
	}
	
	private void btnEntradaEmptyActionPerformed(ActionEvent evt){
		try {
			classificador.classificarLivros(0,0,-2);
		} catch (SortingServiceException e) {
			e.printStackTrace();
		} finally{
			JOptionPane.showMessageDialog(null, "Nao apresenta modificacoes na tabela de livros classificados","Empty Set", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void btnEntradaNullActionPerformed(ActionEvent evt){
		try {
			classificador.classificarLivros(0,0,-1);
		} catch (SortingServiceException sse) {
			sse.printStackTrace();
		} catch (ClassCastException cce){
			cce.printStackTrace();
		} finally{
			JOptionPane.showMessageDialog(null, "Sorting Service Exception", "Exception", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	private void btnApagarCamposActionPerformed(ActionEvent evt){
		apagarCampos();
	}
	
	private void btnEnviarAoServicoDeClassificacaoActionPerformed(ActionEvent evt){
		if(!jtextTitulo.getText().isEmpty() && !jtextAutor.getText().isEmpty()){
			enviarParaServicoDeClassificacao(this.jtextTitulo.getText(),this.jtextAutor.getText(),this.jtextAno.getText());
			mostrarLivrosArmazenadosNoServicoDeSelecao();
			apagarCampos();
		}
		else{
			JOptionPane.showMessageDialog(null, "Preencha os campos Corretamente", "Informacao", JOptionPane.WARNING_MESSAGE);
			apagarCampos();
		}
			
		
	}
	
	private void btnClassificarLivrosActionPerformed(ActionEvent evt){
		int opcao1 = pegarOpcao1DeClassificacao();
		int opcao2 = pegarOpcao2DeClassificacao();
		int opcao3 = pegarOpcao3DeClassificacao();
		
		if(opcao1 + opcao2 + opcao3 != 0){
			classificador.atualizarLivrosParaClassificar();
			try{
				classificador.classificarLivros(opcao1, opcao2, opcao3);
				mostrarOsLivrosClassificadosPeloServiçoDeSelecao();
				JOptionPane.showMessageDialog(null, "Classificacao realizada com sucesso!", "Exception", JOptionPane.INFORMATION_MESSAGE);
			}catch(SortingServiceException sse){
				sse.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Selecione as opcoes de ordenacao. \nLembramos que a opcao2 serve de criterio de desempate para a opcao1, \nassim como, a opcao3 serve de criterio de desempate para a opcao2.\nSe for colocado a opcao1 igual a opcao2, a opcao2 nao sera considerada,\nassim como, se for colocada a opcao2 igual a opcao3,\na opcao3 nao sera considerada. ", "Informacao de ordenacao", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostrarLivrosArmazenadosNoServicoDeSelecao(){
		modeloParaSelecao = classificador.mostrarOsLivrosArmazenadosNoServicoDeSelecao();
		tblParaSelecao.setModel(modeloParaSelecao);
	}
	
	public void mostrarOsLivrosClassificadosPeloServiçoDeSelecao(){
		modeloClassificada = classificador.mostrarOsLivrosClassificados();
		tblClassificada.setModel(modeloClassificada);	
	}
	
	public void apagarCampos(){
		jtextTitulo.setText("");
		jtextAutor.setText("");
		jtextAno.setText("");
	}
		
	public void enviarParaServicoDeClassificacao(String titulo, String autor, String ano){
		try{
			int anoEdicao = Integer.parseInt(ano);
			classificador.adicionaLivro(titulo, autor, anoEdicao);
		}catch(NumberFormatException e){
			apagarCampos();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dados inseridos incorretamente ","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private int pegarOpcao1DeClassificacao(){
		return modoDeSelecao1.getSelectedIndex();	
	}	
	private int pegarOpcao2DeClassificacao(){
		return modoDeSelecao2.getSelectedIndex();
	}
	private int pegarOpcao3DeClassificacao(){
		return modoDeSelecao3.getSelectedIndex();
	}
	
	
}
	
