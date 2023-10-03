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
}
