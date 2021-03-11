package es.http.service.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facultad") // en caso que la tabala sea diferente
public class Facultad {

	// Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "nombre") // no hace falta si se llama igual
	private String nombre;
	@OneToMany
	@JoinColumn(name = "numserie")
	private List<Equipos> equipos;

	@OneToMany
	@JoinColumn(name = "dni")
	private List<Investigador> investigadores;

	// Constructores

	public Facultad() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param equipos
	 * @param investigadores
	 */

	public Facultad(int id, String nombre, List<Equipos> equipos, List<Investigador> investigadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.equipos = equipos;
		this.investigadores = investigadores;
	}

	/**
	 * @return the equipos
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
	public List<Equipos> getEquipos() {
		return equipos;
	}

	/**
	 * @return the investigadores
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigador() {
		return investigadores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	public void setEquipos(List<Equipos> equipos) {
		this.equipos = equipos;
	}

}
