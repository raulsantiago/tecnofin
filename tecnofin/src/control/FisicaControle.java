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
import model.PessoaFisica;


public class FisicaControle {
	
	// Método para salvar no BD
		public void salvar()
	    {       
			// Primeiro salvar dados na tabela Cadastro 
			// deixando as strings em maiusculo                
	        String enderecoMaiusculo = PessoaFisica.endereco.toUpperCase();
	        String complementoMaiusculo = PessoaFisica.complemento.toUpperCase();
	        String ufMaiusculo = PessoaFisica.uf.toUpperCase();
	        String cidadeMaiusculo = PessoaFisica.cidade.toUpperCase();
	        String bairroMaiusculo = PessoaFisica.bairro.toUpperCase();
	        
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
	            pstmt.setString(1, PessoaFisica.email);
	            pstmt.setString(2, PessoaFisica.telefone);
	            pstmt.setString(3, PessoaFisica.celular);
	            pstmt.setString(4, enderecoMaiusculo);
	            pstmt.setString(5, PessoaFisica.numero);
	            pstmt.setString(6, complementoMaiusculo);
	            pstmt.setString(7, ufMaiusculo);
	            pstmt.setString(8, cidadeMaiusculo);
	            pstmt.setString(9, bairroMaiusculo);
	            pstmt.setString(10, PessoaFisica.cep);
	            pstmt.setString(11, PessoaFisica.notas);
	            pstmt.setString(12, data);
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
	        
	        // Segundo selecionar o ultimo id da tabela cadastro para salvar a chave estrangeira na tebela PessoaFisica
	        //	deixando as strings em maiusculo
	        String nomeMaiusculo = PessoaFisica.nomePF.toUpperCase();
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	        ResultSet rs = null;
	        
	        String sql2 = "SELECT * FROM cadastro WHERE idCadastro = (SELECT MAX(idCadastro) FROM cadastro);";
	        
	        String sql3 = "INSERT INTO PessoaFisica (cpf, nomePF, tipoPF, bancoNomePF, bancoNumPF, agenciaPF, tipoContaPF, contaNumPF, FK_idCadastro) "
	        		+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	        try
	        {
	            pstmt = conn.prepareStatement(sql2);
	            rs = pstmt.executeQuery();
	            int idfk = rs.getInt("idCadastro");
	            
	            pstmt = conn.prepareStatement(sql3);
	            pstmt.setLong(1, PessoaFisica.cpf);
	            pstmt.setString(2, nomeMaiusculo);
	            pstmt.setString(3, PessoaFisica.tipoPF);
	            pstmt.setString(4, PessoaFisica.bancoNomePF);
	            pstmt.setInt(5, PessoaFisica.bancoNumPF);
	            pstmt.setString(6, PessoaFisica.agenciaPF);
	            pstmt.setString(7, PessoaFisica.tipoContaPF);
	            pstmt.setString(8, PessoaFisica.contaNumPF);
	            pstmt.setInt(9, idfk);
	            pstmt.executeUpdate(); // Salvando no DB   
	            JOptionPane.showMessageDialog(null, "Salvou com sucesso !");
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
	        PreparedStatement pstmt = null;
	        
	        String nomeMaiusculo = PessoaFisica.nomePF.toUpperCase();
	        String enderecoMaiusculo = PessoaFisica.endereco.toUpperCase();
	        String complementoMaiusculo = PessoaFisica.complemento.toUpperCase();
	        String ufMaiusculo = PessoaFisica.uf.toUpperCase();
	        String cidadeMaiusculo = PessoaFisica.cidade.toUpperCase();
	        String bairroMaiusculo = PessoaFisica.bairro.toUpperCase();
	        
	        String sql1 = "UPDATE PessoaFisica SET cpf = ?, nomePF = ?, tipoPF = ?, bancoNomePF = ?, bancoNumPF = ?, agenciaPF = ?, tipoContaPF = ?, contaNumPF = ? WHERE cpf = ?;";
	        
	        try
	        {   
				pstmt = conn.prepareStatement(sql1);        	
				pstmt.setLong(1, PessoaFisica.cpf);
				pstmt.setString(2, nomeMaiusculo);
	            pstmt.setString(3, PessoaFisica.tipoPF);
				pstmt.setString(4, PessoaFisica.bancoNomePF);
				pstmt.setInt(5, PessoaFisica.bancoNumPF);
				pstmt.setString(6, PessoaFisica.agenciaPF);
				pstmt.setString(7, PessoaFisica.tipoContaPF);
				pstmt.setString(8, PessoaFisica.contaNumPF);
				pstmt.setLong(9, PessoaFisica.cpf);
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
				pstmt.setString(1, PessoaFisica.email);
				pstmt.setString(2, PessoaFisica.telefone);
				pstmt.setString(3, PessoaFisica.celular);
				pstmt.setString(4, enderecoMaiusculo);             
				pstmt.setString(5, PessoaFisica.numero);
				pstmt.setString(6, complementoMaiusculo);
				pstmt.setString(7, ufMaiusculo);
				pstmt.setString(8, cidadeMaiusculo);
				pstmt.setString(9, bairroMaiusculo);
				pstmt.setString(10, PessoaFisica.cep);
				pstmt.setString(11, PessoaFisica.notas);
				pstmt.setInt(12, PessoaFisica.FK_idCadastro);
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
		    	String sql1 = "DELETE FROM PessoaFisica WHERE cpf = ?;";
	    	
	        try
	        {            
	           	pstmt = conn.prepareStatement(sql1);
	        	pstmt.setLong(1, PessoaFisica.cpf);
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
	        	pstmt.setLong(1, PessoaFisica.FK_idCadastro);
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
