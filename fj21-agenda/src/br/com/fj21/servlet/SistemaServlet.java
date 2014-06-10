package br.com.fj21.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fj21.entidades.Contato;
import br.com.fj21.logica.Logica;

@WebServlet("/service")
public class SistemaServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String className = "br.com.fj21.logica." + req.getParameter("logica");
		Class classe = null;
		Logica logica = null;
		
		try {
			classe = Class.forName(className);
			logica = (Logica) classe.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String resultado = logica.executa(req, res);
		
		RequestDispatcher rd = req.getRequestDispatcher(resultado);
		rd.forward(req, res);
		
	}
	
}
