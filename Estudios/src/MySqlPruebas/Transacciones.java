package MySqlPruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacciones {

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
			System.out.println("Transaccion...");
			//begin
			conexion.setAutoCommit(false);
			
			//sentencias SQL
			
			sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT tabla1 VALUES(8, TransNumero1)");
			sentencia.executeUpdate("INSERT tabla1 VALUES(9, TransNUmero2)");
			conexion.commit();
		}catch(SQLException e) {
			try {
				conexion.rollback();
				System.out.println("Cambios anulados");
			}catch(SQLException event) {
				System.out.println("Error Callback " + e.getMessage());
			}
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al cerrar la conexion " + e.getMessage());
			}
		}
	}

}
