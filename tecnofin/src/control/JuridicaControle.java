package control;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import conexoes.Conexao;
import model.PessoaJuridica;

public class JuridicaControle {
	
	// M�todo para salvar no BD
	public void salvar()
    {       
		// Primeiro salvar dados na tabela Cadastro 
		// deixando as strings em maiusculo                
        String enderecoMaiusculo = PessoaJuridica.endereco.toUpperCase();
        String complementoMaiusculo = PessoaJuridica.complemento.toUpperCase();
        String ufMaiusculo = PessoaJuridica.uf.toUpperCase();
        String cidadeMaiusculo = PessoaJuridica.cidade.toUpperCase();
        String bairroMaiusculo = PessoaJuridica.bairro.toUpperCase();
        
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
            pstmt.setString(1, PessoaJuridica.email);
            pstmt.setString(2, PessoaJuridica.telefone);
            pstmt.setString(3, PessoaJuridica.celular);
            pstmt.setString(4, enderecoMaiusculo);
            pstmt.setString(5, PessoaJuridica.numero);
            pstmt.setString(6, complementoMaiusculo);
            pstmt.setString(7, ufMaiusculo);
            pstmt.setString(8, cidadeMaiusculo);
            pstmt.setString(9, bairroMaiusculo);
            pstmt.setString(10, PessoaJuridica.cep);
            pstmt.setString(11, PessoaJuridica.notas);
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
        
        // Segundo selecionar o ultimo id da tabela cadastro para salvar a chave estrangeira na tebela PessoaJuridica
        //	deixando as strings em maiusculo
        String nomeMaiusculo = PessoaJuridica.nomePJ.toUpperCase();
        conn = Conexao.getConexao(); //conectar ao banco de dados
        ResultSet rs = null;
        
        String sql2 = "SELECT * FROM cadastro WHERE idCadastro = (SELECT MAX(idCadastro) FROM cadastro);";
        
        String sql3 = "INSERT INTO pessoaJuridica (cnpj, nomePJ, bancoNomePJ, bancoNumPJ, agenciaPJ, tipoContaPJ, contaNumPJ, FK_idCadastro) "
        		+"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try
        {
            pstmt = conn.prepareStatement(sql2);
            rs = pstmt.executeQuery();
            int idfk = rs.getInt("idCadastro");
            
            pstmt = conn.prepareStatement(sql3);
            pstmt.setLong(1, PessoaJuridica.cnpj);
            pstmt.setString(2, nomeMaiusculo);
            pstmt.setString(3, PessoaJuridica.bancoNomePJ);
            pstmt.setInt(4, PessoaJuridica.bancoNumPJ);
            pstmt.setString(5, PessoaJuridica.agenciaPJ);
            pstmt.setString(6, PessoaJuridica.tipoContaPJ);
            pstmt.setString(7, PessoaJuridica.contaNumPJ);
            pstmt.setInt(8, idfk);
            pstmt.executeUpdate(); // Salvando no DB   
            JOptionPane.showMessageDialog(null, "Salvou com sucesso !");
        }
        catch(SQLException ex)
        {
        	JOptionPane.showMessageDialog(null, "CNPJ j� utilizado ! Erro: " + ex);
        }
        finally
        {
        	Conexao.fecharConexao(conn, pstmt);
        }
        
    }
	
	
	//M�todo para atualizar
    public void Atualizar()
    {    	
    	Connection conn = null;
        conn = Conexao.getConexao(); //conectar ao banco de dados
        PreparedStatement pstmt = null;
        
        String nomeMaiusculo = PessoaJuridica.nomePJ.toUpperCase();
        String enderecoMaiusculo = PessoaJuridica.endereco.toUpperCase();
        String complementoMaiusculo = PessoaJuridica.complemento.toUpperCase();
        String ufMaiusculo = PessoaJuridica.uf.toUpperCase();
        String cidadeMaiusculo = PessoaJuridica.cidade.toUpperCase();
        String bairroMaiusculo = PessoaJuridica.bairro.toUpperCase();
        
        String sql1 = "UPDATE pessoaJuridica SET cnpj = ?, nomePJ = ?, bancoNomePJ = ?, bancoNumPJ = ?, agenciaPJ = ?, tipoContaPJ = ?, contaNumPJ = ? WHERE cnpj = ?;";
        
        try
        {   
			pstmt = conn.prepareStatement(sql1);        	
			pstmt.setLong(1, PessoaJuridica.cnpj);
			pstmt.setString(2, nomeMaiusculo);
			pstmt.setString(3, PessoaJuridica.bancoNomePJ);
			pstmt.setInt(4, PessoaJuridica.bancoNumPJ);
			pstmt.setString(5, PessoaJuridica.agenciaPJ);
			pstmt.setString(6, PessoaJuridica.tipoContaPJ);
			pstmt.setString(7, PessoaJuridica.contaNumPJ);
			pstmt.setLong(8, PessoaJuridica.cnpj);
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
			pstmt.setString(1, PessoaJuridica.email);
			pstmt.setString(2, PessoaJuridica.telefone);
			pstmt.setString(3, PessoaJuridica.celular);
			pstmt.setString(4, enderecoMaiusculo);             
			pstmt.setString(5, PessoaJuridica.numero);
			pstmt.setString(6, complementoMaiusculo);
			pstmt.setString(7, ufMaiusculo);
			pstmt.setString(8, cidadeMaiusculo);
			pstmt.setString(9, bairroMaiusculo);
			pstmt.setString(10, PessoaJuridica.cep);
			pstmt.setString(11, PessoaJuridica.notas);
			pstmt.setInt(12, PessoaJuridica.FK_idCadastro);
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
    
    
    //	M�todo para apagar
    public void Deletar()
    {	
    	final JDesktopPane desk = new JDesktopPane();
        setContentPane(desk);
        int resposta = JOptionPane.showConfirmDialog(desk, "Deseja excluir ?", "Aten��o !",
        			   JOptionPane.YES_NO_CANCEL_OPTION);     //YES = 0, NO = 1, CANCEL = 2
    	if(resposta == 0)
    	{	
    		
	    	Connection conn = null;
	    	PreparedStatement pstmt = null;
	        conn = Conexao.getConexao(); //conectar ao banco de dados
	    	String sql1 = "DELETE FROM pessoaJuridica WHERE cnpj = ?;";
    	
        try
        {            
           	pstmt = conn.prepareStatement(sql1);
        	pstmt.setLong(1, PessoaJuridica.cnpj);
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
        	pstmt.setLong(1, PessoaJuridica.FK_idCadastro);
        	pstmt.executeUpdate();        	
            JOptionPane.showMessageDialog(null, "Dados exclu�dos com sucesso !");            
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
    		JOptionPane.showMessageDialog(null, "N�o foi exclu�do o registro");
    	}
    }

	private void setContentPane(JDesktopPane desk) {
		// TODO Auto-generated method stub		
	}

}