import java.util.*;

class Vertice {
    String nome;

    Vertice(String nome) {
        this.nome = nome;
    }
}

class Aresta {
    Vertice origem;
    Vertice destino;
    int peso;

    Aresta(Vertice origem, Vertice destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    Grafo(List<Vertice> vertices, List<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    List<Aresta> obterArestasSaindoDe(Vertice vertice) {
        List<Aresta> arestasSaindo = new ArrayList<>();
        for (Aresta aresta : arestas) {
            if (aresta.origem == vertice) {
                arestasSaindo.add(aresta);
            }
        }
        return arestasSaindo;
    }

    boolean isConnected() {
        Set<Vertice> visitado = new HashSet<>();
        Queue<Vertice> fila = new LinkedList<>();
        Vertice primeiroVertice = vertices.get(0);
        fila.add(primeiroVertice);
        visitado.add(primeiroVertice);

        while (!fila.isEmpty()) {
            Vertice vertice = fila.poll();

            for (Aresta aresta : obterArestasSaindoDe(vertice)) {
                Vertice vizinho = aresta.destino;
                if (!visitado.contains(vizinho)) {
                    visitado.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }

        return visitado.size() == vertices.size();
    }

    List<Aresta> encontrarCaminhoEuleriano() {
        List<Aresta> caminho = new ArrayList<>();
        Stack<Vertice> pilha = new Stack<>();
        Vertice verticeAtual = vertices.get(0);
        pilha.push(verticeAtual);

        while (!pilha.isEmpty()) {
            List<Aresta> arestasSaindo = obterArestasSaindoDe(verticeAtual);

            if (!arestasSaindo.isEmpty()) {
                Aresta aresta = arestasSaindo.get(0);
                arestasSaindo.remove(0);
                pilha.push(aresta.destino);
                caminho.add(aresta);
            } else {
                pilha.pop();
                if (!pilha.isEmpty()) {
                    verticeAtual = pilha.peek();
                }
            }
        }

        return caminho;
    }
}

public class Main {
    public static void main(String[] args) {
        Vertice A = new Vertice("A");
        Vertice B = new Vertice("B");
        Vertice C = new Vertice("C");
        Vertice D = new Vertice("D");

        List<Vertice> vertices = Arrays.asList(A, B, C, D);

        Aresta AB = new Aresta(A, B, 10);
        Aresta AC = new Aresta(A, C, 15);
        Aresta BC = new Aresta(B, C, 20);
        Aresta CD = new Aresta(C, D, 25);
        Aresta DA = new Aresta(D, A, 30);

        List<Aresta> arestas = Arrays.asList(AB, AC, BC, CD, DA);

        Grafo grafo = new Grafo(vertices, arestas);

        boolean euleriano = true;
        for (Vertice vertice : vertices) {
            int arestasSaindo = grafo.obterArestasSaindoDe(vertice).size();
            int arestasChegando = 0;
            for (Aresta aresta : arestas) {
                if (aresta.destino == vertice) {
                    arestasChegando++;
                }
            }
            if (arestasSaindo != arestasChegando) {
                euleriano = false;
                break;
            }
        }

        System.out.println("O grafo é euleriano? " + euleriano);

        if (euleriano && grafo.isConnected()) {
            System.out.println("Caminho Euleriano possível");
            List<Aresta> caminho = grafo.encontrarCaminhoEuleriano();
            System.out.println("Caminho Euleriano:");
            for (Aresta aresta : caminho)
