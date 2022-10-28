package br.com.estudandoemcasa.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudandoemcasa.gerenciador.model.*;

@WebServlet("/update-company")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCompany = request.getParameter("idUpdateComp");
		String nameCompany = request.getParameter("nameUpdateComp");
		String dateCompany = request.getParameter("dateUpdateComp");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Bank bank = new Bank();
		String page = "list-company";
		try { 
			bank.setCompany(new Company(Integer.parseInt(idCompany), nameCompany, sdf.parse(dateCompany)));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(page);

	}
}
