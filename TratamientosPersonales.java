
public class TratamientosPersonales {
	protected Tratamientos tratamientos;
	protected int cantidadSesiones;
	
	
	public Tratamientos getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(Tratamientos tratamientos) {
		this.tratamientos = tratamientos;
	}

	public int getCantidadSesiones() {
		return cantidadSesiones;
	}

	public void setCantidadSesiones(int cantidadSesiones) {
		this.cantidadSesiones = cantidadSesiones;
	}



	TratamientosPersonales(Tratamientos tratamientos, int cantidadSesiones) {
		this.tratamientos = tratamientos;
		this.cantidadSesiones = cantidadSesiones;
	}
	TratamientosPersonales(){};
	
	public double calcularCostoTratamiento() {
		double total=cantidadSesiones*tratamientos.getPrecio();
		return total;
	}
	
}
