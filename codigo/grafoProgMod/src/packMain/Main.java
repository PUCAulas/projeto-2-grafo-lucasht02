package packMain;

public class Main {
	public static void main(String[] args) {
		// Crie o grafo e adicione vértices e arestas como antes

		Vertice vertice1 = new Vertice("Pedro");
		Vertice vertice2 = new Vertice("Joao");
		Vertice vertice3 = new Vertice("Carlos");

		Aresta aresta = new Aresta(vertice1, vertice2, 3);

		Grafo grafo = new Grafo();
		grafo.addVertice(vertice1);
		grafo.addVertice(vertice2);
		grafo.addVertice(vertice3);

		grafo.addAresta(aresta);

		// Agora, use a classe BFS para verificar a existência de um caminho entre
		// vértices
		Vertice origem = vertice1;
		Vertice destino = vertice3;

		boolean existeCaminho = Bfs.existeCaminho(grafo, origem, destino);

		if (existeCaminho) {
			System.out.println("Existe um caminho entre " + origem.getNome() + " e " + destino.getNome());
		} else {
			System.out.println("Não existe um caminho entre " + origem.getNome() + " e " + destino.getNome());
		}
	}
}
