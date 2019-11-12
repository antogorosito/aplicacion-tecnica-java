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
	
	public Alumno() {}
	public Alumno(int id,Persona per, int legajo) 
	{
		this.idAlumno=id;
		this.persona=per;
		this.legajo=legajo;
	}
}
