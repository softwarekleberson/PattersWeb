package esiii2022.dominio;

public class Parentesco extends EntidadeDominio{

	private String descricao;
	
	public Parentesco(String descricao){
		this.descricao = descricao;
	}
	
	public Parentesco(int id){
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
