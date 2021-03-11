package es.http.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.http.service.dto.Equipos;
import es.http.service.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquiposController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;

	@GetMapping("/equipos")
	public List<Equipos> listarEquipos() {
		return equipoServiceImpl.listarEquipos();
	}

	@PostMapping("/equipos")
	public Equipos salvarEquipo(@RequestBody Equipos equipo) {

		return equipoServiceImpl.guardarEquipo(equipo);
	}

	@GetMapping("/equipos/{id}")
	public Equipos EquipoXID(@PathVariable(name = "id") String id) {

		Equipos Equipo_xid = new Equipos();

		Equipo_xid = equipoServiceImpl.equipoXID(id);

		// System.out.println("Equipo XID: "+Equipo_xid);

		return Equipo_xid;
	}

	@PutMapping("/equipo/{id}")
	public Equipos actualizarEquipo(@PathVariable(name = "id") String id, @RequestBody Equipos Equipo) {

		Equipos Equipo_seleccionado = new Equipos();
		Equipos Equipo_actualizado = new Equipos();

		Equipo_seleccionado = equipoServiceImpl.equipoXID(id);

		Equipo_seleccionado.setNombre(Equipo.getNombre());
		Equipo_seleccionado.setFacultad(Equipo.getFacultad());

		Equipo_actualizado = equipoServiceImpl.actualizarEquipo(Equipo_seleccionado);

		// System.out.println("El Equipo actualizado es: "+ Equipo_actualizado);

		return Equipo_actualizado;
	}

	@DeleteMapping("/equipo/{id}")
	public void eleiminarEquipo(@PathVariable(name = "id") String id) {
		equipoServiceImpl.eliminarEquipo(id);
	}

}
