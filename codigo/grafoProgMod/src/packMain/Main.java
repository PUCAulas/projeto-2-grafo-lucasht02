package packMain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcaoSelecionda = 999;

		Grafo grafo = new Grafo();

		Vertice vertice = new Vertice("Pedro");
		Vertice vertice2 = new Vertice("Joao");

		Aresta aresta = new Aresta(0, 1, 3);

		System.out.println("----------------------");
		System.out.println("Selecione a opcao que deseja: ");
		System.out.println(" 1 - Adicionar vertice\n 2 - Adicinar arestas \n 3 - Imprimir Grafo");
		System.out.println("----------------------");

		opcaoSelecionda = input.nextInt();
		while (opcaoSelecionda != 0) {
			switch (opcaoSelecionda) {
				case 1:
					grafo.addVertice(vertice);
					grafo.addVertice(vertice2);

					break;

				case 2:
					grafo.addAresta(aresta);
					break;

				case 3:
					grafo.imprimirArestas();
					break;

			}
		}
	}

}
