
import java.io.*;

public class GrafoCompleto {
    public static void geraGrafo(int vertices, String nomeArquivo) {
        try {
            PrintWriter writer = new PrintWriter(new File(nomeArquivo));

            // Escreve o número de vértices na primeira linha
            writer.println(vertices + " " + ((vertices*(vertices-1))/2));

            // Para um grafo completo, cada vértice se conecta a todos os outros vértices
            for (int i = 1; i <= vertices; i++) {
                for (int j = i + 1; j <= vertices; j++) {
                    writer.println(i + " " + j);
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        geraGrafo(10, "grafo_completo10.txt");
        geraGrafo(100, "grafo_completo100.txt");
        geraGrafo(500, "grafo_completo500.txt");
        geraGrafo(1000, "grafo_completo1000.txt");
    }
}