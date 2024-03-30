
public class Sucursales {
	private int idSucursal;
	private String localidad;
	private String provincia;
	private  String nombre;
	
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Sucursales(int idSucursal, String localidad, String provincia, String nombre) {
		
		this.idSucursal = idSucursal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	Sucursales(){};
	
	
}
