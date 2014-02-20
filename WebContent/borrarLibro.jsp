<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="libro.Libro" %>

<%
	String isbn = request.getParameter("isbn");
	Libro libro = new Libro();
	libro.setIsbn(isbn);
	libro.borrar();
	response.sendRedirect("mostrarLibro.jsp");
%>