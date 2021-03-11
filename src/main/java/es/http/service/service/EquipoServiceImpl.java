package es.http.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.dao.IEquiposDAO;
import es.http.service.dto.Equipos;

@Service
public class EquipoServiceImpl implements IEquipoService {
	
	@Autowired
	IEquiposDAO iEquipoDAO;

	@Override
	public List<Equipos> listarEquipos() {
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipos guardarEquipo(Equipos equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipos equipoXID(String id) {
		return iEquipoDAO.findById(id).get();
	}

	@Override
	public Equipos actualizarEquipo(Equipos equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(String id) {
		iEquipoDAO.deleteById(id);
	}

}
