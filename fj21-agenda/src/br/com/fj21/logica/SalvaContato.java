package br.com.fj21.logica;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.entidades.Contato;

public class SalvaContato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		
		Long id = null;
		
		try {
			try {
				id = new Long(req.getParameter("id"));
			} catch (Exception e) {
			}
			String nome = req.getParameter("nome");
			String endereco = req.getParameter("endereco");
			String email = req.getParameter("email");
			String dataNascimentoString = req.getParameter("dataNascimento");
		
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascimento = dataFormat.parse(dataNascimentoString);
		
			Contato c = new Contato();
			if(id != null)
				c.setId(id);
			c.setNome(nome);
			c.setEndereco(endereco);
			c.setEmail(email);
			c.setDataNascimento(dataNascimento);
		
			ContatoDAO contatoDAO = new ContatoDAO();
		
			contatoDAO.salvar(c);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(id != null)
			return "contato-salvo.jsp";
		
		return "contato-adicionado.jsp";
	}
	
}
