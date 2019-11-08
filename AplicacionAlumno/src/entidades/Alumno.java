package entidades;

public class Alumno 
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
	public Persona getIdPersona() {
		return persona;
	}
	public void setIdPersona(Persona idPersona) {
		this.persona = idPersona;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public Alumno() {}
	public Alumno(Persona per, int legajo) 
	{
		this.persona=per;
		this.legajo=legajo;
	}
}
