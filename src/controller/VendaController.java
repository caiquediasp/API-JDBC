package controller;

import model.ProdutoModel;
import model.VendaModel;
import util.Produto;
import util.Venda;
import view.ProdutoView;
import view.VendaView;

public class VendaController {
	private VendaModel vendaModel;
	private VendaView vendaView;
	
	public VendaController(VendaModel vendaModel, VendaView vendaView) {
		this.vendaModel = vendaModel;
		this.vendaView = vendaView;
	}
	
	public void cadastrarVenda(Venda venda) throws Exception {
		ProdutoController produtoController = new ProdutoController(new ProdutoModel(), new ProdutoView());
		Produto produto = produtoController.buscarPorId(venda.getIdProduto());
		
		if(produto.getQuantidade() < venda.getQuantidade()) {
			vendaView.mensagem("Venda nao concluida! \nQuantidade para venda é maior que quantidade em estoque!");
		} else {
			vendaModel.cadastrarVenda(venda);
			vendaView.mensagem("Venda cadastrada com sucesso!");
		}
	}
	
	public void cancelarVenda(int idVenda) throws Exception{
		vendaModel.cancelarVenda(idVenda);
		vendaView.mensagem("Venda cancelada com sucesso!");
	}
	
	public void buscarVenda(int idVenda) throws Exception {
		Venda venda = vendaModel.buscarVenda(idVenda);
		vendaView.mensagem(venda.toString());
	}
}
