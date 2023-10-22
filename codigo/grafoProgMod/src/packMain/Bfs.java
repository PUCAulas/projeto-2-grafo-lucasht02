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

}

