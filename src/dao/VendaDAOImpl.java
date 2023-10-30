package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import util.Produto;
import util.Venda;



// --------------------- MUDAR ESSAS VALIDACOESS ---------------------------------




public class VendaDAOImpl implements VendaDAO{
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	public void cadastrarVenda(Venda venda) throws Exception {
		ProdutoDAOImpl crudProduto = new ProdutoDAOImpl();
		Produto produto = crudProduto.buscarPorId(venda.getIdProduto());
		
		if(produto.getQuantidade() < venda.getQuantidade()) {
			System.out.println("Venda nao concluida! \nQuantidade para venda é maior que quantidade em estoque!");
		} else {
			try {
				connection = Conexao.getDatabaseConnection();
				String sql = "INSERT INTO venda(dataVenda, quantidade, id_produto) VALUES (?, ?, ?);";
			
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setDate(1, (Date) venda.getDataVenda());;
				preparedStatement.setInt(2, venda.getQuantidade());
				preparedStatement.setInt(3, venda.getIdProduto());
				
				preparedStatement.executeUpdate();
				
				produto.setQuantidade(produto.getQuantidade() - venda.getQuantidade());
				
				crudProduto.atualizarProduto(produto);
				
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
	
	public void cancelarVenda(int idVenda) throws Exception {
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
			
			crudProduto.atualizarProduto(produto);
			
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
	
	public Venda buscarVenda(int idVenda) throws Exception{
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
				venda.setDataVenda(resultSet.getDate("dataVenda"));
				venda.setQuantidade(resultSet.getInt("quantidade"));
				venda.setIdProduto(resultSet.getInt("id_produto"));
				
				return venda;
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
		
		return null;
	}
}
