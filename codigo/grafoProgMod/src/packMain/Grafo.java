
package packMain;

import java.util.List;
import java.util.ArrayList;

public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;

	public Grafo() {
		this.arestas = new ArrayList<>();
		this.vertices = new ArrayList<>();
	}

	public void addVertice(Vertice vertice) {
		this.vertices.add(vertice);
	}
	
	public void addAresta(Aresta aresta) {
		this.arestas.add(aresta);
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public Vertice verificarSeVerticeJaExiste(String cidadeVertice) {
		for(Vertice verticeJaExistente : this.vertices) {
			if(verticeJaExistente.getNome().equals(cidadeVertice))
				return verticeJaExistente;
		}
		return null;
			
	}
}
