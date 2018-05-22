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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RelatorioConferencia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioConferencia frame = new RelatorioConferencia();
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
	public RelatorioConferencia() {
		setSize(new Dimension(700, 500));
		setPreferredSize(new Dimension(700, 500));
		setMaximumSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioConferencia.class.getResource("/Imagem/money-icon-title.jpg")));
		setTitle("Relat\u00F3rios de Confer\u00EAncia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatriosDasTransaes = new JLabel("RELAT\u00D3RIOS DE CONFER\u00CANCIA\r\n");
		lblRelatriosDasTransaes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatriosDasTransaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatriosDasTransaes.setForeground(Color.GRAY);
		lblRelatriosDasTransaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatriosDasTransaes.setBounds(80, 19, 524, 50);
		contentPane.add(lblRelatriosDasTransaes);
		
		JLabel lblRelatrioTransacao = new JLabel("GERAR RELAT\u00D3RIO DAS TRANSA\u00C7\u00D5ES BANC\u00C1RIAS");
		lblRelatrioTransacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RelatorioConferencia rg = new RelatorioConferencia();
                rg.dispose();
                RelatorioTransacao tp = new RelatorioTransacao();                
                tp.setVisible(true);
				
			}
		});
		lblRelatrioTransacao.setForeground(Color.GRAY);
		lblRelatrioTransacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatrioTransacao.setBounds(20, 151, 495, 30);
		contentPane.add(lblRelatrioTransacao);
		
		JLabel lblRelatrioSaldo = new JLabel("GERAR RELAT\u00D3RIO DE SALDO DAS CONTAS BANC\u00C1RIAS");
		lblRelatrioSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RelatorioConferencia rg = new RelatorioConferencia();
                rg.dispose();
                RelatorioSaldo tp = new RelatorioSaldo();                
                tp.setVisible(true);
			}
		});
		lblRelatrioSaldo.setForeground(Color.GRAY);
		lblRelatrioSaldo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatrioSaldo.setBounds(20, 203, 505, 30);
		contentPane.add(lblRelatrioSaldo);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioConferencia rg = new RelatorioConferencia();
                rg.dispose();
                TelaPrincipal tp = new TelaPrincipal();                
                tp.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(RelatorioConferencia.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		button.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		button.setFont(new Font("SansSerif", Font.BOLD, 12));
		button.setBounds(302, 377, 53, 36);
		contentPane.add(button);
	}
}
