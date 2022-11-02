package br.com.estudandoemcasa.gerenciador.service;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudandoemcasa.gerenciador.constant.Constant;
import br.com.estudandoemcasa.gerenciador.model.Bank;
import br.com.estudandoemcasa.gerenciador.model.Company;
import br.com.estudandoemcasa.gerenciador.model.User;

public class CompanyService {

	private Bank bank = new Bank();

	public CompanyService() {
	}

	public void list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("companys", this.bank.listCompany());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listCompany.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(HttpServletRequest request, HttpServletResponse rp) throws ServletException, IOException {

		Company company = null;
		if (!this.bank.existCompanyName(request.getParameter("nome"))) {

			try {
				company = new Company(Company.count + 1, request.getParameter("nome"),
						Constant.DATE_PATTERN_FORM.parse(request.getParameter("date")));
			} catch (ParseException e) {
				throw new ServletException("Erro of Parse date." + e.getMessage());
			}

			this.bank.addCompany(company);
			rp.sendRedirect(Constant.PATH_HOME + Constant.PAGE_LIST);

		} else {
			rp.sendRedirect(Constant.PATH_HOME + Constant.PAGE_ERROR);
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse rp) throws IOException, ServletException {
		if (!bank.removeCompany(this.bank.existCompanyId(Integer.parseInt(request.getParameter("id"))))) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, rp);
		}
		rp.sendRedirect(Constant.PATH_HOME + Constant.PAGE_LIST);
	}

	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("user");
		String password = request.getParameter("pass"); 
		RequestDispatcher rd = request.getRequestDispatcher("formLogin.jsp");

		for (User user : Bank.getUsers()) {

			if (user.verifyAccess(new User(userName, password))) {
				rd = request.getRequestDispatcher("index.jsp");
				HttpSession session = request.getSession();
				request.setAttribute("user", user);
				rd.forward(request, response);
			} else {
				request.setAttribute("user", ""); 
				rd.forward(request, response);
			}
		}
	}

	public void load(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Company company = this.bank.existCompanyId(Integer.parseInt(request.getParameter("id")));
		String page = !company.getName().isEmpty() ? "WEB-INF/view/formNewCompany.jsp" : "WEB-INF/view/error.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("company", company);
		rd.forward(request, response);
	}

	public void newform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/formNewCompany.jsp");
		rd.forward(request, response);
	}

	public void update(HttpServletRequest rq, HttpServletResponse rp) throws IOException {

		try {
			this.bank.setCompany(new Company(Integer.parseInt(rq.getParameter("idUpdateComp")),
					rq.getParameter("nameUpdateComp"), Constant.DATE_PATTERN.parse(rq.getParameter("dateUpdateComp"))));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		rp.sendRedirect(Constant.PAGE_LIST);
	}

	public void selectMethod(String nameMethod, HttpServletRequest rq, HttpServletResponse rp)
			throws IOException, ServletException {

		switch (nameMethod) {
		case "list":
			this.list(rq, rp);
			break;
		case "delete":
			this.delete(rq, rp);
			break;
		case "newcompany":
			this.newform(rq, rp);
			break;
		case "create":
			this.create(rq, rp);
			break;
		case "load":
			this.load(rq, rp);
			break;
		case "update":
			this.update(rq, rp);
			break;
		case "login":
			this.login(rq, rp);
			break;

		default:
			break;
		}

	}
}
