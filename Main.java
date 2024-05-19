import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// Fonte: https://www.geeksforgeeks.org/find-edge-disjoint-paths-two-vertices/
public class Main{    
    public static void main(String [] args){
        // Objetos e variáveis
        Scanner sc = new Scanner(System.in);
        String nomeArquivo = "";
        
        // Ler nome do arquivo e o número de vértices 
        System.out.println("Digite o nome do arquivo que deseja ler as informações");
        nomeArquivo = sc.nextLine();
        if(nomeArquivo.isBlank()){
            System.out.print("Nome inválido\nDigite novamente: ");
            nomeArquivo = sc.nextLine();
        }

        
        CaminhosDisjuntos caminhos = new CaminhosDisjuntos();
        
        long inicio = System.currentTimeMillis();
        caminhos.Iniciar(nomeArquivo);
        long fim = System.currentTimeMillis();
        System.out.println("Execução: " + (fim - inicio) + "ms");
        sc.close();
    }   

        
       
}