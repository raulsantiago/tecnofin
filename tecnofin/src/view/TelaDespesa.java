package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexao;
import control.DespesaControle;
import control.ReceitaControle;
import model.Despesa;
import model.Receita;
import java.awt.Color;

public class TelaDespesa extends JFrame {

	private JPanel contentPane;
	private JTextField textContaDespesa;
	private JTextField textNomeDespesa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDespesa frame = new TelaDespesa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void limparCampos() 
	{
		textContaDespesa.setText("");
		textNomeDespesa.setText("");
	}
	
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
                    rs.getString("contaDespesa"),
                    rs.getString("nomeDespesa"),
                    rs.getString("idDespesa"),
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
	public TelaDespesa() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				String sql = "SELECT * FROM despesa ORDER BY contaDespesa ASC;";
				preencherTabela(sql);
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDespesa.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Despesas");
		setPreferredSize(new Dimension(650, 500));
		setMaximumSize(new Dimension(650, 500));
		setMinimumSize(new Dimension(650, 500));
		setSize(new Dimension(650, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 634, 461);
		contentPane.add(panel);
		
		JLabel lblPlanoDeContas = new JLabel("PLANO DE CONTAS A PAGAR");
		lblPlanoDeContas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlanoDeContas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlanoDeContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanoDeContas.setForeground(Color.GRAY);
		lblPlanoDeContas.setBounds(170, 48, 293, 16);
		panel.add(lblPlanoDeContas);
		
		JLabel lblDespesas = new JLabel("DESPESAS");
		lblDespesas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespesas.setForeground(Color.GRAY);
		lblDespesas.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDespesas.setBounds(197, 20, 239, 26);
		panel.add(lblDespesas);
		
		JLabel label_2 = new JLabel("CONTA CONT\u00C1BIL");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(80, 78, 111, 16);
		panel.add(label_2);
		
		JLabel lblNomeDaDespesa = new JLabel("NOME DA DESPESA");
		lblNomeDaDespesa.setForeground(Color.GRAY);
		lblNomeDaDespesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDaDespesa.setBounds(247, 77, 155, 16);
		panel.add(lblNomeDaDespesa);
		
		textContaDespesa = new JTextField();
		textContaDespesa.setColumns(10);
		textContaDespesa.setBounds(76, 92, 154, 28);
		panel.add(textContaDespesa);
		
		textNomeDespesa = new JTextField();
		textNomeDespesa.setColumns(10);
		textNomeDespesa.setBounds(242, 92, 263, 28);
		panel.add(textNomeDespesa);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Despesa.contaDespesa = textContaDespesa.getText();
				Despesa.nomeDespesa = textNomeDespesa.getText();
				DespesaControle rc = new DespesaControle();
			    rc.salvar();
			    limparCampos();
			    String sql = "SELECT * FROM despesa ORDER BY contaDespesa ASC;";	      
			    preencherTabela(sql);
			      
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(75, 127, 95, 36);
		panel.add(btnSalvar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setPreferredSize(new Dimension(73, 28));
		btnAlterar.setMinimumSize(new Dimension(73, 28));
		btnAlterar.setMaximumSize(new Dimension(73, 28));
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				String j = String.valueOf(Despesa.idDespesa);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para atualizar");
		        }
		        else
		        {
		        	Despesa.contaDespesa = textContaDespesa.getText();
		        	Despesa.nomeDespesa = textNomeDespesa.getText(); 
		        	DespesaControle rc = new DespesaControle();
				    rc.Atualizar();
				    limparCampos();
				    String sql = "SELECT * FROM despesa ORDER BY contaDespesa ASC;";
				    preencherTabela(sql);
		        }
		        
			}
		});
		btnAlterar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(306, 127, 95, 36);
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setMaximumSize(new Dimension(73, 28));
		btnExcluir.setMinimumSize(new Dimension(73, 28));
		btnExcluir.setPreferredSize(new Dimension(73, 28));
		btnExcluir.setForeground(Color.GRAY);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            
				String j = String.valueOf(Despesa.idDespesa);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para deletar");
		        }
		        else
		        {
		        	DespesaControle rc = new DespesaControle();
				    rc.Deletar();
				    limparCampos();
				    String sql = "SELECT * FROM despesa ORDER BY contaDespesa ASC;";
				    preencherTabela(sql);		        	
		        }
			}
		});
		btnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(410, 127, 95, 36);
		panel.add(btnExcluir);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setForeground(Color.GRAY);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pesquisa pelo nome e código
				String sql = "SELECT * FROM despesa WHERE nomeDespesa LIKE ('%" 
		                + textNomeDespesa.getText() 
		                + "%') AND contaDespesa LIKE ('%"
		                + textContaDespesa.getText()
		                + "%')"
		                + " ORDER BY contaDespesa ASC;";				
				preencherTabela(sql);
				limparCampos();
		        
			}
		});		
		btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultar.setBounds(173, 127, 127, 36);
		panel.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.GRAY);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setBounds(35, 201, 575, 206);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável da Despesa
		        textContaDespesa.setText(table.getValueAt(linha, 0).toString());
		        textNomeDespesa.setText(table.getValueAt(linha, 1).toString());
		        Despesa.idDespesa = Integer.parseInt((table.getValueAt(linha, 2).toString()));
		        Despesa.contaDespesa = textContaDespesa.getText();
		        Despesa.nomeDespesa = textNomeDespesa.getText();
		       
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00D3DIGO CONTA CONT\u00C1BIL", "NOME DA DESPESA", "ID DESPESA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(142);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getColumnModel().getColumn(2).setMaxWidth(15);
		table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaDespesa tr = new TelaDespesa();
                tr.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaDespesa.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnVoltar.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVoltar.setBounds(290, 416, 53, 36);
		panel.add(btnVoltar);
	}
}
