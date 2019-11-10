package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Persona;

public class DataPersona
{
	public Persona getDocente(int idcurso)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Persona p =null;
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select apellido,persona.nombre as nombre\r\n" + 
					"from curso\r\n" + 
					"inner join persona on persona.identificador=curso.idpersona\r\n" + 
					"where curso.identificador=?;");
			stmt.setInt(1,idcurso);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					p=new Persona();
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
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
		return p;
	}
	public int seleccionarUltId() throws AppDataException
	{
		System.out.println("entre");
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int id=0;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select identificador from persona order by identificador desc limit 1");
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
	public void add(Persona per) throws AppDataException
	{		
		PreparedStatement stmt=null;
		try 
		{
			stmt = Conexion.getInstancia().getConn().prepareStatement("insert into persona values(?,?,?,?,?,?,?)");
		    stmt.setInt(1,per.getIdPersona());
		    stmt.setString(2,per.getTipodoc());
			stmt.setLong(3,per.getDocumento());
		    stmt.setString(4, per.getNombre());
		    stmt.setString(5,per.getApellido());
			java.sql.Date fecha=convertUtilToSql(per.getFechanac());
			stmt.setDate(6,fecha);
			stmt.setString(7,per.getDireccion());
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
	public void existe(long nrodoc) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt = Conexion.getInstancia().getConn().prepareStatement("select * from persona where documento=?");
			stmt.setLong(1,nrodoc);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					System.out.println("entre per con ese dni");
					AppDataException ape = new AppDataException("Ya existe una persona cargada");
					throw ape;
				}
			}
		}
		catch (SQLException e)
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
	public void update(Persona per)
	{
		PreparedStatement stmt=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("update persona set nombre=?,apellido=?,tipodoc=?,documento=?,direccion=?,fechanac=? where identificador=?");
			stmt.setInt(7,per.getIdPersona());
		    stmt.setString(3,per.getTipodoc());
			stmt.setLong(4,per.getDocumento());
		    stmt.setString(1, per.getNombre());
		    stmt.setString(2,per.getApellido());
			java.sql.Date fecha=convertUtilToSql(per.getFechanac());
			stmt.setDate(6,fecha);
			stmt.setString(5,per.getDireccion());
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
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) 
	{
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
}
