package br.com.estudandoemcasa.gerenciador.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DelegateAction {

	void command(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
