package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexao;
import model.Transacao;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class RelatorioReceita extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textDataInicio;
	private JTextField textDataFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioReceita frame = new RelatorioReceita();
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
	
//"N\u00BA", "NOME DO BANCO", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
	// FALTA IMPLEMENTAR AS COLUnAS CNPJ/CPF + NOME PF/PJ 
	public void preencherTabela(String sql)
	{
		double valoracumulado = 0;
		DecimalFormat formato = new DecimalFormat("#.##");
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
                    String.valueOf(rs.getString("contaNum")+" "+rs.getString("nome")),
                    String.valueOf((rs.getString("cnpj") == null) ? rs.getString("cpf") : rs.getString("cnpj")), 
               		String.valueOf((rs.getString("nomePJ") == null) ? rs.getString("nomePF") : rs.getString("nomePJ")),
               		String.valueOf((rs.getString("contaReceita") == null) ? rs.getString("contaReceita") : rs.getString("contaReceita")),
               		String.valueOf((rs.getString("nomeReceita") == null) ? rs.getString("nomeReceita") : rs.getString("nomeReceita")),
                    rs.getString("tipo"),
                    rs.getString("dataTransacao"),                    
                    String.valueOf(formato.format(Double.valueOf(rs.getString("valor")))),                    
                    String.valueOf(formato.format(valoracumulado = valoracumulado+Double.valueOf(rs.getString("valor")))),
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
	public RelatorioReceita() {
		setMaximumSize(new Dimension(900, 500));
		setMinimumSize(new Dimension(900, 500));
		setPreferredSize(new Dimension(900, 500));
		setSize(new Dimension(900, 500));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioReceita.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Relat\u00F3rio das Receitas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatrioDasReceitas = new JLabel("RELAT\u00D3RIO DAS RECEITAS\r\n");
		lblRelatrioDasReceitas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatrioDasReceitas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDasReceitas.setForeground(Color.GRAY);
		lblRelatrioDasReceitas.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatrioDasReceitas.setBounds(180, 3, 524, 50);
		contentPane.add(lblRelatrioDasReceitas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 130, 872, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "NOME DO BANCO", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setPreferredWidth(160);
		table.getColumnModel().getColumn(6).setPreferredWidth(130);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setPreferredWidth(130);
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioReceita rg = new RelatorioReceita();
                rg.dispose();
                TelaPrincipal tp = new TelaPrincipal();                
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(RelatorioReceita.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(726, 85, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioReceita ts = new RelatorioReceita();
                ts.dispose();
                RelatorioGerencial rg = new RelatorioGerencial();                
                rg.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(575, 89, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnGerar = new JButton("GERAR");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//"N\u00BA", "NOME DO BANCO", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
				// Pesquisa data inicial e final
				
				String sql = "select * from transacao left OUTER JOIN bancos on transacao.FK_idBancos = bancos.idBancos left OUTER JOIN pessoaJuridica on transacao.FK_cnpj = pessoaJuridica.cnpj left OUTER JOIN pessoaFisica on transacao.FK_cpf = pessoaFisica.cpf left OUTER JOIN receita on transacao.FK_idReceita = receita.idReceita left OUTER JOIN despesa on transacao.FK_idDespesa = despesa.idDespesa AND dataTransacao BETWEEN ('"+textDataInicio.getText()+"') AND ('"+ textDataFinal.getText()+"') WHERE FK_idReceita = idReceita ORDER BY dataTransacao ASC;";
				preencherTabela(sql);
				limparCampos();				
			}
		});
		btnGerar.setForeground(Color.GRAY);
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerar.setBounds(424, 89, 125, 28);
		contentPane.add(btnGerar);
		
		JLabel lblDataInicial = new JLabel("DATA INICIAL");
		lblDataInicial.setForeground(Color.GRAY);
		lblDataInicial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInicial.setBounds(137, 75, 93, 16);
		contentPane.add(lblDataInicial);
		
		textDataInicio = new JTextField();
		textDataInicio.setColumns(10);
		textDataInicio.setBounds(131, 90, 108, 28);
		contentPane.add(textDataInicio);
		
		JLabel lblDataFinal = new JLabel("DATA FINAL");
		lblDataFinal.setForeground(Color.GRAY);
		lblDataFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFinal.setBounds(260, 75, 93, 16);
		contentPane.add(lblDataFinal);
		
		textDataFinal = new JTextField();
		textDataFinal.setColumns(10);
		textDataFinal.setBounds(254, 90, 108, 28);
		contentPane.add(textDataFinal);
	}
}
