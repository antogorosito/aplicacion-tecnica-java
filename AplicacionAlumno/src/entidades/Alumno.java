package entidades;

import java.util.Date;

public class Alumno extends Persona
{
	private int idAlumno;
	private Persona persona;
	private int legajo;
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public Alumno() 
	{
		super();
	}
	public Alumno(int id,Persona per, int legajo) 
	{
		super(per.getIdPersona(),per.getTipodoc(),per.getDocumento(),per.getNombre(),per.getApellido(),per.getFechanac(),per.getDireccion());
		this.idAlumno=id;
		this.persona=per;
		this.legajo=legajo;
	}
}
