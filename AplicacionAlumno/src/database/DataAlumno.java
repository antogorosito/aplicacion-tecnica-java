package database;

import java.sql.*;
import java.util.ArrayList;

import entidades.Alumno;
import entidades.Persona;


public class DataAlumno 
{
	public void update(Alumno al)
	{
		PreparedStatement stmt=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("update alumno set legajo=? where identificador=?");
			stmt.setInt(1,al.getLegajo());
			stmt.setInt(2,al.getIdAlumno());
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void existe(int legajo) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * from alumno where legajo=?");
			stmt.setInt(1,legajo);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					System.out.println("entre alum con ese leg");
					AppDataException ape = new AppDataException("Ya existe una persona cargada");
					throw ape;
				}
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
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
		}
	}
	public Alumno getOneAl(int legajo) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Alumno al=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select alumno.identificador as id,legajo,persona.identificador as idp,nombre,apellido,direccion,documento,tipodoc,fechanac from alumno inner join persona on persona.identificador=alumno.idpersona where legajo=?");
			stmt.setInt(1,legajo);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					Persona p=new Persona();
					p.setIdPersona(rs.getInt("idp"));
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
					p.setDireccion(rs.getString("direccion"));
					p.setDocumento(rs.getLong("documento"));
					p.setFechanac(rs.getDate("fechanac"));
					p.setTipodoc(rs.getString("tipodoc"));
					al=new Alumno();
					al.setPersona(p);
					al.setLegajo(rs.getInt("legajo"));
					al.setIdAlumno(rs.getInt("id"));
					
				}
			}	
			if(al==null)
			{
				AppDataException ape = new AppDataException("No existe el alumno con ese legajo.");
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
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
		}
		return al;
	}
	public int seleccionarUltId() throws AppDataException
	{
		System.out.println("entre");
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int id=0;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select identificador from alumno order by identificador desc limit 1");
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					id=rs.getInt("identificador");
					System.out.println("entre2");
				}
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
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
		}
		return id;
	}
	public void add(Alumno al) throws AppDataException
	{
		PreparedStatement stmt=null;
		try 
		{
			stmt = Conexion.getInstancia().getConn().prepareStatement("insert into alumno values(?,?,?)");
		    stmt.setInt(1,al.getIdAlumno());
		    stmt.setInt(2,al.getPersona().getIdPersona());
			stmt.setInt(3,al.getLegajo());
			stmt.executeUpdate();
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
				Conexion.getInstancia().releaseConn();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			} 
		}
	}
	public ArrayList<Alumno> getAll() 
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Alumno> listado=new ArrayList<Alumno>();
		try
		{
			System.out.println("aqui");
			stmt=Conexion.getInstancia().getConn().prepareStatement("select alumno.identificador as id,legajo,persona.identificador as idp,nombre,apellido,direccion,documento,tipodoc,fechanac from alumno inner join persona on persona.identificador=alumno.idpersona");
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					System.out.println("entre");
					Persona p=new Persona();
					p.setIdPersona(rs.getInt("idp"));
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
					p.setDireccion(rs.getString("direccion"));
					p.setDocumento(rs.getLong("documento"));
					p.setFechanac(rs.getDate("fechanac"));
					p.setTipodoc(rs.getString("tipodoc"));
					Alumno al=new Alumno();
					al.setPersona(p);
					al.setLegajo(rs.getInt("legajo"));
					al.setIdAlumno(rs.getInt("id"));
					listado.add(al);
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
