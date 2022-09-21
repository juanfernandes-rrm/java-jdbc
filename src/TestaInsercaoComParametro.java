import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cc = new ConnectionFactory();
		try(Connection connection = cc.recuperarConexao()){
			connection.setAutoCommit(false);
			
			try (
				PreparedStatement stm = 
						connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", 
								Statement.RETURN_GENERATED_KEYS)
				){
				adicionarVarriavel("SmartTV", "45 polegadas", stm);	
				adicionarVarriavel("Celular", "128gb", stm);
				connection.commit();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
		
	}
	
	public static void adicionarVarriavel(String nome, String descricao, PreparedStatement stm) throws Exception {
		stm.setString(1,nome);
		stm.setString(2,descricao);
		
		if(nome=="Celular") {
			throw new Exception("Produto não pode ser adicionado!");
		}
		
		stm.execute();
		
		try(ResultSet rs = stm.getGeneratedKeys()){
			while(rs.next()) {
				Integer id = rs.getInt(1);
				System.out.println("ID: "+id);
			}
		}
		
	}

}
