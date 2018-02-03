package ar.com.ej1.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class UConnection {

	private static Connection con = null;

	public static Connection getConnection() {
		String driver = null;
		String url = null;
		String usr = null;
		String pwd = null;

		try {
			if (con == null) {
				// con esto determinamos cuando finalize el programa
				Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
				ResourceBundle rb = ResourceBundle.getBundle("jdbc");
				driver = rb.getString("driver");
				url = rb.getString("url");
				pwd = rb.getString("pwd");
				usr = rb.getString("usr");
			}else{
				return con;
			}

			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		    con = DriverManager.getConnection
		          ("jdbc:oracle:thin:@localhost:1521:xe", usr, pwd);
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Error al crear la conexion", ex);
		}
	}

	static class MiShDwnHook extends Thread {
		// justo antes de fi nalizar el programa la JVM invocara
		// a este metodo donde podemos cerrar la conexion
		public void run() {
			try {
				Connection con = UConnection.getConnection();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
