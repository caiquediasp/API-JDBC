package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class CrudProduto {

	public void inserirProduto(Produto produto) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
			String sql = "INSERT INTO produto (id, nome, preco, quantidade) VALUES(?, ?, ?, ?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, produto.getId());
			preparedStatement.setString(2, produto.getNome());
			preparedStatement.setDouble(3, produto.getPreco());
			preparedStatement.setInt(4, produto.getQuantidade());

			System.out.println("Produto inserido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Produto buscarProduto(int idProduto) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Produto produto = new Produto();

		try {
			connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
			String sql = "SELECT * FROM produto WHERE id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idProduto);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				produto.setId(resultSet.getInt("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setPreco(resultSet.getDouble("preco"));
				produto.setQuantidade(resultSet.getInt("quantidade"));

				System.out.println(" Id: " + produto.getId() + " - Nome: " + produto.getNome() 
						+ " - Preco: " + produto.getPreco() + " - Quantidade: " + produto.getQuantidade());

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
		
		return produto;
	}

	public void atualizarProduto(int id, Produto produto) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
			String sql = "UPDATE produto SET id = ?, nome = ?, preco = ?, quantidade = ? WHERE id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, produto.getId());
			preparedStatement.setString(2, produto.getNome());
			preparedStatement.setDouble(3, produto.getPreco());
			preparedStatement.setInt(4, produto.getQuantidade());
			preparedStatement.setInt(5, id);

			System.out.println("Produto atualizado com sucesso!");

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

	public void excluirProduto(int id) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(Conexao.getJdbcURL(), Conexao.getUser(), Conexao.getPassword());
			String sql = "DELETE FROM produto WHERE id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("Produto excluido com sucesso!");
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
