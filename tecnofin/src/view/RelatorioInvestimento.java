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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioInvestimento extends JFrame {

	private JPanel contentPane;
	private JTextField textDataInicio;
	private JTextField textDataFim;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioInvestimento frame = new RelatorioInvestimento();
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
	public RelatorioInvestimento() {
		setMaximumSize(new Dimension(800, 500));
		setMinimumSize(new Dimension(800, 500));
		setPreferredSize(new Dimension(800, 500));
		setSize(new Dimension(800, 500));
		setTitle("Relat\u00F3rio dos Investimentos Financeiros");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioInvestimento.class.getResource("/Imagem/money-icon-title.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatrioInvestimentoFinanceiro = new JLabel("RELAT\u00D3RIO INVESTIMENTO FINANCEIRO\r\n");
		lblRelatrioInvestimentoFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatrioInvestimentoFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioInvestimentoFinanceiro.setForeground(Color.GRAY);
		lblRelatrioInvestimentoFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatrioInvestimentoFinanceiro.setBounds(71, 13, 642, 50);
		contentPane.add(lblRelatrioInvestimentoFinanceiro);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(RelatorioInvestimento.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(667, 90, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(516, 94, 125, 28);
		contentPane.add(btnVoltar);
		
		JButton btnGerar = new JButton("GERAR");
		btnGerar.setForeground(Color.GRAY);
		btnGerar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerar.setBounds(365, 94, 125, 28);
		contentPane.add(btnGerar);
		
		JLabel label_1 = new JLabel("DATA INICIAL");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(78, 80, 93, 16);
		contentPane.add(label_1);
		
		textDataInicio = new JTextField();
		textDataInicio.setColumns(10);
		textDataInicio.setBounds(72, 95, 108, 28);
		contentPane.add(textDataInicio);
		
		JLabel label_2 = new JLabel("DATA FINAL");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(201, 80, 93, 16);
		contentPane.add(label_2);
		
		textDataFim = new JTextField();
		textDataFim.setColumns(10);
		textDataFim.setBounds(195, 95, 108, 28);
		contentPane.add(textDataFim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 144, 760, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "NOME BANCO", "N\u00BA CONT\u00C1BIL", "NOME CONT\u00C1BIL", "TIPO TRANSA\u00C7\u00C3O", "DATA", "VALOR", "VALOR ACUMULADO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(130);
		scrollPane.setViewportView(table);
	}

}
