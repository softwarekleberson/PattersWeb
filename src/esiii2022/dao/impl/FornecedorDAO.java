package esiii2022.dao.impl;

import java.util.List;

import esiii2022.dao.IDAO;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;

public class FornecedorDAO implements IDAO {

	public void salvar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		System.out.println("Cliente SALVO COM SUCESSO!!!");

	}

	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
