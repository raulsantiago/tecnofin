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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RelatorioSaldo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioSaldo frame = new RelatorioSaldo();
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
	public RelatorioSaldo() {
		setMaximumSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setPreferredSize(new Dimension(700, 500));
		setSize(new Dimension(700, 500));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioSaldo.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Relat\u00F3rio de Saldo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatrioDeSaldo = new JLabel("RELAT\u00D3RIO DE SALDO EM CONTA\r\n");
		lblRelatrioDeSaldo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatrioDeSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDeSaldo.setForeground(Color.GRAY);
		lblRelatrioDeSaldo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatrioDeSaldo.setBounds(80, 19, 524, 50);
		contentPane.add(lblRelatrioDeSaldo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 149, 655, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"NOME DO BANCO", "CONTA DO TIPO", "N\u00BA AG\u00CANCIA", "N\u00BA CONTA", "SALDO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JButton btnGerar = new JButton("GERAR");
		btnGerar.setForeground(Color.GRAY);
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerar.setBounds(168, 94, 125, 28);
		contentPane.add(btnGerar);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(RelatorioSaldo.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(470, 90, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(317, 95, 125, 28);
		contentPane.add(btnVoltar);
	}
}
