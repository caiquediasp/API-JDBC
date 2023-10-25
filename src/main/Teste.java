package main;

import java.sql.Connection;
import java.sql.SQLException;

import crud.Conexao;
import crud.CrudProduto;
import crud.CrudVenda;
import model.Produto;
import model.Venda;


public class Teste {
	public static void main(String[] args) {
		Connection connection = null;
		
		CrudProduto eba = new CrudProduto();
		Produto produto = new Produto(1, "alpha", 12.2, 56);
		Produto produto2 = new Produto(3, "beta", 150.0, 15);
		
		CrudVenda tete = new CrudVenda();
		Venda venda = new Venda(1, "15/10/2023", 5, 2);
		Venda venda2 = new Venda(2, "11/10/2023", 11, 3);
		
		try {
        	connection = Conexao.getDatabaseConnection();
        	System.out.println("Conexao estabelecida com sucesso!");
        	
        	tete.cancelarVenda(2);
        	
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
