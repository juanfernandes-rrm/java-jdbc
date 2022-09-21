import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cc = new ConnectionFactory();
		Connection connection = cc.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES('Mouse','Sem fio')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		while(rs.next()) {
			Integer id = rs.getInt(1);
			System.out.println("ID: "+id);
		}
	}

}
