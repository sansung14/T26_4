package es.http.service.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "investigadores") // en caso que la tabala sea diferente
public class Investigador {

	// Atributos de entidad estudiante
	@Id
	@Column(name = "dni") // no hace falta si se llama igual
	private String dni;
	@Column(name = "nomapels") // no hace falta si se llama igual
	private String nomapels;

	@ManyToOne
	@JoinColumn(name = "facultad")
	Facultad facultad;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Reserva> reserva;

	// Constructores

	public Investigador() {

	}

	public Investigador(String dni, String nomapels, Facultad facultad, List<Reserva> reserva) {
		super();
		this.dni = dni;
		this.nomapels = nomapels;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}


	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	
}
