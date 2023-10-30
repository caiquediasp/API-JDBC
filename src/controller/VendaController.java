package controller;

import model.VendaModel;
import util.Venda;
import view.VendaView;

public class VendaController {
	private VendaModel vendaModel;
	private VendaView vendaView;
	
	public VendaController(VendaModel vendaModel, VendaView vendaView) {
		this.vendaModel = vendaModel;
		this.vendaView = vendaView;
	}
	
	public void cadastrarVenda(Venda venda) throws Exception {
		vendaModel.cadastrarVenda(venda);
		vendaView.mensagem("Venda cadastrada com sucesso!");
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
