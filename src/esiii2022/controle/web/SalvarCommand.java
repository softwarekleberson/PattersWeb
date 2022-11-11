package esiii2022.controle.web;

import esiii2022.controle.IFachada;
import esiii2022.controle.impl.Fachada;
import esiii2022.dominio.EntidadeDominio;

public class SalvarCommand extends AbstracCommad {

	public Object executar(EntidadeDominio entidade) {
		return fachada.salvar(entidade);
	}

}
