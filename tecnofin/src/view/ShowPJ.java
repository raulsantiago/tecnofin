package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowPJ extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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

	/**
	 * Create the frame.
	 */
	public ShowPJ() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(288, 113, 426, 28);
		panel.add(textField);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setForeground(Color.GRAY);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(752, 98, 115, 16);
		panel.add(lblCnpj);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(740, 113, 203, 28);
		panel.add(textField_1);
		
		JLabel lblPessoaJurdica = new JLabel("PESSOA JUR\u00CDDICA");
		lblPessoaJurdica.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPessoaJurdica.setHorizontalAlignment(SwingConstants.CENTER);
		lblPessoaJurdica.setForeground(Color.GRAY);
		lblPessoaJurdica.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPessoaJurdica.setBounds(442, 27, 299, 50);
		panel.add(lblPessoaJurdica);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(288, 168, 125, 28);
		panel.add(btnBuscar);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(ShowPJ.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(565, 218, 53, 36);
		panel.add(btnHome);
		
		JButton btnAlterar = new JButton("ALTERAR/DETALHAR");
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(490, 168, 203, 28);
		panel.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(818, 168, 125, 28);
		panel.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 293, 1125, 348);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", "", null, null, null, ""},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, ""},
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
	}

}
