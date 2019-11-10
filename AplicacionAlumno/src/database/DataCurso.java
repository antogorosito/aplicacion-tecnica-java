package database;
import java.util.ArrayList;
import entidades.*;
import java.sql.*;

public class DataCurso 
{
	public ArrayList<Curso> getAllPorCarrera(int legajo) // no se usa
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Curso> lista=new ArrayList<Curso>();
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * from curso where idcarrera in(\r\n" + 
					"select idcarrera\r\n" + 
					"from alumno\r\n" + 
					"inner join inscripciones_carrera on inscripciones_carrera.idalumno=alumno.identificador\r\n" + 
					"where legajo=?)");
			stmt.setInt(1,legajo);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					Curso c=new Curso();
					c.setIdCurso(rs.getInt("identificador"));
					c.setNombre(rs.getString("nombre"));
					c.setAnio(rs.getInt("anio"));
					lista.add(c);
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
		return lista;
	}
	
	public ArrayList<Curso> getAll()
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Curso> listado= new ArrayList<Curso>();
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * from curso");
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					Curso c=new Curso();
					c.setIdCurso(rs.getInt("identificador"));
					c.setNombre(rs.getString("nombre"));
					c.setAnio(rs.getInt("anio"));
					listado.add(c);
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
	public Curso getOne(int id)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Curso c=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select curso.identificador as idcurso,curso.nombre as nombrecurso,anio,idcarrera,cupomaximo,descripcion,apellido,persona.nombre as nombre, idpersona\r\n" + 
					"from curso inner join persona on persona.identificador=curso.idpersona where curso.identificador=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					 c=new Curso();
					c.setIdCurso(rs.getInt("idcurso"));
					c.setNombre(rs.getString("nombrecurso"));
					c.setAnio(rs.getInt("anio"));
					Carrera ca= new Carrera();
					ca.setIdCarrera(rs.getInt("idcarrera"));
					c.setCarrera(ca);
					c.setCupomaximo(rs.getInt("cupomaximo"));
					c.setDescripcion(rs.getString("descripcion"));
					Persona p=new Persona();
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
					p.setIdPersona(rs.getInt("idpersona"));
					c.setDocente(p);

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
		return c;
	}
}
