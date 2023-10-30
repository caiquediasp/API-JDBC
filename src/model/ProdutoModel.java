	package model;

import java.util.List;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import util.Produto;

public class ProdutoModel {
	private ProdutoDAO produtoDAO;
	
	public ProdutoModel() {
		produtoDAO = new ProdutoDAOImpl();
	}
	
	public void inserirProduto(Produto produto) throws Exception {
		produtoDAO.inserirProduto(produto);
	}
	
	public Produto buscarPorId(int id) throws Exception {
		return produtoDAO.buscarPorId(id);
	}
	
	public List<Produto> listarProdutos() throws Exception {
		return produtoDAO.listarProdutos();
	}
	
	public void atualizarProduto(Produto produto) throws Exception {
		produtoDAO.atualizarProduto(produto);
	}
	
	public void excluirProduto(int idProduto) throws Exception {
		produtoDAO.excluirProduto(idProduto);
	}
}
