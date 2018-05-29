package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import conexoes.Conexao;
import control.JuridicaControle;
import control.TransacaoControle;
import model.PessoaJuridica;
import model.Transacao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class ConsultaTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	private JTable table;
	//public static String cpf_cnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTransacao frame = new ConsultaTransacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
// "N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONTABIL", "NOME CONT\u00C1BIL", "TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR", "FK_IDBANCOS", "FK_IDRECEITA", "FK_IDDESPESA", "FK_IDPF", "FK_IDPJ" (14)
	public void preencherTabela(String sql)
	{
		Connection conn = null;        
        conn = Conexao.getConexao(); //conectar ao banco de dados
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);//inicializar do primeiro elemento da tabela
            while(rs.next())
            {            	
            	model.addRow(new Object[] 
                {	
                	rs.getString("idTransacao"),                    
               		rs.getString("contaNum"),
               		String.valueOf(((rs.getLong("FK_cnpj") == 0) ? rs.getLong("FK_cpf") : rs.getLong("FK_cnpj"))), 
               		String.valueOf((rs.getString("nomePJ") == null) ? rs.getString("nomePF") : rs.getString("nomePJ")),
               		String.valueOf((rs.getString("contaDespesa") == null) ? rs.getString("contaReceita") : rs.getString("contaDespesa")),
               		String.valueOf((rs.getString("nomeDespesa") == null) ? rs.getString("nomeReceita") : rs.getString("nomeDespesa")),
                    rs.getString("tipo"),
                    rs.getString("dataTransacao"),
                    rs.getString("valor"),
                    rs.getString("FK_idBancos"),
                    rs.getString("FK_idReceita"),
                    rs.getString("FK_idDespesa"),
                    rs.getString("FK_cpf"),
                    rs.getString("FK_cnpj"),
                });
            }		           
        }
        catch(SQLException ex)
        {
        	JOptionPane.showMessageDialog(null, "Erro ao exibir BD tabela. Erro: " + ex);
        }
        finally
        {
        	Conexao.fecharConexao(conn, pstmt, rs);
        }
	}
	

	/**
	 * Create the frame.
	 */
	public ConsultaTransacao() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				String sql = "select * from transacao left OUTER JOIN bancos on transacao.FK_idBancos = bancos.idBancos left OUTER JOIN pessoaJuridica on transacao.FK_cnpj = pessoaJuridica.cnpj left OUTER JOIN pessoaFisica on transacao.FK_cpf = pessoaFisica.cpf left OUTER JOIN receita on transacao.FK_idReceita = receita.idReceita left OUTER JOIN despesa on transacao.FK_idDespesa = despesa.idDespesa ORDER BY dataTransacao ASC;";
				preencherTabela(sql);
				
			}
		});
		setSize(new Dimension(1100, 700));
		setPreferredSize(new Dimension(1100, 700));
		setMaximumSize(new Dimension(1100, 700));
		setMinimumSize(new Dimension(1100, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Consulta Transa\u00E7\u00E3o Banc\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(321, 3, 441, 50);
		contentPane.add(label);
		
		JLabel lblConsulta = new JLabel("CONSULTA");
		lblConsulta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setForeground(Color.GRAY);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsulta.setBounds(448, 60, 187, 25);
		contentPane.add(lblConsulta);
		
		JComboBox BoxContaBanco = new JComboBox();
		BoxContaBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String contabanco = String.valueOf(BoxContaBanco.getSelectedItem());
				StringTokenizer contaB = new StringTokenizer(contabanco, " ");
				String conta = contaB.nextToken();
				int qtd = conta.length();
				String nomebanco = contabanco.substring(qtd+1);
				
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
	    }
	    catch(SQLException ex)
	    {
	    	JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
	    }
	    finally
	    {
	    	Conexao.fecharConexao(conn, pstmt, rs);
	    }
	    
		BoxContaBanco.setBounds(227, 125, 313, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel label_1 = new JLabel("N\u00BA CONTA BANCO");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(237, 110, 231, 16);
		contentPane.add(label_1);
		
		JComboBox BoxFavorecido = new JComboBox();
		BoxFavorecido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// PESSOA FISICA
				
				String transacao_pf_pj = String.valueOf(BoxFavorecido.getSelectedItem());				
				if(!transacao_pf_pj.equals("") && !transacao_pf_pj.equals("null") && !transacao_pf_pj.equals(null))
				{	
					// Seleciona o ID do favorecido escolhido PF pelo usuário
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
					// Seleciona o ID do favorecido PJ escolhido pelo usuário
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
					    	Conexao.fecharConexao(connn, pstmtt, rss);					    
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
		BoxFavorecido.setBounds(227, 188, 641, 35);
		contentPane.add(BoxFavorecido);
		
		JLabel label_2 = new JLabel("FAVORECIDO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(237, 172, 631, 16);
		contentPane.add(label_2);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				// 	PESSOA FISICA
				
				if(BoxTipo.getSelectedItem() == "PESSOA FÍSICA")
				{	
					BoxFavorecido.removeAllItems();
					Transacao.FK_cnpj = 0;
					Transacao.FK_cpf = 0;
					// PREENCHE COMBO BOX COM NOMES PF
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
				
				
				if(BoxTipo.getSelectedItem() == "PESSOA JURÍDICA") 
				{	
					BoxFavorecido.removeAllItems();
					Transacao.FK_cnpj = 0;
					Transacao.FK_cpf = 0;
					// PREENCHE COMBO BOX COM NOMES PJ
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
				    	Conexao.fecharConexao(conn, pstmt, rs);				    
				    }
				    
				    
				}
				
			}
		});
		BoxTipo.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "PESSOA F\u00CDSICA", "PESSOA JUR\u00CDDICA"}));
		BoxTipo.setForeground(Color.GRAY);
		BoxTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipo.setBounds(555, 125, 313, 35);
		contentPane.add(BoxTipo);
		
		JLabel label_3 = new JLabel("TIPO DE FAVORECIDO");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(565, 111, 231, 16);
		contentPane.add(label_3);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(227, 251, 170, 28);
		contentPane.add(textValor);
		
		JLabel label_4 = new JLabel("VALOR");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(237, 235, 128, 16);
		contentPane.add(label_4);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(407, 251, 170, 28);
		contentPane.add(textData);
		
		JLabel label_5 = new JLabel("DATA");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(414, 235, 128, 16);
		contentPane.add(label_5);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaTransacao tt = new ConsultaTransacao();
                tt.dispose();
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(ConsultaTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(515, 341, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textValor.getText().equals(""))
				{	
					Transacao.valor = Double.parseDouble(textValor.getText());
				}
				if(!textData.getText().equals(""))
				{	
					Transacao.dataTransacao = textData.getText();
				}	
				// Pesquisa pelo nome e CNPJ
				String sql = "select * from transacao left OUTER JOIN bancos on transacao.FK_idBancos = bancos.idBancos left OUTER JOIN pessoaJuridica on transacao.FK_cnpj = pessoaJuridica.cnpj left OUTER JOIN pessoaFisica on transacao.FK_cpf = pessoaFisica.cpf left OUTER JOIN receita on transacao.FK_idReceita = receita.idReceita left OUTER JOIN despesa on transacao.FK_idDespesa = despesa.idDespesa "
						+ "WHERE FK_cnpj LIKE ('%" 
		                + Transacao.FK_cnpj 
		                + "%') AND FK_cpf LIKE ('%"
		                + Transacao.FK_cpf
		                + "%') AND dataTransacao LIKE ('%"
		                + textData.getText()
		                + "%') AND valor LIKE ('%"
		                + textValor.getText()
		                + "%') AND FK_idBancos LIKE ('%"
		                + Transacao.FK_idBancos
		                + "%') ORDER BY dataTransacao ASC;";				
				preencherTabela(sql);
				limparCampos();
				BoxFavorecido.removeAllItems();
				Transacao.valor = null;
				Transacao.dataTransacao = "";
				Transacao.FK_cnpj = 0;
				Transacao.FK_cpf = 0;
				
				
			}
		});
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(227, 291, 125, 28);
		contentPane.add(btnBuscar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaTransacao tp = new ConsultaTransacao();
                tp.dispose();                
                TelaTransacao tt = new TelaTransacao();
                tt.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(743, 291, 125, 28);
		contentPane.add(btnVoltar);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(16, 386, 1051, 265);
		contentPane.add(scrollPane);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultaTransacao spj = new ConsultaTransacao();
                spj.dispose();                
                AtualizarTransacao apj = new AtualizarTransacao();
                apj.setVisible(true); 
                
                int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável
    			Transacao.FK_idBancos = Integer.parseInt((table.getValueAt(linha, 9).toString()));
    			Transacao.FK_cpf = Long.parseLong((table.getValueAt(linha, 12).toString()));
				Transacao.FK_cnpj = Long.parseLong((table.getValueAt(linha, 13).toString()));
				Transacao.FK_idReceita = Integer.parseInt((table.getValueAt(linha, 10).toString()));
				Transacao.FK_idDespesa = Integer.parseInt((table.getValueAt(linha, 11).toString()));
    			
			}
		});
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(391, 291, 125, 28);
		contentPane.add(btnAlterar);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 0 																									
  				//"N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONTABIL", "NOME CONT\u00C1BIL",
				//			   6	     		  7			8		 9             10                  11          12         13
				//"TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR", "FK_IDBANCOS", "FK_IDRECEITA", "FK_IDDESPESA", "FK_IDPF", "FK_IDPJ"
								
				int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável
				Transacao.idTransacao = Integer.parseInt((table.getValueAt(linha, 0).toString()));
				Transacao.tipo = (table.getValueAt(linha, 6).toString());
				Transacao.dataTransacao = (table.getValueAt(linha, 7).toString());
				Transacao.valor = Double.parseDouble((table.getValueAt(linha, 8).toString()));
				Transacao.FK_idBancos = Integer.parseInt((table.getValueAt(linha, 9).toString())); 
				Transacao.FK_idReceita = Integer.parseInt((table.getValueAt(linha, 10).toString()));
				Transacao.FK_idDespesa = Integer.parseInt((table.getValueAt(linha, 11).toString()));
				Transacao.FK_cpf = Long.parseLong((table.getValueAt(linha, 12).toString()));
				Transacao.FK_cnpj = Long.parseLong((table.getValueAt(linha, 13).toString()));
				//Transacao.nome_pf_pf = BoxFavorecido.getSelectedIndex();
				
				Connection conn = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    conn = Conexao.getConexao(); //conectar ao banco de dados			        
		        
			    String sql2 = "SELECT descricao FROM transacao WHERE idTransacao = "+Transacao.idTransacao+";";

			    try
			    {
			        pstmt = conn.prepareStatement(sql2);
			        rs = pstmt.executeQuery();
			        Transacao.descricao = rs.getString("descricao");				        
			    }
			    catch(SQLException ex)
			    {
			    	JOptionPane.showMessageDialog(null, "Erro ao preencher PJ BoxTipoFavorecido. Erro: " + ex);
			    }
			    finally
			    {
			    	Conexao.fecharConexao(conn, pstmt, rs);				    
			    }
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONTABIL", "NOME CONT\u00C1BIL", "TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR", "FK_IDBANCOS", "FK_IDRECEITA", "FK_IDDESPESA", "FK_IDPF", "FK_IDPJ"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(240);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(240);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(110);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(0);
		table.getColumnModel().getColumn(9).setMinWidth(0);
		table.getColumnModel().getColumn(9).setMaxWidth(0);
		table.getColumnModel().getColumn(10).setPreferredWidth(0);
		table.getColumnModel().getColumn(10).setMinWidth(0);
		table.getColumnModel().getColumn(10).setMaxWidth(0);
		table.getColumnModel().getColumn(11).setPreferredWidth(0);
		table.getColumnModel().getColumn(11).setMinWidth(0);
		table.getColumnModel().getColumn(11).setMaxWidth(0);
		table.getColumnModel().getColumn(12).setPreferredWidth(0);
		table.getColumnModel().getColumn(12).setMinWidth(0);
		table.getColumnModel().getColumn(12).setMaxWidth(0);
		table.getColumnModel().getColumn(13).setPreferredWidth(0);
		table.getColumnModel().getColumn(13).setMinWidth(0);
		table.getColumnModel().getColumn(13).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(10).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(10).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(11).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(12).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(13).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(0);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável
			Transacao.FK_idBancos = Integer.parseInt((table.getValueAt(linha, 9).toString()));
			Transacao.FK_cpf = Long.parseLong((table.getValueAt(linha, 12).toString()));
			Transacao.FK_cnpj = Long.parseLong((table.getValueAt(linha, 13).toString()));
                
			}
		});
		scrollPane.setViewportView(table);
		
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j = String.valueOf(Transacao.idTransacao);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para deletar");
		        }
		        else
		        {	
		        	TransacaoControle jc = new TransacaoControle();
				    jc.Deletar();				    
				    String sql = "select * from transacao left OUTER JOIN bancos on transacao.FK_idBancos = bancos.idBancos left OUTER JOIN pessoaJuridica on transacao.FK_cnpj = pessoaJuridica.cnpj left OUTER JOIN pessoaFisica on transacao.FK_cpf = pessoaFisica.cpf left OUTER JOIN receita on transacao.FK_idReceita = receita.idReceita left OUTER JOIN despesa on transacao.FK_idDespesa = despesa.idDespesa ORDER BY dataTransacao ASC;"; 
				    preencherTabela(sql);		        	
		        }
				
			}
		});
		btnExcluir.setForeground(Color.GRAY);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(565, 291, 125, 28);
		contentPane.add(btnExcluir);
	}
	
	public void limparCampos() 
	{   
		textValor.setText("");
	    textData.setText("");	    
	    
	}
	
}
