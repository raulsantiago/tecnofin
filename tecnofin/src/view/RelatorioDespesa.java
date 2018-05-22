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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexao;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import model.Transacao;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class RelatorioDespesa extends JFrame {

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
					RelatorioDespesa frame = new RelatorioDespesa();
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
	
//"N\u00BA", "NOME BANCO", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
	 
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
               		String.valueOf((rs.getString("contaDespesa") == null) ? rs.getString("contaDespesa") : rs.getString("contaDespesa")),
               		String.valueOf((rs.getString("nomeDespesa") == null) ? rs.getString("nomeDespesa") : rs.getString("nomeDespesa")),
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
	public RelatorioDespesa() {
		setMaximumSize(new Dimension(900, 500));
		setMinimumSize(new Dimension(900, 500));
		setPreferredSize(new Dimension(900, 500));
		setSize(new Dimension(900, 500));
		setTitle("Relat\u00F3rio de Despesas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioDespesa.class.getResource("/Imagem/money-icon-title.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatrioDasDespesas = new JLabel("RELAT\u00D3RIO DAS DESPESAS\r\n");
		lblRelatrioDasDespesas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatrioDasDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDasDespesas.setForeground(Color.GRAY);
		lblRelatrioDasDespesas.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatrioDasDespesas.setBounds(180, 2, 524, 50);
		contentPane.add(lblRelatrioDasDespesas);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioDespesa rg = new RelatorioDespesa();
                rg.dispose();
                TelaPrincipal tp = new TelaPrincipal();                
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(RelatorioDespesa.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(725, 81, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioDespesa ts = new RelatorioDespesa();
                ts.dispose();
                RelatorioGerencial rg = new RelatorioGerencial();                
                rg.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(574, 85, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnGerar = new JButton("GERAR");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//"N\u00BA", "NOME BANCO", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
				// Pesquisa data inicial e fianal
				String sql = "select * from transacao left OUTER JOIN bancos on transacao.FK_idBancos = bancos.idBancos left OUTER JOIN pessoaJuridica on transacao.FK_cnpj = pessoaJuridica.cnpj left OUTER JOIN pessoaFisica on transacao.FK_cpf = pessoaFisica.cpf left OUTER JOIN receita on transacao.FK_idReceita = receita.idReceita left OUTER JOIN despesa on transacao.FK_idDespesa = despesa.idDespesa AND dataTransacao BETWEEN ('"+textDataInicio.getText()+"') AND ('"+ textDataFinal.getText()+"') WHERE FK_idDespesa = idDespesa ORDER BY dataTransacao ASC;";
				preencherTabela(sql);
				limparCampos();
			}
		});
		btnGerar.setForeground(Color.GRAY);
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerar.setBounds(423, 85, 125, 28);
		contentPane.add(btnGerar);
		
		JLabel label_1 = new JLabel("DATA INICIAL");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(136, 71, 93, 16);
		contentPane.add(label_1);
		
		textDataInicio = new JTextField();
		textDataInicio.setColumns(10);
		textDataInicio.setBounds(130, 86, 108, 28);
		contentPane.add(textDataInicio);
		
		JLabel label_2 = new JLabel("DATA FINAL");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(259, 71, 93, 16);
		contentPane.add(label_2);
		
		textDataFinal = new JTextField();
		textDataFinal.setColumns(10);
		textDataFinal.setBounds(253, 86, 108, 28);
		contentPane.add(textDataFinal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 141, 866, 314);
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
			},
			new String[] {
				"N\u00BA", "NOME BANCO", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(130);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setPreferredWidth(130);
		scrollPane.setViewportView(table);
	}

}
