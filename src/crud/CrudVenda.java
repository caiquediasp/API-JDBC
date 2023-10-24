package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;
import model.Venda;

public class CrudVenda {
	public void cadastrarVenda(Venda venda) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CrudProduto crudProduto = new CrudProduto();
		Produto produto = crudProduto.buscarProduto(venda.getIdProduto());
		
		if(produto.getQuantidade() < venda.getQuantidade()) {
			System.out.println("Venda nao concluida! \nQuantidade para venda é maior que quantidade em estoque!");
		} else {
			try {
				connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
				String sql = "INSERT INTO venda(id, dataVenda, quantidade, id_produto) VALUES (?, ?, ?, ?, ?);";
			
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, venda.getId());
				preparedStatement.setString(2, venda.getDataVenda());
				preparedStatement.setInt(3, venda.getQuantidade());
				preparedStatement.setInt(4, venda.getIdProduto());
				
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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CrudProduto crudProduto = new CrudProduto();
		Venda venda = buscarVenda(idVenda);
		Produto produto = crudProduto.buscarProduto(venda.getIdProduto());
		
		try {
			connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
			String sql = "DELETE FROM venda WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idVenda);
			System.out.println("Venda cancelada com sucesso!");
			
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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Venda venda = new Venda();

		try {
			connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
			String sql = "SELECT * FROM venda where id = ?;";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idVenda);
			resultSet = preparedStatement.executeQuery(sql);
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
