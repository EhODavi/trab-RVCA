package br.cefetmg.RVCA.dados;

import java.util.ArrayList;
import java.util.List;

import br.cefetmg.RVCA.controle.EmpresaCliente;

public class RepoEmpresaCliente {
	private List<EmpresaCliente> empresaCliente;

	public RepoEmpresaCliente() { // Construtor
		this.empresaCliente = new ArrayList<EmpresaCliente>();
	}

	public boolean adicionarEmpresa(EmpresaCliente empresaCliente) {
		if (empresaCliente != null) {
			this.empresaCliente.add(empresaCliente);
			return true;
		} else {
			return false;
		}
	}

	public boolean alterarEmpresa(EmpresaCliente empresaCliente) {
		if (empresaCliente != null) {
			for (int i = 0; i < this.empresaCliente.size(); i++) {
				if (this.empresaCliente.get(i).getCodigo() == empresaCliente.getCodigo()) {
					this.empresaCliente.remove(i);
					this.empresaCliente.add(i, empresaCliente);
					return true;
				}
			}
		}
		return false;
	}

	public boolean excluirEmpresa(int codigo) {
		for (int i = 0; i < this.empresaCliente.size(); i++) {
			if (codigo == this.empresaCliente.get(i).getCodigo()) {
				this.empresaCliente.remove(i);
				return true;
			}
		}
		return false;
	}

	public EmpresaCliente buscarEmpresa(int codigo) {
		EmpresaCliente c;
		for (int i = 0; i < this.empresaCliente.size(); i++) {
			if (this.empresaCliente.get(i).getCodigo() == codigo) {
				c = this.empresaCliente.get(i);
				return c;
			}
		}
		return null;
	}

	public List<EmpresaCliente> listarEmpresa() {
		return this.empresaCliente;
	}
}
