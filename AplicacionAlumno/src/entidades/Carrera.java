package entidades;

import java.util.Date;

public class Carrera 
{
	private int idCarrera;
	private String nombre;
	private String descripcion;
	private Date fechadesde;
	private Date fehahasta;
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
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
	public Date getFechadesde() {
		return fechadesde;
	}
	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}
	public Date getFehahasta() {
		return fehahasta;
	}
	public void setFehahasta(Date fehahasta) {
		this.fehahasta = fehahasta;
	}
	
	public Carrera()
	{}
}
