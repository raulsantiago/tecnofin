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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textDataInicio;
	private JTextField textFinal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioTransacao frame = new RelatorioTransacao();
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
	public RelatorioTransacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setPreferredSize(new Dimension(900, 700));
		setMaximumSize(new Dimension(900, 700));
		setMinimumSize(new Dimension(900, 700));
		setSize(new Dimension(900, 700));
		setTitle("Relat\u00F3rio das Transa\u00E7\u00F5es Banc\u00E1rias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatrioDasTransaes = new JLabel("RELAT\u00D3RIO DAS TRANSA\u00C7\u00D5ES BANC\u00C1RIAS\r\n");
		lblRelatrioDasTransaes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatrioDasTransaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDasTransaes.setForeground(Color.GRAY);
		lblRelatrioDasTransaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatrioDasTransaes.setBounds(89, 20, 706, 50);
		contentPane.add(lblRelatrioDasTransaes);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(RelatorioTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(810, 94, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(659, 98, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnGerar = new JButton("GERAR");
		btnGerar.setForeground(Color.GRAY);
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerar.setBounds(508, 98, 125, 28);
		contentPane.add(btnGerar);
		
		JLabel label_1 = new JLabel("DATA INICIAL");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(27, 84, 93, 16);
		contentPane.add(label_1);
		
		textDataInicio = new JTextField();
		textDataInicio.setColumns(10);
		textDataInicio.setBounds(21, 99, 108, 28);
		contentPane.add(textDataInicio);
		
		JLabel label_2 = new JLabel("DATA FINAL");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(150, 84, 93, 16);
		contentPane.add(label_2);
		
		textFinal = new JTextField();
		textFinal.setColumns(10);
		textFinal.setBounds(144, 99, 108, 28);
		contentPane.add(textFinal);
		
		JComboBox BoxContaBanco = new JComboBox();
		BoxContaBanco.setBounds(261, 95, 231, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel lblNContaBanco = new JLabel("N\u00BA CONTA BANCO");
		lblNContaBanco.setForeground(Color.GRAY);
		lblNContaBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNContaBanco.setBounds(267, 80, 198, 16);
		contentPane.add(lblNContaBanco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 158, 851, 491);
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
				"N\u00BA", "N\u00BA CONTA", "CNPJ/CPF", "NOME", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TRANSA\u00C7\u00C3O TIPO", "DATA", "VALOR", "SALDO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(130);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		scrollPane.setViewportView(table);
	}

}
