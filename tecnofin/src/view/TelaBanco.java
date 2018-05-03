package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class TelaBanco extends JFrame {

	private JPanel contentPane;
	private JTextField textCidade;
	private JTextField textUf;
	private JTextField textCep;
	private JTextField textEndereco;
	private JTextField textNumero;
	private JTextField textComplemento;
	private JTextField textBairro;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textCelular;
	private JTextField textNome;
	private JTextField textBancoNum;
	private JTextField textAgencia;
	private JTextField textContaNum;
	private JTextField textTipoConta;
	private JTextField textCnpj;
	private JTextField textGerente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBanco frame = new TelaBanco();
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
	public TelaBanco() {
		setMaximumSize(new Dimension(1000, 700));
		setMinimumSize(new Dimension(1000, 700));
		setPreferredSize(new Dimension(1000, 700));
		setSize(new Dimension(1000, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBanco.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Bancos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.GRAY);
		panel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 984, 661);
		contentPane.add(panel);
		
		JLabel lblBancos = new JLabel("BANCOS");
		lblBancos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBancos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancos.setForeground(Color.GRAY);
		lblBancos.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBancos.setBounds(342, 16, 299, 50);
		panel.add(lblBancos);
		
		JLabel label_2 = new JLabel("N\u00BA BANCO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(349, 173, 78, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("NOME DO BANCO");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(63, 100, 115, 16);
		panel.add(label_3);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setForeground(Color.GRAY);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(636, 99, 115, 16);
		panel.add(lblCnpj);
		
		JLabel label_5 = new JLabel("N\u00BA AG\u00CANCIA");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(439, 173, 90, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("N\u00BA CONTA");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(556, 173, 90, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("TIPO DA CONTA");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(722, 173, 115, 16);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("E-MAIL");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(60, 241, 78, 16);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("TELEFONE");
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(502, 241, 78, 16);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("CELULAR");
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(722, 241, 78, 16);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("ENDERE\u00C7O");
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(60, 311, 78, 16);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("N\u00DAMERO");
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(543, 311, 78, 16);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("COMPLEMENTO");
		label_13.setForeground(Color.GRAY);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(679, 311, 103, 16);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("BAIRRO");
		label_14.setForeground(Color.GRAY);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(556, 377, 78, 16);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("MUNIC\u00CDPIO");
		label_15.setForeground(Color.GRAY);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(60, 377, 78, 16);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("UF");
		label_16.setForeground(Color.GRAY);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(458, 377, 60, 16);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("CEP");
		label_17.setForeground(Color.GRAY);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(798, 377, 78, 16);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("NOTAS COMPLEMENTARES");
		label_18.setForeground(Color.GRAY);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(60, 434, 212, 16);
		panel.add(label_18);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(49, 392, 371, 28);
		panel.add(textCidade);
		
		textUf = new JTextField();
		textUf.setColumns(10);
		textUf.setBounds(453, 391, 60, 28);
		panel.add(textUf);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(794, 392, 129, 28);
		panel.add(textCep);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(49, 326, 472, 28);
		panel.add(textEndereco);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(533, 326, 122, 28);
		panel.add(textNumero);
		
		textComplemento = new JTextField();
		textComplemento.setColumns(10);
		textComplemento.setBounds(666, 326, 257, 28);
		panel.add(textComplemento);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(544, 392, 238, 28);
		panel.add(textBairro);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(49, 257, 405, 28);
		panel.add(textEmail);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(487, 257, 212, 28);
		panel.add(textTelefone);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(711, 257, 212, 28);
		panel.add(textCelular);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(49, 117, 505, 28);
		panel.add(textNome);
		
		textBancoNum = new JTextField();
		textBancoNum.setColumns(10);
		textBancoNum.setBounds(342, 189, 78, 28);
		panel.add(textBancoNum);
		
		textAgencia = new JTextField();
		textAgencia.setColumns(10);
		textAgencia.setBounds(432, 189, 103, 28);
		panel.add(textAgencia);
		
		textContaNum = new JTextField();
		textContaNum.setColumns(10);
		textContaNum.setBounds(543, 189, 158, 28);
		panel.add(textContaNum);
		
		textTipoConta = new JTextField();
		textTipoConta.setColumns(10);
		textTipoConta.setBounds(711, 189, 212, 28);
		panel.add(textTipoConta);
		
		textCnpj = new JTextField();
		textCnpj.setColumns(10);
		textCnpj.setBounds(614, 117, 309, 28);
		panel.add(textCnpj);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(222, 554, 125, 28);
		panel.add(btnSalvar);
		
		JButton btnConsulta = new JButton("CONSULTA");
		btnConsulta.setForeground(Color.GRAY);
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsulta.setBounds(429, 554, 125, 28);
		panel.add(btnConsulta);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(Color.GRAY);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(639, 554, 125, 28);
		panel.add(btnLimpar);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(TelaBanco.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(465, 605, 53, 36);
		panel.add(btnHome);
		
		textGerente = new JTextField();
		textGerente.setColumns(10);
		textGerente.setBounds(49, 188, 281, 28);
		panel.add(textGerente);
		
		JLabel lblGerenteDoBanco = new JLabel("GERENTE DO BANCO");
		lblGerenteDoBanco.setForeground(Color.GRAY);
		lblGerenteDoBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGerenteDoBanco.setBounds(64, 173, 153, 16);
		panel.add(lblGerenteDoBanco);
		
		JTextPane textNotas = new JTextPane();
		textNotas.setBounds(49, 450, 874, 76);
		panel.add(textNotas);
	}

}
