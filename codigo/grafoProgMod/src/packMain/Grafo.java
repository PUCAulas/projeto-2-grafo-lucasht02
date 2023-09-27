// package PackMain;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.util.HashMap;
// import java.util.Scanner;

// public class Grafo {

//     // Primeiro é a chave, depois o que vai armazenar
//     private HashMap<Integer, Vertice> grafo;
//     private String nome;

//     public Grafo(String nome) {
//         this.grafo = new HashMap<Integer, Vertice>();
//         this.nome = nome;
//     }

//     public Vertice addVertice(int id) {
//         // criando um novo vertice e inserindo ele
//         Vertice novo = new Vertice(id);
//         this.grafo.put(id, novo);
//         return novo;
//     }

//     public void addAresta(int id1, int id2) {
//         // primeiro vou buscar os dois vertices

//         Vertice v1 = grafo.get(id1);
//         Vertice v2 = grafo.get(id2);

//         if (v1 == null)
//             v1 = this.addVertice(id1);

//         if (v2 == null)
//             v2 = this.addVertice(id2);

//         // segundo pegar o primeiro vertice e add aresta para o segundo como direcionado
//         v1.addAresta(v2, true);

//         // terceiro pegar o segundo vertice e add aresta para o primeiro como não
//         // direcionado
//         v2.addAresta(v1, false);
//     }

   

//     public void imprimirVertice(int id) {
//         System.out.println(this.grafo.get(id));
//     }

//     @Override
//     public String toString() {
//         StringBuilder saida = new StringBuilder();
//         saida.append("Grafo: " + this.nome + "\n");
//         for (Vertice v : this.grafo.values())
//             saida.append(v + "\n");
//         return saida.toString();
//     }
// }



package packMain;
import java.util.List;
import java.util.ArrayList;

public class Grafo {
	private List<Vertice> vertice;
	private List<Aresta> aresta;
	
	public Grafo(){
		this.aresta = new ArrayList<Aresta>();
		this.vertice = new ArrayList<Vertice>();
	}
	
	public void addVertice(Vertice vertice) {
		this.vertice.add(vertice);
	}
	public void addAresta(Aresta aresta) {
		this.aresta.add(aresta);
	}

   public 
}
