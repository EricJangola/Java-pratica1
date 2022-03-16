package model;

public class Produto {
	private int codigo;
	private String preco;
	private String nome;
	private int codCategoria;

	public String getPreco() {
		return preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public void setPreco(Double preco) {
		this.preco = preco.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}		
}
