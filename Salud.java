
public final class Salud extends TratamientosPersonales{
	private boolean consultaClinica;
	private static double valorAdicional;
	
	
	public boolean getConsultaClinica() {
		return consultaClinica;
	}
	public void setConsultaClinica(boolean consultaClinica) {
		this.consultaClinica = consultaClinica;
	}

	public static double getValorAdicional() {
		return valorAdicional;
	}
	public static void setValorAdicional(double valorAdicional) {
		Salud.valorAdicional = valorAdicional;
	}



	Salud(Tratamientos tratamientos, int cantidadSesiones, boolean consultaClinica, double valorAdicional){
		super(tratamientos, cantidadSesiones);
		this.consultaClinica=consultaClinica;
		Salud.valorAdicional=valorAdicional;
	}
	Salud(){};


	public double calcularCostoTratamiento() {
		double total = cantidadSesiones*tratamientos.getPrecio();
		if(consultaClinica) {
			total+=valorAdicional;
		}
		return total;
	}
	
	
}
