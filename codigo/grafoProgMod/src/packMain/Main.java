package packMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		// lendo arquivo para criar o grafo
		try {
			File arquivo = new File("codigo/grafoProgMod/src/paises.txt"); // nome do arquivo
			Scanner scanner = new Scanner(arquivo);

			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				// processando cada linha, criando vertices, arestas e inserindo no grafo
				processarLinha(linha, grafo);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Vertices");
		for (Vertice i : grafo.getVertices()) {
			System.out.println(i.getNome());
		}
		System.out.println("\nArestas");
		for (Aresta i : grafo.getArestas()) {
			System.out.println("Origem: " + i.getOrigem().getNome() + ", Destino: " + i.getDestino().getNome());
		}

		Vertice rodoviaria = grafo.getVertices().get(0);

		List<Vertice> rotaMaisCurta = encontrarRotaMaisCurta(grafo, rodoviaria);

		if (!rotaMaisCurta.isEmpty()) {
			System.out.println("Recomendação de rota mais curta:");
			for (Vertice vertice : rotaMaisCurta) {
				System.out.println(vertice.getNome());
			}
		} else {
			System.out.println("Não foi possível encontrar uma rota mais curta.");
		}
	}

	// Crie o grafo e adicione vértices e arestas como antes
	/*
	 * Vertice vertice1 = new Vertice("Pedro");
	 * Vertice vertice2 = new Vertice("Joao");
	 * Vertice vertice3 = new Vertice("Carlos");
	 * 
	 * Aresta aresta1 = new Aresta(vertice1, vertice2, 3);
	 * Aresta aresta2 = new Aresta(vertice2, vertice3, 3);
	 * Aresta aresta3 = new Aresta(vertice3, vertice1, 3);
	 * 
	 * Grafo grafo = new Grafo();
	 * grafo.addVertice(vertice1);
	 * grafo.addVertice(vertice2);
	 * grafo.addVertice(vertice3);
	 * 
	 * grafo.addAresta(aresta1);
	 * grafo.addAresta(aresta2);
	 * grafo.addAresta(aresta3);
	 * 
	 * // Agora, use a classe BFS para verificar a existência de um caminho entre
	 * // vértices
	 * Vertice origem = vertice1;
	 * Vertice destino = vertice3;
	 * 
	 * boolean existeCaminho = Bfs.existeCaminho(grafo, origem, destino);
	 * 
	 * List<Vertice> cidadesInalcancaveis = Bfs.cidadesInalcancaveis(grafo);
	 * System.out.println(Bfs.percorrerGrafo(grafo));
	 * 
	 * if (cidadesInalcancaveis.isEmpty()) {
	 * System.out.println("Todas cidades sao alcancaveis");
	 * } else {
	 * for (int i = 0; i < cidadesInalcancaveis.size(); i++) {
	 * System.out.println(cidadesInalcancaveis.get(i).getNome());
	 * }
	 * }
	 * if (existeCaminho) {
	 * System.out.println("Existe um caminho entre " + origem.getNome() + " e " +
	 * destino.getNome());
	 * } else {
	 * System.out.println("Não existe um caminho entre " + origem.getNome() + " e "
	 * + destino.getNome());
	 * }
	 */

	public static void processarLinha(String linha, Grafo grafo) {
		Pattern pattern = Pattern.compile("(.+?): (.+)");
		Matcher matcher = pattern.matcher(linha);

		if (matcher.find()) {
			String cidadeInicial = matcher.group(1);// origem
			// inserindo vertice no grafo
			Vertice origemDaLinha = new Vertice(cidadeInicial);
			Vertice verticeJaExistente = grafo.verificarSeVerticeJaExiste(cidadeInicial);
			if (verticeJaExistente == null)
				grafo.addVertice(origemDaLinha);
			else
				origemDaLinha = verticeJaExistente;

			String cidadesSubsequentes = matcher.group(2);// destinos

			// Divide as cidades subsequentes com base na vírgula
			String[] cidadesArray = cidadesSubsequentes.split(", ");

			// Processa cada cidade subsequente
			for (String cidadeInfo : cidadesArray) {
				// separando informacoes da cidade
				Pattern cidadePattern = Pattern.compile("(.+?) \\((\\d+)\\)");
				Matcher cidadeMatcher = cidadePattern.matcher(cidadeInfo);

				if (cidadeMatcher.find()) {
					String cidade = cidadeMatcher.group(1);
					int numero = Integer.parseInt(cidadeMatcher.group(2));
					Vertice origemJaExistente = grafo.verificarSeVerticeJaExiste(cidade);
					if (origemJaExistente == null) {
						Vertice destinoDaLinha = new Vertice(cidade);
						grafo.addVertice(destinoDaLinha);
						Aresta novaAresta = new Aresta(origemDaLinha, destinoDaLinha, numero);
						grafo.addAresta(novaAresta);
					} else {
						Aresta novaAresta = new Aresta(origemDaLinha, origemJaExistente, numero);
						grafo.addAresta(novaAresta);
					}

				}
			}
		}
	}

	public static Vertice encontrarRodoviaria(Grafo grafo) {
		// Percorra todos os vértices e encontre a rodoviária
		for (Vertice vertice : grafo.getVertices()) {
			if (vertice.getNome().equalsIgnoreCase("Rodoviaria")) {
				return vertice;
			}
		}
		return null; // Não encontrou a rodoviária no grafo
	}

	public static List<Vertice> encontrarRotaMaisCurta(Grafo grafo, Vertice origem) {
		Map<Vertice, Integer> distancias = new HashMap<>();
		Map<Vertice, Vertice> predecessores = new HashMap<>();
		Set<Vertice> visitados = new HashSet<>();
		PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

		// Inicialize as distâncias com um valor alto e a origem com distância zero.
		for (Vertice vertice : grafo.getVertices()) {
			distancias.put(vertice, Integer.MAX_VALUE);
		}
		distancias.put(origem, 0);
		filaPrioridade.add(origem);

		while (!filaPrioridade.isEmpty()) {
			Vertice vertice = filaPrioridade.poll();

			if (visitados.contains(vertice)) {
				continue;
			}

			visitados.add(vertice);

			for (Aresta aresta : grafo.getArestas()) {
				if (aresta.getOrigem() == vertice) {
					Vertice vizinho = aresta.getDestino();
					int novaDistancia = distancias.get(vertice) + aresta.getPeso();

					if (novaDistancia < distancias.get(vizinho)) {
						distancias.put(vizinho, novaDistancia);
						predecessores.put(vizinho, vertice);
						filaPrioridade.add(vizinho);
					}
				}
			}
		}

		// Construa a rota mais curta a partir dos predecessores
		List<Vertice> rotaMaisCurta = new ArrayList<>();
		Vertice atual = grafo.getVertices().get(0); // Comece a partir da rodoviária
		while (atual != null) {
			rotaMaisCurta.add(atual);
			atual = predecessores.get(atual);
		}

		Collections.reverse(rotaMaisCurta);
		return rotaMaisCurta;
	}

}
