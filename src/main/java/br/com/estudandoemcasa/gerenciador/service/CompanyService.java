package br.com.estudandoemcasa.gerenciador.service;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudandoemcasa.gerenciador.constant.Constant;
import br.com.estudandoemcasa.gerenciador.model.Bank;
import br.com.estudandoemcasa.gerenciador.model.Company;

public class CompanyService {

	private Bank bank = new Bank();

	public CompanyService() {
	}
	
	public void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constant.PAGE_LIST);
		rd.forward(request, response);
	}

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Company company = null;
		if (!this.bank.existCompanyName(request.getParameter("nome"))) {
			
			try {
				company = new Company(Company.count+1, 
						request.getParameter("nome"), 
						Constant.DATE_PATTERN_FORM.parse(request.getParameter("date")));
			} catch (ParseException e) {
				throw new ServletException("Erro of Parse date." + e.getMessage());
			}
			
			this.bank.addCompany(company);
			response.sendRedirect(Constant.PATH_HOME + Constant.PAGE_LIST);
		}
		response.sendRedirect(Constant.PATH_HOME + Constant.PAGE_ERROR);
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("companys",this.bank.listCompany());
		RequestDispatcher rd = request.getRequestDispatcher(Constant.PAGE_LIST);
		rd.forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if (!bank.removeCompany(this.bank.existCompanyId(Integer.parseInt(request.getParameter("id"))))) {
			response.sendRedirect(Constant.PAGE_ERROR);
		}
		response.sendRedirect(Constant.PATH_HOME + Constant.PAGE_LIST);
	}

	public void load(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NumberFormatException, ParseException, ServletException {

		Company company = this.bank.existCompanyId(Integer.parseInt(request.getParameter("id")));
		String page = !company.getName().isEmpty() ? Constant.PAGE_LIST : Constant.PAGE_ERROR;
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("company", company);
		rd.forward(request, response);
	}

	public void update(HttpServletRequest rq, HttpServletResponse rp) throws IOException, NumberFormatException, ParseException {
		
		this.bank.setCompany(new Company(Integer.parseInt(
				rq.getParameter("idUpdateComp")),
				 rq.getParameter("nameUpdateComp"), 
				 Constant.DATE_PATTERN.parse(rq.getParameter("dateUpdateComp"))));

		rp.sendRedirect(Constant.PATH_HOME + Constant.PAGE_LIST);
	}

	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constant.PAGE_ERROR);
		rd.forward(request, response);
	}
}
