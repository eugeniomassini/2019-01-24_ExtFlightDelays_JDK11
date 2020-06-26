package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulator {

	//Coda degli eventi
	private List<Turista> turisti;
	
	//Modello del mondo
	private Graph <String, DefaultWeightedEdge> grafo;
	private Model model;
	
	//parametri della simulazione
	private Integer numeroPersone;
	private Integer numeroGiorni;
	
	//valori da calcolare
	List<InfoStato> output;
	
	public Simulator() {
		
		turisti = new ArrayList<Turista>();
		output = new ArrayList<InfoStato>();
		
	}
	
	private void inizializza(int numeroPersone, int numeroGiorni, String partenza, Graph<String, DefaultWeightedEdge> grafo) {
		
		this.numeroPersone=numeroPersone;
		this.numeroGiorni =numeroGiorni;
		this.grafo=grafo;
		for(int i=0; i<this.numeroPersone;i++) {
			Turista t= new Turista(partenza, partenza);
			turisti.add(t);
			
		}
		for(String s: grafo.vertexSet()) {
			this.output.add(new InfoStato(s, 0));
		}
		
		run(this.grafo, turisti, partenza);
		
	}

	private void run(Graph<String, DefaultWeightedEdge> grafo, List<Turista> turisti, String partenza) {

	
		//io ho n turisti che partono da uno stato
		//t1 va in s2 ec ec ec 
		
		//itero tanti giorni su quante persone
		
		for(int i=0; i<this.numeroGiorni; i++) {
			for(Turista t:turisti){
				//vedo dove posso andare
				List<InfoArco> outgoing = model.getInfoArco(t.getDaCuiArrvo());
				//calcolo la prob di andarci e ci vado
				for(InfoArco ia: outgoing) {
					if(calcolaProb(this.grafo.getEdgeWeight(this.grafo.getEdge(t.getDaCuiArrvo(), ia.getState())), outgoing)>Math.random()) {
						t.setDaCuiArrvo(ia.getState());
						break;
					}
				}
			}
		}
		
		
	
	}
	
	public List<InfoStato> calcolaPersone(int numeroPersone, int numeroGiorni, String partenza, Graph<String, DefaultWeightedEdge> grafo) {
		
		inizializza(numeroPersone, numeroGiorni, partenza, grafo);
		
		for(InfoStato s: this.output) {
			for(Turista t: this.turisti) {
				if(t.getDaCuiArrvo().equals(s.getStato())) {
					int nPersone = s.getnPersone()+1;
					s.setnPersone(nPersone);
				}
			}
		}
		
		return this.output;
		
		
	}

	private double calcolaProb(double edgeWeight, List<InfoArco> outgoing) {
		double tot=0;
		for(InfoArco ia: outgoing){
			tot+=ia.getPeso();
		}
		
		return edgeWeight/tot;
	}
	
	
}
