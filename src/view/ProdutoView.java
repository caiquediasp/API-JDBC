package view;

import java.util.List;

import util.Produto;

public class ProdutoView {
	
	public void listarProdutos(List<Produto> listaProdutos) {
		System.out.println("Lista de Produtos: ");
		listaProdutos.forEach(System.out::println);
	}
	
	public void mensagem(String mensagem) {
		System.out.println(mensagem);
	}
}
