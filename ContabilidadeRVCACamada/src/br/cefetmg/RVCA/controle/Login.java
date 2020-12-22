package br.cefetmg.RVCA.controle;

public class Login {
	private String usuario;
	private String senha;

	public static Login newInstance(String usuario, String senha) { // Método fábrica
		if (usuario != null && senha != null) {
			return new Login(usuario, senha);
		} else {
			return null;
		}
	}

	private Login(String usuario, String senha) { // Construtor
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public String getSenha() {
		return this.senha;
	}
}
