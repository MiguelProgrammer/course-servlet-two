package br.com.estudandoemcasa.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.estudandoemcasa.gerenciador.model.Bank;
import br.com.estudandoemcasa.gerenciador.model.Company;

@WebServlet("/companys")
public class ListService extends HttpServlet {
	private static final long serialVersionUID = 1L;  

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Company> companys = new Bank().listCompany(); 
		
		XStream toXml = new XStream();
		toXml.alias("company", Company.class);
		String xml = toXml.toXML(companys);
		
		response.setContentType("application/xml");
		response.getWriter().print(xml);
		
		/* Mapper object with Gson lib
		Gson gson = new Gson();
		String json = gson.toJson(companys);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
		*/
	}

}
