<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="sidebar" data-color="purple" data-background-color="white" 
          data-image="${pageContext.request.contextPath}/assets/img/sidebar-1.jpg">
      <div class="logo"><a class="simple-text logo-normal">
          Acme App
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active  ">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard/devs.jsp">
              <i class="material-icons">dashboard</i>
              <p>Home</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="${pageContext.request.contextPath}/userServlet?acao=listar">
              <i class="material-icons">person</i>
              <p>Usuários</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="${pageContext.request.contextPath}/contatosServlet?acao=listar">
              <i class="material-icons">content_paste</i>
              <p>Contatos</p>
            </a>
          </li>
          <li class="nav-item active-pro ">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard/devs.jsp">
              <i class="material-icons">language</i>
              <p>About</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    