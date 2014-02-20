package libro;

import java.util.List;
import util.DBUtil;

public class Libro {

	private String isbn;
	private String titulo;
	private String categoria;

	public Libro() {
		super();
	}
	
	public Libro(String isbn, String titulo, String categoria) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	public void insertar() {
		String consultaSQL = "insert into libro (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
		DBUtil<Libro> dbUtil = new DBUtil<>();
		dbUtil.modificarLibro(consultaSQL);
	}

	public static List<Libro> buscarTodos() {
		String consultaSQL = "select isbn,titulo,categoria from libro";
		DBUtil<Libro> dbUtil = new DBUtil<>();
		List<Libro> lista = dbUtil.seleccionarRegistros(consultaSQL, Libro.class);
		return lista;
	}	

	public static List<String> buscarTodasLasCategorias() {
		String consultaSQL = "select distinct(categoria) from libro";
		DBUtil<String> dbUtil = new DBUtil<>();
		List<String> lista = dbUtil.seleccionarRegistros(consultaSQL, String.class);
		return lista;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
