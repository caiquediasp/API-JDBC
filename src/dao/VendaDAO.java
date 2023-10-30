package dao;

import util.Venda;

public interface VendaDAO {
	void cadastrarVenda(Venda venda) throws Exception;
	
	void cancelarVenda(int idVenda) throws Exception;
	
	Venda buscarVenda(int idVenda) throws Exception;
}
