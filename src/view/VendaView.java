package view;

public class VendaView {
	public void printVenda(int id, String dataVenda, int quantidade, int idProduto) {
		System.out.println("Id: " + id
				+ "\nData Venda: " + dataVenda
				+ "\nQuantidade: " + quantidade
				+ "\nId Produto: " + idProduto);
	}
}
