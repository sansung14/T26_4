package es.http.service.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import es.http.service.dto.Investigador;

/**
 * @author David
 *
 */
public interface IInvestigadorDAO extends JpaRepository<Investigador, String>{
	
}
