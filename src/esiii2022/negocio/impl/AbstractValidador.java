package esiii2022.negocio.impl;

import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public abstract class AbstractValidador 
	implements IStrategy {
	
	protected StringBuilder sb = new StringBuilder();

	protected boolean isNull(Object obj){
		if(obj == null || obj.toString().trim() == "")
			return true;
		return false;
	}

}
