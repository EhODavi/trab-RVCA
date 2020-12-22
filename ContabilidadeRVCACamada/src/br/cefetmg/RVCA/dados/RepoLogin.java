package br.cefetmg.RVCA.dados;

import java.util.ArrayList;
import java.util.List;

import br.cefetmg.RVCA.controle.Login;

public class RepoLogin {
	private List<Login> login;

	public RepoLogin() { // Construtor
		this.login = new ArrayList<Login>();
	}

	public boolean buscarLogin(String usuario, String senha) {
		if (usuario != null && senha != null) {
			for (int i = 0; i < this.login.size(); i++) {
				if (this.login.get(i).getUsuario().equals(usuario) && this.login.get(i).getSenha().equals(senha)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean adicionarLogin(Login login) {
		if (login != null) {
			this.login.add(login);
			return true;
		} else {
			return false;
		}
	}
}
