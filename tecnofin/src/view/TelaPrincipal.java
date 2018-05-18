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
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		setTitle("TECNOFIN - Tecnologia em Sistema de Controle Finaneiro");
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
		lblTecnofin.setForeground(Color.BLACK);
		lblTecnofin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTecnofin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTecnofin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTecnofin.setBounds(38, 6, 568, 87);
		contentPane.add(lblTecnofin);
		
		JButton btnBanco = new JButton("BANCO");
		btnBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
                tp.dispose();
                TelaBanco tb = new TelaBanco();
                tb.setVisible(true);
			}
		});
		btnBanco.setForeground(Color.BLACK);
		btnBanco.setToolTipText("Click para acessar os bancos de origem da empresa que realizam as transa\u00E7\u00F5s !");
		btnBanco.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBanco.setBounds(260, 144, 125, 75);
		btnBanco.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnBanco);
		
		JButton btnAcesso = new JButton("USU\u00C1RIO");
		btnAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
                tp.dispose();
                TelaCadLogin tr = new TelaCadLogin();
                tr.setVisible(true);
			}
		});
		btnAcesso.setForeground(Color.BLACK);
		btnAcesso.setToolTipText("Click para realizar permitir acesso de usu\u00E1rios ao sistema !");
		btnAcesso.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAcesso.setBounds(400, 144, 125, 75);
		contentPane.add(btnAcesso);
		
		JButton btnGerencial = new JButton("GERENCIAL");
		btnGerencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
                tp.dispose();
                RelatorioGerencial rg = new RelatorioGerencial();
                rg.setVisible(true);
			}
		});
		btnGerencial.setForeground(Color.BLACK);
		btnGerencial.setToolTipText("Click para acessar os relat\u00F3rios gerenciais !");
		btnGerencial.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGerencial.setBounds(400, 231, 125, 75);
		btnGerencial.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.add(btnGerencial);
		
		JButton btnConferencia = new JButton("CONFER\u00CANCIA");
		btnConferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
                tp.dispose();
                RelatorioConferencia rc = new RelatorioConferencia();
                rc.setVisible(true);
				
			}
		});
		btnConferencia.setForeground(Color.BLACK);
		btnConferencia.setToolTipText("Click para acessar os relat\u00F3rios de confer\u00EAncia !");
		btnConferencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConferencia.setBounds(260, 235, 125, 75);
		contentPane.add(btnConferencia);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSair.setBorder(null);
		btnSair.setBackground(new Color(255, 51, 0));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setToolTipText("Click para sair do sistema !");
		btnSair.setSize(new Dimension(10, 10));
		btnSair.setBounds(539, 403, 50, 40);
		contentPane.add(btnSair);
		
		JComboBox comboBoxMov = new JComboBox();
		comboBoxMov.setForeground(Color.BLACK);
		comboBoxMov.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxMov.getSelectedItem() == "TRANSAÇÃO")
				{
					//String s = (String) comboBoxMov.getSelectedItem();
					TelaPrincipal tp = new TelaPrincipal();
                    tp.dispose();
                    TelaTransacao tt = new TelaTransacao();
                    tt.setVisible(true);
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
					TelaPrincipal tp = new TelaPrincipal();
                    tp.dispose();
                    TelaDespesa tr = new TelaDespesa();
                    tr.setVisible(true);
				}
				
			}
		});
		comboBoxMov.setToolTipText("Selecione para acessar as transa\u00E7\u00F5es banc\u00E1rias, despesas e receitas !");
		comboBoxMov.setModel(new DefaultComboBoxModel(new String[] {"TRANSA\u00C7\u00C3O", "RECEITA", "DESPESA"}));
		comboBoxMov.setName("");
		comboBoxMov.setBounds(123, 235, 125, 75);
		contentPane.add(comboBoxMov);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem() == "PESSOA FÍSICA") 
				{
					TelaPrincipal tp = new TelaPrincipal();
                    tp.dispose();
                    TelaPF tpf = new TelaPF();
                    tpf.setVisible(true);
				}
				if(comboBox.getSelectedItem() == "PESSOA JURÍDICA") 
				{
					TelaPrincipal tp = new TelaPrincipal();
                    tp.dispose();
                    TelaPJ tpj = new TelaPJ();
                    tpj.setVisible(true);
				}
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PESSOA F\u00CDSICA", "PESSOA JUR\u00CDDICA"}));
		comboBox.setBounds(123, 145, 125, 75);
		contentPane.add(comboBox);
	}

	protected static void EXIT_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
