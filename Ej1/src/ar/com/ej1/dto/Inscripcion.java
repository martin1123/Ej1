package ar.com.ej1.dto;

public class Inscripcion {

	private Long id;
	private String nombre;
	private String telefono;
	private Long idCurso;
	private Long idFormaDePago;

	public Inscripcion(Long id, String nombre, String telefono, Long idCurso, Long idFormaDePago) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.idCurso = idCurso;
		this.idFormaDePago = idFormaDePago;
	}

	public Inscripcion() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Long getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(Long idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}
	
	

}
