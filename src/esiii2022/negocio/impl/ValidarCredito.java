package esiii2022.negocio.impl;

import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarCredito implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		
		if(cliente.getCredito() < 1000){
			return "O crédito do cliente tem que ser ao menos R$ 1.000,00";
		}
		
		return null;
	}

}
