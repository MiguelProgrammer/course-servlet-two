package br.com.estudandoemcasa.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudandoemcasa.gerenciador.service.CompanyService;

@WebServlet(urlPatterns = "/")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();  
		
		if(session.getAttribute("user") == null) { 
			action = "login";
		}
		
		CompanyService companyService = new CompanyService();  
		companyService.selectMethod(action, request, response); 
	}
}
