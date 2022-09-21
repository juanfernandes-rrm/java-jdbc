package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private int id;
	public String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(int id,String nome) {
		this.id = id;
		this.nome = nome;
	}

	
	public int getId() {
		return id;
	}


	public String getNome() {
		return this.nome;
	}
	
	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}


	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
}
