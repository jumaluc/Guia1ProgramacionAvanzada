import java.util.Calendar;

public class Particulares extends Clientes {
	private double descuento;
	private static int cantidadClientesParticulares;
	
	
	
	
	public static int  getCantidadClientesParticulares() {
		return cantidadClientesParticulares;
	}

	public static void setCantidadClientesParticulares(int cantidadClientesParticulares) {
		Particulares.cantidadClientesParticulares = cantidadClientesParticulares;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	Particulares(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
			Sucursales[] sucursales,  char formaPago, double descuento){
		super(nombre, numeroDocumento, objetivo, fechaNacimiento, fechaInicio, sucursales,  formaPago);
		this.descuento=descuento;
	}
	Particulares(){};
	
	public double calcularCosto() {
		double total=0;
		double a=0;
		for(int i=0 ; i<tratamientos.length ; i++) {
			if(tratamientos[i] instanceof Salud) {
				a=a+((Salud)tratamientos[i]).calcularCostoTratamiento();
			}
			else {
				a+=tratamientos[i].calcularCostoTratamiento();
			}
		}
		total=a-(a*descuento/100);
		if(formaPago=='e') {
			total=total-total*0.05;
		}
		return total;
	}
}
