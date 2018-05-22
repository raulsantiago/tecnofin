package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexoes.Conexao;
import control.JuridicaControle;
import control.TransacaoControle;
import model.PessoaJuridica;
import model.Transacao;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AtualizarTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	
	public static String sinal;
	public static int salvar1;
	public static int salvar2;
	public static double valoranterior;
	public static String nomerecdesp;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarTransacao frame = new AtualizarTransacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtualizarTransacao() {
		/*addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				textValor.setText(String.valueOf(Transacao.valor));
				textData.setText(Transacao.dataTransacao);
				
			}
		});*/
		setMaximumSize(new Dimension(700, 700));
		setMinimumSize(new Dimension(700, 700));
		setPreferredSize(new Dimension(700, 700));
		setSize(new Dimension(700, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Altera\u00E7\u00E3o de Transa\u00E7\u00E3o Banc\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel label = new JLabel("FAVORECIDO");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(92, 217, 118, 16);
		contentPane.add(label);
		
		JComboBox BoxContaBanco = new JComboBox();		
		// PREENCHER O COMBO BOX COM NOMES PF OU PJ
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    conn = Conexao.getConexao(); //conectar ao banco de dados			        
        
	    String sql1 = "SELECT contaNum, nome FROM bancos ORDER BY nome ASC;";

	    try
	    {
	        pstmt = conn.prepareStatement(sql1);
	        rs = pstmt.executeQuery();
	        List<String> strList = new ArrayList<String>();
	        while(rs.next())
	        {
	            strList.add(rs.getString("contaNum")+" "+rs.getString("nome"));
	        }	
	        
	        for (String sf:strList)			    		
	        	BoxContaBanco.addItem(sf);
	        	Conexao.fecharConexao(conn, pstmt, rs);
	    }
	    catch(SQLException ex)
	    {
	    	JOptionPane.showMessageDialog(null, "Erro ao PREENCHER BOXCONTABANCO. Erro: " + ex);
	    }
	    finally
	    {
	    	Conexao.fecharConexao(conn, pstmt, rs);
	    }
		BoxContaBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Transacao.contabanco = String.valueOf(BoxContaBanco.getSelectedItem());				
				StringTokenizer contaB = new StringTokenizer(Transacao.contabanco, " ");
				String conta = contaB.nextToken();
				int qtd = conta.length();
				String nomebanco = Transacao.contabanco.substring(qtd+1);
				
				// Seleciona o ID do banco escolhido pelo usuário
				Connection conn = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    conn = Conexao.getConexao(); //conectar ao banco de dados
			    String sql2 = "SELECT idBancos FROM bancos WHERE contaNum = ('"+conta+"') AND nome = ('"+nomebanco+"');";
			    if(!sql1.equals("SELECT idBancos FROM bancos WHERE contaNum = ('null') AND nome = ('null');")) 
			    {
			    	try 
			    	{
			    		pstmt = conn.prepareStatement(sql2);
		            	rs = pstmt.executeQuery();
		            	Transacao.FK_idBancos = rs.getInt("idBancos");		            	
			    	}
			    	 catch(SQLException ex)
				    {
			    		 JOptionPane.showMessageDialog(null, "Erro ao select ID bancos BOXCONTABANCO. Erro: " + ex);
				    }
			    	finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);
				    }
			   }
				
			}
		});
		BoxContaBanco.setBounds(82, 109, 313, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel label_1 = new JLabel("N\u00BA CONTA BANCO");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(92, 94, 231, 16);
		contentPane.add(label_1);
		
		
		
		JLabel label_2 = new JLabel("TIPO DE LAN\u00C7AMENTO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(92, 276, 231, 16);
		contentPane.add(label_2);
		
		
		
		JLabel label_3 = new JLabel("CLASSIFICA\u00C7\u00C3O CONT\u00C1BIL");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(92, 335, 231, 16);
		contentPane.add(label_3);
		
		
		
		JLabel label_4 = new JLabel("TIPO DA TRANSA\u00C7\u00C3O BANC\u00C1RIA");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(92, 389, 231, 16);
		contentPane.add(label_4);
		
		textValor = new JTextField();
		textValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String vl = textValor.getText();				
				if(!vl.matches("\\d{1,16}\\.\\d{2}"))
				{
					JOptionPane.showMessageDialog(null,"Formato do valor incorreto! Exemplo do certo:  1234567.89","ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textValor.setColumns(10);
		textValor.setBounds(82, 460, 170, 28);
		contentPane.add(textValor);
		
		JLabel label_5 = new JLabel("VALOR");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(92, 444, 128, 16);
		contentPane.add(label_5);
		
		textData = new JTextField();
		textData.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String vl = textData.getText();
				if(!vl.matches("\\d{2}/\\d{2}/\\d{4}"))
				{
					JOptionPane.showMessageDialog(null,"Formato da data incorreto! Exemplo do certo: 12/05/2018","ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textData.setColumns(10);
		textData.setBounds(304, 460, 170, 28);
		contentPane.add(textData);
		
		JLabel label_6 = new JLabel("DATA");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(311, 444, 128, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("INFORMA\u00C7\u00D5ES COMPLEMENTARES DA TRANSA\u00C7\u00C3O");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(92, 498, 348, 16);
		contentPane.add(label_7);
		
		
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j = String.valueOf(Transacao.idTransacao);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha da tela anterior para atualizar");
		        }
		        else
		        {
		        	
		        	Transacao.valor = Double.parseDouble(String.valueOf(textValor.getText()));
					Transacao.dataTransacao = textData.getText();
					
					// CALCULANDO O SALDO		
					if(!textValor.equals(""))
					{	
						Connection conn = null;
					    PreparedStatement pstmt = null;
					    ResultSet rs = null;
					    conn = Conexao.getConexao(); //conectar ao banco de dados
					    String sql1 = "SELECT valor FROM transacao WHERE idTransacao = ('"+Transacao.idTransacao+"');";
					    try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();			            	
			            	valoranterior = rs.getDouble("valor");
				    	}
				    	 catch(SQLException ex)
					    {
				
					    }
				    	finally
					    {
					    	Conexao.fecharConexao(conn, pstmt, rs);
					    }
					    
					    conn = Conexao.getConexao(); //conectar ao banco de dados
					    String sql2 = "SELECT saldo FROM bancos WHERE idBancos = ('"+Transacao.FK_idBancos+"');";
					    if(!sql2.equals("SELECT saldo FROM bancos WHERE idBancos = ('null');")) 
					    {				    	
					    	try 
					    	{
					    		pstmt = conn.prepareStatement(sql2);
				            	rs = pstmt.executeQuery();			            	
				            	double sdl = rs.getDouble("saldo");
				            	if(sinal == "-") 
								{
									Transacao.saldo = (sdl - (Transacao.valor - valoranterior));
								} else 
								{
									Transacao.saldo = (sdl + (Transacao.valor - valoranterior ));								
								}
						        
					    	}
					    	 catch(SQLException ex)
						    {
					
						    }
					    	finally
						    {
						    	Conexao.fecharConexao(conn, pstmt, rs);
						    }
					   }
					}
					/*
					System.out.println("Transacao.tipo="+Transacao.tipo);
				    System.out.println("Transacao.dataTransacao="+Transacao.dataTransacao);
				    System.out.println("Transacao.descricao="+Transacao.descricao);
					System.out.println("Transacao.valor="+Transacao.valor);
					System.out.println("Transacao.FK_idDespesa="+Transacao.FK_idDespesa);
					System.out.println("Transacao.FK_idReceita="+Transacao.FK_idReceita);
					System.out.println("Transacao.FK_cnpj="+Transacao.FK_cnpj);
					System.out.println("Transacao.FK_cpf="+Transacao.FK_cpf);
					System.out.println("Transacao.FK_idBancos="+Transacao.FK_idBancos);
					System.out.println("Transacao.idTransacao="+Transacao.idTransacao);
					System.out.println(Transacao.saldo);
					*/
		        	if((salvar1 == 1) && (salvar2 == 1)) 
		        	{
		        		TransacaoControle tc = new TransacaoControle();
						tc.Atualizar();				    
					    limparCampos();
						AtualizarTransacao tp = new AtualizarTransacao();
		                tp.dispose();
		                ConsultaTransacao tt = new ConsultaTransacao();
		                tt.setVisible(true);
		        	}
					
	                
		        }
		        
			}
		});
		btnConfirmar.setForeground(Color.GRAY);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmar.setBounds(97, 590, 125, 28);
		contentPane.add(btnConfirmar);
		
		JTextPane textNotas = new JTextPane();
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Transacao.descricao = textNotas.getText();
			    textNotas.setText("");
			}
		});
		textNotas.setBounds(82, 514, 502, 61);
		contentPane.add(textNotas);
		
		JComboBox BoxReceitaDespesa = new JComboBox();
		BoxReceitaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// RECEITA
				
				String transacao_rec_desp = String.valueOf(BoxReceitaDespesa.getSelectedItem());				
				StringTokenizer recdesp = new StringTokenizer(transacao_rec_desp, " ");
				String contarecdesp = recdesp.nextToken();				
				int qtd = contarecdesp.length();
				if(!transacao_rec_desp.equals("") && !transacao_rec_desp.equals("null") && !transacao_rec_desp.equals(null)) 
				{
					nomerecdesp = transacao_rec_desp.substring(qtd+1);
				}
				
				if(!transacao_rec_desp.equals("") && !transacao_rec_desp.equals("null") && !transacao_rec_desp.equals(null))
				{	
					// Seleciona o ID da receita quando escolhido pelo usuário
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados
				    String sql1 = "SELECT idReceita FROM receita WHERE contaReceita = ('"+contarecdesp+"') AND nomeReceita = ('"+nomerecdesp+"');";
				    if(!sql1.equals("SELECT idReceita FROM receita WHERE contaReceita = ('null') AND nomeReceita = ('null');")) 
				    {				    	
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();
			            	Transacao.FK_idReceita = rs.getInt("idReceita");			            	  
				    	}
				    	 catch(SQLException ex)
					    {
				
					    }
				    	finally
					    {
					    	Conexao.fecharConexao(conn, pstmt, rs);
					    }
				   }
				} 
				
				// DESPESA	
				
				if(!transacao_rec_desp.equals("") && !transacao_rec_desp.equals("null") && !transacao_rec_desp.equals(null))
				{	
					// Seleciona o ID da despesa quando escolhido pelo usuário
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados
				    String sql2 = "SELECT idDespesa FROM despesa WHERE contaDespesa = ('"+contarecdesp+"') AND nomeDespesa = ('"+nomerecdesp+"');";
				    if(!sql2.equals("SELECT idDespesa FROM despesa WHERE contaDespesa = ('null') AND nomeDespesa = ('null');")) 
				    {				    	
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql2);
			            	rs = pstmt.executeQuery();
			            	Transacao.FK_idDespesa = rs.getInt("idDespesa");
			            }
				    	 catch(SQLException ex)
					    {
				
					    }
				    	finally
					    {
					    	Conexao.fecharConexao(conn, pstmt, rs);
					    }
				   }
				}
				
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxReceitaDespesa.removeAllItems();			    
			}
		});
		BoxReceitaDespesa.setBounds(82, 350, 313, 35);
		contentPane.add(BoxReceitaDespesa);
		
		JComboBox BoxRecDes = new JComboBox();
		BoxRecDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(BoxRecDes.getSelectedItem() == "DESPESA")
				{	
					BoxReceitaDespesa.removeAllItems();
					Transacao.FK_idDespesa = 0;
					Transacao.FK_idReceita = 0;					
					//Selecionar o ultimo id das tabelas relacionadas para salvar a chave estrangeira na transacao
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados			        
			        
				    String sql1 = "SELECT contaDespesa, nomeDespesa FROM despesa ORDER BY contaDespesa ASC;";

				    try
				    {
				        pstmt = conn.prepareStatement(sql1);
				        rs = pstmt.executeQuery();
				        List<String> strList = new ArrayList<String>();
				        while(rs.next())
				        {
				            strList.add(rs.getString("contaDespesa")+" "+rs.getString("nomeDespesa"));
				        }	
				        
				        for (String sf:strList)			    		
				        	BoxReceitaDespesa.addItem(sf);
				    }
				    catch(SQLException ex)
				    {
				    	JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);
				    }
				}
				if(BoxRecDes.getSelectedItem() == "RECEITA") 
				{	
					BoxReceitaDespesa.removeAllItems();
					Transacao.FK_idDespesa = 0;
					Transacao.FK_idReceita = 0;
					//Selecionar o ultimo id das tabelas relacionadas para salvar a chave estrangeira na transacao
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados			        
			        
				    String sql2 = "SELECT * FROM receita ORDER BY contaReceita ASC;";

				    try
				    {
				        pstmt = conn.prepareStatement(sql2);
				        rs = pstmt.executeQuery();
				        List<String> strList = new ArrayList<String>();
				        while(rs.next())
				        {
				            strList.add(rs.getString("contaReceita")+" "+rs.getString("nomeReceita"));
				        }	
				        
				        for (String sj:strList)			    		
				        	BoxReceitaDespesa.addItem(sj);
				    }
				    catch(SQLException ex)
				    {
				    	JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);
				    }
				}
				
			
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BoxRecDes.getSelectedItem() == "SELECÃO OBRIGATÓRIA")
				{
					JOptionPane.showMessageDialog(null, "Terá que refazer tudo novamente tarvés da tela de consulta, pois não pode confirmar a alterção sem selecionar "
							+ "TIPO DE LANÇAMENTO e TIPO DA TRANSAÇÃO BANCÁRIA !");
					limparCampos();
					AtualizarTransacao tp = new AtualizarTransacao();
	                tp.dispose();
	                ConsultaTransacao tt = new ConsultaTransacao();
	                tt.setVisible(true);
				} else 
				{
					salvar1 = 1;
					BoxRecDes.setSelectedIndex(0);
				}
				
			}
		});		
		BoxRecDes.setModel(new DefaultComboBoxModel(new String[] {"SELEC\u00C3O OBRIGAT\u00D3RIA", "DESPESA", "RECEITA"}));
		BoxRecDes.setForeground(Color.GRAY);
		BoxRecDes.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxRecDes.setBounds(82, 290, 313, 35);
		contentPane.add(BoxRecDes);
		
		JComboBox BoxFavorecido = new JComboBox();
		BoxFavorecido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// PESSOA FISICA
				
				String transacao_pf_pj = String.valueOf(BoxFavorecido.getSelectedItem());				
				if(!transacao_pf_pj.equals("") && !transacao_pf_pj.equals("null") &&
						!transacao_pf_pj.equals(null))
				{	
					// Seleciona o ID do favorecido escolhido pelo usuário
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados
				    String sql1 = "SELECT cpf FROM pessoaFisica WHERE nomePF = ('"+transacao_pf_pj+"');";
				    if(!sql1.equals("SELECT cpf FROM pessoaFisica WHERE nomePF = ('null');")) 
				    {				    	
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();
			            	Transacao.FK_cpf = rs.getLong("cpf");
				    	}
				    	 catch(SQLException ex)
					    {
				
					    }
				    	finally
					    {
					    	Conexao.fecharConexao(conn, pstmt, rs);
					    }
				   }
				} 
				
				// PESSOA JURIDICA
				
				if(!transacao_pf_pj.equals("") && !transacao_pf_pj.equals("null") && !transacao_pf_pj.equals(null)) 
				{	
					// Seleciona o ID do favorecido escolhido pelo usuário
					Connection connn = null;
				    PreparedStatement pstmtt = null;
				    ResultSet rss = null;							    
				    connn = Conexao.getConexao(); //conectar ao banco de dados
				    String sql2 = "SELECT cnpj FROM pessoaJuridica WHERE nomePJ = ('"+transacao_pf_pj+"');";
				    if(!sql2.equals("SELECT cnpj FROM pessoaJuridica WHERE nomePJ = ('null');")) 
				    {	
				    	try
					    {
				    		pstmtt = connn.prepareStatement(sql2);
			            	rss = pstmtt.executeQuery();
			            	Transacao.FK_cnpj = rss.getLong("cnpj");			            						    
					    }
					    catch(SQLException ex)
					    {

					    }
					    finally
					    {
					    	Conexao.fecharConexao(connn, pstmtt, rss);
					    }				    	
				    }
				}
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxFavorecido.removeAllItems();			    
			}
		});
		BoxFavorecido.setBounds(82, 233, 502, 35);
		contentPane.add(BoxFavorecido);
		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarTransacao tp = new AtualizarTransacao();
                tp.dispose();
                ConsultaTransacao tt = new ConsultaTransacao();
                tt.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(443, 591, 125, 28);
		contentPane.add(btnVoltar);
		
		JComboBox BoxTipoFavorecido = new JComboBox();
		BoxTipoFavorecido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// PESSOA FISICA
				
				if(BoxTipoFavorecido.getSelectedItem() == "PESSOA FÍSICA")
				{	
					BoxFavorecido.removeAllItems();
					Transacao.FK_cnpj = 0;
					Transacao.FK_cpf = 0;
					//Selecionar o ultimo id das tabelas relacionadas para salvar a chave estrangeira na transacao
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados			        
			        
				    String sql1 = "SELECT nomePF FROM pessoaFisica ORDER BY nomePF ASC;";

				    try
				    {
				        pstmt = conn.prepareStatement(sql1);
				        rs = pstmt.executeQuery();
				        List<String> strList = new ArrayList<String>();
				        while(rs.next()) 
				        {
				        	try
					        {
				        	    strList.add(rs.getString("nomePF"));
					        }
				        	 catch(SQLException ex)
							 {
							   	JOptionPane.showMessageDialog(null, "Erro ao preencher PF BoxTipoFavorecido. Erro: " + ex);
							 }
				        }
				        rs.close();				        
				        for (String sf:strList)			    		
				        	BoxFavorecido.addItem(sf);				        
				    }
				    catch(SQLException ex)
				    {
				    	JOptionPane.showMessageDialog(null, "Erro ao preencher PF BoxTipoFavorecido. Erro: " + ex);
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);
				    }
				}
				
				// PESSOA JURIDICA
				
				
				if(BoxTipoFavorecido.getSelectedItem() == "PESSOA JURÍDICA") 
				{	
					BoxFavorecido.removeAllItems();
					Transacao.FK_cnpj = 0;
					Transacao.FK_cpf = 0;
					//Selecionar o ultimo id das tabelas relacionadas para salvar a chave estrangeira na transacao
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados			        
			        
				    String sql2 = "SELECT nomePJ FROM pessoaJuridica ORDER BY nomePJ ASC;";

				    try
				    {
				        pstmt = conn.prepareStatement(sql2);
				        rs = pstmt.executeQuery();
				        List<String> strList = new ArrayList<String>();
				        while(rs.next()) 
				        {
				        	try
					        {
					            strList.add(rs.getString("nomePJ"));
					        }
				        	 catch(SQLException ex)
							 {
							   	JOptionPane.showMessageDialog(null, "Erro ao preencher PJ BoxTipoFavorecido. Erro: " + ex);
							 }
				        }
				        rs.close();
				        for (String sj:strList)			    		
				        	BoxFavorecido.addItem(sj);				        
				    }
				    catch(SQLException ex)
				    {
				    	JOptionPane.showMessageDialog(null, "Erro ao preencher PJ BoxTipoFavorecido. Erro: " + ex);
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);				    }
				    
				    
				}
				
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxTipoFavorecido.setSelectedIndex(0);			    
			}
		});
		BoxTipoFavorecido.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "PESSOA F\u00CDSICA", "PESSOA JUR\u00CDDICA"}));
		BoxTipoFavorecido.setForeground(Color.GRAY);
		BoxTipoFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipoFavorecido.setBounds(82, 170, 313, 35);
		contentPane.add(BoxTipoFavorecido);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(BoxTipo.getSelectedItem() == "PAGAMENTO") 
				{
					Transacao.tipo = "PAGAMENTO";
					sinal = "-";
				}				
				if(BoxTipo.getSelectedItem() == "RECEBIMENTO") 
				{
					Transacao.tipo = "RECEBIMENTO";
					sinal = "+";
				}				
				if(BoxTipo.getSelectedItem() == "ESTORNO") 
				{
					Transacao.tipo = "ESTORNO";
					if(BoxRecDes.getSelectedItem() == "RECEITA")
					{
						sinal = "-";						
					}
					if(BoxRecDes.getSelectedItem() == "DESPESA")
					{
						sinal = "+";
					}
					
				}				
				if(BoxTipo.getSelectedItem() == "APLICAÇÃO") 
				{
					Transacao.tipo = "APLICAÇÃO";
					if(BoxRecDes.getSelectedItem() == "RECEITA")
					{
						sinal = "+";						
					}
					if(BoxRecDes.getSelectedItem() == "DESPESA")
					{
						sinal = "-";
					}
				}				
				if(BoxTipo.getSelectedItem() == "RESGATE") 
				{
					Transacao.tipo = "RESGATE";
					if(BoxRecDes.getSelectedItem() == "RECEITA")
					{
						sinal = "+";						
					}
					if(BoxRecDes.getSelectedItem() == "DESPESA")
					{
						sinal = "-";
					}
				}				
				if(BoxTipo.getSelectedItem() == "RENDIMENTO") 
				{
					Transacao.tipo = "RENDIMENTO";
					sinal = "+";
				}				
				if(BoxTipo.getSelectedItem() == "PREJUÍZO") 
				{
					Transacao.tipo = "PREJUÍZO";
					sinal = "-";
				}
				
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				if(BoxTipo.getSelectedItem() == "SELECÃO OBRIGATÓRIA")
				{
					JOptionPane.showMessageDialog(null, "Terá que refazer tudo novamente tarvés da tela de consulta, pois não pode confirmar a alterção sem selecionar "
							+ "TIPO DE LANÇAMENTO e TIPO DA TRANSAÇÃO BANCÁRIA !");
					limparCampos();
					AtualizarTransacao tp = new AtualizarTransacao();
	                tp.dispose();
	                ConsultaTransacao tt = new ConsultaTransacao();
	                tt.setVisible(true);
				} else 
				{
					salvar2 = 1;
					BoxTipo.setSelectedIndex(0);
				}
				
				
			}
		});
		BoxTipo.setModel(new DefaultComboBoxModel(new String[] {"SELEC\u00C3O OBRIGAT\u00D3RIA", "PAGAMENTO", "RECEBIMENTO", "ESTORNO", "APLICA\u00C7\u00C3O", "RESGATE", "RENDIMENTO", "PREJU\u00CDZO"}));
		BoxTipo.setForeground(Color.GRAY);
		BoxTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipo.setBounds(82, 406, 313, 35);
		contentPane.add(BoxTipo);
		
		JLabel label_8 = new JLabel("TIPO DE FAVORECIDO");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(92, 156, 231, 16);
		contentPane.add(label_8);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarTransacao tt = new AtualizarTransacao();
                tt.dispose();
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(AtualizarTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(301, 619, 53, 36);
		contentPane.add(btnHome);
		
		JLabel label_9 = new JLabel("TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		label_9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_9.setBounds(122, 6, 440, 35);
		contentPane.add(label_9);
		
		JLabel lblAlterao = new JLabel("ALTERA\u00C7\u00C3O");
		lblAlterao.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlterao.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterao.setForeground(Color.GRAY);
		lblAlterao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlterao.setBounds(248, 46, 187, 25);
		contentPane.add(lblAlterao);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				textValor.setText(String.valueOf(Transacao.valor));
				textData.setText(Transacao.dataTransacao);
				// SELECIONA BOX TIPO PAGAMENTO RESGATE - OK
				for (int j = 0; j < BoxTipo.getItemCount(); j++)
		        {  
		        	 if (Transacao.tipo.equals(BoxTipo.getItemAt(j)))
		        	 {
		        		 BoxTipo.setSelectedIndex(j);
		        	 }
		        }				
				// SELECIONA BOX BANCO - OK
				Connection conn = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    conn = Conexao.getConexao(); //conectar ao banco de dados
			    String sql1 = "SELECT contaNum, nome FROM bancos WHERE idBancos = "+Transacao.FK_idBancos+";";
			    try
			    {
			        pstmt = conn.prepareStatement(sql1);
			        rs = pstmt.executeQuery();
			        Transacao.boxbanco = String.valueOf((rs.getString("contaNum")+" "+rs.getString("nome")));
			        for (int i = 0; i < BoxContaBanco.getItemCount(); i++)
			        {  
			        	 if (Transacao.boxbanco.equals(BoxContaBanco.getItemAt(i))){
			        		 BoxContaBanco.setSelectedIndex(i);
			        	 }
			        }
			        
			        Conexao.fecharConexao(conn, pstmt, rs);
			    }
			    catch(SQLException ex)
			    {
			    	
			    }
			    finally
			    {
			    	Conexao.fecharConexao(conn, pstmt, rs);				    
			    }
			    // // SELECIONA BOX FAVORECIDO PF OU PJ
			    conn = Conexao.getConexao(); //conectar ao banco de dados			    
			    String sql2 = "SELECT nomePF FROM pessoaFisica, transacao WHERE transacao.FK_cpf = cpf AND transacao.FK_cpf = "+Transacao.FK_cpf+" limit 1;";
			    if(sql2.equals("SELECT nomePF FROM pessoaFisica, transacao WHERE transacao.FK_cpf = cpf AND transacao.FK_cpf = 0 limit 1;")) 
			    {	
			    	//BoxTipoFavorecido.setSelectedIndex(2);
			    	String sql3 = "SELECT nomePJ FROM pessoaJuridica, transacao WHERE transacao.FK_cnpj = cnpj AND transacao.FK_cnpj = "+Transacao.FK_cnpj+" limit 1;";
			    	try
				    {
				        pstmt = conn.prepareStatement(sql3);
				        rs = pstmt.executeQuery();
				        String nomePPJ = rs.getString("nomePJ");
				        BoxFavorecido.addItem(nomePPJ);
				    }
				    catch(SQLException ex)
				    {

				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);				    
				    }
			    } else 
			    {	
		    		
			    	try
				    {
				        pstmt = conn.prepareStatement(sql2);
				        rs = pstmt.executeQuery();
				        String nomePPF = rs.getString("nomePF");
				        BoxFavorecido.addItem(nomePPF);
				    }
				    catch(SQLException ex)
				    {
				    	
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);				    
				    }
			    }
			    
			    // SELECIONE BOX DESPESA OU RECEITA
			    conn = Conexao.getConexao(); //conectar ao banco de dados			    
			    String sql4 = "SELECT contaDespesa, nomeDespesa FROM despesa, transacao WHERE transacao.FK_idDespesa = idDespesa AND transacao.FK_idDespesa = "+Transacao.FK_idDespesa+" limit 1;";
			    if(sql4.equals("SELECT contaDespesa, nomeDespesa FROM despesa, transacao WHERE transacao.FK_idDespesa = idDespesa AND transacao.FK_idDespesa = 0 limit 1;")) 
			    {	
			    	String sql5 = "SELECT contaReceita, nomeReceita FROM receita, transacao WHERE transacao.FK_idReceita = idReceita AND transacao.FK_idReceita = "+Transacao.FK_idReceita+" limit 1;";
			    
			    	try
				    {
				        pstmt = conn.prepareStatement(sql5);
				        rs = pstmt.executeQuery();
				        String nomeRE = (rs.getString("contaReceita")+" "+rs.getString("nomeReceita"));
				        BoxReceitaDespesa.addItem(nomeRE);
				    }
				    catch(SQLException ex)
				    {
				    	
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);				    
				    }
			    } else 
			    {
			    	
			    	try
				    {
				        pstmt = conn.prepareStatement(sql4);
				        rs = pstmt.executeQuery();
				        String nomeDE = (rs.getString("contaDespesa")+" "+rs.getString("nomeDespesa"));
				        BoxReceitaDespesa.addItem(nomeDE);
				    }
				    catch(SQLException ex)
				    {
				    	
				    }
				    finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);				    
				    }
			    }
			    //PREECNHER DESCRIÇÃO - OK
			    conn = Conexao.getConexao(); //conectar ao banco de dados			        
			    String sql6 = "SELECT descricao FROM transacao WHERE idTransacao = "+Transacao.idTransacao+";";
			    try
			    {
			        pstmt = conn.prepareStatement(sql6);
			        rs = pstmt.executeQuery();
			        textNotas.setText(rs.getString("descricao"));
			        Conexao.fecharConexao(conn, pstmt, rs);
			    }
			    catch(SQLException ex)
			    {
			    	
			    }
			    finally
			    {
			    	Conexao.fecharConexao(conn, pstmt, rs);				    
			    }
			}
		});
		
		
	}
	
	protected boolean mouseClicked2() {
		// TODO Auto-generated method stub
		return false;
	}

	public void limparCampos() 
	{   
		textValor.setText("");
	    textData.setText("");	    
	}
	
}
