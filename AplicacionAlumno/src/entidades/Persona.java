package entidades;

import java.util.Date;

public abstract class Persona 
{
	private int idPersona;
	private TipoDoc tipodoc;
	private long documento;
	private String nombre;
	private String apellido;
	private Date fechanac;
	private String direccion;
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public TipoDoc getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(TipoDoc tipodoc) {
		this.tipodoc = tipodoc;
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechanac() {
		return fechanac;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	
	public Persona() {}
	public Persona(int id,TipoDoc tipo, long doc, String nombre, String apellido, Date fecha,String direccion) 
	{
		this.idPersona=id;
		this.tipodoc=tipo;
		this.documento=doc;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechanac=fecha;
		this.direccion=direccion;
	}
}