package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.User;
import br.com.bank.service.UserServiceImpl;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User user;
	private UserServiceImpl service;

	public UserServlet() {
		this.service = new UserServiceImpl();
		this.user = new User();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("admin") == null) {
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
				RequestDispatcher rv = request.getRequestDispatcher("/admin/pages/users/list_users.jsp");
				request.setAttribute("removido", "Usuário removido com sucesso!");
				request.setAttribute("users", this.service.list());
				rv.forward(request, response);
				break;

			case "editar":
				Long id2 = Long.parseLong(request.getParameter("id"));
				User u = this.service.editar(id2);
				RequestDispatcher re = request.getRequestDispatcher("/admin/pages/users/edit_users.jsp");
				request.setAttribute("user", u);
				re.forward(request, response);
				break;

			case "listar":
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/users/list_users.jsp");
				request.setAttribute("users", this.service.list());
				rd.forward(request, response);
				break;

			case "cadastrar":
				RequestDispatcher rc = request.getRequestDispatcher("/admin/pages/users/add_users.jsp");
				rc.forward(request, response);
				break;

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
			request.setAttribute("error", "Faça o login!");
			rd.forward(request, response);
		} else {

			String acao = request.getParameter("acao");

			switch (acao) {

			case "salvar":
				this.user = new User();
				this.user.setEmail(request.getParameter("email"));
				this.user.setPassword(request.getParameter("password"));

				if (this.service.salvar(user)) {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/users/list_users.jsp");
					request.setAttribute("sucesso", "Usuário salvo com sucesso!");
					request.setAttribute("users", this.service.list());
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/users/list_users.jsp");
					request.setAttribute("sucesso", "Erro, usuário já existente!");
					request.setAttribute("users", this.service.list());
					rd.forward(request, response);

				}
				break;

			case "atualizar":

				this.user = this.service.editar(Long.parseLong(request.getParameter("id")));
				this.user.setEmail(request.getParameter("email"));
				this.user.setPassword(request.getParameter("password"));
				this.service.atualizar(user);

				RequestDispatcher rd2 = request.getRequestDispatcher("/admin/pages/users/list_users.jsp");
				request.setAttribute("sucesso", "Usuário editado com sucesso!");
				request.setAttribute("users", this.service.list());
				rd2.forward(request, response);
				break;

			}
		}

	}

}
