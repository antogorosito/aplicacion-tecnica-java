package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.*;

public class DataInscripcionCarrera
{
	public int  getProm(Alumno al, Carrera ca)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int prom=0;
		
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select avg(nota) as promedio, carrera.nombre as carrera\r\n" + 
					"from inscripciones_curso\r\n" + 
					"inner join curso on curso.identificador=inscripciones_curso.idcurso\r\n" + 
					"inner join carrera on carrera.identificador=curso.idcarrera\r\n"+
					"where estado='aprobado' and idalumno=? and idcarrera=?\r\n" + 
					"group by idalumno,carrera.nombre");
			stmt.setInt(1, al.getIdAlumno());
			stmt.setInt(2, ca.getIdCarrera());
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					prom=rs.getInt("promedio");
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e )
			{
				e.printStackTrace();
			}
		}
		return prom;
	}
	public InscripcionCarrera validarCarreraCurso(int idal,int idcurso) throws AppDataException
	{

		PreparedStatement stmt=null;
		ResultSet rs=null;
		InscripcionCarrera ic=null;
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("\r\n" + 
					"select * from curso where identificador=? and idcarrera in(\r\n" + 
					"select idcarrera\r\n" + 
					"from alumno	\r\n" + 
					"inner join inscripciones_carrera on inscripciones_carrera.idalumno=alumno.identificador\r\n" + 
					"where alumno.identificador=? )");
			stmt.setInt(1,idcurso);
			stmt.setInt(2, idal);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					ic= new InscripcionCarrera();
					Carrera c=new Carrera();
					c.setIdCarrera(rs.getInt("idcarrera"));
					ic.setCarrera(c);
				}
			}
			if(ic==null)
			{
				AppDataException ape = new AppDataException("No esta inscripto a la carrera para realizar ese curso.");
				throw ape;
			}
		}
		catch(SQLException e)
		{
			AppDataException ape = new AppDataException(e, "Error en base de datos");
			throw ape;
		}
		finally
		{
			try
			{
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return ic;
	}
	public ArrayList<InscripcionCarrera> getAllInscripcionesCarrera(Alumno al)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<InscripcionCarrera> listado=new ArrayList<InscripcionCarrera>();
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * from inscripciones_carrera inner join carrera on carrera.identificador=inscripciones_carrera.idcarrera where idalumno=?");
			stmt.setInt(1,al.getIdAlumno());
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					InscripcionCarrera ic=new InscripcionCarrera();
					Carrera ca=new Carrera();
					ca.setIdCarrera(rs.getInt("idcarrera"));
					ca.setNombre(rs.getString("nombre"));
					ic.setCarrera(ca);
					ic.setAlumno(al);
					ic.setFechainscripcion(rs.getDate("fechainscripcion"));
					listado.add(ic);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return listado;
	}
}
