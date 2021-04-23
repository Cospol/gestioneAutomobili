package it.prova.gestioneautomobili.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobili.model.Automobile;
import it.prova.gestioneautomobili.service.AutomobileService;
import it.prova.gestioneautomobili.service.MyServiceFactory;
import it.prova.gestioneautomobiliutility.UtilityAutomobileForm;

@WebServlet("/ListAutomobiliServlet")
public class ListAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		try {
			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());
		} catch (Exception e) {
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String cilindrataInputParam = request.getParameter("cilindrata");
		String dataImmatricolazioneParam = request.getParameter("dataImmatricolazione");

		Date dataImmatricolazioneParsed = UtilityAutomobileForm.parseDateImmatricolazioneFromString(dataImmatricolazioneParam);

		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		try {
			if (UtilityAutomobileForm.areAllEmptyFields(marcaInputParam, modelloInputParam, cilindrataInputParam,
					dataImmatricolazioneParam) && dataImmatricolazioneParsed == null) {
				request.setAttribute("listaAutomobiliAttribute", automobileService.listAll());
			}
			else { 
				Automobile automobileInput = new Automobile(marcaInputParam, modelloInputParam,
						cilindrataInputParam != ""   ? Integer.parseInt(cilindrataInputParam) : null, dataImmatricolazioneParsed);

				request.setAttribute("listaAutomobiliAttribute",automobileService.findByExample(automobileInput));
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
 		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}


}
