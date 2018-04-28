package conexoes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Raul
 */

public class Conexao {
	
	//atributos static para a conexao e serão final = uma constante
	//private static Connection conexao;
    private static final String DRIVER = "org.sqlite.JDBC"; 	// comando para abrir a biblioteca do SqLite
    private static final String URL = "jdbc:sqlite:C:/Users/famil/Documents/ProjetoTCC/tecnofin/src/BancoDados/BDtecnofin.db"; //url de conexao
	
	/**
	 * Método que conecta ao banco de dados 
	 * @return 
	 * @throws ClassNotFoundException 
	 */

 /*   
	public static Connection conectar()
	{
		try
		{
			// comando para abrir a biblioteca do SqLite
			Class.forName(DRIVER);			
			// conectar com o bano de dados			
            return (Connection) DriverManager.getConnection(URL);

		}
		catch (ClassNotFoundException | SQLException ex)
		{
			//System.err.println(e.getMessage());
            throw new RuntimeException("Algo errado com a conexão com o BD, erro: " + ex);

		}		
	}
	
	
	 public static void desconectar(Connection conn)
	    {
	        if(conn != null)//se o DB estiver conectado
	        {
	            try
	            {
	                conn.close();
	            }
	            catch(SQLException ex)
	            {
	                throw new RuntimeException("Algo errado com o fechamento da conexão com o BD, erro: " + ex);
	            }
	        }
	    }
	 
	
	*/
    
    public static Connection getConexao()
    {
        try
        {
            Class.forName(DRIVER);            
            return (Connection) DriverManager.getConnection(URL);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            throw new RuntimeException("Algo errado com a conexão com o BD, erro: " + ex);
        }
    }
    
    public static void fecharConexao(Connection conn)
    {
        if(conn != null)//se o DB estiver conectado
        {
            try
            {
                conn.close();
            }
            catch(SQLException ex)
            {
                throw new RuntimeException("Algo errado com o fechamento da conexão com o BD, erro: " + ex);
            }
        }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement stmt)
    {
        if(stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch(SQLException ex)
            {
                throw new RuntimeException("Algo errado com o fechamento da conexão com o BD, erro: " + ex);
            }
        }
        
        fecharConexao(conn);
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException ex)
            {
                throw new RuntimeException("Algo errado com o fechamento da conexão com o BD, erro: " + ex);
            }
        }
        
        fecharConexao(conn, stmt);
    }
	
	
}
