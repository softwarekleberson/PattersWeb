package esiii2022.negocio.impl;

import java.util.Date;

import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ComplementarDtCadastro implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		entidade.setDtCadastro(new Date());
		return null;
	}

}
