package es.http.service.service;

import java.util.List;

import es.http.service.dto.Investigador;



public interface IInvestigadorService {

	//Metodos del CRUD
		public List<Investigador> listarInvestigadors(); //Listar All 
		
		public Investigador guardarInvestigador(Investigador investigador);	//Guarda un Investigador CREATE
		
		public Investigador investigadorXID(String id); //Leer datos de un Investigador READ
		
		public Investigador actualizarInvestigador(Investigador investigador); //Actualiza datos del Investigador UPDATE
		
		public void eliminarInvestigador(String id);// Elimina el Investigador DELETE
	

}


