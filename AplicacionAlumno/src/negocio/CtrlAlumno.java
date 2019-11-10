package negocio;

import java.util.ArrayList;

import database.*;
import entidades.Alumno;

public class CtrlAlumno 
{
	private DataAlumno da;
	public CtrlAlumno()
	{
		da=new DataAlumno();
	}
	public void existe(int legajo) throws AppDataException
	{
		 da.existe(legajo);
	}
	public Alumno getOneAl(int legajo) throws AppDataException
	{
		 return da.getOneAl(legajo);
	}
	public int seleccionarUltId() throws AppDataException
	{
		return da.seleccionarUltId();
	}
	public void add(Alumno al)  throws AppDataException
	{
		da.add(al);
	}
	public ArrayList<Alumno> getAll()
	{

		return da.getAll();
	}
	public void update(Alumno al)
	{
		da.update(al);
	}
}
