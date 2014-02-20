<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="libro.Libro" %>

<%
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	//realizar consulta usando clase DBUtil
	Libro libro = new Libro(isbn, titulo, categoria);
	libro.insertar();
	response.sendRedirect("mostrarLibro.jsp");
%>