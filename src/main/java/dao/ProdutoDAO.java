package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
	
	public String inserir(Produto produto) {		
		String retorno = "falha";
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			String query = "INSERT INTO produto (nome, preco, codCategoria) VALUES ('"+produto.getNome() + "','"+ produto.getPreco() +"','" + produto.getCodCategoria() + "')";
			stmt.execute(query);
			retorno = "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}		
		return retorno;
	}
	
	public List<Produto> listar(){
		List<Produto> produtos = new ArrayList<Produto>();
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from produto");
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(Double.parseDouble(rs.getString("preco")));
				produtos.add(produto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}
		return produtos;
	}

    public List<Produto> porCategoria(Integer id) {
        Conexao conn = new Conexao();
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from produto where codCategoria = " + id);
			if (rs.next()) {
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(Double.parseDouble(rs.getString("preco")));
				produtos.add(produto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}
		return produtos;
    }

	public List<Produto> porNomeLike(String nome, int categoria) throws Exception {
        Conexao conn = new Conexao();
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from produto where categoria = "+categoria+ " and nome like " + nome+ "%");
			if (rs.next()) {
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(Double.parseDouble(rs.getString("preco")));
				produtos.add(produto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.fecharConexao();
		}
		return produtos;
    }
}
