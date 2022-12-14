package br.com.estudandoemcasa.gerenciador.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudandoemcasa.gerenciador.service.CompanyService;

//@WebFilter(urlPatterns = "/*")
public class MonitoringFilter extends HttpFilter implements Filter {

	CompanyService service = new CompanyService();

	@Override
	public void init(FilterConfig config) throws ServletException {}

	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Long before = System.currentTimeMillis();

		System.out.println("Before: " + before);

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		chain.doFilter(rq, rp);

		Long after = System.currentTimeMillis();
		System.out.println("After: " + after);
		System.out.println("Diference: " + (after - before));
	}
}
