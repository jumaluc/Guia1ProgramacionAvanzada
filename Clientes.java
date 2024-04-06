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
	public void setTratamientosPCantidadSesiones( int c, int p) {
		tratamientos[p].setCantidadSesiones(c);
	}
	public void setTratamientosP(Tratamientos t, int p) {
		tratamientos[p].setTratamientos(t);
	}
	public void createTratamientosP(Tratamientos t,boolean b, int p) {
		if(b) {
			tratamientos[p] = new Salud();
			
		}
		else {
			tratamientos[p] = new TratamientosPersonales();
		}
		tratamientos[p].setTratamientos(t);
	}
	

	public char getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(char formaPago) {
		this.formaPago = formaPago;
	}
	
	Clientes(){}
	
	Clientes(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
			Sucursales[] sucursales, char formaPago) {
		this();
		this.nombre = nombre;
		this.numeroDocumento = numeroDocumento;
		this.objetivo = objetivo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInicio = fechaInicio;
		this.sucursales = sucursales;
		this.formaPago = formaPago;
	}
	
	
	public abstract double calcularCosto();
	
	
}
