<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="libro.Libro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Libro libro = Libro.buscarPorClave(request.getParameter("isbn")); %>
	<form id="formEditarLibro" action="actualizarLibro.jsp">
		<fieldset>
			<legend>Edición de libro</legend>
			<p>
				<label for="isbn">ISBN:</label> 
				<input id="isbn" type="text" name="isbn" value="<%=libro.getIsbn()%>" />
			</p>
			<p>
				<label for="titulo">Titulo:</label> <input id="titulo" type="text"
					name="titulo" value="<%=libro.getTitulo()%>" />
			</p>
			<p>
				<label for="categoria">Categoria:</label> 
					<select name="categoria">
					<%
						List<String> categorias = null;
						categorias = Libro.buscarTodasLasCategorias();
						for (String categoria : categorias) {
							if (libro.getCategoria().equals(categoria)) {
					%>
					<option value="<%=categoria%>" selected="selected"><%=categoria%></option>
						<%
							} else {
						%>
					<option value="<%=categoria%>"><%=categoria%></option>
						<%
							}
						}
						%>
				</select>
				<br/>
			</p>
			<p>
				<input type="submit" value="Actualizar" />
			</p>
		</fieldset>
	</form>
</body>
</html>