package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fj21.entidades.Contato;
import br.com.fj21.banco.ConnectionFactory;

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
}
