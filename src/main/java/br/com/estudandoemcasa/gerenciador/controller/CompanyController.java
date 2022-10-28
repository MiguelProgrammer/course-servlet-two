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
		
		case "list":
			this.getService().list(request, response);
			break;
		case "delete":
			this.getService().delete(request, response);
			break;
		case "update":
			try {
				this.getService().update(request, response);
			} catch (NumberFormatException | IOException | ParseException | ServletException e) { 
				e.printStackTrace();
			}
			break;

		default:
			break;
		}	
	}
	
	public CompanyService getService() {
		return service;
	}
}
