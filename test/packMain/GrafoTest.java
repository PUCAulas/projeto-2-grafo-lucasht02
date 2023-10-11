package packMain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {

    @Test
    public void testAddVertice() {
        Grafo grafo = new Grafo();
        Vertice vertice1 = new Vertice("Pedro");
        grafo.addVertice(vertice1);

        assertEquals(1, grafo.getVertices().size());
        assertTrue(grafo.getVertices().contains(vertice1));
    }

    @Test
    public void testAddAresta() {
        Grafo grafo = new Grafo();
        Vertice vertice1 = new Vertice("Pedro");
        Vertice vertice2 = new Vertice("Lucas");
        Aresta aresta = new Aresta(vertice1, vertice2, 3);
        grafo.addAresta(aresta);

        assertEquals(1, grafo.getArestas().size());
        assertTrue(grafo.getArestas().contains(aresta));
    }
}
