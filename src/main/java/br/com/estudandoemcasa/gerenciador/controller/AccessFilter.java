package br.com.estudandoemcasa.gerenciador.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudandoemcasa.gerenciador.service.CompanyService;

@WebFilter(urlPatterns = "/company")
public class AccessFilter extends HttpFilter implements Filter{
	private static final long serialVersionUID = 1L;


	CompanyService service = new CompanyService();

	@Override
	public void init(FilterConfig config) throws ServletException {}

	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		HttpSession session = rq.getSession();

		if (session.getAttribute("user") == null && !rq.getParameter("action").equals("login")) {
			service.loginform(rq, rp);
			return;
		}
		chain.doFilter(rq, rp);
	}
}
