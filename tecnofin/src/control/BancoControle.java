package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.Banco;

public class BancoControle {
	
		// Método para salvar no BD
		public void salvar()
	    {       
			// Primeiro salvar dados na tabela Cadastro 
			// deixando as strings em maiusculo                
	        String enderecoMaiusculo = Banco.endereco.toUpperCase();
	        String complementoMaiusculo = Banco.complemento.toUpperCase();
	        String ufMaiusculo = Banco.uf.toUpperCase();
	        String cidadeMaiusculo = Banco.cidade.toUpperCase();
	        String bairroMaiusculo = Banco.bairro.toUpperCase();
	        
	        //data do sistema
	        Date datasistema = new Date();
	        SimpleDateFormat sdp = new SimpleDateFormat("dd/MM/yyyy");
	        String data = sdp.format(datasistema);
	                
	        Connection conn = null;
	        String sql1 = "INSERT INTO cadastro (email, telefone, celular, endereco, numero, complemento, uf, cidade, bairro, cep, notas, dataCadastro) "
	        		+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";        
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        PreparedStatement pstmt = null;
	        try
	        {
	            pstmt = conn.prepareStatement(sql1);    
	            pstmt.setString(1, Banco.email);
	            pstmt.setString(2, Banco.telefone);
	            pstmt.setString(3, Banco.celular);
	            pstmt.setString(4, enderecoMaiusculo);
	            pstmt.setString(5, Banco.numero);
	            pstmt.setString(6, complementoMaiusculo);
	            pstmt.setString(7, ufMaiusculo);
	            pstmt.setString(8, cidadeMaiusculo);
	            pstmt.setString(9, bairroMaiusculo);
	            pstmt.setString(10, Banco.cep);
	            pstmt.setString(11, Banco.notas);
	            pstmt.setString(12, data);
	            pstmt.executeUpdate(); // Salvando no DB                    
	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null, "Erro 1 ao salvar no banco de dados. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        
	        // Segundo selecionar o ultimo id da tabela cadastro para salvar a chave estrangeira na tebela Banco
	        //	deixando as strings em maiusculo e saldo padrão inicial de zero
	        String nomeMaiusculo = Banco.nome.toUpperCase();	        
	        String tipoContaMaiusculo = Banco.tipoConta.toUpperCase();
	        String gerenteMaiusculo = Banco.gerente.toUpperCase();
	        
	        Double saldo = 0.0;
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        ResultSet rs = null;
	        
	        String sql2 = "SELECT * FROM cadastro WHERE idCadastro = (SELECT MAX(idCadastro) FROM cadastro);";
	        
	        String sql3 = "INSERT INTO bancos (cnpjB, nome, numeroB, agencia, tipoConta, contaNum, gerente, saldo, FK_idCadastro) "
	        		+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	        try
	        {
	            pstmt = conn.prepareStatement(sql2);
	            rs = pstmt.executeQuery();
	            int idfk = rs.getInt("idCadastro");
	            
	            pstmt = conn.prepareStatement(sql3);
	            pstmt.setLong(1, Banco.cnpj);
	            pstmt.setString(2, nomeMaiusculo);
	            pstmt.setInt(3, Banco.bancoNum);
	            pstmt.setString(4, Banco.agencia);
	            pstmt.setString(5, tipoContaMaiusculo);
	            pstmt.setString(6, Banco.contaNum);
	            pstmt.setString(7, gerenteMaiusculo);
	            pstmt.setDouble(8, saldo);
	            pstmt.setInt(9, idfk);
	            pstmt.executeUpdate(); // Salvando no DB   
	            JOptionPane.showMessageDialog(null, "Salvou com sucesso !");
	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null, "Erro 2 ao salvar no banco de dados. Erro: " + ex);
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
	        PreparedStatement pstmt = null;
	        
	        String nomeMaiusculo = Banco.nome.toUpperCase();
	        String enderecoMaiusculo = Banco.endereco.toUpperCase();
	        String complementoMaiusculo = Banco.complemento.toUpperCase();
	        String ufMaiusculo = Banco.uf.toUpperCase();
	        String cidadeMaiusculo = Banco.cidade.toUpperCase();
	        String bairroMaiusculo = Banco.bairro.toUpperCase();
	        
	        String sql1 = "UPDATE bancos SET cnpjB = ?, nome = ?, numeroB = ?, agencia = ?, tipoConta = ?, contaNum = ?, gerente = ? WHERE idBancos = ?;";
	        
	        try
	        {   
				pstmt = conn.prepareStatement(sql1);        	
				pstmt.setLong(1, Banco.cnpj);
				pstmt.setString(2, nomeMaiusculo);
				pstmt.setInt(3, Banco.bancoNum);				
				pstmt.setString(4, Banco.agencia);
				pstmt.setString(5, Banco.tipoConta);
				pstmt.setString(6, Banco.contaNum);
				pstmt.setString(7, Banco.gerente);
				pstmt.setInt(8, Banco.idBancos);
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
	        
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        
	        String sql2 = "UPDATE cadastro SET email = ?, telefone = ?, celular = ?, endereco = ?, numero = ?, complemento = ?, uf = ?, cidade = ?, bairro = ?, cep = ?, notas = ?"
	        		+" WHERE idCadastro = ?;";
	        
	        try
	        {   				
				pstmt = conn.prepareStatement(sql2);	
				pstmt.setString(1, Banco.email);
				pstmt.setString(2, Banco.telefone);
				pstmt.setString(3, Banco.celular);
				pstmt.setString(4, enderecoMaiusculo);             
				pstmt.setString(5, Banco.numero);
				pstmt.setString(6, complementoMaiusculo);
				pstmt.setString(7, ufMaiusculo);
				pstmt.setString(8, cidadeMaiusculo);
				pstmt.setString(9, bairroMaiusculo);
				pstmt.setString(10, Banco.cep);
				pstmt.setString(11, Banco.notas);
				pstmt.setInt(12, Banco.FK_idCadastro);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro 2 ao atualizar no BD. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        
	        
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
		    	String sql1 = "DELETE FROM bancos WHERE idBancos = ?;";
	    	
	        try
	        {            
	           	pstmt = conn.prepareStatement(sql1);
	        	pstmt.setInt(1, Banco.idBancos);
	        	pstmt.executeUpdate();       	       
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro 1 ao deletar no BD. Erro: " + ex);
	        }
	        finally
	        {
	        	Conexao.fecharConexao(conn, pstmt);
	        }
	        
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	    	String sql2 = "DELETE FROM cadastro WHERE idCadastro = ?;";
	    	
	    	try
	        {   
	        	pstmt = conn.prepareStatement(sql2);
	        	pstmt.setInt(1, Banco.FK_idCadastro);
	        	pstmt.executeUpdate();        	
	            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso !");            
	        }
	        catch(SQLException ex)
	        {
	            JOptionPane.showMessageDialog(null, "Erro 2 ao deletar no BD. Erro: " + ex);
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
