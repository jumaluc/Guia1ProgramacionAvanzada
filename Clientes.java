import java.util.*;
public abstract class Clientes implements ICalculable {
	protected String nombre ;
	protected int numeroDocumento ;
	protected String  objetivo ;
	protected Calendar fechaNacimiento ;
	protected Calendar fechaInicio ;
	protected Sucursales sucursales[] ;
	protected TratamientosPersonales tratamientos[] = new TratamientosPersonales[10];
	protected char formaPago;

	 public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Sucursales[] getSucursales() {
		return sucursales;
	}

	public void setSucursales(Sucursales[] sucursales) {
		this.sucursales = sucursales;
	}

	public TratamientosPersonales[] getTratamientosP() {
		return tratamientos;
	}

	public void setTratamientos(Tratamientos t, int c, int p) {
		tratamientos[p].setTratamientos(t);
		tratamientos[p].setCantidadSesiones(c);;
	}

	public char getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(char formaPago) {
		this.formaPago = formaPago;
	}
	
	Clientes(){
		for(int i=0; i<tratamientos.length; i++) {
			tratamientos[i]= new TratamientosPersonales();
		}
	}
	Clientes(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
			Sucursales[] sucursales, TratamientosPersonales[] tratamientos, char formaPago) {
		this();
		this.nombre = nombre;
		this.numeroDocumento = numeroDocumento;
		this.objetivo = objetivo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInicio = fechaInicio;
		this.sucursales = sucursales;
		this.tratamientos = tratamientos;
		this.formaPago = formaPago;
	}
	
	
	public abstract double calcularCosto();
	
	
}
