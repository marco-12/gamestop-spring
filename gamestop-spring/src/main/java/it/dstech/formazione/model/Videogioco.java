package it.dstech.formazione.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Videogioco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titolo;
	private Pegi pegi;
	private double prezzo;
	private String categoria;
	
	public Videogioco() {
		
	}

	public Videogioco(Long id, String titolo, Pegi pegi, double prezzo, String categoria) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.pegi = pegi;
		this.prezzo = prezzo;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Pegi getPegi() {
		return pegi;
	}

	public void setPegi(Pegi pegi) {
		this.pegi = pegi;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
