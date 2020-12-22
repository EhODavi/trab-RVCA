package br.cefetmg.RVCA.controle;

public class EmpresaCliente {
	private String CNPJ;
	private String nome;
	private String inscricaoEstadual;
	private String telefone;
	private int codigo;
	private static int geraCodigo = 1;

	// Fabrica
	public static EmpresaCliente newInstance(String CNPJ, String inscricaoEstadual, String nome, String telefone) {
		if (CNPJ != null && inscricaoEstadual != null && nome != null && telefone != null) {
			return new EmpresaCliente(CNPJ, inscricaoEstadual, nome, telefone);
		} else {
			return null;
		}
	}

	// Contrutor
	private EmpresaCliente(String CNPJ, String inscricaoEstadual, String nome, String telefone) {
		this.CNPJ = CNPJ;
		this.inscricaoEstadual = inscricaoEstadual;
		this.nome = nome;
		this.telefone = telefone;
		this.codigo = geraCodigo;
		geraCodigo++;
	}

	// ----------------------------------------------

	// Alterar
	public boolean setCNPJ(String CNPJ) {
		if (CNPJ != null) {
			this.CNPJ = CNPJ;
			return true;
		} else {
			return false;
		}
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
	public boolean setInscricaoEstadual(String inscricaoEstadual) {
		if (inscricaoEstadual != null) {
			this.inscricaoEstadual = inscricaoEstadual;
			return true;
		} else {
			return false;
		}
	}

	// ----------------------------------------------
	public boolean setTelefone(String telefone) {
		if (telefone != null) {
			this.telefone = telefone;
			return true;
		} else {
			return false;
		}
	}

	// ----------------------------------------------
	public String getCNPJ() {
		return this.CNPJ;
	}

	// ----------------------------------------------
	public String getNome() {
		return this.nome;
	}

	// ----------------------------------------------
	public String getInscricaoEstadual() {
		return this.inscricaoEstadual;
	}

	// ----------------------------------------------
	public String getTelefone() {
		return this.telefone;
	}

	// ----------------------------------------------
	public int getCodigo() {
		return this.codigo;
	}

}
