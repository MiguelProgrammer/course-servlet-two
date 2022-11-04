package br.com.estudandoemcasa.gerenciador.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/company")
public class EmulaFilter implements Filter{

	@Override
	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain arg2)
			throws IOException, ServletException { 
		
		Long before = System.currentTimeMillis();
		System.out.println("Before: " + before);
		
		arg2.doFilter(rq, rp);
		
		System.out.println(System.currentTimeMillis() - before);
	}
}
