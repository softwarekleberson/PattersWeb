package esiii2022.controle.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.dominio.Fornecedor;

public class FornecedorVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		//getparameter....
		Fornecedor fornecedor = new Fornecedor();
		
		return fornecedor;
	}

	public void setEntidade(HttpServletResponse response,
			HttpServletRequest request, Object entidade) {
		

	}

}
