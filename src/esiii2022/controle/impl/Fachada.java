package esiii2022.controle.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import esiii2022.controle.IFachada;
import esiii2022.dao.IDAO;
import esiii2022.dao.impl.ClienteDAO;
import esiii2022.dao.impl.FornecedorDAO;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.EntidadeDominio;
import esiii2022.dominio.Fornecedor;
import esiii2022.negocio.IStrategy;
import esiii2022.negocio.impl.ComplementarDtCadastro;
import esiii2022.negocio.impl.ValidarCPF;
import esiii2022.negocio.impl.ValidarCredito;
import esiii2022.negocio.impl.ValidarDadosCliente;
import esiii2022.negocio.impl.ValidarDependentes;
import esiii2022.negocio.impl.ValidarExistencia;

public class Fachada implements IFachada {
	/* Mapa de daos indexado pelo nome da classe 
	 * e tem como valor um DAO */	
	private Map<String, IDAO> daos = new HashMap<String, IDAO>();
	
	/* Mapa de regras de negocio indexado pelo nome da classe 
	 * e tem como valor uma lista de strategies */	
	private Map<String, List<IStrategy>> rns = new HashMap<String, List<IStrategy>>();
	
	public Fachada(){
		String nmCliente = Cliente.class.getName();
		
		daos.put(nmCliente, new ClienteDAO());
		
		String nmFornecedor = Fornecedor.class.getName();
		
		daos.put(nmFornecedor, new FornecedorDAO());
		
		
		
		ValidarDadosCliente vCliente = new ValidarDadosCliente();
		ValidarCPF vCpf = new ValidarCPF();
		ValidarCredito vCredito = new ValidarCredito();
		ValidarExistencia vExistencia = new ValidarExistencia();
		ValidarDependentes vDependentes = new ValidarDependentes();
		ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
			
		ArrayList<IStrategy> rnsCliente = new ArrayList<IStrategy>();
		rnsCliente.add(vCliente);
		rnsCliente.add(vCpf);
		rnsCliente.add(vCredito);
		rnsCliente.add(vExistencia);
		rnsCliente.add(vDependentes);
		rnsCliente.add(cDtCadastro);	
		
		List<IStrategy> rnsFuncionario = new ArrayList<IStrategy>();
	
		rnsFuncionario.add(vCpf);	
		rnsFuncionario.add(cDtCadastro);	
		
		rns.put(nmCliente, rnsCliente);
		rns.put(nmFornecedor, rnsFuncionario);
		
	}

	public String salvar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		String nmEntidade = entidade.getClass().getName();
		List<IStrategy> regras = rns.get(nmEntidade);
		
		for(IStrategy s: regras){
			String msg = s.processar(entidade);
			if(msg != null){
				sb.append(msg);
				sb.append("\n");
			}
		}
		
		if(sb.length() == 0){
			IDAO dao = daos.get(nmEntidade);
			dao.salvar(entidade);
		}else{
			return sb.toString();
		}
		return null;
	}

	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
