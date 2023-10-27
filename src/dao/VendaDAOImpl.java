package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import model.Produto;
import model.Venda;

public class VendaDAOImpl implements VendaDAO{
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	public void cadastrarVenda(Venda venda) throws ClassNotFoundException {
		ProdutoDAOImpl crudProduto = new ProdutoDAOImpl();
		Produto produto = crudProduto.buscarPorId(venda.getIdProduto());
		
		if(produto.getQuantidade() < venda.getQuantidade()) {
			System.out.println("Venda nao concluida! \nQuantidade para venda é maior que quantidade em estoque!");
		} else {
			try {
				connection = Conexao.getDatabaseConnection();
				String sql = "INSERT INTO venda(id, dataVenda, quantidade, id_produto) VALUES (?, ?, ?, ?);";
			
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, venda.getId());
				preparedStatement.setString(2, venda.getDataVenda());
				preparedStatement.setInt(3, venda.getQuantidade());
				preparedStatement.setInt(4, venda.getIdProduto());
				
				preparedStatement.executeUpdate();
				
				produto.setQuantidade(produto.getQuantidade() - venda.getQuantidade());
				
				crudProduto.atualizarProduto(venda.getIdProduto(), produto);
				
				System.out.println("Venda realizada com sucesso!");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void cancelarVenda(int idVenda) throws ClassNotFoundException {
		ProdutoDAOImpl crudProduto = new ProdutoDAOImpl();
		Venda venda = buscarVenda(idVenda);
		Produto produto = crudProduto.buscarPorId(venda.getIdProduto());
		
		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "DELETE FROM venda WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idVenda);
			System.out.println("Venda cancelada com sucesso!");
			
			preparedStatement.executeUpdate();
			
			produto.setQuantidade(venda.getQuantidade() + produto.getQuantidade());
			
			crudProduto.atualizarProduto(produto.getId(), produto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Venda buscarVenda(int idVenda) {
		ResultSet resultSet = null;
		Venda venda = new Venda();

		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "SELECT * FROM venda where id = ?;";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idVenda);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				venda.setId(resultSet.getInt("id"));
				venda.setDataVenda(resultSet.getString("dataVenda"));
				venda.setQuantidade(resultSet.getInt("quantidade"));
				venda.setIdProduto(resultSet.getInt("id_produto"));

				System.out.println(" Id: " + venda.getId() + " - Data Venda: " + venda.getDataVenda() 
						+ " - Quantidade: " + venda.getQuantidade() + " - Id Produto: " + venda.getIdProduto());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return venda;
	}
}
