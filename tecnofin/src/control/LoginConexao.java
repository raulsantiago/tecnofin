package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.Login;
import view.TelaLogin;
import view.TelaPrincipal;

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
}
