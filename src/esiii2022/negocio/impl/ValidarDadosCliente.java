package esiii2022.negocio.impl;

import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarDadosCliente extends AbstractValidador {

	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		
		
		
		if(isNull(cliente.getNome())){
			sb.append("É obrigatório o cadastro do nome do cliente \n");
		}
		
		if(isNull(cliente.getCpf())){
			sb.append("É obrigatório o cadastro do cpf do cliente \n");
		}
		
		if(cliente.getCredito() < 0){
			sb.append("É obrigatório o cadastro do créidto do cliente \n");
		}
		
		ValidarEndereco vEndereco = new ValidarEndereco();
		
		String msgValidacaoEnd = vEndereco.processar(cliente.getEndereco());
		
		if( msgValidacaoEnd != null ){
			sb.append(msgValidacaoEnd);
		}
		
		return null;
	}
	
	
	
	

}
