package PackMain;
public class Aresta {

    private Vertice vertice; // guardando o vertice e mostrando para onde esta apontando

    private boolean direcao;

    public Aresta(Vertice vertice, boolean direcao) {
        this.vertice = vertice;
        this.direcao = direcao;
    }

    public boolean direcao() {
        return this.direcao;
    }

    public Vertice vertice() {
        return this.vertice;
    }

}

// package packMain;

// public class Aresta {
// 	private int idOrigem;
// 	private int idDestino;
// 	private int peso;
	
// 	public int getIdOrigem() {
// 		return idOrigem;
// 	}
// 	public void setIdOrigem(int idOrigem) {
// 		this.idOrigem = idOrigem;
// 	}
// 	public int getIdDestino() {
// 		return idDestino;
// 	}
// 	public void setIdDestino(int idDestino) {
// 		this.idDestino = idDestino;
// 	}
// 	public int getPeso() {
// 		return peso;
// 	}
// 	public void setPeso(int peso) {
// 		this.peso = peso;
// 	}
	
	
// }
