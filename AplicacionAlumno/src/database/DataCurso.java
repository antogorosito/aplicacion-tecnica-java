package database;
import java.util.ArrayList;
import entidades.*;
import java.sql.*;

public class DataCurso 
{	
	public ArrayList<Curso> getAll()
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Curso> listado= new ArrayList<Curso>();
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * from curso order by nombre");
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
	public Curso getOne(int id) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Curso c=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select curso.identificador as idcurso,curso.nombre as nombrecurso,anio,idcarrera,cupomaximo,descripcion,apellido,persona.nombre as nombre, idpersona,iddocente\r\n" + 
					"from curso inner join docente on docente.identificador=curso.iddocente \r\n" + 
					"inner join persona on persona.identificador=docente.idpersona where curso.identificador=?");
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
					Docente d=new Docente();
					d.setPersona(p);
					d.setIdDocente(rs.getInt("iddocente"));
					c.setDocente(d);

				}
			}
			if(c==null)
			{
				AppDataException ape = new AppDataException("No se encontro ningun curso");
				throw ape;
			}
		}
		catch(SQLException e)
		{
			AppDataException ape = new AppDataException(e, "Error con la base de datos");
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
		return c;
	}
}
