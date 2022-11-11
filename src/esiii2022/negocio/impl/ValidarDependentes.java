package esiii2022.negocio.impl;

import esiii2022.dominio.Cliente;
import esiii2022.dominio.Dependente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarDependentes implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		int nrDeps = cliente.getDependentes().length;
		
		if( nrDeps > 2){
			return "Um cliente pode ter no máximo dois dependentes!";
		}else{
			ValidarParentesco vParentesco = new ValidarParentesco();
			for(Dependente d:cliente.getDependentes()){
				String msg = vParentesco.processar(d);
				if(msg != null){
					return msg;
				}				
			}
		}
		
		return null;
	}

}
