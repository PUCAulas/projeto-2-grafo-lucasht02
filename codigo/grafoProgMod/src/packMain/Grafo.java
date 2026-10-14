
package packMain;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private Vertice vertice;

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

	public Vertice getVertice(String nomeVertice) {
		
		return vertice;
	}

	public Vertice verificarSeVerticeJaExiste(String cidadeVertice) {
		for(Vertice verticeJaExistente : this.vertices) {
			if(verticeJaExistente.getNome().equals(cidadeVertice))
				return verticeJaExistente;
		}
		return null;
			
	}

	public List<Aresta> obterArestasSaindoDe(Vertice vertice) {
        List<Aresta> arestasSaindo = new ArrayList<>();
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem() == vertice) {
                arestasSaindo.add(aresta);
            }
        }
        return arestasSaindo;
    }

	public boolean isConnected() {
        Set<Vertice> visitado = new HashSet<>();
        Queue<Vertice> fila = new LinkedList<>();
        Vertice primeiroVertice = vertices.get(0);
        fila.add(primeiroVertice);
        visitado.add(primeiroVertice);

        while (!fila.isEmpty()) {
            Vertice vertice = fila.poll();

            for (Aresta aresta : obterArestasSaindoDe(vertice)) {
                Vertice vizinho = aresta.getDestino();
                if (!visitado.contains(vizinho)) {
                    visitado.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }

        return visitado.size() == vertices.size();
    }
}
