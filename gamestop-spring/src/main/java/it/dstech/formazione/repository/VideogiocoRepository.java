package it.dstech.formazione.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.dstech.formazione.model.Videogioco;


public interface VideogiocoRepository extends CrudRepository<Videogioco, Long>{
	
	@Query(value = "SELECT v FROM Videogioco v WHERE v.nome LIKE '%' || :keyword || '%'"
			+ " OR v.pegi LIKE '%' || :keyword || '%'"
			+ " OR v.prezzo LIKE '%' || :keyword || '%'"
			+ " OR v.categoria LIKE '%' || :keyword || '%'")
	public List<Videogioco> search(@Param("keyword") String keyword);
	
	public List<Videogioco> orderByPrezzo();
	
	public List<Videogioco> orderByNome();
	
	public List<Videogioco> orderByCategoria();
	
	public List<Videogioco> orderByClassificazione();

}
