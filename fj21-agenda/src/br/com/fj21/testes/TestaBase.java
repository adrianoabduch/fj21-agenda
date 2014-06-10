package br.com.fj21.testes;

import java.sql.SQLException;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.entidades.Contato;

public class TestaBase {
	
	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();
		Contato c = null;
		try {
			c = contatoDAO.findById(5L);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(c.getNome());
		System.out.println(c.getEndereco());
		System.out.println(c.getEmail());
		System.out.println(c.getDataNascimento());
	}

}
