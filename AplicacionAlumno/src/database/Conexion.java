package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{

	private String dbDriver = "org.postgresql.Driver";
	private String user = "postgres";
	private String pass = "admin";
	private String port="5432";
	private String host="localhost";
	private String db="inicializacion-db";
	private String dbType="postgresql";
	private Connection conn;
	private int cantConn = 0;
	
	Conexion() {
		
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			System.out.println(e);

		}
		
	}
	
	private static Conexion instancia;
	
	public static Conexion getInstancia(){
		if (instancia == null){
			instancia = new Conexion();
		}
		return instancia;
		}
	
	
	public Connection getConn() throws SQLException{
		
		if(conn==null || conn.isClosed()){
			
			conn = DriverManager.getConnection("jdbc:"+dbType+"://"+host+"/"+db+"?&useSSL=false&serverTimezone=America/Argentina/Buenos_Aires",user,pass);
	
		}
		return conn;
	}
	
	public void releaseConn(){
		try{
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e){
			System.out.println(e);
				
		}
	}
}
