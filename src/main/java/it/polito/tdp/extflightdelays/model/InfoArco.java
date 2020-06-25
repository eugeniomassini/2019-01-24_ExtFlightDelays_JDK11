package it.polito.tdp.extflightdelays.model;

public class InfoArco implements Comparable <InfoArco>{
	
	private String state;
	private Double peso;
	public InfoArco(String state, Double peso) {
		super();
		this.state = state;
		this.peso = peso;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "InfoArco [state=" + state + ", peso=" + peso + "]";
	}
	@Override
	public int compareTo(InfoArco o) {
		return Double.compare(this.peso, o.peso);
	}
	
	
	
	

}
