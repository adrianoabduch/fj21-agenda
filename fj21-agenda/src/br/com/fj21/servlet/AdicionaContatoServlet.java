package br.com.fj21.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.entidades.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");

		String dataNascimentoString = req.getParameter("dataNascimento");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = null;
		try {
			dataNascimento = dateFormat.parse(dataNascimentoString);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		Contato c = new Contato();
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setDataNascimento(dataNascimento);
		
		ContatoDAO contatoDAO = new ContatoDAO();
		try {
			contatoDAO.insereContato(c);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		PrintWriter out = res.getWriter();
		out.println("Contato \"" + c.getNome() + "\" salvo com sucesso.");
		
	}

}

