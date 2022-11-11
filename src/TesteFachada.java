import esiii2022.controle.IFachada;
import esiii2022.controle.impl.Fachada;
import esiii2022.dominio.Cidade;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.Dependente;
import esiii2022.dominio.Endereco;
import esiii2022.dominio.Estado;
import esiii2022.dominio.Parentesco;


public class TesteFachada {

	public static void main(String[] args) {
		Parentesco conjuge = new Parentesco("CONJUGE");
		Parentesco filho = new Parentesco("FILHO");
		
		Dependente dep1 = new Dependente("Maria", conjuge);
		Dependente dep2 = new Dependente("Luizinho", filho);
				
		Estado sp = new Estado("SP");
		
		Cidade mogi = new Cidade("Mogi das Cruzes", sp);
		Endereco endereco = new Endereco("Rua da Fatec", "00000000", "xxxx", mogi);
		
		Dependente[] deps = {dep1,dep2};
		
		Cliente cliente = new Cliente("José", 1000, "12345678996", endereco, deps);

		IFachada fachada = new Fachada();
		
		String msg = fachada.salvar(cliente);
		
		
		if(msg != null)
			System.out.println(msg);

	}

}
