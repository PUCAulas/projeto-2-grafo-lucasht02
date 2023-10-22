package packMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CicloEuler {
    
    private static List<Aresta> encontrarCaminhoEuleriano(Grafo grafo) {
        List<Aresta> caminho = new ArrayList<>();
    Stack<Vertice> pilha = new Stack<>();
    Vertice verticeAtual = grafo.getVertices().get(0);
    pilha.push(verticeAtual);
    int[] indiceArestas = new int[grafo.getVertices().size()]; // Array para rastrear o índice da próxima aresta a ser usada

    while (!pilha.isEmpty()) {
        int verticeAtualIndex = grafo.getVertices().indexOf(verticeAtual);
        List<Aresta> arestasSaindo = grafo.obterArestasSaindoDe(verticeAtual);

        if (indiceArestas[verticeAtualIndex] < arestasSaindo.size()) {
            Aresta aresta = arestasSaindo.get(indiceArestas[verticeAtualIndex]);
            indiceArestas[verticeAtualIndex]++;
            pilha.push(aresta.getDestino());
            caminho.add(aresta);
            verticeAtual = aresta.getDestino();
        } else {
            pilha.pop();
            if (!pilha.isEmpty()) {
                verticeAtual = pilha.peek();
            }
        }
}

return caminho;

    }
    


    public static String verificaEuleriano(Grafo grafo){
        boolean euleriano = true;
        for (Vertice vertice : grafo.getVertices()) {
            int arestasSaindo = grafo.obterArestasSaindoDe(vertice).size();
            int arestasChegando = 0;
            for (Aresta aresta : grafo.getArestas()) {
                if (aresta.getDestino() == vertice) {
                    arestasChegando++;
                }
            }
            if (arestasSaindo != arestasChegando) {
                euleriano = false;
                break;
            }
        }

       StringBuilder caminhoString = new StringBuilder();
        if (euleriano && grafo.isConnected()) {
             
            List<Aresta> caminho = encontrarCaminhoEuleriano(grafo);
            
            caminhoString.append("Caminho encontrado:\n");
            caminhoString.append(caminho.get(0).getOrigem().getNome()+" -> ");
            for (Aresta aresta : caminho)
                caminhoString.append(aresta.getDestino().getNome()+" -> ");
            caminhoString.delete(caminhoString.length() - 4, caminhoString.length()); // Remove a última seta " -> ".
            return caminhoString.toString();
            
            
        }
        caminhoString.append("Nao eh possivel encontrar um ciclo euleriano!");
        return caminhoString.toString();
    }
}
