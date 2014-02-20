<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="libro.Libro" %>

<%
	String isbn= request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	Libro libro = new Libro(isbn, titulo, categoria);
	libro.actualizar();
	response.sendRedirect("mostrarLibro.jsp");
%>