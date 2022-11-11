package esiii2022.negocio.impl;

import esiii2022.dominio.Endereco;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarEndereco extends AbstractValidador {

	public String processar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco)entidade;
		
		if(isNull(endereco.getLogradouro())){
			sb.append("É obrigatório o cadastro do logradouro do cliente \n");
		}
		if(isNull(endereco.getCep())){
			sb.append("É obrigatório o cadastro do cep do cliente \n");
		}
				
		if(isNull(endereco.getCidade().getNome())){
			sb.append("É obrigatório o cadastro da cidade do cliente \n");
		}
		
		if(isNull(endereco.getCidade().getEstado().getNome())){
			sb.append("É obrigatório o cadastro do estado do cliente \n");
		}
		
		if(sb.length() != 0){
			return sb.toString();
		}
		
		return null;
	}

}
