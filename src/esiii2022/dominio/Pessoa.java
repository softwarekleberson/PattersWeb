package esiii2022.dominio;

public class Pessoa extends EntidadeDominio {

	private String nome;
	
	public Pessoa(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
