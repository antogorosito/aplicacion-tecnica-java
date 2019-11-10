package entidades;

public class Curso
{
	private int idCurso;
	private Carrera carrera;
	private String nombre;
	private String descripcion;
	private int cupomaximo;
	private int anio;
	private Persona docente;
	
	public Persona getDocente() {
		return docente;
	}
	public void setDocente(Persona docente) {
		this.docente = docente;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCupomaximo() {
		return cupomaximo;
	}
	public void setCupomaximo(int cupomaximo) {
		this.cupomaximo = cupomaximo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public Curso() {}
}
