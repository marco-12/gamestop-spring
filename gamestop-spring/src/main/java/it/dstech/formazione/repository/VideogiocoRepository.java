package it.dstech.formazione.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.dstech.formazione.model.Videogioco;


public interface VideogiocoRepository extends CrudRepository<Videogioco, Long>{
	
	@Query(value = "SELECT v FROM Videogioco v WHERE v.titolo LIKE '%' || :keyword || '%'"
			+ " OR v.pegi LIKE '%' || :keyword || '%'"
			+ " OR v.prezzo LIKE '%' || :keyword || '%'"
			+ " OR v.categoria LIKE '%' || :keyword || '%'")
	public List<Videogioco> search(@Param("keyword") String keyword);
	
	@Query("select v from Videogioco v order by prezzo ASC")
	public List<Videogioco> orderByPrezzo();
	
	@Query("select v from Videogioco v order by titolo ASC")
	public List<Videogioco> orderByTitolo();
	
	@Query("select v from Videogioco v order by categoria ASC")
	public List<Videogioco> orderByCategoria();
	
	@Query("select v from Videogioco v order by classificazione ASC")
	public List<Videogioco> orderByClassificazione();

}
