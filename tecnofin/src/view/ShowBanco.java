package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexao;
import control.BancoControle;
import control.JuridicaControle;
import model.Banco;
import model.PessoaJuridica;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ShowBanco extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textAgencia;
	private JTextField textNumero;
	private JTextField textTipoConta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowBanco frame = new ShowBanco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void limparCampos() 
	{   	    		
		textNome.setText("");
		textAgencia.setText("");
		textNumero.setText("");
		textTipoConta.setText("");
	}
	
	//"NOME DO BANCO", "TIPO CONTA", "N\u00BA CONTA", "SALDO", "GERENTE", "TELEFONE", "CELULAR", "E-MAIL", "IDBANCOS", "FK_IDCADASTRO"
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
                    rs.getString("nome"),
                    rs.getString("tipoConta"),
                    rs.getString("contaNum"),
                    rs.getString("saldo"),
                    rs.getString("gerente"),                    
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("idBancos"),
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
	public ShowBanco() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				String sql = "SELECT * FROM bancos, cadastro where FK_idCadastro = idCadastro ORDER BY nome ASC;";
				preencherTabela(sql);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowBanco.class.getResource("/Imagem/money-icon-title.jpg")));
		setMaximumSize(new Dimension(1200, 700));
		setMinimumSize(new Dimension(1200, 700));
		setPreferredSize(new Dimension(1200, 700));
		setSize(new Dimension(1200, 700));
		setTitle("Bancos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanco = new JLabel("BANCOS");
		lblBanco.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBanco.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanco.setForeground(Color.GRAY);
		lblBanco.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBanco.setBounds(442, 25, 299, 50);
		contentPane.add(lblBanco);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pesquisa pelo nome do banco, agencia, numero da conta e tipo de conta 
				String sql = "SELECT * FROM bancos, cadastro WHERE nome LIKE ('%" 
		                + textNome.getText() 
		                + "%') AND agencia LIKE ('%"
		                + textAgencia.getText()
		                + "%') AND numeroB LIKE ('%"
		                + textNumero.getText()
		                + "%') AND tipoConta LIKE ('%"
		                + textTipoConta.getText()
		                + "%') AND FK_idCadastro = idCadastro"
		                + " ORDER BY nome ASC;";				
				preencherTabela(sql);
				limparCampos();
				
			}
		});
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(217, 171, 125, 28);
		contentPane.add(btnBuscar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowBanco spj = new ShowBanco();
                spj.dispose();                
				TelaBanco tpj = new TelaBanco();
				tpj.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(827, 171, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnAlterar = new JButton("ALTERAR/DETALHAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowBanco spj = new ShowBanco();
                spj.dispose();                
                AtualizarBanco apj = new AtualizarBanco();
                apj.setVisible(true);
			}
		});
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(380, 171, 238, 28);
		contentPane.add(btnAlterar);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowBanco spj = new ShowBanco();
                spj.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(ShowBanco.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(565, 221, 53, 36);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("NOME DO BANCO");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(217, 100, 118, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAgncia = new JLabel("AG\u00CANCIA");
		lblAgncia.setForeground(Color.GRAY);
		lblAgncia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgncia.setBounds(499, 100, 118, 16);
		contentPane.add(lblAgncia);
		
		JLabel lblNConta = new JLabel("N\u00BA CONTA");
		lblNConta.setForeground(Color.GRAY);
		lblNConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNConta.setBounds(629, 100, 118, 16);
		contentPane.add(lblNConta);
		
		JLabel lblTipoDeConta = new JLabel("TIPO DE CONTA");
		lblTipoDeConta.setForeground(Color.GRAY);
		lblTipoDeConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeConta.setBounds(766, 100, 118, 16);
		contentPane.add(lblTipoDeConta);
		
		textNome = new JTextField();
		textNome.setBounds(213, 116, 263, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textAgencia = new JTextField();
		textAgencia.setBounds(484, 117, 122, 28);
		contentPane.add(textAgencia);
		textAgencia.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(615, 117, 122, 28);
		contentPane.add(textNumero);
		
		textTipoConta = new JTextField();
		textTipoConta.setColumns(10);
		textTipoConta.setBounds(749, 116, 203, 28);
		contentPane.add(textTipoConta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 300, 1143, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável da Receita
				Banco.idBancos = Integer.parseInt((table.getValueAt(linha, 8).toString()));
				Banco.FK_idCadastro = Integer.parseInt((table.getValueAt(linha, 9).toString())); 
				
				Connection conn = null;        
		        conn = Conexao.getConexao(); //conectar ao banco de dados
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
				
				String sql = "SELECT * FROM bancos, cadastro WHERE idBancos LIKE ('" 
		                + Banco.idBancos
		                + "') AND FK_idCadastro = idCadastro;";
		                
		         try
		        {
		            pstmt = conn.prepareStatement(sql);		            
		            rs = pstmt.executeQuery();
		            
		            Banco.cnpj = rs.getLong("cnpj");
		            Banco.nome = rs.getString("nome");
		            Banco.bancoNum = rs.getInt("numeroB");		            
		            Banco.agencia = rs.getString("agencia");
		            Banco.tipoConta = rs.getString("tipoConta");
    				Banco.contaNum = rs.getString("contaNum");
    				Banco.gerente = rs.getString("gerente");
    				Banco.saldo = rs.getDouble("saldo");
    				Banco.email = rs.getString("email");
		            Banco.telefone = rs.getString("telefone");
		            Banco.celular = rs.getString("celular");
    				Banco.endereco = rs.getString("endereco");
    				Banco.numero = rs.getString("numero");
    				Banco.complemento = rs.getString("complemento");
    				Banco.uf = rs.getString("uf");
    				Banco.cidade = rs.getString("cidade");
    				Banco.bairro = rs.getString("bairro");
    				Banco.cep = rs.getString("cep");
    				Banco.notas = rs.getString("notas");
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
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"NOME DO BANCO", "TIPO CONTA", "N\u00BA CONTA", "SALDO", "GERENTE", "TELEFONE", "CELULAR", "E-MAIL", "IDBANCOS", "FK_IDCADASTRO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(114);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(7).setPreferredWidth(82);
		table.getColumnModel().getColumn(8).setMinWidth(0);
		table.getColumnModel().getColumn(8).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);		
		table.getColumnModel().getColumn(9).setMinWidth(0);
		table.getColumnModel().getColumn(9).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(9).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(9).setMaxWidth(0);
		scrollPane.setViewportView(table);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j = String.valueOf(Banco.idBancos);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para deletar");
		        }
		        else
		        {
		        	
		        	
		        	BancoControle jc = new BancoControle();
				    jc.Deletar();				    
				    String sql = "SELECT * FROM bancos, cadastro where FK_idCadastro = idCadastro ORDER BY nome ASC;";
				    preencherTabela(sql);		        	
		        }	
		        
			}
		});
		btnExcluir.setForeground(Color.GRAY);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(645, 171, 125, 28);
		contentPane.add(btnExcluir);
	}

}
