package br.cefetmg.RVCA.controle;

import java.util.Scanner;

import br.cefetmg.RVCA.ui.UIEmpresaCliente;
import br.cefetmg.RVCA.ui.UIInventarioEstoque;
import br.cefetmg.RVCA.ui.UILogin;
import br.cefetmg.RVCA.ui.UIPrincipal;
import br.cefetmg.RVCA.ui.UIProduto;


public class Programa {
	
	EmpresaCliente e1 = EmpresaCliente.newInstance("77773749000104", "558.814.812.977", "Riachuelo", "38474623");
	banco.adicionarEmpresa(e1);
	Produto p1 = Produto.newInstance("Roupa", 20, "Calça Jeans", 10, "Unidades");
	banco.buscarEmpresa(1).getInventario().adicionarProduto(p1);
	Produto p2 = Produto.newInstance("Roupa", 30, "Camisa Branca", 20, "Unidades");
	banco.buscarEmpresa(1).getInventario().adicionarProduto(p2);
	Produto p3 = Produto.newInstance("Roupa", 15, "Sapato Preto", 5, "Unidades");
	banco.buscarEmpresa(1).getInventario().adicionarProduto(p3);
	EmpresaCliente e2 = EmpresaCliente.newInstance("43473749000104", "558.814.543.977", "Saraiva", "38474824");
	banco.adicionarEmpresa(e2);
	Produto p4 = Produto.newInstance("Livro", 15, "Livro de Inglês", 5, "Unidades");
	banco.buscarEmpresa(2).getInventario().adicionarProduto(p4);
	Produto p5 = Produto.newInstance("Livro", 5, "Livro de Português", 10, "Unidades");
	banco.buscarEmpresa(2).getInventario().adicionarProduto(p5);
	Produto p6 = Produto.newInstance("Livro", 15, "Livro de Geografia", 5, "Unidades");
	banco.buscarEmpresa(2).getInventario().adicionarProduto(p6);
	EmpresaCliente e3 = EmpresaCliente.newInstance("76543749000104", "558.814.123.977", "Samsung", "38476623");
	banco.adicionarEmpresa(e3);
	Produto p7 = Produto.newInstance("Celular", 1150, "Nokia C2", 2, "Unidades");
	banco.buscarEmpresa(3).getInventario().adicionarProduto(p7);
	Produto p8 = Produto.newInstance("Celular", 1500, "Nexus 5x", 2, "Unidades");
	banco.buscarEmpresa(3).getInventario().adicionarProduto(p8);
	Produto p9 = Produto.newInstance("Celular", 2000, "Galaxy S8", 2, "Unidades");
	banco.buscarEmpresa(3).getInventario().adicionarProduto(p9);
	Login loginDavi = Login.newInstance("Davi", "123");
	banco.adicionarLogin(loginDavi);
	Login loginNeres = Login.newInstance("Andre", "456");
	banco.adicionarLogin(loginNeres);
}
