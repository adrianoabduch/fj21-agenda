package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fj21.banco.ConnectionFactory;
import br.com.fj21.entidades.Contato;

public class ContatoDAO {
	
	public Contato findContatoById(Long id) throws SQLException {
		String queryString = "select * from contatos where id = ? ";
		
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement ps = con.prepareStatement(queryString);
		
		//Seta o ID na query
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		Contato c = new Contato();
		while(rs.next()) {
			c.setId(rs.getLong("id"));
			c.setNome(rs.getString("nome"));
			c.setEndereco(rs.getString("endereco"));
			c.setEmail(rs.getString("email"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			try {
				c.setDataNascimento(sdf.parse(rs.getString("dataNascimento")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		con.close();
		
		return c;
	}
	
	public void insereContato(Contato c) throws SQLException {
		String queryString = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?) ";
		
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement ps = con.prepareStatement(queryString);
		ps.setString(1, c.getNome());
		ps.setString(2, c.getEmail());
		ps.setString(3, c.getEndereco());
		try {
			ps.setDate(4, new java.sql.Date(c.getDataNascimento().getTime()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		ps.execute();
		con.close();
	}
	
	public boolean deletaContato(Long contatoId) throws SQLException {
		String queryString = "delete from contatos where id = ? ";
		
		PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(queryString);
		ps.setLong(1, contatoId);
		
		boolean sucesso = ps.execute();
		ps.close();
		
		return sucesso;
	}
	
	public List<Contato> buscaTodos() throws SQLException {
		String queryString = "select * from contatos ";
		
		PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(queryString);
		ResultSet rs = ps.executeQuery();
		
		List<Contato> lista = new ArrayList();
		while(rs.next()) {
			Contato c = new Contato();
			c.setId(rs.getLong("id"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setEndereco(rs.getString("endereco"));
			try {
				String dataString = rs.getString("dataNascimento");
				SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
				c.setDataNascimento(dataFormat.parse(dataString));
			} catch (ParseException e) {
			}
			
			lista.add(c);
		}
		
		rs.close();
		ps.close();
		
		return lista;
		
	}
	
	public List<Contato> getLista() throws SQLException {
		return buscaTodos();
	}
}
