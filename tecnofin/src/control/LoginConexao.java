package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.Login;
import view.TelaLogin;
import view.TelaPrincipal;

/** 
 * @author Raul
 * @Método de CRUD para Login
 * @Método de Autenticação de login
 */


public class LoginConexao {
	
	public void verificarLogin()
    {
         
        Connection conn = null;
        String sql = "SELECT * FROM login WHERE email in ('" + Login.email + "');";
        conn = Conexao.getConexao(); //conectar ao banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null;
               
        try
        {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if(rs.next())
            {
            String usuario = rs.getString("email");
            String password = rs.getString("senha");
            Login.admin = rs.getInt("admin");
                if(usuario.equals(Login.email) && password.equals(Login.senha))
                {
                    TelaPrincipal tp = new TelaPrincipal();
                    tp.setVisible(true);
                    TelaLogin tl = new TelaLogin();                    
                    tl.dispose();
                 }
            } else
            {
            	JOptionPane.showMessageDialog(null, "Digitou o email e/ou a senha errado !");
                Conexao.fecharConexao(conn);               
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao entrar no banco de dados. Erro: " + ex);
        }
        finally
        {
        	Conexao.fecharConexao(conn);
        }
    }
	
	// Método para salvar no BD
		public void salvar()
	    {       
			 //deixando as strings em maiusculo
	        String nomeMaiusculo = Login.nome.toUpperCase();
	        String cargoMaiusculo = Login.cargo.toUpperCase();
	        Connection conn = null;
	        String sql = "INSERT INTO login (nome, email, cargo, senha, admin) "+"VALUES (?, ?, ?, ?, ?);";
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        PreparedStatement pstmt = null;
	        
	      
	        try
	        {
	            pstmt = conn.prepareStatement(sql);    
	            pstmt.setString(1, nomeMaiusculo);
	            pstmt.setString(2, Login.email);
	            pstmt.setString(3, cargoMaiusculo);
	            pstmt.setString(4, Login.senha);
	            pstmt.setInt(5, Login.admin);
	            pstmt.executeUpdate(); // Salvando no DB                    
	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	    }
		
		
		//Método para atualizar
	    public void Atualizar()
	    {    	
	    	Connection conn = null;
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        String nomeMaiusculo = Login.nome.toUpperCase();
	        String cargoMaiusculo = Login.cargo.toUpperCase();
	    	String sql = "UPDATE login SET nome = ?, email = ?, cargo = ?, senha = ?, admin = ? WHERE idLogin = ?;"; 	
	        PreparedStatement pstmt = null; 
	        
	        try
	        {   
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, nomeMaiusculo);
		        pstmt.setString(2, Login.email);
		        pstmt.setString(3, cargoMaiusculo);
		        pstmt.setString(4, Login.senha);
		        pstmt.setInt(5, Login.admin); 
	        	pstmt.setInt(6, Login.idLogin);
	        	pstmt.executeUpdate(); // Salvando no DB
	            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro ao atualizar no BD. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	    }
	    
	    
	  //Método para apagar
	    public void Deletar()
	    {
	    	final JDesktopPane desk = new JDesktopPane();
	        setContentPane(desk);
	        int resposta = JOptionPane.showConfirmDialog(desk, "Deseja excluir ?", "Atenção !",
	        		JOptionPane.YES_NO_CANCEL_OPTION);     //YES = 0, NO = 1, CANCEL = 2
	    	if(resposta == 0)
	    	{
	    	
	    	Connection conn = null;
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	    	String sql = "DELETE FROM login WHERE idLogin = ?;";
	        PreparedStatement pstmt = null;
	        
	        try
	        {            
	           	pstmt = conn.prepareStatement(sql);
	        	pstmt.setInt(1, Login.idLogin);
	        	pstmt.executeUpdate();  // Salvando no DB           
	            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso !");            
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro ao deletar no BD. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        
	    	} else
	    	{
	    		JOptionPane.showMessageDialog(null, "Não foi excluído o registro");
	    	}
	    }


		private void setContentPane(JDesktopPane desk) {
			// TODO Auto-generated method stub
			
		}
}
