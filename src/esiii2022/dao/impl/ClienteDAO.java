package esiii2022.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import esiii2022.dao.IDAO;
import esiii2022.dominio.Cliente;
import esiii2022.dominio.Dependente;
import esiii2022.dominio.EntidadeDominio;

public class ClienteDAO implements IDAO {

	private Connection connection = null;
	
	public void salvar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;


		try {
			connection = Conexao.getConnectionPostgres();

			connection.setAutoCommit(false);

			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			enderecoDAO.salvar(cliente.getEndereco());

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cliente(nome, cpf, ");
			sql.append("dt_cadastro, credito, end_id) VALUES (?,?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			Timestamp time = new Timestamp(cliente.getDtCadastro().getTime());
			pst.setTimestamp(3, time);
			pst.setDouble(4, cliente.getCredito());
			pst.setInt(5, cliente.getEndereco().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCli = 0;
			if (rs.next())
				idCli = rs.getInt(1);
			cliente.setId(idCli);

			salvarDependentes(cliente);
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void salvarDependentes(Cliente cliente) throws SQLException {
		PreparedStatement pst = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_dependente(nome, cli_id, ");
		sql.append("dt_cadastro, par_id) VALUES (?,?,?,?)");

		for (Dependente d : cliente.getDependentes()) {
			

			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, d.getNome());
			pst.setInt(2, cliente.getId());
			Timestamp time = new Timestamp(cliente.getDtCadastro().getTime());
			pst.setTimestamp(3, time);
			pst.setInt(4, d.getParentesco().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idPar = 0;
			if (rs.next())
				idPar = rs.getInt(1);
			d.setId(idPar);

		}

	}

	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
