
public class Prepagas {
	private String nombre;
	private int idPrepaga;
	private String plan []=new String[3];
	private double topeReintegro;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdPrepaga() {
		return idPrepaga;
	}
	public void setIdPrepaga(int idPrepaga) {
		this.idPrepaga = idPrepaga;
	}
	public String [] getPlan() {
		return plan;
	}
	public void setPlan(String [] plan) {
		this.plan = plan;
	}
	public double getTopeReintegro() {
		return topeReintegro;
	}
	public void setTopeReintegro(double topeReintegro) {
		this.topeReintegro = topeReintegro;
	}
	
	Prepagas(int idPrepaga, String [] plan, double topeReintegro, String nombre) {
		this.idPrepaga = idPrepaga;
		this.plan = plan;
		this.topeReintegro = topeReintegro;
		this.nombre = nombre;
	}
	Prepagas(){};
	
}
