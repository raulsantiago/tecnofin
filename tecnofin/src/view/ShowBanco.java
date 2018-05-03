package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowBanco extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textAgencia;
	private JTextField textNumero;
	private JTextField textField;
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

	/**
	 * Create the frame.
	 */
	public ShowBanco() {
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
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(217, 171, 125, 28);
		contentPane.add(btnBuscar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(827, 171, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnAlterar = new JButton("ALTERAR/DETALHAR");
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(502, 171, 179, 28);
		contentPane.add(btnAlterar);
		
		JButton btnHome = new JButton("");
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(749, 116, 203, 28);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 300, 1143, 352);
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
	}

}
