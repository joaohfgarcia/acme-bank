<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:admin_template>

	<jsp:attribute name="content">
	
		<div class="container-fluid">	
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Edição de Cadastro</h4>
                  <p class="card-category">Dados do Contato</p>
                </div>
                <div class="card-body">
                  <form action="${pageContext.request.contextPath}/contatosServlet?&acao=atualizar" method="post">
                    <div class="row">
	                    <div class="col-md-1">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Id</label>
	                          <input type="text" name = "id" class="form-control" required="required" value="${contato.id}" readonly>              
	                        </div>
	                      </div>
	                      <div class="col-md-6">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nome</label>
	                          <input type="text" name = "nome" class="form-control" maxlength="50" required="required" value="${contato.nome}">             
	                        </div>
	                      </div>
	                      <div class="col-md-5">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Email</label>
	                          <input type="email" name="email" class="form-control" maxlength="50" required="required" value="${contato.email}">
	                        </div>
	                      </div>
                    </div>
                    <div class="clearfix" align="center">
                    	<button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
	</jsp:attribute>

</mt:admin_template>
