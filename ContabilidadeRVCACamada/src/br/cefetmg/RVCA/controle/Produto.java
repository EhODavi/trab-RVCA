package br.cefetmg.RVCA.controle;

public class Produto {
	private String categoria;
	private double valorPorUnidadeMedida;
	private String unidadeMedida;
	private String nome;
	private int codigo;
	private double valorTotal;
	private int quantidade;
	private static int geraCodigo = 1;
	private EmpresaCliente empresa;

	// Metodo fabrica--------------------------------
	public static Produto newInstance(String categoria, double valorPorUnidadeMedida, String nome, int quantidade,
			String unidadeMedida, EmpresaCliente empresa) {
		if (categoria != null && valorPorUnidadeMedida > 0 && nome != null && quantidade > 0 && unidadeMedida != null
				&& empresa != null) {
			return new Produto(categoria, valorPorUnidadeMedida, nome, quantidade, unidadeMedida, empresa);
		} else {
			return null;
		}
	}

	// Construtor------------------------------------
	private Produto(String categoria, double valorPorUnidadeMedida, String nome, int quantidade, String unidadeMedida,
			EmpresaCliente empresa) {
		this.categoria = categoria;
		this.valorPorUnidadeMedida = valorPorUnidadeMedida;
		this.unidadeMedida = unidadeMedida;
		this.nome = nome;
		this.codigo = Produto.geraCodigo;
		this.quantidade = quantidade;
		this.valorTotal = quantidade * valorPorUnidadeMedida;
		this.empresa = empresa;
		Produto.geraCodigo++;
	}

	// ----------------------------------------------
	public String getCategoria() {
		return this.categoria;
	}

	// ----------------------------------------------
	public boolean setCategoria(String categoria) {
		if (categoria != null) {
			this.categoria = categoria;
			return true;
		} else {
			return false;
		}
	}

	// ----------------------------------------------
	public double getValorPorUnidadeMedida() {
		return this.valorPorUnidadeMedida;
	}

	// ----------------------------------------------
	public boolean setValorPorUnidadeMedida(double valorPorUnidadeMedida) {
		if (valorPorUnidadeMedida > 0) {
			this.valorPorUnidadeMedida = valorPorUnidadeMedida;
			this.valorTotal = this.valorPorUnidadeMedida * this.quantidade;
			return true;
		} else {
			return false;
		}
	}

	// ----------------------------------------------
	public String getNome() {
		return this.nome;
	}

	// ----------------------------------------------
	public boolean setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
			return true;
		} else {
			return false;
		}
	}

	// ----------------------------------------------
	public int getCodigo() {
		return this.codigo;
	}

	// ----------------------------------------------
	public int getQuantidade() {
		return this.quantidade;
	}

	// ----------------------------------------------
	public boolean setQuantidade(int quantidade) {
		if (quantidade > 0) {
			this.quantidade = quantidade;
			this.valorTotal = this.valorPorUnidadeMedida * this.quantidade;
			return true;
		}
		return false;
	}

	// ----------------------------------------------
	public double getValorTotal() {
		return this.valorTotal;
	}

	// ----------------------------------------------
	public String getUnidadeMedida() {
		return this.unidadeMedida;
	}

	// ----------------------------------------------
	public boolean setUnidadeMedida(String unidadeMedida) {
		if (unidadeMedida != null) {
			this.unidadeMedida = unidadeMedida;
			return true;
		}
		return false;
	}

	public EmpresaCliente getEmpresa() {
		return this.empresa;
	}
}
