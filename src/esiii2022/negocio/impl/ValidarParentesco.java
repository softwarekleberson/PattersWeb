package esiii2022.negocio.impl;

import esiii2022.dominio.Dependente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarParentesco implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Dependente dependente = (Dependente)entidade;
		int parentesco = dependente.getParentesco().getId();
		if(parentesco != 1 && parentesco != 2){
			return "Um dependente só pode ser CONJUGE ou FILHO";
		}
		return null;
	}

}
