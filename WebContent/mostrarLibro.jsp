<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="libro.Libro"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>

	<form name="filtroCategoria">
		<select name="categoria">
			<option value="Seleccione Categoria">Seleccione categoria...</option>
			<%
				List<String> categorias = null;
				categorias = Libro.buscarTodasLasCategorias();
				for (String cat : categorias) {
			%>
			<option value="<%=cat%>">
				<%=cat%></option>
			<%
				}
			%>
		</select> <input type="submit" value="Filtrar">
	</form>
	
	<br />

	<%
		List<Libro> libros = null;
		if (request.getParameter("categoria") == null
				|| request.getParameter("categoria").equals(
						"Seleccione Categoria")) {
			libros = Libro.buscarTodos();
		} else {
			libros = Libro.buscarPorCategoria(request
					.getParameter("categoria"));
		}
		for (Libro lib : libros) {
	%>

	<%=lib.getIsbn()%>
	<%=lib.getTitulo()%>
	<%=lib.getCategoria()%>
	<a href="formularioEditarLibro.jsp?isbn=<%=lib.getIsbn()%>">Editar</a>
	<a href="borrarLibro.jsp?isbn=<%=lib.getIsbn()%>">Borrar</a>
	<br />
	<%
		}
	%>
	<a href="formularioAltaLibro.jsp">Insertar Libro</a>
</body>
</html>