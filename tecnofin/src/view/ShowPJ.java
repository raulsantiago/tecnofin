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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexao;
import control.JuridicaControle;
import control.ReceitaControle;
import model.PessoaJuridica;
import model.Receita;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShowPJ extends JFrame {

	private JPanel contentPane;
	private JTextField textRazao;
	private JTextField textCnpj;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPJ frame = new ShowPJ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void limparCampos() 
	{   	    		
		textRazao.setText("");
		textCnpj.setText("");
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
                    rs.getString("nomePJ"),
                    rs.getString("cnpj"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("dataCadastro"),
                    rs.getString("FK_idCadastro"),
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
	public ShowPJ() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				String sql = "SELECT * FROM pessoaJuridica, cadastro where FK_idCadastro = idCadastro ORDER BY nomePJ ASC;";
				preencherTabela(sql);
			}
		});
		setMaximumSize(new Dimension(1200, 700));
		setMinimumSize(new Dimension(1200, 700));
		setPreferredSize(new Dimension(1200, 700));
		setSize(new Dimension(1200, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowPJ.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Pessoa Jur\u00EDdica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1184, 661);
		contentPane.add(panel);
		
		JLabel lblRazoSocial = new JLabel("RAZ\u00C3O SOCIAL");
		lblRazoSocial.setForeground(Color.GRAY);
		lblRazoSocial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRazoSocial.setBounds(299, 98, 115, 16);
		panel.add(lblRazoSocial);
		
		textRazao = new JTextField();
		textRazao.setColumns(10);
		textRazao.setBounds(288, 113, 426, 28);
		panel.add(textRazao);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setForeground(Color.GRAY);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(752, 98, 115, 16);
		panel.add(lblCnpj);
		
		textCnpj = new JTextField();
		textCnpj.setColumns(10);
		textCnpj.setBounds(740, 113, 203, 28);
		panel.add(textCnpj);
		
		JLabel lblPessoaJurdica = new JLabel("PESSOA JUR\u00CDDICA");
		lblPessoaJurdica.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPessoaJurdica.setHorizontalAlignment(SwingConstants.CENTER);
		lblPessoaJurdica.setForeground(Color.GRAY);
		lblPessoaJurdica.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPessoaJurdica.setBounds(442, 27, 299, 50);
		panel.add(lblPessoaJurdica);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pesquisa pelo nome e CNPJ
				String sql = "SELECT * FROM pessoaJuridica, cadastro WHERE cnpj LIKE ('%" 
		                + textCnpj.getText() 
		                + "%') AND nomePJ LIKE ('%"
		                + textRazao.getText()
		                + "%') AND FK_idCadastro = idCadastro"
		                + " ORDER BY nomePJ ASC;";				
				preencherTabela(sql);
				limparCampos();
				
			}
		});
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(288, 168, 125, 28);
		panel.add(btnBuscar);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowPJ spj = new ShowPJ();
                spj.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(ShowPJ.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(565, 218, 53, 36);
		panel.add(btnHome);
		
		JButton btnAlterar = new JButton("ALTERAR/DETALHAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ShowPJ spj = new ShowPJ();
                spj.dispose();                
                AtualizarPJ apj = new AtualizarPJ();
                apj.setVisible(true);
				
			}
		});
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(442, 168, 203, 28);
		panel.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowPJ spj = new ShowPJ();
                spj.dispose();                
				TelaPJ tpj = new TelaPJ();
				tpj.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(818, 168, 125, 28);
		panel.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 293, 1125, 348);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável da Receita
				PessoaJuridica.cnpj = Long.parseLong((table.getValueAt(linha, 1).toString()));
				PessoaJuridica.FK_idCadastro = Integer.parseInt((table.getValueAt(linha, 6).toString())); 
				
				Connection conn = null;        
		        conn = Conexao.getConexao(); //conectar ao banco de dados
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
				
				String sql = "SELECT * FROM pessoaJuridica, cadastro WHERE cnpj LIKE ('" 
		                + PessoaJuridica.cnpj
		                + "') AND FK_idCadastro = idCadastro;";
		                
		         try
		        {
		            pstmt = conn.prepareStatement(sql);		            
		            rs = pstmt.executeQuery();
		            
		            PessoaJuridica.nomePJ = rs.getString("nomePJ");
		            PessoaJuridica.bancoNomePJ = rs.getString("bancoNomePJ");
		            PessoaJuridica.bancoNumPJ = rs.getInt("bancoNumPJ");
		            PessoaJuridica.agenciaPJ = rs.getString("agenciaPJ");
		            PessoaJuridica.tipoContaPJ = rs.getString("tipoContaPJ");
    				PessoaJuridica.contaNumPJ = rs.getString("contaNumPJ");
    				PessoaJuridica.email = rs.getString("email");
		            PessoaJuridica.telefone = rs.getString("telefone");
		            PessoaJuridica.celular = rs.getString("celular");
    				PessoaJuridica.endereco = rs.getString("endereco");
    				PessoaJuridica.numero = rs.getString("numero");
    				PessoaJuridica.complemento = rs.getString("complemento");
    				PessoaJuridica.uf = rs.getString("uf");
    				PessoaJuridica.cidade = rs.getString("cidade");
    				PessoaJuridica.bairro = rs.getString("bairro");
    				PessoaJuridica.cep = rs.getString("cep");
    				PessoaJuridica.notas = rs.getString("notas");
    				Conexao.fecharConexao(conn, pstmt, rs);
		             
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
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"RAZ\u00C3O SOCIAL", "CNPJ", "E-MAIL", "TELEFONE", "CELULAR", "DATA CADASTRO", "FK_IDCADASTRO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(115);
		table.getColumnModel().getColumn(6).setPreferredWidth(0);
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
		scrollPane.setViewportView(table);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j = String.valueOf(PessoaJuridica.cnpj);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para deletar");
		        }
		        else
		        {
		        	
		        	
		        	JuridicaControle jc = new JuridicaControle();
				    jc.Deletar();				    
				    String sql = "SELECT * FROM pessoaJuridica, cadastro where FK_idCadastro = idCadastro ORDER BY nomePJ ASC;";
				    preencherTabela(sql);		        	
		        }		        
			}
		});
		btnExcluir.setForeground(Color.GRAY);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(670, 168, 125, 28);
		panel.add(btnExcluir);
	}

}
