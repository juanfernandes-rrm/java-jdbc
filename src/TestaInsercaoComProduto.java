import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Cômoda","Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> produtos = produtoDAO.listar();
			produtos.stream().forEach(lp -> System.out.println(lp));
		}
		
		System.out.println(comoda.toString());
	}
}
