package entidades;

public enum TipoDoc {
	
		DNI(1),
		LC(2);
	
	int valor;
	
	TipoDoc(int p)
	{
		valor=p;
	}
	public int getValor()
	{
		return valor;
	}
}
