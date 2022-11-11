package esiii2022.negocio;

import esiii2022.dominio.EntidadeDominio;

public interface IStrategy {

	public String processar(EntidadeDominio entidade);
	
}
