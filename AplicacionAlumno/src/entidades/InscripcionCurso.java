package entidades;

import java.util.Date;

public class InscripcionCurso 
{
	private Alumno alumno;
	private Curso curso;
	private Date fechainscripcion;
	private int nota;
	private String estado;
	
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getFechainscripcion() {
		return fechainscripcion;
	}
	public void setFechainscripcion(Date fechainscripcion) {
		this.fechainscripcion = fechainscripcion;
	}
	public InscripcionCurso() {} 
}
