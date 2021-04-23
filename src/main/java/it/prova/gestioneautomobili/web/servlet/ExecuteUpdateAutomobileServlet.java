package it.prova.gestioneautomobili.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobili.model.Automobile;
import it.prova.gestioneautomobili.service.MyServiceFactory;
import it.prova.gestioneautomobiliutility.UtilityAutomobileForm;

/**
 * Servlet implementation class ExecuteUpdateArticoloServlet
 */
@WebServlet("/ExecuteUpdateAutomobileServlet")
public class ExecuteUpdateAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String idInputParam = request.getParameter("id");
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String cilindrataInputParam = request.getParameter("cilindrata");
		String dataImmatricolazioneParam = request.getParameter("dataImmatricolazione");

		Date dataImmatricolazioneParsed = UtilityAutomobileForm.parseDateImmatricolazioneFromString(dataImmatricolazioneParam);

		Automobile automobileInstance = new Automobile(Long.parseLong(idInputParam),marcaInputParam, modelloInputParam,
				cilindrataInputParam != ""  ? Integer.parseInt(cilindrataInputParam) : 0, dataImmatricolazioneParsed);

		if (!UtilityAutomobileForm.validateInput(marcaInputParam, modelloInputParam, cilindrataInputParam,
				dataImmatricolazioneParam) || dataImmatricolazioneParam == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.setAttribute("modifica_automobile_attr", automobileInstance);
			request.getRequestDispatcher("/automobile/update.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getAutomobileServiceInstance().aggiorna(automobileInstance);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore nella modifica dell' automobile");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
