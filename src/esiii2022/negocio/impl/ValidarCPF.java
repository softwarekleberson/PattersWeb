package esiii2022.negocio.impl;

import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarCPF implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		if(cliente.getCpf().length()!=11){
			return "O CPF dever ter pelo menos 11 digitos!";
		}
		return null;
	}

}
