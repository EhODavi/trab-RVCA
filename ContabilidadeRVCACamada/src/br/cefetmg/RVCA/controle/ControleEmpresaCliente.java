package br.cefetmg.RVCA.controle;

import java.util.List;

import br.cefetmg.RVCA.dados.RepoEmpresaCliente;

public class ControleEmpresaCliente {
	private RepoEmpresaCliente repoEmpresaCliente;

	public ControleEmpresaCliente() { // Construtor
		repoEmpresaCliente = new RepoEmpresaCliente();
	}

	public boolean adicionarEmpresa(EmpresaCliente empresaCliente) {
		return repoEmpresaCliente.adicionarEmpresa(empresaCliente);
	}

	public boolean alterarEmpresa(EmpresaCliente empresaCliente) {
		return repoEmpresaCliente.alterarEmpresa(empresaCliente);
	}

	public boolean excluirEmpresa(int codigo) {
		return repoEmpresaCliente.excluirEmpresa(codigo);
	}

	public EmpresaCliente buscarEmpresa(int codigo) {
		return repoEmpresaCliente.buscarEmpresa(codigo);
	}

	public List<EmpresaCliente> listarEmpresa() {
		return repoEmpresaCliente.listarEmpresa();
	}
}
