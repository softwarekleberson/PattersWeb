package esiii2022.controle.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esiii2022.dominio.Cidade;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.Dependente;
import esiii2022.dominio.Endereco;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.dominio.Estado;
import esiii2022.dominio.Parentesco;

public class ClienteVH implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		int parent1 = Integer.parseInt(request.getParameter("cbParentesco1"));
		int parent2 = Integer.parseInt(request.getParameter("cbParentesco2"));
		
		String nmDep1 = request.getParameter("txtDependente1");
		String nmDep2 = request.getParameter("txtDependente2");		
		
		String nmEstado = request.getParameter("cbEstado");
		String  nmCidade = request.getParameter("txtCidade");
		
		String  nmLogradouro = request.getParameter("txtLogradouro");
		String  nmCep = request.getParameter("txtCep");
		String  nmComplemento = request.getParameter("txtComplemento");
		
		String nmCliente = request.getParameter("txtNome");
		String vCredito = request.getParameter("txtCredito");
		double cred = 0;
		if(vCredito != null){
			cred = Double.valueOf(vCredito);
		}
		
		String txtCpf = request.getParameter("txtCpf");
		
		
		Parentesco parentesco1 = new Parentesco(parent1);
		Parentesco parentesco2 = new Parentesco(parent2);
		
		Dependente dep1 = new Dependente(nmDep1, parentesco1);
		Dependente dep2 = new Dependente(nmDep2, parentesco2);
				
		Estado estado = new Estado(nmEstado);
		
		Cidade cidade = new Cidade(nmCidade, estado);
		Endereco endereco = new Endereco(nmLogradouro, nmCep, nmComplemento, cidade);
		
		Dependente[] deps = {dep1,dep2};
		
		Cliente cliente = new Cliente(nmCliente, cred, txtCpf, endereco, deps);
		
		return cliente;
	}

	public void setEntidade(HttpServletResponse response,
			HttpServletRequest request, Object msg) {

		PrintWriter out;
		try {
			out = response.getWriter();
			if(msg != null){
				out.print(msg);
			}else{
				out.print("<h1>Cliente Salvo com sucesso!</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
