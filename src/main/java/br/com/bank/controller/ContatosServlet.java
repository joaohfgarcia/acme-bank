package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Contato;
import br.com.bank.service.ContatoServiceImpl;


@WebServlet("/contatosServlet")
public class ContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Contato contato;
	private ContatoServiceImpl service;
	
	public ContatosServlet() {
		this.service = new ContatoServiceImpl();
		this.contato = new Contato();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
			request.setAttribute("error", "Faça o login!");
			rd.forward(request, response);
		}
		else {
			String acao = request.getParameter("acao");
			
			switch (acao) {
			
			case "remover":
				String id = request.getParameter("id");
				this.service.remover(Long.parseLong(id));
				RequestDispatcher rv = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
				request.setAttribute("removido", "Contato removido com sucesso!");
				request.setAttribute("contatos", this.service.list());
				rv.forward(request, response);
				break;
				
			case "editar":
				Long id2 = Long.parseLong(request.getParameter("id"));
				Contato c = this.service.editar(id2);
				RequestDispatcher re = request.getRequestDispatcher("/admin/pages/contatos/edit_contatos.jsp");
				request.setAttribute("contato", c);
				re.forward(request, response);
				break;	
				
			case "listar":
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
				request.setAttribute("contatos", this.service.list());
				rd.forward(request, response);
				break;
			
			case "cadastrar":
				RequestDispatcher rc = request.getRequestDispatcher("/admin/pages/contatos/add_contatos.jsp");
				rc.forward(request, response);
				break;
				
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
			request.setAttribute("error", "Faça o login!");
			rd.forward(request, response);
		}
		else {
			String acao = request.getParameter("acao");
			
			switch (acao) {
			
			case "salvar":
				this.contato = new Contato();
				this.contato.setNome(request.getParameter("nome"));
				this.contato.setEmail(request.getParameter("email"));
				
				this.service.salvar(contato);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
				request.setAttribute("sucesso", "Contato salvo com sucesso!");
				request.setAttribute("contatos", this.service.list());
				rd.forward(request, response);
				break;
			
			case "atualizar":
				
				this.contato = this.service.editar(Long.parseLong(request.getParameter("id")));
				this.contato.setNome(request.getParameter("nome"));
				this.contato.setEmail(request.getParameter("email"));
				
				this.service.atualizar(contato);
				
				RequestDispatcher rd2 = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
				request.setAttribute("sucesso", "Contato editado com sucesso!");
				request.setAttribute("contatos", this.service.list());
				rd2.forward(request, response);
				break;
				
			
			}
		}
		
			
	}

}
