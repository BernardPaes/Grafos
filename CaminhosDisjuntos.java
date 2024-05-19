import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// https://www.geeksforgeeks.org/find-edge-disjoint-paths-two-vertices/
public class CaminhosDisjuntos {
    static int V; // Quantidade de vértices

    // Encontra caminho aumentante
    static boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    q.add(v);
                    visited[v] = true;
                    parent[v] = u;
                }
            }
        }

        return visited[t];
    }
    static int findDisjointPaths(int graph[][], int s, int t) {
        int rGraph[][] = new int[V][V];
        for (int u = 0; u < V; u++)
            for (int v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];
        int max_flow = 0;
        List<List<Integer>> caminhos = new ArrayList<>();


        while (bfs(rGraph, s, t, parent)) {
            // Encontra fluxo máximo através do caminho encontrado
            List<Integer> path = new ArrayList<>();
            int path_flow = Integer.MAX_VALUE;

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
                path.add(0, v);
            }
            path.add(0, s);
            caminhos.add(path);

            // Reduz as capacidades residuais e atualiza as capacidades correspondentes
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            max_flow += path_flow;
        }

        mostrarCaminhos(caminhos);
        return max_flow;
    }

    public static void mostrarCaminhos(List<List<Integer>> caminhos){
        for(List<Integer> caminho : caminhos){
            for(int i : caminho){
                System.out.print("(" + i + ") ");
            }
            System.out.println();
        }
    }
    public void Iniciar(String nomeArquivo){
         try {
            // Variáveis 
            int i = 0, quantArestas = 0, quantVertices = 0;
            int inicio = 0, fim = 0;
            // Abre o arquivo 
            File arquivo = new File(nomeArquivo);
            Scanner sc = new Scanner(arquivo);

            // Lê quais vértices serão a raiz e o destino da busca
            inicio = sc.nextInt();
            fim = sc.nextInt();

            // Lê a quantidade de vertices e arestas necessárias
            quantVertices = sc.nextInt();
            V = quantVertices;
            quantArestas = sc.nextInt();
            System.out.println(quantArestas);
            int grafo[][] = new int[quantVertices + 1][quantVertices + 1];;

            // Preenche a matriz grafo
            for(i = 0; i < quantArestas; i++){
                int origem = sc.nextInt();
                int destino = sc.nextInt();
                grafo[origem][destino] = 1;
            }
    

            // Busca pelo caminhos disjuntos e os imprime na tela
            System.out.println("Quantidade de caminhos disjuntos encontrados: " + findDisjointPaths(grafo, inicio, fim) + "\n Origem: " + inicio + " Destino: " + fim);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
