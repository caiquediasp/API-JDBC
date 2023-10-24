package model;

public class Venda {
	private int id;
	private String dataVenda;
	private int quantidade;
	private int idProduto;
	
	public Venda() {
		
	}
	
	public Venda(int id, String dataVenda, int quantidade, int idProduto) {
		super();
		this.id = id;
		this.dataVenda = dataVenda;
		this.quantidade = quantidade;
		this.idProduto = idProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
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
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", quantidade=" + quantidade + ", idProduto="
				+ idProduto + "]";
	}
}
