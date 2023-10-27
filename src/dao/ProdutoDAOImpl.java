package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO{
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	public void inserirProduto(Produto produto) throws ClassNotFoundException {
		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "INSERT INTO produto (id, nome, preco, quantidade) VALUES(?, ?, ?, ?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, produto.getId());
			preparedStatement.setString(2, produto.getNome());
			preparedStatement.setDouble(3, produto.getPreco());
			preparedStatement.setInt(4, produto.getQuantidade());
			
			preparedStatement.executeUpdate();

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
	
	public List<Produto> listarProdutos() throws ClassNotFoundException {
		ResultSet resultSet = null;
		Produto produto = new Produto();
		List<Produto> listaProdutos = new ArrayList<>();

		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "SELECT * FROM produto";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				produto.setId(resultSet.getInt(1));
				produto.setNome(resultSet.getString(2));
				produto.setPreco(resultSet.getDouble(3));
				produto.setQuantidade(resultSet.getInt(4));

				listaProdutos.add(produto);
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
		
		return listaProdutos;
	}

	public Produto buscarPorId(int idProduto) throws ClassNotFoundException {
		ResultSet resultSet = null;
		Produto produto = new Produto();

		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "SELECT * FROM produto WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idProduto);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				produto.setId(resultSet.getInt(1));
				produto.setNome(resultSet.getString(2));
				produto.setPreco(resultSet.getDouble(3));
				produto.setQuantidade(resultSet.getInt(4));
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

		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "UPDATE produto SET id = ?, nome = ?, preco = ?, quantidade = ? WHERE id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, produto.getId());
			preparedStatement.setString(2, produto.getNome());
			preparedStatement.setDouble(3, produto.getPreco());
			preparedStatement.setInt(4, produto.getQuantidade());
			preparedStatement.setInt(5, id);
			
			preparedStatement.executeUpdate();
			
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

		try {
			connection = Conexao.getDatabaseConnection();
			String sql = "DELETE FROM produto WHERE id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
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