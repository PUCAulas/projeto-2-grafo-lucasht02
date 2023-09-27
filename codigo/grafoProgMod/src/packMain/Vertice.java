import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertice {

    // criando atributos
    private final Integer id;

    // criando a lista de arestas
    private List<Aresta> arestas;

    public Vertice(int id) {
        this.id = id;

        // criando a lista para a aresta
        this.arestas = new LinkedList<>();
    }

    // criando uma aresta e inserindo ela
    public void addAresta(Vertice vertice, boolean direcao) {
        this.arestas.add(new Aresta(vertice, direcao));
    }

    @Override
    public String toString() {
        return "Vertice: " + this.id + "(i) grau de saída: "
                + this.arestas.stream().filter(aresta -> aresta.direcao()).count()
                + "(ii) grau de entrada: "
                + this.arestas.stream().filter(aresta -> !aresta.direcao()).count()
                + "(iii) conjunto de sucessores: "
                + this.arestas.stream()
                        .filter(aresta -> aresta.direcao())
                        .map(aresta -> aresta.vertice().id.toString())
                        .collect(Collectors.joining(", "))
                + "(iv) conjunto de predecessores: "
                + this.arestas.stream()
                        .filter(aresta -> !aresta.direcao())
                        .map(aresta -> aresta.vertice().id.toString())
                        .collect(Collectors.joining(", "));
    }
}


// package packMain;

// public class Vertice {
// 	private int id;
// 	private String nome;
	
// 	public String getNome() {
// 		return nome;
// 	}
// 	public void setNome(String nome) {
// 		this.nome = nome;
// 	}
	
// 	public int getId() {
// 		return id;
// 	}
// 	public void setId(int id) {
// 		this.id = id;
// 	}
// }
