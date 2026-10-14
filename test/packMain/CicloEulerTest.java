package packMain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CicloEulerTest {

    @Test
    public void verificaEuleriano() {
        Grafo grafo = new Grafo();
        Vertice vertice1 = new Vertice("Pedro");
        Vertice vertice2 = new Vertice("Joao");
        Vertice vertice3 = new Vertice("Carlos");
        Aresta aresta1 = new Aresta(vertice1, vertice2, 3);
        Aresta aresta2 = new Aresta(vertice2, vertice3, 3); // Adicionando uma nova aresta entre João e Carlos
        Aresta aresta3 = new Aresta(vertice3, vertice1, 3);
        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addAresta(aresta1);
        grafo.addAresta(aresta2); // Adicionando a nova aresta ao grafo
        grafo.addAresta(aresta3);
        assertEquals("Caminho encontrado:\nPedro -> Joao -> Carlos -> Pedro", CicloEuler.verificaEuleriano(grafo));
    }

}
