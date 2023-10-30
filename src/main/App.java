package main;


import util.Produto;
import util.Venda;
import view.ProdutoView;
import view.VendaView;

import java.util.Calendar;
import java.util.Date;

import controller.ProdutoController;
import controller.VendaController;
import model.ProdutoModel;
import model.VendaModel;


public class App {
	public static void main(String[] args) throws Exception {
		ProdutoModel produtoModel = new ProdutoModel();
		ProdutoView produtoView = new ProdutoView();
		ProdutoController produtoController = new ProdutoController(produtoModel, produtoView);
		
		VendaModel vendaModel = new VendaModel();
		VendaView vendaView = new VendaView();
		VendaController vendaController = new VendaController(vendaModel, vendaView);
		
		produtoController.inserirProduto(new Produto("Esponja", 3.98, 25));
		produtoController.inserirProduto(new Produto("Chocolate", 7.80, 10));
		
		vendaController.cadastrarVenda(new Venda(new Date(2023/02/01), 1, 1));
	
	
	}
}
