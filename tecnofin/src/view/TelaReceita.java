package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.ReceitaControle;
import model.Receita;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import conexoes.Conexao;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TelaReceita extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textContaReceita;
	private JTextField textNomeReceita;
	private JTable table;

	/**
	 * @author Raul
	 * @Método limparCampos
	 * @Método preencherTabela JTable com uma coluna oculta de idReceita
	 * @Método windowActivated para show das receitas na tabela por ordem de código do plano de contas
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReceita frame = new TelaReceita();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void limparCampos() 
	{
		textContaReceita.setText("");
	    textNomeReceita.setText("");
	}
	
	public void preencherTabela(String sql)
	{
		Connection conn = null;        
        conn = Conexao.getConexao(); //conectar ao banco de dados
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try
        {
            pstmt = conn.prepareStatement(sql);		            
            rs = pstmt.executeQuery();            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);//inicializar do primeiro elemento da tabela
            
            while(rs.next())
            {
                model.addRow(new Object[] 
                {
                    rs.getString("contaReceita"),
                    rs.getString("nomeReceita"),
                    rs.getString("idReceita"),
                });
            }		           
        }
        catch(SQLException ex)
        {
        	JOptionPane.showMessageDialog(null, "Erro ao exibir o banco de dados. Erro: " + ex);
        }
        finally
        {
        	Conexao.fecharConexao(conn, pstmt, rs);
        }
	}
	

	/**
	 * Create the frame.
	 */
	public TelaReceita() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				String sql = "SELECT * FROM receita ORDER BY contaReceita ASC;";
				preencherTabela(sql);
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\famil\\Documents\\ProjetoTCC\\tecnofin\\src\\Imagem\\money-icon-title.jpg"));
		setPreferredSize(new Dimension(650, 500));
		setMinimumSize(new Dimension(650, 500));
		setMaximumSize(new Dimension(650, 500));
		setTitle("Receitas");
		setSize(new Dimension(650, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanoDeContas = new JLabel("PLANO DE CONTAS A RECEBER");
		lblPlanoDeContas.setForeground(SystemColor.textHighlight);
		lblPlanoDeContas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlanoDeContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanoDeContas.setBounds(212, 48, 190, 16);
		contentPane.add(lblPlanoDeContas);
		
		JLabel lblReceitas = new JLabel("RECEITAS");
		lblReceitas.setForeground(SystemColor.textHighlight);
		lblReceitas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReceitas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceitas.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblReceitas.setBounds(254, 20, 105, 26);
		contentPane.add(lblReceitas);
		
		JLabel lblContaContbil = new JLabel("CONTA CONT\u00C1BIL");
		lblContaContbil.setBounds(119, 78, 111, 16);
		contentPane.add(lblContaContbil);
		
		JLabel lblNomeDaReceita = new JLabel("NOME DA RECEITA");
		lblNomeDaReceita.setBounds(247, 77, 114, 16);
		contentPane.add(lblNomeDaReceita);
		
		textContaReceita = new JTextField();
		textContaReceita.setBounds(116, 92, 114, 28);
		contentPane.add(textContaReceita);
		textContaReceita.setColumns(10);
		
		textNomeReceita = new JTextField();
		textNomeReceita.setBounds(242, 92, 263, 28);
		contentPane.add(textNomeReceita);
		textNomeReceita.setColumns(10);		
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  Receita.contaReceita = textContaReceita.getText();
			      Receita.nomeReceita = textNomeReceita.getText();
			      ReceitaControle rc = new ReceitaControle();
			      rc.salvar();
			      limparCampos();
			      String sql = "SELECT * FROM receita ORDER BY contaReceita ASC;";	      
			      preencherTabela(sql);
			      
			}
		});
		btnSalvar.setFont(new Font("SansSerif", Font.BOLD, 9));
		btnSalvar.setBounds(116, 127, 95, 28);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				String j = String.valueOf(Receita.idReceita);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para atualizar");
		        }
		        else
		        {
		        	Receita.contaReceita = textContaReceita.getText();
				    Receita.nomeReceita = textNomeReceita.getText(); 
		        	ReceitaControle rc = new ReceitaControle();
				    rc.Atualizar();
				    limparCampos();
				    String sql = "SELECT * FROM receita ORDER BY contaReceita ASC;";
				    preencherTabela(sql);
		        }
		        
			}
		});
		btnAlterar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAlterar.setFont(new Font("SansSerif", Font.BOLD, 9));
		btnAlterar.setBounds(312, 127, 95, 28);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            
				String j = String.valueOf(Receita.idReceita);
		        if(j.equals(""))
		        {
		            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha da planilha para deletar");
		        }
		        else
		        {
		        	ReceitaControle rc = new ReceitaControle();
				    rc.Deletar();
				    limparCampos();
				    String sql = "SELECT * FROM receita ORDER BY contaReceita ASC;";
				    preencherTabela(sql);		        	
		        }
			}
		});
		btnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir.setFont(new Font("SansSerif", Font.BOLD, 9));
		btnExcluir.setBounds(410, 127, 95, 28);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pesquisa pelo nome e código
				String sql = "SELECT * FROM receita WHERE nomeReceita LIKE ('%" 
		                + textNomeReceita.getText() 
		                + "%') AND contaReceita LIKE ('%"
		                + textContaReceita.getText()
		                + "%')"
		                + " ORDER BY contaReceita ASC;";				
				preencherTabela(sql);
				limparCampos();
		        
			}
		});
		btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 9));
		btnConsultar.setBounds(214, 127, 95, 28);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 201, 575, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int linha = table.getSelectedRow();//selecionar a linha da tabela e jogar na variável da Receita
		        textContaReceita.setText(table.getValueAt(linha, 0).toString());
		        textNomeReceita.setText(table.getValueAt(linha, 1).toString());
		        Receita.idReceita = Integer.parseInt((table.getValueAt(linha, 2).toString()));
		        Receita.contaReceita = textContaReceita.getText();
			    Receita.nomeReceita = textNomeReceita.getText();
		       
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00D3DIGO CONTA CONT\u00C1BIL", "NOME DA RECEITA", "ID RECEITA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(172);
		table.getColumnModel().getColumn(1).setPreferredWidth(320);
		table.getColumnModel().getColumn(2).setMaxWidth(0);  
		table.getColumnModel().getColumn(2).setMinWidth(0);  
		table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);  
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaReceita tr = new TelaReceita();
                tr.dispose();                
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaReceita.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		btnVoltar.setToolTipText("Click para voltar a tela principal do sistema TECNOFIN !");
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVoltar.setBounds(290, 416, 53, 36);
		contentPane.add(btnVoltar);
	}
}
