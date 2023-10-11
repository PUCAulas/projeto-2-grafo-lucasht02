package packMain;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Crie o grafo e adicione vértices e arestas como antes
		
		Vertice vertice1 = new Vertice("Pedro");
		Vertice vertice2 = new Vertice("Joao");
		Vertice vertice3 = new Vertice("Carlos");
		
		Aresta aresta1 = new Aresta(vertice1, vertice2, 3);
		Aresta aresta2 = new Aresta(vertice2, vertice3, 3);
		Aresta aresta3 = new Aresta(vertice3, vertice1, 3);
		
		Grafo grafo = new Grafo();
		grafo.addVertice(vertice1);
		grafo.addVertice(vertice2);
		grafo.addVertice(vertice3);

		grafo.addAresta(aresta1);
		grafo.addAresta(aresta2);
		grafo.addAresta(aresta3);

		// Agora, use a classe BFS para verificar a existência de um caminho entre
		// vértices
		Vertice origem = vertice1;
		Vertice destino = vertice3;

		boolean existeCaminho = Bfs.existeCaminho(grafo, origem, destino);

		List<Vertice> cidadesInalcancaveis = Bfs.cidadesInalcancaveis(grafo);

		if (cidadesInalcancaveis.isEmpty()) {
			System.out.println("Todas cidades são alcançáveis");
		} else {
			for (int i = 0; i < cidadesInalcancaveis.size(); i++) {
				System.out.println(cidadesInalcancaveis.get(i).getNome());
			}
		}
		if (existeCaminho) {
			System.out.println("Existe um caminho entre " + origem.getNome() + " e " + destino.getNome());
		} else {
			System.out.println("Não existe um caminho entre " + origem.getNome() + " e " + destino.getNome());
		}
	}
}
