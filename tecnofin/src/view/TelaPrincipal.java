package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/Imagem/money-icon-title.jpg")));
		setSize(new Dimension(650, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 500);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTecnofin = new JLabel("Bem vindo ao sistema TECNOFIN");
		lblTecnofin.setForeground(SystemColor.textHighlight);
		lblTecnofin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTecnofin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTecnofin.setFont(new Font("AR JULIAN", Font.BOLD, 27));
		lblTecnofin.setBounds(0, 6, 644, 87);
		contentPane.add(lblTecnofin);
		
		JButton btnPessoas = new JButton("PESSOAS");
		btnPessoas.setToolTipText("Click para acessar as pessoas f\u00EDsicas e jur\u00EDdicas que movimentam as transa\u00E7\u00F5es !");
		btnPessoas.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnPessoas.setBounds(400, 144, 125, 75);
		contentPane.add(btnPessoas);
		
		JButton btnBanco = new JButton("BANCO");
		btnBanco.setToolTipText("Click para acessar os bancos de origem da empresa que realizam as transa\u00E7\u00F5s !");
		btnBanco.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnBanco.setBounds(260, 144, 125, 75);
		btnBanco.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnBanco);
		
		JButton btnAcesso = new JButton("ACESSO");
		btnAcesso.setToolTipText("Click para realizar permitir acesso de usu\u00E1rios ao sistema !");
		btnAcesso.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnAcesso.setBounds(400, 235, 125, 75);
		contentPane.add(btnAcesso);
		
		JButton btnGerencial = new JButton("GERENCIAL");
		btnGerencial.setToolTipText("Click para acessar os relat\u00F3rios gerenciais !");
		btnGerencial.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnGerencial.setBounds(122, 235, 125, 75);
		btnGerencial.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.add(btnGerencial);
		
		JButton btnConferencia = new JButton("CONFER\u00CANCIA");
		btnConferencia.setToolTipText("Click para acessar os relat\u00F3rios de confer\u00EAncia !");
		btnConferencia.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		btnConferencia.setBounds(260, 235, 125, 75);
		contentPane.add(btnConferencia);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setToolTipText("Click para sair do sistema !");
		btnSair.setSize(new Dimension(10, 10));
		btnSair.setBounds(539, 403, 84, 39);
		contentPane.add(btnSair);
		
		JComboBox comboBoxMov = new JComboBox();
		comboBoxMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxMov.getSelectedItem() == "TRANSAÇÃO")
				{
					String s = (String) comboBoxMov.getSelectedItem();
					System.out.println(s);
				}
				if(comboBoxMov.getSelectedItem() == "RECEITA") 
				{
					TelaPrincipal tp = new TelaPrincipal();
                    tp.dispose();
                    TelaReceita tr = new TelaReceita();
                    tr.setVisible(true);
				}
				if(comboBoxMov.getSelectedItem() == "DESPESA") 
				{
					String st = (String) comboBoxMov.getSelectedItem();
					System.out.println(st);
				}
				
			}
		});
		comboBoxMov.setToolTipText("Selecione para acessar as transa\u00E7\u00F5es banc\u00E1rias, despesas e receitas !");
		comboBoxMov.setModel(new DefaultComboBoxModel(new String[] {"TRANSA\u00C7\u00C3O", "RECEITA", "DESPESA"}));
		comboBoxMov.setName("");
		comboBoxMov.setBounds(122, 143, 125, 75);
		contentPane.add(comboBoxMov);
	}
}
