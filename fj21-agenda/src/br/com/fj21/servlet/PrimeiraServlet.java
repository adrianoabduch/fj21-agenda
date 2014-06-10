package br.com.fj21.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.dao.ContatoDAO;
import br.com.fj21.entidades.Contato;

@WebServlet("/primeiraServlet")
public class PrimeiraServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String x = req.getParameter("teste");
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato c = null;
		try {
			c = contatoDAO.findById(1L);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<center>" + x + "</center>");
		pw.println("<center>" + c.getNome() + "</center>");
		pw.println("</html>");
		
	}
}
