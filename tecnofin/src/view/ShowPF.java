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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowPF extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPF frame = new ShowPF();
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
	public ShowPF() {
		setMaximumSize(new Dimension(1200, 700));
		setMinimumSize(new Dimension(1200, 700));
		setPreferredSize(new Dimension(1200, 700));
		setSize(new Dimension(1200, 700));
		setTitle("Pessoa F\u00EDsica");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowPF.class.getResource("/Imagem/money-icon-title.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("NOME");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(299, 98, 115, 16);
		contentPane.add(label);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(288, 113, 426, 28);
		contentPane.add(textNome);
		
		JLabel label_1 = new JLabel("CPF");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(752, 98, 115, 16);
		contentPane.add(label_1);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(740, 113, 203, 28);
		contentPane.add(textCpf);
		
		JLabel label_2 = new JLabel("PESSOA F\u00CDSICA");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_2.setBounds(442, 27, 299, 50);
		contentPane.add(label_2);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(288, 168, 125, 28);
		contentPane.add(btnBuscar);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(ShowPF.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(565, 218, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnAlterar = new JButton("ALTERAR/DETALHAR");
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(502, 168, 179, 28);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(818, 168, 125, 28);
		contentPane.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 293, 1125, 348);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"NOME", "CPF", "E-MAIL", "TELEFONE", "CELULAR", "DATA CADASTRO", "FK_IDCADASTRO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(115);
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
		scrollPane.setViewportView(table);
	}
}
