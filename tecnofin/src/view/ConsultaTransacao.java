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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	private JTextField textCnpjCpf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTransacao frame = new ConsultaTransacao();
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
	public ConsultaTransacao() {
		setSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Consulta Transa\u00E7\u00E3o Banc\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(171, 3, 441, 50);
		contentPane.add(label);
		
		JLabel lblConsulta = new JLabel("CONSULTA");
		lblConsulta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setForeground(Color.GRAY);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsulta.setBounds(298, 60, 187, 25);
		contentPane.add(lblConsulta);
		
		JComboBox BoxContaBanco = new JComboBox();
		BoxContaBanco.setBounds(73, 125, 313, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel label_1 = new JLabel("N\u00BA CONTA BANCO");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(83, 110, 231, 16);
		contentPane.add(label_1);
		
		JComboBox BoxFavorecido = new JComboBox();
		BoxFavorecido.setBounds(73, 188, 641, 35);
		contentPane.add(BoxFavorecido);
		
		JLabel label_2 = new JLabel("FAVORECIDO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(83, 172, 631, 16);
		contentPane.add(label_2);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.setForeground(Color.GRAY);
		BoxTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipo.setBounds(401, 125, 313, 35);
		contentPane.add(BoxTipo);
		
		JLabel label_3 = new JLabel("TIPO DE FAVORECIDO");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(411, 111, 231, 16);
		contentPane.add(label_3);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(73, 251, 170, 28);
		contentPane.add(textValor);
		
		JLabel label_4 = new JLabel("VALOR");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(83, 235, 128, 16);
		contentPane.add(label_4);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(253, 251, 170, 28);
		contentPane.add(textData);
		
		JLabel label_5 = new JLabel("DATA");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(260, 235, 128, 16);
		contentPane.add(label_5);
		
		JLabel lblCnpjcpf = new JLabel("CNPJ/CPF");
		lblCnpjcpf.setForeground(Color.GRAY);
		lblCnpjcpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpjcpf.setBounds(442, 235, 128, 16);
		contentPane.add(lblCnpjcpf);
		
		textCnpjCpf = new JTextField();
		textCnpjCpf.setColumns(10);
		textCnpjCpf.setBounds(435, 251, 279, 28);
		contentPane.add(textCnpjCpf);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(ConsultaTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(365, 341, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.GRAY);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(73, 291, 125, 28);
		contentPane.add(btnBuscar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(589, 291, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(237, 291, 125, 28);
		contentPane.add(btnAlterar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 386, 771, 168);
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
			},
			new String[] {
				"N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONTABIL", "NOME CONT\u00C1BIL", "TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR", "SALDO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setForeground(Color.GRAY);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(411, 291, 125, 28);
		contentPane.add(btnExcluir);
	}
}
