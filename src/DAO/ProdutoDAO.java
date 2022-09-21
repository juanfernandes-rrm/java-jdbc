package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class ProdutoDAO {

	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (NOME, DESCRICAO) VALUES (?, ?)";
		try(PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			psmt.setString(1, produto.getNome());
			psmt.setString(2, produto.getDescricao());
			psmt.execute();
		
			try(ResultSet rs = psmt.getGeneratedKeys()){
				while(rs.next()) {
					produto.setId(rs.getInt(1));
				}
			}
		}
	}
	
	public List<Produto> listar() throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			try(ResultSet rs = pstm.getResultSet()){
				while(rs.next()) {
					Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
		
	}
	
	public List<Produto> buscar(Categoria ct) throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID=?";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, ct.getId());
			pstm.execute();
			try(ResultSet rs = pstm.getResultSet()){
				while(rs.next()) {
					Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
		
	}
	
}
