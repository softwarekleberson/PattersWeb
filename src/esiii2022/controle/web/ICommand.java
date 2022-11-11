package esiii2022.controle.web;

import esiii2022.dominio.EntidadeDominio;

public interface ICommand {

	public Object executar(EntidadeDominio entidade); 
	
}
