package projeto2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BfsTest {

    private Grafo grafo;
    private Vertice verticeA;
    private Vertice verticeB;
    private Vertice verticeC;
    private Vertice verticeD;

    @Before
    public void setUp() {
        grafo = new Grafo();
        verticeA = new Vertice("A");
        verticeB = new Vertice("B");
        verticeC = new Vertice("C");
        verticeD = new Vertice("D");

        // Adicione arestas ao grafo
        grafo.adicionarAresta(new Aresta(verticeA, verticeB));
        grafo.adicionarAresta(new Aresta(verticeB, verticeC));
        grafo.adicionarAresta(new Aresta(verticeC, verticeD));
    }

    @Test
    public void testExisteCaminhoCaminhoExiste() {
        assertTrue(Bfs.existeCaminho(grafo, verticeA, verticeD));
    }

    @Test
    public void testExisteCaminhoCaminhoNaoExiste() {
        assertFalse(Bfs.existeCaminho(grafo, verticeA, verticeC));
    }
}
