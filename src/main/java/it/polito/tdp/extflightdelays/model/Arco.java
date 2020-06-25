package it.polito.tdp.extflightdelays.model;

public class Arco {

	private String state1;
	private String state2;
	private double peso;
	public Arco(String state1, String state2, double peso) {
		super();
		this.state1 = state1;
		this.state2 = state2;
		this.peso = peso;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Arco [state1=" + state1 + ", state2=" + state2 + ", peso=" + peso + "]";
	}
	
	
	
}
