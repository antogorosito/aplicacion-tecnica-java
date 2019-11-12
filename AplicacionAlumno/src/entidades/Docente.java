package entidades;

public class Docente 
{
	private int idDocente;
	private String cargo;
	private Persona persona; 

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Docente(){}
	public Docente(int id,String cargo, Persona per)
	{
		this.idDocente=id;
		this.cargo=cargo;
		this.persona=per;
	}
}
