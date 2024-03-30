
public class Tratamientos {
	private int idTratamientos;
	private String nombre;
	private double precio;
	private boolean inyectable;
	private int maximoSesiones;
	private char tipoTratamiento;
	
	
	
	public int getIdTratamientos() {
		return idTratamientos;
	}
	public void setIdTratamientos(int idTratamientos) {
		this.idTratamientos = idTratamientos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean getInyectable() {
		return inyectable;
	}
	public void setInyectable(boolean inyectable) {
		this.inyectable = inyectable;
	}
	public int getMaximoSesiones() {
		return maximoSesiones;
	}
	public void setMaximoSesiones(int maximoSesiones) {
		this.maximoSesiones = maximoSesiones;
	}
	public char getTipoTratamiento() {
		return tipoTratamiento;
	}
	public void setTipoTratamiento(char tipoTratamiento) {
		this.tipoTratamiento = tipoTratamiento;
	}
	
	Tratamientos(String nombre, double precio, boolean inyectable, int maximoSesiones, char tipoTratamiento) {
		this.nombre = nombre;
		this.precio = precio;
		this.inyectable = inyectable;
		this.maximoSesiones = maximoSesiones;
		this.tipoTratamiento = tipoTratamiento;
	}
	Tratamientos(){};
	
	

	
}
