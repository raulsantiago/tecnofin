package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import conexoes.Conexao;
import model.Transacao;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class RelatorioTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textDataInicio;
	private JTextField textDataFinal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioTransacao frame = new RelatorioTransacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void limparCampos() 
	{   	    		
		textDataInicio.setText("");
		textDataFinal.setText("");
	}
	
	
	// "N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR"
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
               		String.valueOf((rs.getString("cnpj") == null) ? rs.getString("cpf") : rs.getString("cnpj")), 
               		String.valueOf((rs.getString("nomePJ") == null) ? rs.getString("nomePF") : rs.getString("nomePJ")),
               		String.valueOf((rs.getString("contaDespesa") == null) ? rs.getString("contaReceita") : rs.getString("contaDespesa")),
               		String.valueOf((rs.getString("nomeDespesa") == null) ? rs.getString("nomeReceita") : rs.getString("nomeDespesa")),
                    rs.getString("tipo"),
                    rs.getString("dataTransacao"),
                    rs.getString("valor"),
                    
                });
            }		           
        }
        catch(SQLException ex)
        {
        	JOptionPane.showMessageDialog(null, "Erro ao exibir o banco de dados. Erro: " + ex);
        }
        finally
        {
        	Conexao.fecharConexao(conn, pstmt, rs);
        }
	}

	

	/**
	 * Create the frame.
	 */
	public RelatorioTransacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setPreferredSize(new Dimension(900, 700));
		setMaximumSize(new Dimension(900, 700));
		setMinimumSize(new Dimension(900, 700));
		setSize(new Dimension(900, 700));
		setTitle("Relat\u00F3rio das Transa\u00E7\u00F5es Banc\u00E1rias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatrioDasTransaes = new JLabel("RELAT\u00D3RIO DAS TRANSA\u00C7\u00D5ES BANC\u00C1RIAS\r\n");
		lblRelatrioDasTransaes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatrioDasTransaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDasTransaes.setForeground(Color.GRAY);
		lblRelatrioDasTransaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatrioDasTransaes.setBounds(89, 20, 706, 50);
		contentPane.add(lblRelatrioDasTransaes);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioTransacao rg = new RelatorioTransacao();
                rg.dispose();
                TelaPrincipal tp = new TelaPrincipal();                
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(RelatorioTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(810, 94, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioTransacao ts = new RelatorioTransacao();
                ts.dispose();
                RelatorioConferencia rg = new RelatorioConferencia();                
                rg.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(659, 98, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnGerar = new JButton("GERAR");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pesquisa data inicial e fianl e numero conta
				
				String sql = "select * from transacao left OUTER JOIN bancos on transacao.FK_idBancos = bancos.idBancos left OUTER JOIN pessoaJuridica on transacao.FK_cnpj = pessoaJuridica.cnpj left OUTER JOIN pessoaFisica on transacao.FK_cpf = pessoaFisica.cpf left OUTER JOIN receita on transacao.FK_idReceita = receita.idReceita left OUTER JOIN despesa on transacao.FK_idDespesa = despesa.idDespesa AND dataTransacao BETWEEN ('"+textDataInicio.getText()+"') AND ('"+ textDataFinal.getText()+"') WHERE FK_idBancos = '"+Transacao.FK_idBancos+"' ORDER BY dataTransacao ASC;";				
				preencherTabela(sql);
				limparCampos();
				
			}
		});
		btnGerar.setForeground(Color.GRAY);
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerar.setBounds(508, 98, 125, 28);
		contentPane.add(btnGerar);
		
		JLabel label_1 = new JLabel("DATA INICIAL");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(27, 84, 93, 16);
		contentPane.add(label_1);
		
		textDataInicio = new JTextField();
		textDataInicio.setColumns(10);
		textDataInicio.setBounds(21, 99, 108, 28);
		contentPane.add(textDataInicio);
		
		JLabel label_2 = new JLabel("DATA FINAL");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(150, 84, 93, 16);
		contentPane.add(label_2);
		
		textDataFinal = new JTextField();
		textDataFinal.setColumns(10);
		textDataFinal.setBounds(144, 99, 108, 28);
		contentPane.add(textDataFinal);
		
		JComboBox BoxContaBanco = new JComboBox();		
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
		BoxContaBanco.setBounds(261, 95, 231, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel lblNContaBanco = new JLabel("N\u00BA CONTA BANCO");
		lblNContaBanco.setForeground(Color.GRAY);
		lblNContaBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNContaBanco.setBounds(267, 80, 198, 16);
		contentPane.add(lblNContaBanco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 158, 851, 491);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		scrollPane.setViewportView(table);
	}

}
