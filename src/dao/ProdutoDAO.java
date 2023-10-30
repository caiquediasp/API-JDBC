package dao;

import java.util.List;

import util.Produto;

public interface ProdutoDAO {
	void inserirProduto(Produto produto) throws Exception;
	
	List<Produto> listarProdutos() throws Exception;
	
	Produto buscarPorId(int idProduto) throws Exception;
	
	void atualizarProduto(Produto produto) throws Exception;
	
	void excluirProduto(int idProduto) throws Exception;
}
