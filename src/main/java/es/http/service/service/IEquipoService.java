package es.http.service.service;

import java.util.List;

import es.http.service.dto.Equipos;

public interface IEquipoService {

	//Metodos del CRUD
		public List<Equipos> listarEquipos(); //Listar All 
		
		public Equipos guardarEquipo(Equipos equipo);	//Guarda un Equipo CREATE
		
		public Equipos equipoXID(String id); //Leer datos de un Equipo READ
		
		public Equipos actualizarEquipo(Equipos equipo); //Actualiza datos del equipo UPDATE
		
		public void eliminarEquipo(String id);// Elimina el equipo DELETE
	
}


