package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Login;
import control.LoginConexao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("TECNOFIN - Tecnologia em Sistema de Controle Finaneiro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		setSize(new Dimension(650, 500));
		setPreferredSize(new Dimension(500, 500));
		setFocusTraversalKeysEnabled(false);
		setFocusCycleRoot(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTecnofin = new JLabel("TECNOFIN");
		lblTecnofin.setBorder(null);
		lblTecnofin.setBounds(190, 52, 197, 62);
		lblTecnofin.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		lblTecnofin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTecnofin.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTecnofin.setBackground(new Color(0, 102, 102));
		lblTecnofin.setForeground(Color.GRAY);
		lblTecnofin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTecnofin.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblEmail = new JLabel("Digite seu e-mail");
		lblEmail.setBounds(109, 136, 119, 20);
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblDigiteSuaSenha = new JLabel("Digite sua senha");
		lblDigiteSuaSenha.setBounds(109, 206, 119, 20);
		lblDigiteSuaSenha.setForeground(Color.GRAY);
		lblDigiteSuaSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(109, 227, 400, 30);
		
		JFormattedTextField txtEmail = new JFormattedTextField();
		txtEmail.setBounds(109, 156, 400, 30);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.email = txtEmail.getText();
				Login.senha = new String(txtSenha.getPassword());
				LoginConexao vg = new LoginConexao();
			    vg.verificarLogin();  //é o método de verificar o usuário	
				
			}
		});
		btnEntrar.setBounds(259, 279, 150, 30);
		btnEntrar.setForeground(Color.GRAY);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().setLayout(null);
		getContentPane().add(lblTecnofin);
		getContentPane().add(lblEmail);
		getContentPane().add(lblDigiteSuaSenha);
		getContentPane().add(txtSenha);
		getContentPane().add(txtEmail);
		getContentPane().add(btnEntrar);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTecnofin, lblEmail, lblDigiteSuaSenha, txtSenha, txtEmail, btnEntrar}));
	}
}
