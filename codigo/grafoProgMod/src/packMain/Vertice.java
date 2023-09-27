// package PackMain;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.stream.Collectors;

// public class Vertice {

//     // criando atributos
//     private final Integer id;

//     // criando a lista de arestas
//     private List<Aresta> arestas;

//     public Vertice(int id) {
//         this.id = id;

//         // criando a lista para a aresta
//         this.arestas = new LinkedList<>();
//     }

//     // criando uma aresta e inserindo ela
//     public void addAresta(Vertice vertice, boolean direcao) {
//         this.arestas.add(new Aresta(vertice, direcao));
//     }

//     public void imprimeArestas(){
        
//     }
// }


package packMain;

public class Vertice {
  private static idProximo = 0;
	private int id;
	private String nome;

    public Vertice(String nome){
        this.setNome(nome);
        this.setId();
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = idProximo;
       this.idProximo++;
	}
}
