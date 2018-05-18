package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.JuridicaControle;
import control.ReceitaControle;
import model.PessoaJuridica;
import model.Receita;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AtualizarPJ extends JFrame {

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
	private JTextField textNomeBanco;
	private JTextField textBancoNum;
	private JTextField textAgencia;
	private JTextField textContaNum;
	private JTextField textTipoConta;
	private JTextField textRazao;
	private JTextField textCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarPJ frame = new AtualizarPJ();
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
		textNomeBanco.setText("");
		textBancoNum.setText("");
		textAgencia.setText("");
		textContaNum.setText("");
		textTipoConta.setText("");
		textRazao.setText("");
		textCnpj.setText("");
	}
	
	

	/**
	 * Create the frame.
	 */
	public AtualizarPJ() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
								
				textCnpj.setText(String.valueOf(PessoaJuridica.cnpj));				
				textNomeBanco.setText(PessoaJuridica.bancoNomePJ);				
				textRazao.setText(PessoaJuridica.nomePJ);				
				textBancoNum.setText(String.valueOf(PessoaJuridica.bancoNumPJ));			
				textAgencia.setText(PessoaJuridica.agenciaPJ);				
				textTipoConta.setText(PessoaJuridica.tipoContaPJ);				
				textContaNum.setText(PessoaJuridica.contaNumPJ);				
				textEmail.setText(PessoaJuridica.email);				
				textTelefone.setText(PessoaJuridica.telefone);				
				textCelular.setText(PessoaJuridica.celular);				
				textEndereco.setText(PessoaJuridica.endereco);				
				textNumero.setText(PessoaJuridica.numero);				
				textComplemento.setText(PessoaJuridica.complemento);				
				textUf.setText(PessoaJuridica.uf);				
				textCidade.setText(PessoaJuridica.cidade);				
 				textBairro.setText(PessoaJuridica.bairro); 				
 				textCep.setText(PessoaJuridica.cep);
 								
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarPJ.class.getResource("/Imagem/money-icon-title.jpg")));
		setMaximumSize(new Dimension(1000, 700));
		setMinimumSize(new Dimension(1000, 700));
		setPreferredSize(new Dimension(1000, 700));
		setSize(new Dimension(1000, 700));
		setTitle("Altera\u00E7\u00E3o e Detalhamento de Pessoa Juridica");
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
		
		JLabel label = new JLabel("PESSOA JUR\u00CDDICA");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(342, 16, 299, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("RAZ\u00C3O SOCIAL");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(60, 102, 115, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("N\u00BA BANCO");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(349, 173, 78, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("NOME DO BANCO");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(60, 173, 115, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("CNPJ");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(639, 102, 115, 16);
		panel.add(label_4);
		
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
		
		textNomeBanco = new JTextField();
		textNomeBanco.setColumns(10);
		textNomeBanco.setBounds(49, 189, 281, 28);
		panel.add(textNomeBanco);
		
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
		
		textRazao = new JTextField();
		textRazao.setColumns(10);
		textRazao.setBounds(49, 117, 554, 28);
		panel.add(textRazao);
		
		textCnpj = new JTextField();
		textCnpj.setColumns(10);
		textCnpj.setBounds(631, 117, 292, 28);
		panel.add(textCnpj);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String j = String.valueOf(PessoaJuridica.cnpj);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para atualizar");
		        }
		        else
		        {
		        	
		        	PessoaJuridica.cnpj = Long.parseLong(textCnpj.getText());
		        	PessoaJuridica.bancoNumPJ = Integer.parseInt(textBancoNum.getText());
		        	PessoaJuridica.bancoNomePJ = textNomeBanco.getText();
		        	PessoaJuridica.nomePJ = textRazao.getText();
		        	PessoaJuridica.agenciaPJ = textAgencia.getText();				
		        	PessoaJuridica.tipoContaPJ = textTipoConta.getText();				
		        	PessoaJuridica.contaNumPJ = textContaNum.getText();				
		        	PessoaJuridica.email = textEmail.getText();				
		        	PessoaJuridica.telefone = textTelefone.getText();				
		        	PessoaJuridica.celular = textCelular.getText();				
		        	PessoaJuridica.endereco = textEndereco.getText();				
		        	PessoaJuridica.numero = textNumero.getText();				
		        	PessoaJuridica.complemento = textComplemento.getText();				
		        	PessoaJuridica.uf = textUf.getText();				
		        	PessoaJuridica.cidade = textCidade.getText();				
		        	PessoaJuridica.bairro = textBairro.getText(); 				
		        	PessoaJuridica.cep = textCep.getText(); 
				    
				    JuridicaControle pj = new JuridicaControle();		     
				    pj.Atualizar();				    
				    limparCampos();
		        }			    
			}
		});
		btnAlterar.setForeground(Color.GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(222, 554, 125, 28);
		panel.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarPJ apj = new AtualizarPJ();
                apj.dispose();                
                ShowPJ spj = new ShowPJ();
                spj.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(639, 554, 125, 28);
		panel.add(btnVoltar);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarPJ apj = new AtualizarPJ();
                apj.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon(AtualizarPJ.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		btnHome.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnHome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHome.setBounds(465, 605, 53, 36);
		panel.add(btnHome);
		
		JTextPane textNotas = new JTextPane();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {				
 				
 				textNotas.setText(PessoaJuridica.notas); 				
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        PessoaJuridica.notas = textNotas.getText();
			}
		});		
		textNotas.setBounds(49, 452, 874, 76);
		panel.add(textNotas);
		
		JLabel lblDetalhamentoEAlterao = new JLabel("DETALHAMENTO E ALTERA\u00C7\u00C3O");
		lblDetalhamentoEAlterao.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDetalhamentoEAlterao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhamentoEAlterao.setForeground(Color.GRAY);
		lblDetalhamentoEAlterao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDetalhamentoEAlterao.setBounds(342, 58, 299, 28);
		panel.add(lblDetalhamentoEAlterao);
	}
}
