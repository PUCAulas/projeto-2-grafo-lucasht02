package packMain;

import java.util.*;

public class Bfs {
    public static boolean existeCaminho(Grafo grafo, Vertice origem, Vertice destino) {
        Queue<Vertice> fila = new LinkedList<>();
        Set<Vertice> visitados = new HashSet<>();

        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            if (atual == destino) {
                return true;
            }

            for (Aresta aresta : grafo.getArestas()) {
                if (aresta.getOrigem() == atual && !visitados.contains(aresta.getDestino())) {
                    fila.add(aresta.getDestino());
                    visitados.add(aresta.getDestino());
                }
            }
        } 

        return false;
    }

    public static List<Vertice> cidadesInalcancaveis(Grafo grafo) {
        List<Vertice> cidadesInalcancaveis = new ArrayList<>();
        for (Vertice destino : grafo.getVertices()) {
            boolean alcancaDestino = false;
            for (Vertice origem : grafo.getVertices()) {
                if (origem != destino && existeCaminho(grafo, origem, destino)) {
                    alcancaDestino = true;
                    break;
                }
            }
            if (!alcancaDestino) {
                cidadesInalcancaveis.add(destino);
            }
        }
        return cidadesInalcancaveis;
    }

    public static String percorrerGrafo(Grafo grafo) {
        List<Vertice> vertices = grafo.getVertices();
        Map<Vertice, Boolean> visitados = new HashMap<>();
        for (Vertice vertice : vertices) {
            visitados.put(vertice, false);
        }

        List<String> caminho = new ArrayList<>();
        Vertice inicio = vertices.get(0); // Comece a partir de um vértice inicial (pode ser qualquer um).

        if (percorrerDFS(grafo, inicio, visitados, caminho)) {
            // Verificou-se que é possível percorrer todos os vértices e arestas.
            StringBuilder caminhoString = new StringBuilder();
            for (String passo : caminho) {
                caminhoString.append(passo).append(" -> ");
            }
            caminhoString.delete(caminhoString.length() - 4, caminhoString.length()); // Remove a última seta " -> ".
            return caminhoString.toString();
        } else {
            return "Não é possível percorrer todos os vértices e arestas em um único passeio.";
        }
    }

    private static boolean percorrerDFS(Grafo grafo, Vertice vertice, Map<Vertice, Boolean> visitados, List<String> caminho) {
        List<Vertice> vertices = grafo.getVertices();
        List<Aresta> arestas = grafo.getArestas();
        visitados.put(vertice, true);
        caminho.add(vertice.getNome());

        for (Aresta aresta : arestas) {
            if (aresta.getOrigem() == vertice && !visitados.get(aresta.getDestino())) {
                if (percorrerDFS(grafo, aresta.getDestino(), visitados, caminho)) {
                    return true;
                }
            }
        }

        // Verifica se todos os vértices foram visitados.
        for (Vertice v : vertices) {
            if (!visitados.get(v)) {
                return false;
            }
        }

        return true;
    }
}

