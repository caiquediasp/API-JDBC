package main;
import crud.CrudProduto;
import model.Produto;

public class Teste {

	public static void main(String[] args) throws Exception {
		Produto produto = new Produto(1, "teste", 123.3, 41);
		Produto produto2 = new Produto(2, "esponja", 50.2, 12);
		CrudProduto crudProduto = new CrudProduto();
		
		crudProduto.inserirProduto(produto);
		
		crudProduto.atualizarProduto(1, produto2);
		
		crudProduto.buscarProduto(2);
	}
}
