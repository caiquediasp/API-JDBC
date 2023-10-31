package util;

import java.util.Date;

public class Venda {
	private int id;
	private Date dataVenda;
	private int quantidade;
	private int idProduto;
	
	public Venda() {
		
	}
	
	public Venda(int quantidade, int idProduto) {
		this.quantidade = quantidade;
		this.idProduto = idProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public String toString() {
		return "Venda [Id = " + id + ", Data Venda = " + dataVenda + ", Quantidade = " + quantidade + ", ID Produto = "
				+ idProduto + "]";
	}
}
