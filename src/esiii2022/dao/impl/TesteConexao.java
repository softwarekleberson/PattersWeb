package esiii2022.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) {
		Conexao cx = new Conexao();
		
		try {
			Connection connection = cx.getConnectionPostgres();
			
			if(connection != null){
				System.out.println("CONECTOOOOUUUUUU");
			}else{
				System.out.println("NÃO CONECTOOOOUUUUUU :-(");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
