package database;

import java.util.ArrayList;

import entidades.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DataInscripcionCurso 
{
	private static java.sql.Date convertUtilToSql(java.util.Date uDate)
	{
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
	public void add(Alumno al,Curso cu) throws AppDataException, ParseException 
	{
		PreparedStatement stmt=null;
		try 
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("insert into inscripciones_curso(idalumno,idcurso,fechainscripcion) values(?,?,?)");
			stmt.setInt(1, al.getIdAlumno());
			stmt.setInt(2, cu.getIdCurso());
			java.util.Date fecha =new java.util.Date();
			DateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
			String fechaActu=Formato.format(fecha);
			java.sql.Date fechaInscripcion=convertUtilToSql(Formato.parse(fechaActu));
			stmt.setDate(3, fechaInscripcion);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			AppDataException ape = new AppDataException(e, "Error al actualizar la base de datos");
			throw ape;
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
	public boolean validarCupo(int curso) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean ic=false;
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select nombre,count(inscripciones_curso.idalumno) as cantidad,cupomaximo\r\n" + 
					"from inscripciones_curso\r\n" + 
					"inner join curso on curso.identificador=inscripciones_curso.idcurso\r\n" + 
					"where curso.identificador=?\r\n" + 
					"group by identificador;");
			stmt.setInt(1,curso);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					int cantInscriptos=rs.getInt("cantidad");
					int cupo=rs.getInt("cupomaximo");
					if(cantInscriptos>=cupo)
					{
						ic=true;
						AppDataException ape = new AppDataException("No hay cupo en el curso.");
						throw ape;
					}	

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
	public boolean verificarInscripcion(int id, int curso) throws AppDataException
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean ic=false;
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * \r\n" + 
					"from inscripciones_curso\r\n" + 
					"inner join curso on curso.identificador=inscripciones_curso.idcurso\r\n" + 
					"where idalumno=? and idcurso=?");
			stmt.setInt(1,id);
			stmt.setInt(2,curso);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					ic=true;
					AppDataException ape = new AppDataException("Ya posee otras inscripciones al curso.");
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
	public ArrayList<InscripcionCurso> getInscriptos(int id)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<InscripcionCurso> cc=new ArrayList<InscripcionCurso>();
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select curso.identificador as id,curso.nombre as curso, fechainscripcion,persona.nombre as nombre, apellido, inscripciones_curso.idalumno as alumno, curso.iddocente as docente\r\n" + 
					"from curso\r\n" + 
					"inner join inscripciones_curso on inscripciones_curso.idcurso=curso.identificador\r\n" + 
					"inner join alumno on inscripciones_curso.idalumno=alumno.identificador\r\n" + 
					"inner join persona on persona.identificador=alumno.idpersona\r\n" + 
					"where curso.identificador=? and extract(year from fechainscripcion)=(select extract(year from current_date))");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					Curso c=new Curso();
					c.setNombre(rs.getString("curso"));
					c.setIdCurso(id);
					Docente d=new Docente();
					d.setIdDocente(rs.getInt("docente"));
					c.setDocente(d);					
					Alumno al=new Alumno();
					al.setIdAlumno(rs.getInt("alumno"));
					Persona p=new Persona();
					p.setApellido(rs.getString("apellido"));
					p.setNombre(rs.getString("nombre"));
					al.setPersona(p);
					InscripcionCurso ic= new InscripcionCurso();
					ic.setAlumno(al);
					ic.setFechainscripcion(rs.getDate("fechainscripcion"));
					ic.setCurso(c);
					cc.add(ic);
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
		return cc;
	}
	
	
	public ArrayList<InscripcionCurso> getEstadoCursoAnterior(Alumno al)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<InscripcionCurso> listado=new ArrayList<InscripcionCurso>();
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select * from inscripciones_curso inner join curso on curso.identificador=inscripciones_curso.idcurso where idalumno=? and extract(year from fechainscripcion)<>(select extract(year from current_date))");
			stmt.setInt(1,al.getIdAlumno());
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					InscripcionCurso ic= new InscripcionCurso();
					ic.setAlumno(al);
					ic.setEstado(rs.getString("estado"));
					ic.setNota(rs.getInt("nota"));
					ic.setFechainscripcion(rs.getDate("fechainscripcion"));
					Curso c= new Curso();
					c.setIdCurso(rs.getInt("idcurso"));
					c.setDescripcion(rs.getString("descripcion"));
					c.setNombre(rs.getString("nombre"));
					ic.setCurso(c);
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
	public ArrayList<InscripcionCurso> getAllInscripcionesCurso(Alumno al)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<InscripcionCurso> listado=new ArrayList<InscripcionCurso>();
		try
		{
			stmt=Conexion.getInstancia().getConn().prepareStatement("select idcurso,nombre,descripcion,fechainscripcion,nota, COALESCE(estado,'vacio') as estado from inscripciones_curso inner join curso on curso.identificador=inscripciones_curso.idcurso where idalumno=? and extract(year from fechainscripcion)=(select extract(year from current_date))");
			stmt.setInt(1,al.getIdAlumno());
			rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) 
				{
					InscripcionCurso ic= new InscripcionCurso();
					ic.setAlumno(al);
					ic.setEstado(rs.getString("estado"));
					ic.setNota(rs.getInt("nota"));
					ic.setFechainscripcion(rs.getDate("fechainscripcion"));
					Curso c= new Curso();
					c.setIdCurso(rs.getInt("idcurso"));
					c.setDescripcion(rs.getString("descripcion"));
					c.setNombre(rs.getString("nombre"));
					ic.setCurso(c);
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
