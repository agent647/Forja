package MySqlPruebas;

import java.sql.*;

public class MySqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet result = null;
		String url = 
			"jdbc:mysql://localhost:3306/spring?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, password);
			sentencia = conexion.createStatement();
			System.out.println("Driver Cargado");
		}catch(ClassNotFoundException e){
			System.out.println("Error con los drivers de conexion " + e.getMessage());
		}catch(SQLException e) {
			System.out.println("No se pudo conectar con la base de datos " + e.getMessage());
		}
		
		try {
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS tabla1 (id1 INT PRIMARY KEY, nombre CHAR(20) DEFAULT '-') ");
			System.out.println("Tabla creada");
			
		}catch(SQLException e) {
			System.out.println("Error al crear la tabla " + e.getMessage());
		}
		
		try {
			sentencia.executeUpdate("INSERT tabla1 VALUES (3, 'Sebastian')");
			sentencia.executeUpdate("INSERT tabla1 VALUES(4, 'Juan')");
			sentencia.executeUpdate("INSERT tabla1 VALUES(5, 'Felipe')");
			System.out.println("Datos cargados correctamente");
		}catch(SQLException e) {
			System.out.println("No se pueden insertar los datos " + e.getMessage());
		}
		
		try {
			result = sentencia.executeQuery("SELECT * FROM tabla1");
			while(result.next()) {
				System.out.println("id : " + result.getLong("id1"));
				System.out.println("nombre : " + result.getString("nombre"));
				System.out.println();
			}
			System.out.println("Datos obtenidos correctamente");
		}catch(SQLException e) {
			System.out.println("Error con los datos " + e.getMessage());
		}
		
		try {
			sentencia.executeUpdate("DELETE FROM tabla1 WHERE id1=3");
			sentencia.executeUpdate("DELETE FROM tabla1 WHERE id1=4");
			sentencia.executeUpdate("DELETE FROM tabla1 WHERE id1=5");
			System.out.println("Datos borrados correctamente");
		}catch(SQLException e) {
			System.out.println("Hubo un error al querer borrar los datos " + e.getMessage());
		}
	}
	
	

}
