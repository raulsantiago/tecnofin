package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.Transacao;

public class TransacaoControle {
    
	
		// Método para salvar no BD
		public void salvar()
	    {       
			Connection conn = null;
	        PreparedStatement pstmt = null;


	        /* Selecionar o ultimo id das tabelas relacionadas para salvar a chave estrangeira na transacao	    
			
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        String sql1 = "SELECT * FROM despesa WHERE idDespesa = (SELECT MAX(idDespesa) FROM despesa);";
	        
	        String sql2 = "SELECT * FROM receita WHERE idReceita = (SELECT MAX(idReceita) FROM receita);";
	        		
	    	String sql3 = "SELECT * FROM bancos WHERE idBancos = (SELECT MAX(idBancos) FROM bancos);";

	        try
	        {
	            pstmt = conn.prepareStatement(sql1);
	            rs = pstmt.executeQuery();
	            int idDesp = rs.getInt("idDespesa");
	            
	            pstmt = conn.prepareStatement(sql2);
	            rs = pstmt.executeQuery();
	            int idRec = rs.getInt("idReceita");
	            
	            pstmt = conn.prepareStatement(sql3);
	            rs = pstmt.executeQuery();
	            int idBanc = rs.getInt("idBancos");
	            
	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt, rs);
	        }
	        
	        
	        //Quem foi selecionado no Combo Box recebe os valores devidos
	        if() 
	        {
	        	Transacao.FK_cpf
		        Transacao.FK_cnpj	
	        }
	        
	        
	        if() 
	        {
	        	Transacao.FK_idDespesa
		        Transacao.FK_idReceita	        	
	        }
	         
	         */
	        
	        // deixando as strings em maiusculo                
	        String tipoMaiusculo = Transacao.tipo.toUpperCase();
	        
	        // transacao_pf_pj   variavel do favorecido PF ou PJ selecioada
	        
	        // transacao_rec_desp   variavel da receita ou despesa selecioada
	        
	       
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
	        
	        
	        
	    }
		
		
		
		

}
