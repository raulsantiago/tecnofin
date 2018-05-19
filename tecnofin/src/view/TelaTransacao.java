package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexoes.Conexao;
import control.TransacaoControle;
import model.PessoaJuridica;
import model.Transacao;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.util.Locale;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	public static String transacao_pf_pj;
	public static String transacao_rec_desp;
	public static String nomerecdesp;
	public static String sinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTransacao frame = new TelaTransacao();
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
	@SuppressWarnings("unchecked")
	public TelaTransacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setSize(new Dimension(700, 700));
		setMaximumSize(new Dimension(700, 700));
		setMinimumSize(new Dimension(700, 700));
		setPreferredSize(new Dimension(700, 700));
		setTitle("Transa\u00E7\u00F5es Banc\u00E1rias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Transacao.valor = Double.parseDouble(String.valueOf(textValor.getText()));
				Transacao.dataTransacao = textData.getText();
				
				// CALCULANDO O SALDO		
				if(!textValor.equals(""))
				{	
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados
				    
				    String sql1 = "SELECT saldo FROM bancos WHERE idBancos = ('"+Transacao.FK_idBancos+"');";
				    if(!sql1.equals("SELECT saldo FROM bancos WHERE idBancos = ('null');")) 
				    {
				    	//System.out.println(sql1);
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();
			            	double sdl = rs.getDouble("saldo");
			            	if(sinal == "-") 
							{
								Transacao.saldo = (sdl - Transacao.valor);
							} else 
							{
								Transacao.saldo = (sdl + Transacao.valor);
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
				System.out.println("Transacao.saldo="+Transacao.saldo);
				*/
				TransacaoControle tc = new TransacaoControle();
				tc.salvar();
			    limparCampos();
			}
		});
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(111, 584, 125, 28);
		contentPane.add(btnSalvar);
		
		
		JLabel lblTransaesBancrias = new JLabel("TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		lblTransaesBancrias.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTransaesBancrias.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaesBancrias.setForeground(Color.GRAY);
		lblTransaesBancrias.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTransaesBancrias.setBounds(121, 16, 441, 50);
		contentPane.add(lblTransaesBancrias);
		
		JLabel lblFavorecido = new JLabel("FAVORECIDO");
		lblFavorecido.setForeground(Color.GRAY);
		lblFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFavorecido.setBounds(106, 211, 118, 16);
		contentPane.add(lblFavorecido);
		
		JComboBox BoxContaBanco = new JComboBox();
		BoxContaBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contabanco = String.valueOf(BoxContaBanco.getSelectedItem());
				//System.out.println("CONTA BANCO = "+contabanco);
				StringTokenizer contaB = new StringTokenizer(contabanco, " ");
				String conta = contaB.nextToken();
				//System.out.println(conta);
				int qtd = conta.length();
				String nomebanco = contabanco.substring(qtd+1);
				//System.out.println(nomebanco);			
				
				// Seleciona o ID do banco escolhido pelo usuário
				Connection conn = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    conn = Conexao.getConexao(); //conectar ao banco de dados
			    String sql1 = "SELECT idBancos FROM bancos WHERE contaNum = ('"+conta+"') AND nome = ('"+nomebanco+"');";
			    if(!sql1.equals("SELECT idBancos FROM bancos WHERE contaNum = ('null') AND nome = ('null');")) 
			    {
			    	try 
			    	{
			    		pstmt = conn.prepareStatement(sql1);
		            	rs = pstmt.executeQuery();
		            	Transacao.FK_idBancos = rs.getInt("idBancos");
				        //System.out.println("Variavel Transacao.FK_idBancos = "+Transacao.FK_idBancos);
				    	//Conexao.fecharConexao(conn, pstmt, rs);
			    	}
			    	 catch(SQLException ex)
				    {
			    		 JOptionPane.showMessageDialog(null, "Erro ao select bancos. Erro: " + ex);
				    }
			    	finally
				    {
				    	Conexao.fecharConexao(conn, pstmt, rs);
				    }
			   } 
				
			}
		});
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
			    }
			    catch(SQLException ex)
			    {
			    	JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
			    }
			    finally
			    {
			    	Conexao.fecharConexao(conn, pstmt, rs);
			    }
		BoxContaBanco.setBounds(96, 103, 313, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel lblBancoDaTransao = new JLabel("N\u00BA CONTA BANCO");
		lblBancoDaTransao.setForeground(Color.GRAY);
		lblBancoDaTransao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBancoDaTransao.setBounds(106, 88, 231, 16);
		contentPane.add(lblBancoDaTransao);
		
		JComboBox BoxReceitaDespesa = new JComboBox();		
		BoxReceitaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// RECEITA
				
				String transacao_rec_desp = String.valueOf(BoxReceitaDespesa.getSelectedItem());
				//System.out.println("VARIAVEL transacao_rec_desp = "+transacao_rec_desp);
				StringTokenizer recdesp = new StringTokenizer(transacao_rec_desp, " ");
				String contarecdesp = recdesp.nextToken();				
				int qtd = contarecdesp.length();
				if(!transacao_rec_desp.equals("") && !transacao_rec_desp.equals("null") && !transacao_rec_desp.equals(null)) 
				{
					nomerecdesp = transacao_rec_desp.substring(qtd+1);
				}
								
				//System.out.println(contarecdesp);	
				//System.out.println(nomerecdesp);
				
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
				    	//System.out.println(sql1);
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();
			            	Transacao.FK_idReceita = rs.getInt("idReceita");
					        //System.out.println("Variavel Transacao.FK_idReceita = "+Transacao.FK_idReceita);
					        //rs.close();
					    	//Conexao.fecharConexao(conn, pstmt, rs);
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
				    String sql1 = "SELECT idDespesa FROM despesa WHERE contaDespesa = ('"+contarecdesp+"') AND nomeDespesa = ('"+nomerecdesp+"');";
				    if(!sql1.equals("SELECT idDespesa FROM despesa WHERE contaDespesa = ('null') AND nomeDespesa = ('null');")) 
				    {
				    	//System.out.println(sql1);
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();
			            	Transacao.FK_idDespesa = rs.getInt("idDespesa");
					        //System.out.println("Variavel Transacao.FK_idDespesa = "+Transacao.FK_idDespesa);
					        //rs.close();
					    	//Conexao.fecharConexao(conn, pstmt, rs);
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxReceitaDespesa.removeAllItems();			    
			}
		});
		BoxReceitaDespesa.setBounds(96, 344, 313, 35);
		contentPane.add(BoxReceitaDespesa);
				
		JComboBox BoxTipoRecDes = new JComboBox();
		BoxTipoRecDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(BoxTipoRecDes.getSelectedItem() == "DESPESA")
				{	
					BoxReceitaDespesa.removeAllItems();				
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
				if(BoxTipoRecDes.getSelectedItem() == "RECEITA") 
				{	
					BoxReceitaDespesa.removeAllItems();
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxTipoRecDes.setSelectedIndex(0);			    
			}
		});
		BoxTipoRecDes.setForeground(Color.GRAY);
		BoxTipoRecDes.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipoRecDes.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "DESPESA", "RECEITA"}));
		BoxTipoRecDes.setBounds(96, 284, 313, 35);
		contentPane.add(BoxTipoRecDes);
		
		JLabel lblClassificaoContbil = new JLabel("TIPO DE LAN\u00C7AMENTO");
		lblClassificaoContbil.setForeground(Color.GRAY);
		lblClassificaoContbil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClassificaoContbil.setBounds(106, 270, 231, 16);
		contentPane.add(lblClassificaoContbil);
		
		JLabel label = new JLabel("CLASSIFICA\u00C7\u00C3O CONT\u00C1BIL");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(106, 329, 231, 16);
		contentPane.add(label);
		
		JLabel lblTipoDaTransao = new JLabel("TIPO DA TRANSA\u00C7\u00C3O BANC\u00C1RIA");
		lblTipoDaTransao.setForeground(Color.GRAY);
		lblTipoDaTransao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDaTransao.setBounds(106, 383, 231, 16);
		contentPane.add(lblTipoDaTransao);
		
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
		textValor.setLocale(new Locale("pt", "BR"));		
		textValor.setBounds(96, 454, 170, 28);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblValor = new JLabel("VALOR");
		lblValor.setForeground(Color.GRAY);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(106, 438, 128, 16);
		contentPane.add(lblValor);
		
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
		textData.setBounds(318, 454, 170, 28);
		contentPane.add(textData);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setForeground(Color.GRAY);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(325, 438, 128, 16);
		contentPane.add(lblData);
		
		JLabel lblInformaesComplementaresDa = new JLabel("INFORMA\u00C7\u00D5ES COMPLEMENTARES DA TRANSA\u00C7\u00C3O");
		lblInformaesComplementaresDa.setForeground(Color.GRAY);
		lblInformaesComplementaresDa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformaesComplementaresDa.setBounds(106, 492, 348, 16);
		contentPane.add(lblInformaesComplementaresDa);
		
		
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTransacao tt = new TelaTransacao();
                tt.dispose();
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(TelaTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(315, 613, 53, 36);
		contentPane.add(btnHome);
		
		
		
		JButton btnConsulta = new JButton("CONSULTA");
		btnConsulta.setForeground(Color.GRAY);
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsulta.setBounds(457, 585, 125, 28);
		contentPane.add(btnConsulta);
		
		JComboBox BoxFavorecido = new JComboBox();
		BoxFavorecido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// PESSOA FISICA
				
				String transacao_pf_pj = String.valueOf(BoxFavorecido.getSelectedItem());
				//System.out.println("variavel transacao_pf_pj = "+transacao_pf_pj);
				if(!transacao_pf_pj.equals("") && !transacao_pf_pj.equals("null") && !transacao_pf_pj.equals(null))
				{	
					// Seleciona o ID do favorecido escolhido pelo usuário
					Connection conn = null;
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    conn = Conexao.getConexao(); //conectar ao banco de dados
				    String sql1 = "SELECT cpf FROM pessoaFisica WHERE nomePF = ('"+transacao_pf_pj+"');";
				    if(!sql1.equals("SELECT cpf FROM pessoaFisica WHERE nomePF = ('null');")) 
				    {
				    	//System.out.println(sql1);
				    	try 
				    	{
				    		pstmt = conn.prepareStatement(sql1);
			            	rs = pstmt.executeQuery();
			            	Transacao.FK_cpf = rs.getLong("cpf");
					        //System.out.println("Variavel Transacao.FK_cpf = "+Transacao.FK_cpf);
					        //rs.close();
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
				    if(!sql1.equals("SELECT cnpj FROM pessoaJuridica WHERE nomePJ = ('null');")) 
				    {	
				    	try
					    {
				    		pstmtt = connn.prepareStatement(sql2);
			            	rss = pstmtt.executeQuery();
			            	Transacao.FK_cnpj = rss.getLong("cnpj");
					        //System.out.println("Variavel Transacao.FK_cnpj = "+Transacao.FK_cnpj);
					    	Conexao.fecharConexao(connn, pstmtt, rss);					    }
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxFavorecido.removeAllItems();			    
			}
		});
		BoxFavorecido.setBounds(96, 227, 502, 35);
		contentPane.add(BoxFavorecido);
		
		
		JComboBox BoxTipoFavorecido = new JComboBox();
		BoxTipoFavorecido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// PESSOA FISICA
				
				if(BoxTipoFavorecido.getSelectedItem() == "PESSOA FÍSICA")
				{	
					BoxFavorecido.removeAllItems();
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxTipoFavorecido.setSelectedIndex(0);			    
			}
		});
		BoxTipoFavorecido.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "PESSOA F\u00CDSICA", "PESSOA JUR\u00CDDICA"}));
		BoxTipoFavorecido.setForeground(Color.GRAY);
		BoxTipoFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipoFavorecido.setBounds(96, 164, 313, 35);
		contentPane.add(BoxTipoFavorecido);
		
		JLabel lblTipoDeFavorecido = new JLabel("TIPO DE FAVORECIDO");
		lblTipoDeFavorecido.setForeground(Color.GRAY);
		lblTipoDeFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeFavorecido.setBounds(106, 150, 231, 16);
		contentPane.add(lblTipoDeFavorecido);
		
		JTextPane textDescricao = new JTextPane();
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Transacao.descricao = textDescricao.getText();
			    textDescricao.setText("");
			}
		});		
		textDescricao.setBounds(96, 508, 502, 61);
		contentPane.add(textDescricao);
		
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
					if(BoxTipoRecDes.getSelectedItem() == "RECEITA")
					{
						sinal = "-";						
					}
					if(BoxTipoRecDes.getSelectedItem() == "DESPESA")
					{
						sinal = "+";
					}
					
				}				
				if(BoxTipo.getSelectedItem() == "APLICAÇÃO") 
				{
					Transacao.tipo = "APLICAÇÃO";
					if(BoxTipoRecDes.getSelectedItem() == "RECEITA")
					{
						sinal = "+";						
					}
					if(BoxTipoRecDes.getSelectedItem() == "DESPESA")
					{
						sinal = "-";
					}
				}				
				if(BoxTipo.getSelectedItem() == "RESGATE") 
				{
					Transacao.tipo = "RESGATE";
					if(BoxTipoRecDes.getSelectedItem() == "RECEITA")
					{
						sinal = "-";						
					}
					if(BoxTipoRecDes.getSelectedItem() == "DESPESA")
					{
						sinal = "+";
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
				
				//System.out.println("VARIAVEL Transacao.tipo = "+Transacao.tipo);
				
			}
		});
		BoxTipo.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "PAGAMENTO", "RECEBIMENTO", "ESTORNO", "APLICA\u00C7\u00C3O", "RESGATE", "RENDIMENTO", "PREJU\u00CDZO"}));
		BoxTipo.setForeground(Color.GRAY);
		BoxTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipo.setBounds(96, 400, 313, 35);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxTipo.setSelectedIndex(0);			    
			}
		});
		contentPane.add(BoxTipo);
		
		
		
	}
	
	public void limparCampos() 
	{   
		textValor.setText("");
	    textData.setText("");	    
	}
	
}