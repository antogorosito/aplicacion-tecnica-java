package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.*;

public class DataDocente 
{
	public Docente getDocente(int idcurso) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Docente d =null;
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select apellido,persona.nombre as nombre,persona.identificador as id,docente.identificador as idd, cargo \r\n" + 
					"from curso\r\n" + 
					"inner join docente on docente.identificador=curso.iddocente\r\n" + 
					"inner join persona on persona.identificador=docente.idpersona\r\n" + 
					"where curso.identificador=?");
			stmt.setInt(1,idcurso);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					Persona p=new Persona();
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
					p.setIdPersona(rs.getInt("id"));
					d=new Docente();
					d.setPersona(p);
					d.setIdDocente(rs.getInt("idd"));
					d.setCargo(rs.getString("cargo"));
				}
			}
			if(d==null)
			{
				AppDataException ape = new AppDataException("No existe docente para ese curso.");
				throw ape;
			}
		}
		catch(SQLException e)
		{
			AppDataException ape = new AppDataException(e,"Error con la base de datos.");
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
		return d;
	}
}
