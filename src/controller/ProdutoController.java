package controller;

import java.util.List;

import model.ProdutoModel;
import util.Produto;
import view.ProdutoView;

public class ProdutoController {
	private ProdutoModel produtoModel = new ProdutoModel();
	private ProdutoView produtoView = new ProdutoView();
	
	public ProdutoController(ProdutoModel produtoModel,ProdutoView produtoView) {
		this.produtoModel = produtoModel;
		this.produtoView = produtoView;
	}
	
	public void inserirProduto(Produto produto) throws Exception {
		produtoModel.inserirProduto(produto);
		produtoView.mensagem("Produto cadastrado com sucesso!");
	}
	
	public void buscarPorId(int id) throws Exception {
		Produto produto = produtoModel.buscarPorId(id);
		produtoView.mensagem(produto.toString());
	}
	
	public void listarProdutos() throws Exception {
		List<Produto> produto = produtoModel.listarProdutos();
		if(produto.isEmpty()) {
			produtoView.mensagem("Nenhum Produto cadastrado!");
		} else {
			produtoView.listarProdutos(produto);
		}
	}
	
	public void atualizarProduto(Produto produto) throws Exception {
		produtoModel.atualizarProduto(produto);
		produtoView.mensagem("Produto atualizado com sucesso!");
		
	}
	
	public void excluirProduto(int id) throws Exception {
		produtoModel.excluirProduto(id);
		produtoView.mensagem("Produto excluido com sucesso!");
	}	
}
