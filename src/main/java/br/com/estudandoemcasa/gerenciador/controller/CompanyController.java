package br.com.estudandoemcasa.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudandoemcasa.gerenciador.controller.CompanyController;
import br.com.estudandoemcasa.gerenciador.service.CompanyService;


@WebServlet("/company")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	private CompanyService service = new CompanyService();
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		switch (request.getParameter("action")) {

		case "newform":
			this.service.form(request, response);
			break;
		case "new":
			this.service.create(request, response);
			break;
		case "list":
			this.service.list(request, response);
			break;
		case "delete":
			this.service.delete(request, response);
			break;
		case "load":
			try {
				this.service.load(request, response);
			} catch (NumberFormatException | IOException e) { 
				e.printStackTrace();
			} catch (ParseException e) { 
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				this.service.update(request, response);
			} catch (NumberFormatException | IOException | ParseException e) {
				e.printStackTrace();
			}
			break;
		case "error":
			this.service.error(request, response);
			break;
			
		default:
			break;
		}	
	}
}
