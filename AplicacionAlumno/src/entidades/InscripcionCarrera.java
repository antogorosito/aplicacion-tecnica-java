package entidades;

import java.util.Date;

public class InscripcionCarrera 
{
	private Alumno alumno;
	private Carrera carrera;
	private Date fechainscripcion;
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public Date getFechainscripcion() {
		return fechainscripcion;
	}
	public void setFechainscripcion(Date fechainscripcion) {
		this.fechainscripcion = fechainscripcion;
	}
	
	public InscripcionCarrera() {}
}
