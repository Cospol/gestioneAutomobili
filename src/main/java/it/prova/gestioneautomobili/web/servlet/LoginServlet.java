package it.prova.gestioneautomobili.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobili.model.Utente;
import it.prova.gestioneautomobili.service.MyServiceFactory;
import it.prova.gestioneautomobili.service.UtenteService;

/**
 * Servlet implementation class LoginExecuteServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameInput = request.getParameter("inputUsername");
		String passwordInput = request.getParameter("inputPassword");
		UtenteService utenteService = MyServiceFactory.getUtenteServiceInstance();
		Utente utenteDaCercare = utenteService.cercaPerUsernameEpassword(usernameInput, passwordInput);
		RequestDispatcher rd = null;
		if (utenteDaCercare == null) {
			rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("errorMessage","L'account specificato non esiste");
			rd.forward(request, response);
		}
		request.getSession().setAttribute("username", utenteDaCercare.getUsername());
		utenteDaCercare.setPassword("xxxxxxxxx");
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}

}
