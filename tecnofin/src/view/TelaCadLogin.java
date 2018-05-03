package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import conexoes.Conexao;
import control.LoginConexao;
import model.Login;
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
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelaCadLogin extends JFrame {

	
	private JPanel contentPane;
	private JTextField textCargo;
	private JTextField textNome;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTable table;	
	
	/**
	 * @author Raul
	 * @Método limparCampos
	 * @Método preencherTabela JTable com uma coluna oculta de idLogin
	 * @Método windowActivated para show dos logins na tabela por ordem de nome
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadLogin frame = new TelaCadLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void limparCampos() 
	{
		textCargo.setText("");
		textNome.setText("");
		txtEmail.setText("");
		passwordField.setText("");		
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
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getString("email"),
                    rs.getString("admin"),
                    rs.getString("idLogin"),
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
	public TelaCadLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				String sql = "SELECT * FROM login ORDER BY nome ASC;";
				preencherTabela(sql);
				
			}
		});
		setMaximumSize(new Dimension(700, 700));
		setMinimumSize(new Dimension(700, 700));
		setPreferredSize(new Dimension(700, 700));
		setSize(new Dimension(700, 700));
		setTitle("Cadastro de login para acesso ao sistema");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadLogin.class.getResource("/Imagem/money-icon-title.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 678, 655);
		contentPane.add(panel);
		
		JLabel lblUsuriosComAcesso = new JLabel("USU\u00C1RIOS");
		lblUsuriosComAcesso.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsuriosComAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuriosComAcesso.setForeground(Color.GRAY);
		lblUsuriosComAcesso.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuriosComAcesso.setBounds(192, 52, 293, 26);
		panel.add(lblUsuriosComAcesso);
		
		JLabel lblAcessoAoSistema = new JLabel("ACESSO AO SISTEMA");
		lblAcessoAoSistema.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAcessoAoSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcessoAoSistema.setForeground(Color.GRAY);
		lblAcessoAoSistema.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAcessoAoSistema.setBounds(159, 20, 360, 26);
		panel.add(lblAcessoAoSistema);
		
		JLabel lblCargoDoUsurio = new JLabel("CARGO DO USU\u00C1RIO");
		lblCargoDoUsurio.setForeground(Color.GRAY);
		lblCargoDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargoDoUsurio.setBounds(397, 90, 146, 16);
		panel.add(lblCargoDoUsurio);
		
		JLabel lblNomeDoUsurio = new JLabel("NOME DO USU\u00C1RIO");
		lblNomeDoUsurio.setForeground(Color.GRAY);
		lblNomeDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDoUsurio.setBounds(15, 90, 141, 16);
		panel.add(lblNomeDoUsurio);
		
		textCargo = new JTextField();
		textCargo.setColumns(10);
		textCargo.setBounds(392, 104, 273, 28);
		panel.add(textCargo);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(12, 105, 366, 28);
		panel.add(textNome);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.nome = textNome.getText();
				Login.cargo = textCargo.getText();
				Login.email = txtEmail.getText();
				Login.senha = new String(passwordField.getPassword());
			    LoginConexao lc = new LoginConexao();
			    lc.salvar();
			    limparCampos();
			    String sql = "SELECT * FROM login ORDER BY nome ASC;";	      
			    preencherTabela(sql);			      
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(15, 285, 120, 28);
		panel.add(btnSalvar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				String j = String.valueOf(Login.idLogin);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para atualizar");
		        }
		        else
		        {
		        	Login.nome = textNome.getText();
					Login.cargo = textCargo.getText();
					Login.email = txtEmail.getText();
					Login.senha = new String(passwordField.getPassword());					
					LoginConexao lc = new LoginConexao();
				    lc.Atualizar();
				    limparCampos();
				    String sql = "SELECT * FROM login ORDER BY nome ASC;";
				    preencherTabela(sql);
		        }
		        
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(279, 285, 120, 28);
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir.setForeground(Color.GRAY);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j = String.valueOf(Login.idLogin);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para atualizar");
		        }
		        else
		        {		        	
		        	LoginConexao lc = new LoginConexao();
				    lc.Deletar();
				    limparCampos();
				    String sql = "SELECT * FROM login ORDER BY nome ASC;"; 
				    preencherTabela(sql);			
		        }
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(413, 285, 120, 28);
		panel.add(btnExcluir);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultar.setForeground(Color.GRAY);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pesquisa pelos nome, cargo, email e admin
				String sql = "SELECT * FROM login WHERE nome LIKE ('%" 
		                + textNome.getText()
		                + "%') AND email LIKE ('%"
		                + txtEmail.getText() 
		                + "%') AND cargo LIKE ('%"
		                + textCargo.getText()
		                + "%')"
		                + " ORDER BY nome ASC;";
				preencherTabela(sql);
			    limparCampos();
			}			
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultar.setBounds(145, 285, 125, 28);
		panel.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 325, 654, 254);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = table.getSelectedRow();//selecionar a linha da tabela e passando para campoField
				textNome.setText(table.getValueAt(linha, 0).toString());
				textCargo.setText(table.getValueAt(linha, 1).toString());
				txtEmail.setText(table.getValueAt(linha, 2).toString());				
				Login.admin = Integer.parseInt((table.getValueAt(linha, 3).toString()));
				Login.idLogin = Integer.parseInt((table.getValueAt(linha, 4).toString()));
				Login.nome = textNome.getText(); // o conteudo do campoField para as variaveis repectivas de login
				Login.cargo = textCargo.getText();
				Login.email = txtEmail.getText();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"NOME", "CARGO", "E-MAIL", "ADMINISTRADOR", "ID LOGIN"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(163);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(165);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(15);
		table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadLogin tc = new TelaCadLogin();
                tc.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaCadLogin.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnVoltar.setBounds(312, 613, 53, 36);
		panel.add(btnVoltar);
		btnVoltar.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(13, 165, 366, 28);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-MAIL DO USU\u00C1RIO");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(18, 148, 177, 16);
		panel.add(lblEmail);
		
		JLabel lblSenhaDoUsurio = new JLabel("SENHA DO USU\u00C1RIO");
		lblSenhaDoUsurio.setForeground(Color.GRAY);
		lblSenhaDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenhaDoUsurio.setBounds(398, 149, 146, 16);
		panel.add(lblSenhaDoUsurio);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(393, 165, 273, 28);
		panel.add(passwordField);
		
		JCheckBox checkBoxAdmin = new JCheckBox("ADMINISTRADOR DO SISTEMA");
		checkBoxAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBoxAdmin.isSelected() == false)
				{
					Login.admin = 0;
				} else 
				{
					Login.admin = 1;
				}
			}
		});
		checkBoxAdmin.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {	
				 if (e.getStateChange() == ItemEvent.DESELECTED)
				 {
					Login.admin = 0;
				 }else 
				 {
					Login.admin = 1;
				 }
			}
		});
		checkBoxAdmin.setToolTipText("Marque para ser Administrador do sistema TECNOFIN !");
		checkBoxAdmin.setName("");
		checkBoxAdmin.setForeground(Color.GRAY);
		checkBoxAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxAdmin.setBounds(15, 205, 226, 18);
		panel.add(checkBoxAdmin);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setForeground(Color.GRAY);
		btnLimpar.setBounds(545, 286, 120, 28);
		panel.add(btnLimpar);
	}
}