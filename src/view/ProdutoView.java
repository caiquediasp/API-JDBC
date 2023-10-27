package view;

import java.util.List;

import model.Produto;

public class ProdutoView {
	
	public void listarProdutos(List<Produto> listaProdutos) {
		listaProdutos.forEach(produto -> printProduto(produto));
	}
	
	public void printProduto(Produto produto) {
		System.out.println("Id: " + produto.getId()
				+ "\nNome: " + produto.getNome()
				+ "\nPreco: " + produto.getPreco()
				+ "\nQuantidade: " + produto.getQuantidade()
				+ "\n");
	}
}
