package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph <String, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private List<String> stati;
	private Simulator sim;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
		stati = dao.loadAllStates();
	}
	
	public List<String> getStati() {
		return stati;
	}

	public void creaGrafo() {

		grafo = new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		
		Graphs.addAllVertices(this.grafo, stati);
		
		for(Arco a: dao.getArchi()) {
			
			/*
			 * if(!this.grafo.containsVertex(a.getState1())){
			 * this.grafo.addVertex(a.getState1()); } else
			 * if(this.grafo.containsVertex(a.getState2())){
			 * this.grafo.addVertex(a.getState2()); }
			 */
			
			DefaultWeightedEdge e = this.grafo.getEdge(a.getState1(), a.getState2());
			
			if(e==null) {
				Graphs.addEdgeWithVertices(this.grafo, a.getState1(), a.getState2(), a.getPeso());
			}
			
		}
		
		System.out.format("#vertici: %d\n#archi: %d", this.grafo.vertexSet().size(), this.grafo.edgeSet().size());
		
	}

	
	public List<InfoArco> getInfoArco(String stato) {
		
		List<InfoArco> output = new ArrayList<>();
		
		for(DefaultWeightedEdge e:this.grafo.outgoingEdgesOf(stato)) {
			output.add(new InfoArco(this.grafo.getEdgeTarget(e), this.grafo.getEdgeWeight(e)));
		}
		
		Collections.sort(output);
		
		return output;
		
	}

	public Graph<String, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}
	
	public List<InfoStato> calcolaPersone(int numeroPersone, int numeroGiorni, String partenza){
		sim = new Simulator();
		return sim.calcolaPersone(numeroPersone, numeroGiorni, partenza, this.grafo);
		
	}

}
