package model;

import dao.VendaDAO;
import dao.VendaDAOImpl;
import util.Venda;

public class VendaModel {
	private VendaDAO vendaDAO;
	
	public VendaModel() {
		vendaDAO = new VendaDAOImpl();
	}
	
	public void cadastrarVenda(Venda venda) throws Exception {
		vendaDAO.cadastrarVenda(venda);
	}
	
	public void cancelarVenda(int idVenda) throws Exception {
		vendaDAO.cancelarVenda(idVenda);
	}
	
	public Venda buscarVenda(int idVenda) throws Exception {
		return vendaDAO.buscarVenda(idVenda);
	}
}
