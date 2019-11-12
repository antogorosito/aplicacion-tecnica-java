package negocio;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import database.*;
import entidades.*;

public class CtrlInscripcionCurso 
{
	private DataInscripcionCurso dic;
	public CtrlInscripcionCurso()
	{
		dic=new DataInscripcionCurso();
	}
	public ArrayList<InscripcionCurso> getAllInscripcionesCurso(Alumno al)
	{
		return dic.getAllInscripcionesCurso(al);
	}
	public ArrayList<InscripcionCurso> getEstadoCursoAnterior(Alumno al)
	{
		return dic.getEstadoCursoAnterior(al);
	}
	public ArrayList<InscripcionCurso> getInscriptos(int id)
	{
		return dic.getInscriptos(id);
	}
	public boolean verificarInscripcion(int id, int curso)  throws AppDataException
	{
		return dic.verificarInscripcion(id,curso);
	}
	public boolean validarCupo(int curso) throws AppDataException
	{
		return dic.validarCupo(curso);
	}
	public void add(Alumno al,Curso curso) throws AppDataException, ParseException
	{
		dic.add(al,curso);
	}
}
