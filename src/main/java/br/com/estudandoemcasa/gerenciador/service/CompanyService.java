package br.com.estudandoemcasa.gerenciador.service;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudandoemcasa.gerenciador.model.Bank;
import br.com.estudandoemcasa.gerenciador.model.Company;

public class CompanyService {

	private String pathHome = "/gerenciador/company";

	public CompanyService() {
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Bank bank = new Bank();
		request.setAttribute("companys", bank.listCompany());
		RequestDispatcher rd = request.getRequestDispatcher(this.getPathHome() + "?action=list");
		rd.forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idCompany = request.getParameter("id");
		Bank bank = new Bank();
		if (!bank.removeCompany(bank.existCompanyId(Integer.parseInt(idCompany)))) {
			response.sendRedirect("/error.jsp");
		}
		response.sendRedirect(this.getPathHome() + "?action=list");
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, ParseException, ServletException {

		String idCompany = request.getParameter("idCompany");

		Bank bank = new Bank();
		String page = "/error.jsp";
		Company company = bank.existCompanyId(Integer.parseInt(idCompany));

		if (!company.getName().isEmpty()) {
			page = "/FormNewCompany.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("company", company);
		rd.forward(request, response);
	}

	public String getPathHome() {
		return pathHome;
	}
}
