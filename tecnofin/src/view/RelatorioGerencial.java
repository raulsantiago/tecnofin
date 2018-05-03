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
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RelatorioGerencial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGerencial frame = new RelatorioGerencial();
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
	public RelatorioGerencial() {
		setTitle("Relat\u00F3rios Gerenciais");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioGerencial.class.getResource("/Imagem/money-icon-title.jpg")));
		setMaximumSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setPreferredSize(new Dimension(700, 500));
		setSize(new Dimension(700, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatriosGerenciais = new JLabel("RELAT\u00D3RIOS GERENCIAIS\r\n");
		lblRelatriosGerenciais.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRelatriosGerenciais.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatriosGerenciais.setForeground(Color.GRAY);
		lblRelatriosGerenciais.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRelatriosGerenciais.setBounds(80, 35, 524, 50);
		contentPane.add(lblRelatriosGerenciais);
		
		JLabel lblGerarRelatrioDas = new JLabel("GERAR RELAT\u00D3RIO DAS RECEITAS");
		lblGerarRelatrioDas.setForeground(Color.GRAY);
		lblGerarRelatrioDas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGerarRelatrioDas.setBounds(35, 167, 495, 30);
		contentPane.add(lblGerarRelatrioDas);
		
		JLabel lblGerarRelatrioDas_1 = new JLabel("GERAR RELAT\u00D3RIO DAS DESPESAS");
		lblGerarRelatrioDas_1.setForeground(Color.GRAY);
		lblGerarRelatrioDas_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGerarRelatrioDas_1.setBounds(35, 223, 505, 30);
		contentPane.add(lblGerarRelatrioDas_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(RelatorioGerencial.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		button.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		button.setFont(new Font("SansSerif", Font.BOLD, 12));
		button.setBounds(317, 393, 53, 36);
		contentPane.add(button);
		
		JLabel lblGerarRelatrioDe = new JLabel("GERAR RELAT\u00D3RIO DE INVESTIMENTOS FINANCEIROS");
		lblGerarRelatrioDe.setForeground(Color.GRAY);
		lblGerarRelatrioDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGerarRelatrioDe.setBounds(35, 276, 505, 30);
		contentPane.add(lblGerarRelatrioDe);
	}

}
