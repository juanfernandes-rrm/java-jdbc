import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cc = new ConnectionFactory();
		Connection connection = cc.recuperarConexao();
		
		//recebe um statement
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		//executa o statement
		stm.execute();
		
		//retorno do statement
		ResultSet rs = stm.getResultSet();
		
		while(rs.next()) {
			Integer id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao  = rs.getString("DESCRICAO");
			System.out.println("ID: "+id+", Nome: "+nome+", Descricao: "+descricao);
		}
		
		
		
		connection.close();
		
	}

}
