package br.com.bank.atutenticacao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		boolean taLogado = (session != null && session.getAttribute("admin") != null);
		
		String urlLogin = httpRequest.getContextPath() + "/admin/login.jsp";
		String ulrLoginServlet = "/acme-bank/admin/dashboard/LoginServlet";
		
		System.out.println(httpRequest.getRequestURI());
		System.out.println(urlLogin);
		
		boolean isRequestLogin = httpRequest.getRequestURI().equals(urlLogin);
		boolean isPaginaLogin = httpRequest.getRequestURI().endsWith("login.jsp");
		boolean isRequestLoginServlet = ulrLoginServlet.equals(httpRequest.getRequestURI());
		
		if(taLogado && (isRequestLogin || isPaginaLogin)) {
			System.out.println("Pagina de login. Já logado.");
			RequestDispatcher dispacher = request.getRequestDispatcher("admin/dashboard/devs.jsp");
			dispacher.forward(request, response);
			
		}else if (taLogado || isRequestLogin || isRequestLoginServlet ) {
			System.out.println("Já logado ou tentando logar.");

			chain.doFilter(request, response);
			
		} else {
			System.out.println("Não está logado.");

			RequestDispatcher dispacher = request.getRequestDispatcher("/admin/login.jsp");
			dispacher.forward(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("inicio");
	
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
