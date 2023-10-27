package dao;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {
	void inserirProduto(Produto produto) throws ClassNotFoundException;
	
	List<Produto> listarProdutos() throws ClassNotFoundException;
	
	Produto buscarPorId(int idProduto) throws ClassNotFoundException;
	
	void atualizarProduto(int idProduto, Produto produto) throws ClassNotFoundException;
	
	void excluirProduto(int idProduto) throws ClassNotFoundException;
}
