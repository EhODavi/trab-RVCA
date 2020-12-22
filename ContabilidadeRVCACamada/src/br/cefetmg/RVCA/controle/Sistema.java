package br.cefetmg.RVCA.controle;

import java.util.List;

public class Sistema {

	private static Sistema instance;

	private ControleLogin ctlLogin;
	private ControleEmpresaCliente ctlEmpresaCliente;
	private ControleProduto ctlProduto;

	// ----------------------------------------------
	private Sistema() { // Construtor
		this.ctlEmpresaCliente = new ControleEmpresaCliente();
		this.ctlLogin = new ControleLogin();
		this.ctlProduto = new ControleProduto();
	}

	// ----------------------------------------------
	public static Sistema getInstance() { // Singleton
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}

	// ----------------------------------------------
	public boolean adicionarEmpresa(EmpresaCliente empresaCliente) {
		return ctlEmpresaCliente.adicionarEmpresa(empresaCliente);
	}

	// ----------------------------------------------
	public boolean alterarEmpresa(EmpresaCliente empresaCliente) {
		return ctlEmpresaCliente.alterarEmpresa(empresaCliente);
	}

	// ----------------------------------------------
	public boolean excluirEmpresa(int codigo) {
		return ctlEmpresaCliente.excluirEmpresa(codigo);
	}

	// ----------------------------------------------
	public EmpresaCliente buscarEmpresa(int codigo) {
		return ctlEmpresaCliente.buscarEmpresa(codigo);
	}

	// ----------------------------------------------
	public List<EmpresaCliente> listarEmpresa() {
		return ctlEmpresaCliente.listarEmpresa();
	}

	public boolean adicionarProduto(Produto produto) {
		return ctlProduto.adicionarProduto(produto);
	}

	public boolean alterarProduto(Produto produto) {
		return ctlProduto.alterarProduto(produto);
	}

	public boolean excluirProduto(int codigo) {
		return ctlProduto.excluirProduto(codigo);
	}

	public List<Produto> listarProduto() {
		return ctlProduto.listarProduto();
	}

	public Produto buscarProduto(int codigo) {
		return ctlProduto.buscarProduto(codigo);
	}

	// ----------------------------------------------
	public boolean adicionarLogin(Login login) {
		return ctlLogin.adicionarLogin(login);
	}

	// ----------------------------------------------
	public boolean buscarLogin(String usuario, String senha) {
		return ctlLogin.buscarLogin(usuario, senha);
	}
}