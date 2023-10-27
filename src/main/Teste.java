package main;

import java.sql.Connection;
import java.sql.SQLException;

import conexao.Conexao;
import model.Produto;
import model.Venda;
import controller.ProdutoController;
import controller.VendaController;


public class Teste {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection connection = null;
		
		Produto produto = new Produto(1, "alpha", 12.2, 56);
		ProdutoController produtoController = new ProdutoController();
		
		try {
        	connection = Conexao.getDatabaseConnection();
        	System.out.println("Conexao estabelecida com sucesso!");
        	produtoController.listarProdutos();
        	
        
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
