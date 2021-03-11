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

import es.http.service.dto.Investigador;
import es.http.service.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadors")
	public List<Investigador> listaInvestigadors(){
		return investigadorServiceImpl.listarInvestigadors();
	}
	
	
	@PostMapping("/investigadors")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	
	@GetMapping("/investigadors/{id}")
	public Investigador investigadorXID(@PathVariable(name="id") String id) {
		
		Investigador Investigador_xid= new Investigador();
		
		Investigador_xid=investigadorServiceImpl.investigadorXID(id);
		
		//System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;
	}
	
	@PutMapping("/investigadors/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name="id")String id,@RequestBody Investigador investigador) {
		
		Investigador Investigador_seleccionado= new Investigador();
		Investigador Investigador_actualizado= new Investigador();
		
		Investigador_seleccionado= investigadorServiceImpl.investigadorXID(id);
		
		Investigador_seleccionado.setNomapels(investigador.getNomapels());
		Investigador_seleccionado.setFacultad(investigador.getFacultad());

		Investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(Investigador_seleccionado);
		
		//System.out.println("El Investigador actualizado es: "+ Investigador_actualizado);
		
		return Investigador_actualizado;
	}
	
	@DeleteMapping("/investigadors/{id}")
	public void eleiminarInvestigador(@PathVariable(name="id")String id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}
	
	
}
