package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class AtualizarTransacao extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarTransacao frame = new AtualizarTransacao();
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
	public AtualizarTransacao() {
		setMaximumSize(new Dimension(700, 700));
		setMinimumSize(new Dimension(700, 700));
		setPreferredSize(new Dimension(700, 700));
		setSize(new Dimension(700, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Altera\u00E7\u00E3o de Transa\u00E7\u00E3o Banc\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox BoxFavorecido = new JComboBox();
		BoxFavorecido.setBounds(82, 233, 502, 35);
		contentPane.add(BoxFavorecido);
		
		JLabel label = new JLabel("FAVORECIDO");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(92, 217, 118, 16);
		contentPane.add(label);
		
		JComboBox BoxContaBanco = new JComboBox();
		BoxContaBanco.setBounds(82, 109, 313, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel label_1 = new JLabel("N\u00BA CONTA BANCO");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(92, 94, 231, 16);
		contentPane.add(label_1);
		
		JComboBox BoxRecDes = new JComboBox();
		BoxRecDes.setModel(new DefaultComboBoxModel(new String[] {"DESPESA", "RECEITA"}));
		BoxRecDes.setForeground(Color.GRAY);
		BoxRecDes.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxRecDes.setBounds(82, 290, 313, 35);
		contentPane.add(BoxRecDes);
		
		JLabel label_2 = new JLabel("TIPO DE LAN\u00C7AMENTO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(92, 276, 231, 16);
		contentPane.add(label_2);
		
		JComboBox BoxReceitaDespesa = new JComboBox();
		BoxReceitaDespesa.setBounds(82, 350, 313, 35);
		contentPane.add(BoxReceitaDespesa);
		
		JLabel label_3 = new JLabel("CLASSIFICA\u00C7\u00C3O CONT\u00C1BIL");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(92, 335, 231, 16);
		contentPane.add(label_3);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.setModel(new DefaultComboBoxModel(new String[] {"PAGAMENTO", "RECEBIMENTO", "ESTORNO", "APLICA\u00C7\u00C3O", "RESGATE", "RENDIMENTO", "PREJU\u00CDZO"}));
		BoxTipo.setForeground(Color.GRAY);
		BoxTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipo.setBounds(82, 406, 313, 35);
		contentPane.add(BoxTipo);
		
		JLabel label_4 = new JLabel("TIPO DA TRANSA\u00C7\u00C3O BANC\u00C1RIA");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(92, 389, 231, 16);
		contentPane.add(label_4);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(82, 460, 170, 28);
		contentPane.add(textValor);
		
		JLabel label_5 = new JLabel("VALOR");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(92, 444, 128, 16);
		contentPane.add(label_5);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(304, 460, 170, 28);
		contentPane.add(textData);
		
		JLabel label_6 = new JLabel("DATA");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(311, 444, 128, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("INFORMA\u00C7\u00D5ES COMPLEMENTARES DA TRANSA\u00C7\u00C3O");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(92, 498, 348, 16);
		contentPane.add(label_7);
		
		JTextPane textNotas = new JTextPane();
		textNotas.setBounds(82, 514, 502, 61);
		contentPane.add(textNotas);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(97, 590, 125, 28);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(443, 591, 125, 28);
		contentPane.add(btnVoltar);
		
		JComboBox BoxTipoFavorecido = new JComboBox();
		BoxTipoFavorecido.setModel(new DefaultComboBoxModel(new String[] {"PESSOA F\u00CDSICA", "PESSOA JUR\u00CDDICA"}));
		BoxTipoFavorecido.setForeground(Color.GRAY);
		BoxTipoFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipoFavorecido.setBounds(82, 170, 313, 35);
		contentPane.add(BoxTipoFavorecido);
		
		JLabel label_8 = new JLabel("TIPO DE FAVORECIDO");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(92, 156, 231, 16);
		contentPane.add(label_8);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(AtualizarTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(301, 619, 53, 36);
		contentPane.add(btnHome);
		
		JLabel label_9 = new JLabel("TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		label_9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_9.setBounds(122, 6, 440, 35);
		contentPane.add(label_9);
		
		JLabel lblAlterao = new JLabel("ALTERA\u00C7\u00C3O");
		lblAlterao.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlterao.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterao.setForeground(Color.GRAY);
		lblAlterao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlterao.setBounds(248, 46, 187, 25);
		contentPane.add(lblAlterao);
	}
}
