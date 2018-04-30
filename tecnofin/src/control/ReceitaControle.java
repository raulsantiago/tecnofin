package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.Receita;

/** 
 * @author Raul
 * @Método de CRUD para Receitas
 */

public class ReceitaControle {
	
	// Método para salvar no BD
	public void salvar()
    {       
		 //deixando as strings em maiusculo
        String contaReceitaMaiusculo = Receita.contaReceita.toUpperCase();
        String nomeReceitaMaiusculo = Receita.nomeReceita.toUpperCase();
        Connection conn = null;
        String sql = "INSERT INTO receita (contaReceita, nomeReceita) "+"VALUES (?, ?);";
        conn = Conexao.getConexao(); //conectar ao banco de dados
        PreparedStatement pstmt = null;
        
      
        try
        {
            pstmt = conn.prepareStatement(sql);    
            pstmt.setString(1, contaReceitaMaiusculo);
            pstmt.setString(2, nomeReceitaMaiusculo); 
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
        String contaReceitaM = Receita.contaReceita.toUpperCase();
        String nomeReceitaM = Receita.nomeReceita.toUpperCase();
    	String sql = "UPDATE receita SET contaReceita = ?, nomeReceita = ? WHERE idReceita = ?;";    	
        PreparedStatement pstmt = null;
        
        try
        {   
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, contaReceitaM);
        	pstmt.setString(2, nomeReceitaM);
        	pstmt.setInt(3, Receita.idReceita);
        	pstmt.executeUpdate();
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
    	String sql = "DELETE FROM receita WHERE idReceita = ?;";
        PreparedStatement pstmt = null;
        
        try
        {            
           	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, Receita.idReceita);
        	pstmt.executeUpdate();            
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
