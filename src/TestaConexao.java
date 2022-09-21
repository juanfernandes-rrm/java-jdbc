import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cc = new ConnectionFactory();
		Connection connection = cc.recuperarConexao();
		
		connection.close();
	}

}
