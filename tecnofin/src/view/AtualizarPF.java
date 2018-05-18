package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.FisicaControle;
import control.JuridicaControle;
import model.PessoaFisica;
import model.PessoaJuridica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarPF extends JFrame {

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
	private JTextField textTipoConta;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTipoPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarPF frame = new AtualizarPF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void limparCampos() 
	{   
	    textCidade.setText("");
		textUf.setText("");
		textCep.setText("");
		textEndereco.setText("");
		textNumero.setText("");
		textComplemento.setText("");
		textBairro.setText("");
		textEmail.setText("");
		textTelefone.setText("");
		textCelular.setText("");
		textBancoNome.setText("");
		textBancoNum.setText("");
		textAgencia.setText("");
		textContaNum.setText("");
		textTipoConta.setText("");
		textNome.setText("");
		textCpf.setText("");
		textTipoPF.setText("");
		
	}
	
	

	/**
	 * Create the frame.
	 */
	public AtualizarPF() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				textCpf.setText(String.valueOf(PessoaFisica.cpf));
				textBancoNome.setText(PessoaFisica.bancoNomePF);				
				textTipoPF.setText(PessoaFisica.tipoPF);
				textNome.setText(PessoaFisica.nomePF);				
				textBancoNum.setText(String.valueOf(PessoaFisica.bancoNumPF));			
				textAgencia.setText(PessoaFisica.agenciaPF);				
				textTipoConta.setText(PessoaFisica.tipoContaPF);				
				textContaNum.setText(PessoaFisica.contaNumPF);				
				textEmail.setText(PessoaFisica.email);				
				textTelefone.setText(PessoaFisica.telefone);				
				textCelular.setText(PessoaFisica.celular);				
				textEndereco.setText(PessoaFisica.endereco);				
				textNumero.setText(PessoaFisica.numero);				
				textComplemento.setText(PessoaFisica.complemento);				
				textUf.setText(PessoaFisica.uf);				
				textCidade.setText(PessoaFisica.cidade);				
 				textBairro.setText(PessoaFisica.bairro); 				
 				textCep.setText(PessoaFisica.cep);
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarPF.class.getResource("/Imagem/money-icon-title.jpg")));
		setMaximumSize(new Dimension(1000, 700));
		setMinimumSize(new Dimension(1000, 700));
		setPreferredSize(new Dimension(1000, 700));
		setSize(new Dimension(1000, 700));
		setTitle("Detalhar e atualizar pessoa f\u00EDsica");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.GRAY);
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(0, 0, 984, 661);
		panel.add(panel_1);
		
		JLabel label = new JLabel("PESSOA F\u00CDSICA");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(342, 16, 299, 50);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("NOME");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(60, 102, 115, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("N\u00BA BANCO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(349, 173, 78, 16);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("NOME DO BANCO");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(60, 173, 115, 16);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("CPF");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(732, 102, 115, 16);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("N\u00BA AG\u00CANCIA");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(439, 173, 90, 16);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("N\u00BA CONTA");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(556, 173, 90, 16);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("TIPO DA CONTA");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(722, 173, 115, 16);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("E-MAIL");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(60, 241, 78, 16);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("TELEFONE");
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(502, 241, 78, 16);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("CELULAR");
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(722, 241, 78, 16);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("ENDERE\u00C7O");
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(60, 311, 78, 16);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("N\u00DAMERO");
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(543, 311, 78, 16);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("COMPLEMENTO");
		label_13.setForeground(Color.GRAY);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(679, 311, 103, 16);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("BAIRRO");
		label_14.setForeground(Color.GRAY);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(556, 377, 78, 16);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("MUNIC\u00CDPIO");
		label_15.setForeground(Color.GRAY);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(60, 377, 78, 16);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("UF");
		label_16.setForeground(Color.GRAY);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(458, 377, 60, 16);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("CEP");
		label_17.setForeground(Color.GRAY);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(798, 377, 78, 16);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("NOTAS COMPLEMENTARES");
		label_18.setForeground(Color.GRAY);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(60, 434, 212, 16);
		panel_1.add(label_18);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(49, 392, 371, 28);
		panel_1.add(textCidade);
		
		textUf = new JTextField();
		textUf.setColumns(10);
		textUf.setBounds(453, 391, 60, 28);
		panel_1.add(textUf);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(794, 392, 129, 28);
		panel_1.add(textCep);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(49, 326, 472, 28);
		panel_1.add(textEndereco);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(533, 326, 122, 28);
		panel_1.add(textNumero);
		
		textComplemento = new JTextField();
		textComplemento.setColumns(10);
		textComplemento.setBounds(666, 326, 257, 28);
		panel_1.add(textComplemento);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(544, 392, 238, 28);
		panel_1.add(textBairro);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(49, 257, 405, 28);
		panel_1.add(textEmail);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(487, 257, 212, 28);
		panel_1.add(textTelefone);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(711, 257, 212, 28);
		panel_1.add(textCelular);
		
		textBancoNome = new JTextField();
		textBancoNome.setColumns(10);
		textBancoNome.setBounds(49, 189, 281, 28);
		panel_1.add(textBancoNome);
		
		textBancoNum = new JTextField();
		textBancoNum.setColumns(10);
		textBancoNum.setBounds(342, 189, 78, 28);
		panel_1.add(textBancoNum);
		
		textAgencia = new JTextField();
		textAgencia.setColumns(10);
		textAgencia.setBounds(432, 189, 103, 28);
		panel_1.add(textAgencia);
		
		textContaNum = new JTextField();
		textContaNum.setColumns(10);
		textContaNum.setBounds(543, 189, 158, 28);
		panel_1.add(textContaNum);
		
		textTipoConta = new JTextField();
		textTipoConta.setColumns(10);
		textTipoConta.setBounds(711, 189, 212, 28);
		panel_1.add(textTipoConta);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(49, 117, 426, 28);
		panel_1.add(textNome);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(720, 117, 203, 28);
		panel_1.add(textCpf);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String j = String.valueOf(PessoaFisica.cpf);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para atualizar");
		        }
		        else
		        {
		        	
		        	PessoaFisica.cpf = Long.parseLong(textCpf.getText());
		        	PessoaFisica.bancoNumPF = Integer.parseInt(textBancoNum.getText());
		        	PessoaFisica.tipoPF = textTipoPF.getText();
		        	PessoaFisica.bancoNomePF = textBancoNome.getText();
		        	PessoaFisica.nomePF = textNome.getText();
		        	PessoaFisica.agenciaPF = textAgencia.getText();				
		        	PessoaFisica.tipoContaPF = textTipoConta.getText();				
		        	PessoaFisica.contaNumPF = textContaNum.getText();				
		        	PessoaFisica.email = textEmail.getText();				
		        	PessoaFisica.telefone = textTelefone.getText();				
		        	PessoaFisica.celular = textCelular.getText();				
		        	PessoaFisica.endereco = textEndereco.getText();				
		        	PessoaFisica.numero = textNumero.getText();				
		        	PessoaFisica.complemento = textComplemento.getText();				
		        	PessoaFisica.uf = textUf.getText();				
		        	PessoaFisica.cidade = textCidade.getText();				
		        	PessoaFisica.bairro = textBairro.getText(); 				
		        	PessoaFisica.cep = textCep.getText(); 
				    
				    FisicaControle pj = new FisicaControle();		     
				    pj.Atualizar();				    
				    limparCampos();
		        }	
				
			}
		});
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(222, 554, 125, 28);
		panel_1.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AtualizarPF apj = new AtualizarPF();
                apj.dispose();                
                ShowPF spj = new ShowPF();
                spj.setVisible(true);
                
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(639, 554, 125, 28);
		panel_1.add(btnVoltar);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AtualizarPF apj = new AtualizarPF();
                apj.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(AtualizarPF.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(465, 605, 53, 36);
		panel_1.add(btnHome);
		
		textTipoPF = new JTextField();
		textTipoPF.setColumns(10);
		textTipoPF.setBounds(487, 117, 223, 28);
		panel_1.add(textTipoPF);
		
		JLabel label_19 = new JLabel("TIPO DE PESSOA");
		label_19.setForeground(Color.GRAY);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(502, 102, 115, 16);
		panel_1.add(label_19);
		
		JTextPane textNotas = new JTextPane();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {				
 				
 				textNotas.setText(PessoaFisica.notas); 				
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        PessoaFisica.notas = textNotas.getText();
			}
		});
		textNotas.setBounds(49, 450, 874, 76);		
		panel_1.add(textNotas);
		
		JLabel lblDetalharEAtualizar = new JLabel("DETALHAR E ATUALIZAR");
		lblDetalharEAtualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDetalharEAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalharEAtualizar.setForeground(Color.GRAY);
		lblDetalharEAtualizar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDetalharEAtualizar.setBounds(342, 62, 299, 28);
		panel_1.add(lblDetalharEAtualizar);
	}
}
