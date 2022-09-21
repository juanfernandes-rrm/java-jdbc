import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cc = new ConnectionFactory();
		Connection connection = cc.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		//retorna o número de linhas modificadas após o statement
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("LinhasModificadas: "+linhasModificadas);
	}

}
