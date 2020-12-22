package br.cefetmg.RVCA.controle;

import br.cefetmg.RVCA.dados.RepoLogin;

public class ControleLogin {
	private RepoLogin repoLogin;

	public ControleLogin() { // Construtor
		repoLogin = new RepoLogin();
	}

	public boolean buscarLogin(String usuario, String senha) {
		return repoLogin.buscarLogin(usuario, senha);
	}

	public boolean adicionarLogin(Login login) {
		return repoLogin.adicionarLogin(login);
	}
}
