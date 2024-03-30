import java.util.Calendar;

public class ConPrepagas extends Clientes{
	private Prepagas prepaga;
	private String numeroAfiliado;
	
	public Prepagas getPrepaga() {
		return prepaga;
	}

	public void setPrepaga(Prepagas prepaga) {
		this.prepaga = prepaga;
	}

	public String getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(String numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}


	ConPrepagas(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
			Sucursales[] sucursales, TratamientosPersonales[] tratamientos, char formaPago, Prepagas prepaga, String numeroAfiliado){
		super(nombre, numeroDocumento, objetivo, fechaNacimiento, fechaInicio, sucursales, tratamientos, formaPago);
		this.prepaga=prepaga;
		this.numeroAfiliado=numeroAfiliado;
}
	ConPrepagas(){};
	
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
		total=a-prepaga.getTopeReintegro();
		
		return total;
	}


	public void supereTopeReintegro() {
		if(calcularCosto()+prepaga.getTopeReintegro() > prepaga.getTopeReintegro()) {
			System.out.println("Nombre: "+nombre);
			System.out.println("Numero de Documento: "+numeroDocumento);
			System.out.println("Fecha de Nacimiento: "+fechaNacimiento.get(Calendar.DATE)+"/"+(fechaNacimiento.get(Calendar.MONTH))+1+"/"+fechaNacimiento.get(Calendar.YEAR));
			System.out.println("Forma de pago: "+formaPago);
			System.out.println("Nombre de la prepaga: "+prepaga.getNombre());
			System.out.println("Costo total del tratamiento: "+calcularCosto()+prepaga.getTopeReintegro());
			System.out.println("Tope de reintegro: "+prepaga.getTopeReintegro());
			System.out.println("Valor realmente abonado: "+calcularCosto());
		}		
	}
}
