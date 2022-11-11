package esiii2022.dominio;

import java.util.Date;

public class Cliente extends Pessoa{
	private double credito;
	private String cpf;	
	private Endereco endereco;
	private Dependente[] dependentes;
	
	public Cliente(String nome, double credito, 
			String cpf, Endereco endereco, Dependente[] dependentes){
		super(nome);
		this.credito = credito;
		this.cpf = cpf;	
		this.endereco = endereco;
		this.dependentes = dependentes;
	}	

	public Dependente[] getDependentes() {
		return dependentes;
	}

	public void setDependentes(Dependente[] dependentes) {
		this.dependentes = dependentes;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
		
}
