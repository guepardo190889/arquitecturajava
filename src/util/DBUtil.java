package util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil<T> {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/arquitecturajava";
	private static final String USUARIO = "blackdeath";
	private static final String CLAVE = "aeiou123";

	public int modificarRegistro(String consultaSQL) throws ClassNotFoundException, SQLException {
		
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
		} catch (ClassNotFoundException e) {
			System.out.println("Error de acceso al driver" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error de SQL" + e.getMessage());
		} finally {
			if (sentencia != null) {
				try {
					sentencia.close();
				}
				catch (SQLException e) {
					System.out.println("Error al cerrar la Sentencia");
				}
			}
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar la Conexion");
				}
			}
		}
		
		return filasAfectadas;
	}

	@SuppressWarnings("unchecked")
	public List<T> seleccionarRegistros(String consultaSQL, Class<T> clase) {
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet rs = null;
		List<T> lista = new ArrayList<>();

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery(consultaSQL);
			
			while(rs.next()) {
				T objeto = (T)Class.forName(clase.getName()).newInstance();
				Method[] metodos = objeto.getClass().getDeclaredMethods();
				
				for(int i = 0; i < metodos.length; i++) {
					if(metodos[i].getName().startsWith("set")) {
						metodos[i].invoke(
								objeto,
								rs.getString(metodos[i].getName().substring(3)));
					}
					if(objeto.getClass().getName().equals("java.lang.String")) {
						objeto=(T)rs.getString(1);
					}
				}
				lista.add(objeto);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error Driver" + e.getMessage());
		}
		catch (SQLException e) {
			System.out.println("Error de SQL " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error al seleccionar los registros " + e.getMessage());
		}
		finally {
			if(sentencia != null) {
				try {
					sentencia.close();
				}
				catch (SQLException e) {
					System.out.println("Error al cerrar la Sentencia");
				}
			}
			if(conexion != null) {
				try {
					conexion.close();
				}
				catch (SQLException e) {
					System.out.println("Error al cerrar la Conexion");
				}
			}
		}
		return lista;
	}
}