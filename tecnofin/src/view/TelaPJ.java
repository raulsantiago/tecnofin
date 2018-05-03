package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class TelaPJ extends JFrame {

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
	private JTextField textBancoNome;
	private JTextField textBancoNum;
	private JTextField textAgencia;
	private JTextField textContaNum;
	private JTextField textField;
	private JTextField textNome;
	private JTextField textCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPJ frame = new TelaPJ();
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
	public TelaPJ() {
		setForeground(Color.GRAY);
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setMinimumSize(new Dimension(1000, 700));
		setMaximumSize(new Dimension(1000, 700));
		setPreferredSize(new Dimension(1000, 700));
		setSize(new Dimension(1000, 700));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPJ.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Pessoa Jur\u00EDdica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPessoaJurdica = new JLabel("PESSOA JUR\u00CDDICA");
		lblPessoaJurdica.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPessoaJurdica.setHorizontalAlignment(SwingConstants.CENTER);
		lblPessoaJurdica.setForeground(Color.GRAY);
		lblPessoaJurdica.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPessoaJurdica.setBounds(342, 16, 299, 50);
		contentPane.add(lblPessoaJurdica);
		
		JLabel lblNome = new JLabel("RAZ\u00C3O SOCIAL");
		lblNome.setForeground(Color.GRAY);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(60, 102, 115, 16);
		contentPane.add(lblNome);
		
		JLabel lblNmeroDoBanco = new JLabel("N\u00BA BANCO");
		lblNmeroDoBanco.setForeground(Color.GRAY);
		lblNmeroDoBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmeroDoBanco.setBounds(349, 173, 78, 16);
		contentPane.add(lblNmeroDoBanco);
		
		JLabel lblNomeDoBanco = new JLabel("NOME DO BANCO");
		lblNomeDoBanco.setForeground(Color.GRAY);
		lblNomeDoBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDoBanco.setBounds(60, 173, 115, 16);
		contentPane.add(lblNomeDoBanco);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setForeground(Color.GRAY);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(639, 102, 115, 16);
		contentPane.add(lblCnpj);
		
		JLabel lblNAgncia = new JLabel("N\u00BA AG\u00CANCIA");
		lblNAgncia.setForeground(Color.GRAY);
		lblNAgncia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNAgncia.setBounds(439, 173, 90, 16);
		contentPane.add(lblNAgncia);
		
		JLabel lblNConta = new JLabel("N\u00BA CONTA");
		lblNConta.setForeground(Color.GRAY);
		lblNConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNConta.setBounds(556, 173, 90, 16);
		contentPane.add(lblNConta);
		
		JLabel lblTipoDaConta = new JLabel("TIPO DA CONTA");
		lblTipoDaConta.setForeground(Color.GRAY);
		lblTipoDaConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDaConta.setBounds(722, 173, 115, 16);
		contentPane.add(lblTipoDaConta);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(60, 241, 78, 16);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setForeground(Color.GRAY);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(502, 241, 78, 16);
		contentPane.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setForeground(Color.GRAY);
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCelular.setBounds(722, 241, 78, 16);
		contentPane.add(lblCelular);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setForeground(Color.GRAY);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(60, 311, 78, 16);
		contentPane.add(lblEndereo);
		
		JLabel lblNmero = new JLabel("N\u00DAMERO");
		lblNmero.setForeground(Color.GRAY);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmero.setBounds(543, 311, 78, 16);
		contentPane.add(lblNmero);
		
		JLabel lblComplemento = new JLabel("COMPLEMENTO");
		lblComplemento.setForeground(Color.GRAY);
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplemento.setBounds(679, 311, 103, 16);
		contentPane.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setForeground(Color.GRAY);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setBounds(556, 377, 78, 16);
		contentPane.add(lblBairro);
		
		JLabel lblMunicpio = new JLabel("MUNIC\u00CDPIO");
		lblMunicpio.setForeground(Color.GRAY);
		lblMunicpio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMunicpio.setBounds(60, 377, 78, 16);
		contentPane.add(lblMunicpio);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setForeground(Color.GRAY);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(458, 377, 60, 16);
		contentPane.add(lblUf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.GRAY);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCep.setBounds(798, 377, 78, 16);
		contentPane.add(lblCep);
		
		JLabel lblNotasComplementares = new JLabel("NOTAS COMPLEMENTARES");
		lblNotasComplementares.setForeground(Color.GRAY);
		lblNotasComplementares.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNotasComplementares.setBounds(60, 434, 212, 16);
		contentPane.add(lblNotasComplementares);
		
		textCidade = new JTextField();
		textCidade.setBounds(49, 392, 371, 28);
		contentPane.add(textCidade);
		textCidade.setColumns(10);
		
		textUf = new JTextField();
		textUf.setBounds(453, 391, 60, 28);
		contentPane.add(textUf);
		textUf.setColumns(10);
		
		textCep = new JTextField();
		textCep.setBounds(794, 392, 129, 28);
		contentPane.add(textCep);
		textCep.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(49, 326, 472, 28);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setBounds(533, 326, 122, 28);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(666, 326, 257, 28);
		contentPane.add(textComplemento);
		textComplemento.setColumns(10);
		
		textBairro = new JTextField();
		textBairro.setBounds(544, 392, 238, 28);
		contentPane.add(textBairro);
		textBairro.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(49, 257, 405, 28);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(487, 257, 212, 28);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(711, 257, 212, 28);
		contentPane.add(textCelular);
		
		textBancoNome = new JTextField();
		textBancoNome.setBounds(49, 189, 281, 28);
		contentPane.add(textBancoNome);
		textBancoNome.setColumns(10);
		
		textBancoNum = new JTextField();
		textBancoNum.setColumns(10);
		textBancoNum.setBounds(342, 189, 78, 28);
		contentPane.add(textBancoNum);
		
		textAgencia = new JTextField();
		textAgencia.setColumns(10);
		textAgencia.setBounds(432, 189, 103, 28);
		contentPane.add(textAgencia);
		
		textContaNum = new JTextField();
		textContaNum.setBounds(543, 189, 158, 28);
		contentPane.add(textContaNum);
		textContaNum.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(711, 189, 212, 28);
		contentPane.add(textField);
		
		textNome = new JTextField();
		textNome.setBounds(49, 117, 554, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCnpj = new JTextField();
		textCnpj.setBounds(631, 117, 292, 28);
		contentPane.add(textCnpj);
		textCnpj.setColumns(10);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(222, 554, 125, 28);
		contentPane.add(btnSalvar);
		
		JButton btnConsulta = new JButton("CONSULTA");
		btnConsulta.setForeground(Color.GRAY);
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsulta.setBounds(429, 554, 125, 28);
		contentPane.add(btnConsulta);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(Color.GRAY);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(639, 554, 125, 28);
		contentPane.add(btnLimpar);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(TelaPJ.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(465, 605, 53, 36);
		contentPane.add(btnHome);
		
		JTextPane textNotas = new JTextPane();
		textNotas.setBounds(49, 452, 874, 76);
		contentPane.add(textNotas);
	}
}
