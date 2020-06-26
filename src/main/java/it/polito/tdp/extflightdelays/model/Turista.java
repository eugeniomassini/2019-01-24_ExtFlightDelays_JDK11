package it.polito.tdp.extflightdelays.model;

public class Turista {
	
	private String inCuiSono;
	private String daCuiArrvo;
	public Turista(String inCuiSono, String daCuiArrvo) {
		super();
		this.inCuiSono = inCuiSono;
		this.daCuiArrvo = daCuiArrvo;
	}
	public String getInCuiSono() {
		return inCuiSono;
	}
	public void setInCuiSono(String inCuiSono) {
		this.inCuiSono = inCuiSono;
	}
	public String getDaCuiArrvo() {
		return daCuiArrvo;
	}
	public void setDaCuiArrvo(String daCuiArrvo) {
		this.daCuiArrvo = daCuiArrvo;
	}
	@Override
	public String toString() {
		return "Turista [inCuiSono=" + inCuiSono + ", daCuiArrvo=" + daCuiArrvo + "]";
	}
	

}
