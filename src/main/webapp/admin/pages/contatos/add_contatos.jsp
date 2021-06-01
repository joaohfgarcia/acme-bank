<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	
	<jsp:attribute name="content">
		
		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Cadastro de Contato</h4>
                  <p class="card-category">Preencha seus dados</p>
                </div>
                <div class="card-body">
                  <form action="${pageContext.request.contextPath}/contatosServlet?&acao=salvar" method="POST">
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Nome</label>
                          <input type="text" name="nome" class="form-control" maxlength="50" required="required">
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Email</label>
                          <input type="email" name="email" class="form-control" maxlength="50" required="required">
                        </div>
                      </div>
                    </div>
                    <input type="submit" value="salvar" class="btn btn-sm btn-primary"/>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        		
	</jsp:attribute>
		
</mt:admin_template>


