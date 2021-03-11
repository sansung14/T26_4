package es.http.service.service;

import java.util.List;

import es.http.service.dto.Reserva;

public interface IReservaService {

	//Metodos del CRUD
		public List<Reserva> listarReserva(); //Listar All 
		
		public Reserva guardarReserva(Reserva reserva);	//Guarda un Reserva CREATE
		
		public Reserva reservaXID(int id); //Leer datos de un Reserva READ
		
		public Reserva actualizarReserva(Reserva reserva); //Actualiza datos del Reserva UPDATE
		
		public void eliminarReserva(int id);// Elimina el Reserva DELETE
	
}


