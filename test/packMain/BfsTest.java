package packMain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BfsTest {

    @Test
    public void testExisteCaminho() {
        Grafo grafo = new Grafo();
        Vertice vertice1 = new Vertice("Pedro");
        Vertice vertice2 = new Vertice("Joao");
        Vertice vertice3 = new Vertice("Carlos");
        Aresta aresta1 = new Aresta(vertice1, vertice2, 3);
        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addAresta(aresta1);

        Vertice origem = vertice1;
        Vertice destino = vertice3;

        assertTrue(Bfs.existeCaminho(grafo, origem, destino));
    }

    @Test
    public void testNaoExisteCaminho() {
        Grafo grafo = new Grafo();
        Vertice vertice1 = new Vertice("Pedro");
        Vertice vertice2 = new Vertice("Joao");
        Vertice vertice3 = new Vertice("Carlos");
        Aresta aresta1 = new Aresta(vertice1, vertice2, 3);
        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addAresta(aresta1);

        Vertice origem = vertice2;
        Vertice destino = vertice3;

        assertFalse(Bfs.existeCaminho(grafo, origem, destino));
    }
}
