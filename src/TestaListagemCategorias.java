import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemCategorias {
	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias =  categoriaDAO.listarComProdutos();
			categorias.stream().forEach(lc -> {
				System.out.println(lc.getNome());
				for(Produto produto: lc.getProdutos()) {
					System.out.println(lc.getNome()+" - "+produto.getNome());
						
				}
			});
		}
	}
}
