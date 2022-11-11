package esiii2022.controle.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esiii2022.dominio.EntidadeDominio;

public interface IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	public void setEntidade(HttpServletResponse response, HttpServletRequest request,
			Object msg);
	
}
