package controller;

import model.Venda;
import view.VendaView;

public class VendaController {
	private Venda model;
	private VendaView view;
	
	public VendaController(Venda model, VendaView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setVendaId(int id) {
		model.setId(id);
	}
	
	public int getVendaId() {
		return model.getId();
	}
	
	public void setDataVenda(String dataVenda) {
		model.setDataVenda(dataVenda);
	}
	
	public String getDataVenda() {
		return model.getDataVenda();
	}
	
	public void setQuantidadeVenda(int quantidade) {
		model.setQuantidade(quantidade);
	}
	
	public int getQuantidadeVenda() {
		return model.getQuantidade();
	}
	
	public void setIdProdutoVenda(int idProduto) {
		model.setIdProduto(idProduto);
	}
	
	public int getIdProdutoVenda() {
		return model.getIdProduto();
	}
	
	public void printVenda() {
		view.printVenda(getVendaId(), getDataVenda(), getQuantidadeVenda(), getIdProdutoVenda());
	}
}
