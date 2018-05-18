<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Sessões</title>
</head>
<body>
<c:url value="pagina2.jsp" var="x"/>
	<c:if test="${(sessionScope.logado == null)}">
		<c:redirect url="login.jsp" />
		</c:if>
		<table class="table table-striped" style="width: 25%; align-self: center;">
			<thead>
				<tr>
					<th>
						<h3>
							<span class="glyphicon glyphicon-user"></span>  ${logado}</h3>
					</th>
					<th><a href="ajuda.jsp">Ajuda</a></th>
					<th><a href="logout">Sair</a></th>
				</tr>
			</thead>
		</table>
	<h1></h1>
	<br>
	<h3>Esta é a página 1</h3>
	<br>
	<a href="${x}">Próxima >> </a>
</body>
</html>