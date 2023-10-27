package dao;

import model.Venda;

public interface VendaDAO {
	void cadastrarVenda(Venda venda) throws ClassNotFoundException;
	
	void cancelarVenda(int idVenda) throws ClassNotFoundException;
	
	Venda buscarVenda(int idVenda) throws ClassNotFoundException;
}
