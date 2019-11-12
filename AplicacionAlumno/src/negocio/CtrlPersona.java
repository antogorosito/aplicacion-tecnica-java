package negocio;

import database.*;
import entidades.Persona;

public class CtrlPersona
{
	private DataPersona dp;
	public CtrlPersona()
	{
		dp=new DataPersona();
	}
	public void add(Persona per) throws AppDataException
	{
		dp.add(per);
	}
	public int seleccionarUltId() throws AppDataException
	{
		return dp.seleccionarUltId();
	}
	public void existe(long nrodoc) throws AppDataException
	{
		 dp.existe(nrodoc);
	}
	public void update(Persona p) throws AppDataException
	{
		dp.update(p);
	}
	public Persona getDocente(int idcurso)
	{
		return dp.getDocente(idcurso);
	}
}
