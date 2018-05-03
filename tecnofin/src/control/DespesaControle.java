package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.Despesa;

/** 
	 * @author Raul
	 * @Método de CRUD para Despesas
	 */
	
	public class DespesaControle {
		
		// Método para salvar no BD
		public void salvar()
	    {       
			 //deixando as strings em maiusculo
	        String contaDespesaMaiusculo = Despesa.contaDespesa.toUpperCase();
	        String nomeDespesaMaiusculo = Despesa.nomeDespesa.toUpperCase();
	        Connection conn = null;
	        String sql = "INSERT INTO despesa (contaDespesa, nomeDespesa) "+"VALUES (?, ?);";
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        PreparedStatement pstmt = null;
	        
	      
	        try
	        {
	            pstmt = conn.prepareStatement(sql);    
	            pstmt.setString(1, contaDespesaMaiusculo);
	            pstmt.setString(2, nomeDespesaMaiusculo); 
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
	        String contaDespesaM = Despesa.contaDespesa.toUpperCase();
	        String nomeDespesaM = Despesa.nomeDespesa.toUpperCase();
	    	String sql = "UPDATE despesa SET contaDespesa = ?, nomeDespesa = ? WHERE idDespesa = ?;";    	
	        PreparedStatement pstmt = null;
	        
	        try
	        {   
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, contaDespesaM);
	        	pstmt.setString(2, nomeDespesaM);
	        	pstmt.setInt(3, Despesa.idDespesa);
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
	    	String sql = "DELETE FROM despesa WHERE idDespesa = ?;";
	        PreparedStatement pstmt = null;
	        
	        try
	        {            
	           	pstmt = conn.prepareStatement(sql);
	        	pstmt.setInt(1, Despesa.idDespesa);
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

