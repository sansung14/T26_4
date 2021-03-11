package es.http.service.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva") // en caso que la tabala sea diferente
public class Reserva {

	// Atributos de entidad registro_curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	
	@ManyToOne
	@JoinColumn(name = "numserie")
	Equipos equipo;

	@ManyToOne
	@JoinColumn(name = "dni")
	Investigador investigador;
	
	@Column(name = "comienzo") // no hace falta si se llama igual
	private String comienzo;
	@Column(name = "fin") // no hace falta si se llama igual
	private String fin;
	
	
	// Constructores

	public Reserva() {

	}



	public String getComienzo() {
		return comienzo;
	}



	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}



	public String getFin() {
		return fin;
	}



	public void setFin(String fin) {
		this.fin = fin;
	}



	public Reserva(int id, Equipos equipo, Investigador investigador, String comienzo, String fin) {
		super();
		this.id = id;
		this.equipo = equipo;
		this.investigador = investigador;
		this.comienzo = comienzo;
		this.fin = fin;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

}
