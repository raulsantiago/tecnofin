package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.PessoaJuridica;
import model.Transacao;

public class TransacaoControle {
    
	
		// Método para salvar no BD
		public void salvar()
	    {       
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        // deixando as strings em maiusculo                
	        String tipoMaiusculo = Transacao.tipo.toUpperCase();
	        String sql = "INSERT INTO transacao (tipo, dataTransacao, valor, descricao, FK_idDespesa, FK_idReceita, FK_cnpj, FK_cpf, FK_idBancos) "
	        		+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";        
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        
	        try
	        {
	            pstmt = conn.prepareStatement(sql);    
	            pstmt.setString(1, tipoMaiusculo);
	            pstmt.setString(2, Transacao.dataTransacao);
	            pstmt.setDouble(3, Transacao.valor);
	            pstmt.setString(4, Transacao.descricao);
	            pstmt.setInt(5, Transacao.FK_idDespesa);
	            pstmt.setInt(6, Transacao.FK_idReceita);
	            pstmt.setLong(7, Transacao.FK_cnpj);
	            pstmt.setLong(8, Transacao.FK_cpf);
	            pstmt.setInt(9, Transacao.FK_idBancos);
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
	        
	        // Alterando o saldo na tabela bancos
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        	        
	        String sql2 = "UPDATE bancos SET saldo = ? WHERE idBancos = ?;";
	        
	        try
	        {   
				pstmt = conn.prepareStatement(sql2);        	
				pstmt.setDouble(1, Transacao.saldo);		
				pstmt.setInt(2, Transacao.FK_idBancos);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados salvo com sucesso !");
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro ao atualizar no BD tabela bancos. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        JOptionPane.showMessageDialog(null, "Dados salvo com sucesso !");
	        
	    }
		
		
		//Método para atualizar
	    public void Atualizar()
	    {    	
	    	Connection conn = null;
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        PreparedStatement pstmt = null;
	        
	        String sql1 = "UPDATE transacao SET tipo = ?, dataTransacao = ?, valor = ?, descricao = ?, FK_idDespesa = ?, FK_idReceita = ?, FK_idBancos = ?, FK_cpf = ?, FK_cnpj = ? WHERE idTransacao = ?;";
	        
	        try
	        {   
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, Transacao.tipo);
				pstmt.setString(2, Transacao.dataTransacao);
				pstmt.setDouble(3, Transacao.valor);
				pstmt.setString(4, Transacao.descricao);
				pstmt.setInt(5, Transacao.FK_idDespesa);
				pstmt.setInt(6, Transacao.FK_idReceita);
				pstmt.setInt(7, Transacao.FK_idBancos);
				pstmt.setLong(8, Transacao.FK_cpf);
				pstmt.setLong(9, Transacao.FK_cnpj);
				pstmt.setInt(10, Transacao.idTransacao);				
				pstmt.executeUpdate();
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro 1 ao atualizar no BD. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        
	        
	        // Alterando o saldo na tabela bancos
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        	        
	        String sql2 = "UPDATE bancos SET saldo = ? WHERE idBancos = ?;";
	        
	        try
	        {   
				pstmt = conn.prepareStatement(sql2);        	
				pstmt.setDouble(1, Transacao.saldo);	
				pstmt.setInt(2, Transacao.FK_idBancos);
				pstmt.executeUpdate();
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro ao atualizar no BD tabela bancos. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
	        
	        
	        
	    }
	    
	    
	    //	Método para apagar
	    public void Deletar()
	    {	
	    	final JDesktopPane desk = new JDesktopPane();
	        setContentPane(desk);
	        int resposta = JOptionPane.showConfirmDialog(desk, "Deseja excluir ?", "Atenção !",
	        			   JOptionPane.YES_NO_CANCEL_OPTION);     //YES = 0, NO = 1, CANCEL = 2
	    	if(resposta == 0)
	    	{	
	    		
		    	Connection conn = null;
		    	PreparedStatement pstmt = null;
		        conn = Conexao.getConexao(); //conectar ao banco de dados
		    	String sql1 = "DELETE FROM transacao WHERE idTransacao = ?;";	    	
	        try
	        {            
	           	pstmt = conn.prepareStatement(sql1);
	        	pstmt.setInt(1, Transacao.idTransacao);
	        	pstmt.executeUpdate(); 
	        	JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso !");
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro 1 ao deletar no BD. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        
	    	}
	    	
	    }

		private void setContentPane(JDesktopPane desk) {
			
		}

		

}
