package controller;

import dao.ProdutoDAOImpl;
import model.Produto;
import view.ProdutoView;

public class ProdutoController {
	private ProdutoView view = new ProdutoView();
	public ProdutoDAOImpl crud = new ProdutoDAOImpl();
	
	public void inserirProduto(Produto produto) throws ClassNotFoundException {
		crud.inserirProduto(produto);
	}
	
	public void buscarPorId(int id) throws ClassNotFoundException {
		view.printProduto(crud.buscarPorId(id));
	}
	
	public void listarProdutos() throws ClassNotFoundException {
		view.listarProdutos(crud.listarProdutos());
	}
	
	public void atualizarProduto(int id, Produto produto) throws ClassNotFoundException {
		try {
			crud.atualizarProduto(id, produto);
			System.out.println("Produto atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluirProduto(int id) throws ClassNotFoundException {
		crud.excluirProduto(id);
		System.out.println("Produto excluido com sucesso!");
	}
	
}
