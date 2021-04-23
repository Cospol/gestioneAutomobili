package it.prova.gestioneautomobili.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobili.model.Automobile;
import it.prova.gestioneautomobili.service.AutomobileService;
import it.prova.gestioneautomobili.service.MyServiceFactory;




@WebServlet("/ExecuteDeleteAutomobileServlet")
public class ExecuteDeleteAutomobileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	}

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("/login.jsp");
			return;
		}
		
		String idInput = request.getParameter("idInput");
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		Automobile automobileInstance= null;
		try {
			automobileInstance = automobileService.caricaSingoloElemento(Long.parseLong(idInput)); 
			if (automobileInstance == null) {
				request.setAttribute("errorMessage", "Attenzione l 'automobile che si vuole eliminare non è presente");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			automobileService.rimuovi(automobileInstance);
			request.setAttribute("listaAutomobiliAttribute", automobileService.listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile.jsp").forward(request, response);
		}
	}

}
