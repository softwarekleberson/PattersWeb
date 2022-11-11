package esiii2022.dominio;

import java.util.Date;

public class Endereco extends EntidadeDominio{

	private String logradouro;
	private String cep;
	private String complemento;
	private Cidade cidade;
	
	public Endereco(String logradouro, String cep, String complemento,
			Cidade cidade){
		this.logradouro = logradouro;
		this.cep = cep;
		this.complemento = complemento;
		this.cidade = cidade;
		this.dtCadastro = new Date();
		
	}

	

	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
}
