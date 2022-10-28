package br.com.estudandoemcasa.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudandoemcasa.gerenciador.model.*;

@WebServlet("/new-company")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nameCompany = request.getParameter("nome");
		String dateOpen = request.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Bank bank = new Bank();
		Company company = null;
		String page = "/error.jsp";

		if (!bank.existCompanyName(nameCompany)) {
			
			try {
				company = new Company(Company.count+1, nameCompany, sdf.parse(dateOpen.toString()));
			} catch (ParseException e) {
				throw new ServletException("Erro of Parse date." + e.getMessage());
			}
			
			bank.addCompany(company);
			page = "list-company";
		}
		
		response.sendRedirect(page); 
	}
}
