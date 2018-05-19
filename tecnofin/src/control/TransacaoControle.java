package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	        
	    }
		
		
		
		

}
