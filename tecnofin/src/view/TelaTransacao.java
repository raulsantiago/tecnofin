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
import javax.swing.JList;
import javax.swing.JTree;
import java.awt.Scrollbar;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaTransacao extends JFrame {

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
					TelaTransacao frame = new TelaTransacao();
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
	public TelaTransacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaTransacao.class.getResource("/Imagem/money-icon-title.jpg")));
		setSize(new Dimension(700, 700));
		setMaximumSize(new Dimension(700, 700));
		setMinimumSize(new Dimension(700, 700));
		setPreferredSize(new Dimension(700, 700));
		setTitle("Transa\u00E7\u00F5es Banc\u00E1rias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTransaesBancrias = new JLabel("TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		lblTransaesBancrias.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTransaesBancrias.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaesBancrias.setForeground(Color.GRAY);
		lblTransaesBancrias.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTransaesBancrias.setBounds(121, 16, 441, 50);
		contentPane.add(lblTransaesBancrias);
		
		JComboBox BoxFavorecido = new JComboBox();
		BoxFavorecido.setBounds(96, 227, 502, 35);
		contentPane.add(BoxFavorecido);
		
		JLabel lblFavorecido = new JLabel("FAVORECIDO");
		lblFavorecido.setForeground(Color.GRAY);
		lblFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFavorecido.setBounds(106, 211, 118, 16);
		contentPane.add(lblFavorecido);
		
		JComboBox BoxContaBanco = new JComboBox();
		BoxContaBanco.setBounds(96, 103, 313, 35);
		contentPane.add(BoxContaBanco);
		
		JLabel lblBancoDaTransao = new JLabel("N\u00BA CONTA BANCO");
		lblBancoDaTransao.setForeground(Color.GRAY);
		lblBancoDaTransao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBancoDaTransao.setBounds(106, 88, 231, 16);
		contentPane.add(lblBancoDaTransao);
		
		JComboBox BoxTipoRecDes = new JComboBox();
		BoxTipoRecDes.setForeground(Color.GRAY);
		BoxTipoRecDes.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipoRecDes.setModel(new DefaultComboBoxModel(new String[] {"DESPESA", "RECEITA"}));
		BoxTipoRecDes.setBounds(96, 284, 313, 35);
		contentPane.add(BoxTipoRecDes);
		
		JLabel lblClassificaoContbil = new JLabel("TIPO DE LAN\u00C7AMENTO");
		lblClassificaoContbil.setForeground(Color.GRAY);
		lblClassificaoContbil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClassificaoContbil.setBounds(106, 270, 231, 16);
		contentPane.add(lblClassificaoContbil);
		
		JComboBox BoxReceitaDespesa = new JComboBox();
		BoxReceitaDespesa.setBounds(96, 344, 313, 35);
		contentPane.add(BoxReceitaDespesa);
		
		JLabel label = new JLabel("CLASSIFICA\u00C7\u00C3O CONT\u00C1BIL");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(106, 329, 231, 16);
		contentPane.add(label);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.setModel(new DefaultComboBoxModel(new String[] {"PAGAMENTO", "RECEBIMENTO", "ESTORNO", "APLICA\u00C7\u00C3O", "RESGATE", "RENDIMENTO", "PREJU\u00CDZO"}));
		BoxTipo.setForeground(Color.GRAY);
		BoxTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipo.setBounds(96, 400, 313, 35);
		contentPane.add(BoxTipo);
		
		JLabel lblTipoDaTransao = new JLabel("TIPO DA TRANSA\u00C7\u00C3O BANC\u00C1RIA");
		lblTipoDaTransao.setForeground(Color.GRAY);
		lblTipoDaTransao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDaTransao.setBounds(106, 383, 231, 16);
		contentPane.add(lblTipoDaTransao);
		
		textValor = new JTextField();
		textValor.setBounds(96, 454, 170, 28);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblValor = new JLabel("VALOR");
		lblValor.setForeground(Color.GRAY);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(106, 438, 128, 16);
		contentPane.add(lblValor);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(318, 454, 170, 28);
		contentPane.add(textData);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setForeground(Color.GRAY);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(325, 438, 128, 16);
		contentPane.add(lblData);
		
		JLabel lblInformaesComplementaresDa = new JLabel("INFORMA\u00C7\u00D5ES COMPLEMENTARES DA TRANSA\u00C7\u00C3O");
		lblInformaesComplementaresDa.setForeground(Color.GRAY);
		lblInformaesComplementaresDa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformaesComplementaresDa.setBounds(106, 492, 348, 16);
		contentPane.add(lblInformaesComplementaresDa);
		
		JTextPane textDescricao = new JTextPane();
		textDescricao.setBounds(96, 508, 502, 61);
		contentPane.add(textDescricao);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(TelaTransacao.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(315, 613, 53, 36);
		contentPane.add(btnHome);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(111, 584, 125, 28);
		contentPane.add(btnSalvar);
		
		JButton btnConsulta = new JButton("CONSULTA");
		btnConsulta.setForeground(Color.GRAY);
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsulta.setBounds(457, 585, 125, 28);
		contentPane.add(btnConsulta);
		
		JComboBox BoxTipoFavorecido = new JComboBox();
		BoxTipoFavorecido.setModel(new DefaultComboBoxModel(new String[] {"PESSOA F\u00CDSICA", "PESSOA JUR\u00CDDICA"}));
		BoxTipoFavorecido.setForeground(Color.GRAY);
		BoxTipoFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		BoxTipoFavorecido.setBounds(96, 164, 313, 35);
		contentPane.add(BoxTipoFavorecido);
		
		JLabel lblTipoDeFavorecido = new JLabel("TIPO DE FAVORECIDO");
		lblTipoDeFavorecido.setForeground(Color.GRAY);
		lblTipoDeFavorecido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeFavorecido.setBounds(106, 150, 231, 16);
		contentPane.add(lblTipoDeFavorecido);
	}
}
