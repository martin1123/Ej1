package ar.com.ej1.dto;

public class FormaDePago {

	private Long id;
	private String descripcion;
	private Double recargo;
	
	public FormaDePago(Long id, String descripcion, Double recargo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.recargo = recargo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getRecargo() {
		return recargo;
	}
	public void setRecargo(Double recargo) {
		this.recargo = recargo;
	}
		
	
}
