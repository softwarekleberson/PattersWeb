package esiii2022.dao.impl;

import java.util.Date;

import esiii2022.dao.IDAO;
import esiii2022.dominio.Cidade;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.Dependente;
import esiii2022.dominio.Endereco;
import esiii2022.dominio.Estado;
import esiii2022.dominio.Parentesco;

public class TesteDAO {

	public static void main(String[] args) {
		Parentesco conjuge = new Parentesco(1);
		Parentesco filho = new Parentesco(2);
		
		Dependente dep1 = new Dependente("Maria", conjuge);
		Dependente dep2 = new Dependente("Luizinho", filho);
				
		Estado sp = new Estado("SP");
		
		Cidade mogi = new Cidade("Mogi das Cruzes", sp);
		Endereco endereco = new Endereco("Rua da Fatec", "00000000", "xxxx", mogi);
		endereco.setDtCadastro(new Date());	
		
		
		Dependente[] deps = {dep1,dep2};
		
		Cliente cliente = new Cliente("José", 1000, "12345678996", endereco, deps);
		cliente.setDtCadastro(new Date());
		
		IDAO daoEnd = new ClienteDAO();
		
		daoEnd.salvar(cliente);
	}

}
