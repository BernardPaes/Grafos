
import java.io.*;

public class GrafoSimples {
    public static void geraGrafo(int vertices, String nomeArquivo) {
        try {
            PrintWriter writer = new PrintWriter(new File(nomeArquivo));

            // Escreve o número de vértices na primeira linha
            writer.println(vertices + " " + (vertices - 1));

            // Para um grafo simples, cada vértice se conecta apenas ao próximo
            for (int i = 1; i < vertices; i++) {
                writer.println(i + " " + (i + 1));
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        geraGrafo(10, "grafo_simples10.txt");
        geraGrafo(100, "grafo_simples100.txt");
        geraGrafo(500, "grafo_simples500.txt");
        geraGrafo(1000, "grafo_simples1000.txt");
    }
}