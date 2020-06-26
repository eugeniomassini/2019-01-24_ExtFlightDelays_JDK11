package it.polito.tdp.extflightdelays.model;

public class InfoStato {
	
	private String stato;
	private Integer nPersone;
	public InfoStato(String stato, Integer nPersone) {
		super();
		this.stato = stato;
		this.nPersone = nPersone;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Integer getnPersone() {
		return nPersone;
	}
	public void setnPersone(Integer nPersone) {
		this.nPersone = nPersone;
	}
	@Override
	public String toString() {
		return "InfoStato [stato=" + stato + ", nPersone=" + nPersone + "]";
	}
	
	

}
