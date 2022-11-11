package esiii2022.negocio.impl;

import java.util.List;

import esiii2022.dao.IDAO;
import esiii2022.dao.impl.ClienteDAO;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.negocio.IStrategy;

public class ValidarExistencia implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		
		IDAO clienteDao = new ClienteDAO();
		
		List<EntidadeDominio> clientes = clienteDao.consultar(entidade);
		
		
		if(clientes != null && clientes.size() > 0){
			return "Cliente já cadastrado!";
		}
		return null;
	}

}
