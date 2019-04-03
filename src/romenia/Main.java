package romenia;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static Mapa novoMapa = new Mapa();

    public static void mostraMapa() {
        novoMapa.addVertice("Neamt", 0);
        novoMapa.addVertice("Oradea", 1);
        novoMapa.addVertice("Zerind", 2);
        novoMapa.addVertice("Arad", 3);
        novoMapa.addVertice("Timisoara", 4);
        novoMapa.addVertice("Lugoj", 5);
        novoMapa.addVertice("Mehadia", 6);
        novoMapa.addVertice("Drobeta", 7);
        novoMapa.addVertice("Craiova", 8);
        novoMapa.addVertice("Sibiu", 9);
        novoMapa.addVertice("Rimnicu Vilcea", 10);
        novoMapa.addVertice("Fagaras", 11);
        novoMapa.addVertice("Pitesti", 12);
        novoMapa.addVertice("Bucharest", 13);
        novoMapa.addVertice("Glurgiu", 14);
        novoMapa.addVertice("Urziceni", 15);
        novoMapa.addVertice("Vaslui", 16);
        novoMapa.addVertice("Hisrova", 17);
        novoMapa.addVertice("Eforie", 18);
        novoMapa.addVertice("Iasi", 19);

        novoMapa.addBorda(1, 2, 71);
        novoMapa.addBorda(2, 3, 75);
        novoMapa.addBorda(1, 9, 151);
        novoMapa.addBorda(3, 9, 140);
        novoMapa.addBorda(3, 4, 118);
        novoMapa.addBorda(4, 5, 111);
        novoMapa.addBorda(5, 6, 70);
        novoMapa.addBorda(6, 7, 75);
        novoMapa.addBorda(7, 8, 120);
        novoMapa.addBorda(8, 10, 146);
        novoMapa.addBorda(8, 12, 138);
        novoMapa.addBorda(12, 10, 97);
        novoMapa.addBorda(10, 9, 80);
        novoMapa.addBorda(9, 11, 99);
        novoMapa.addBorda(11, 13, 211);
        novoMapa.addBorda(13, 12, 101);
        novoMapa.addBorda(13, 14, 90);
        novoMapa.addBorda(13, 15, 85);
        novoMapa.addBorda(15, 17, 98);
        novoMapa.addBorda(17, 18, 86);
        novoMapa.addBorda(15, 16, 142);
        novoMapa.addBorda(16, 19, 92);
        novoMapa.addBorda(19, 0, 87);
                
    }
    public static void printCidade() {
        System.out.println("1. Oradea ");
        System.out.println("2. Zerind");
        System.out.println("3. Arad");
        System.out.println("4. Timisoara");
        System.out.println("5. Lugoj");
        System.out.println("6. Mehadia");
        System.out.println("7. Drobeta");
        System.out.println("8. Craiova");
        System.out.println("9. Sibiu");
        System.out.println("10. Rimnicu Vilcea");
        System.out.println("11. Fagaras");
        System.out.println("12. Pitesti");
        System.out.println("13. Bucharest");
        System.out.println("14. Glurgiu");
        System.out.println("15. Urziceni");
        System.out.println("16. Vaslui");
        System.out.println("17. Hisrova");
        System.out.println("18. Eforie");
        System.out.println("19. Iasi");
        System.out.println("20. Neamt");
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("problema da Romenia\n");
        System.out.println("Lista de cidade: ");
        printCidade();
        mostraMapa();
        String inicio="", destino=""; 
        int escolha;
        boolean status=false;
        while(status==false) {
            System.out.print("digite o nome da cidade de inicio: ");
            inicio =input.readLine();
            System.out.print("digite o destino da cidade destino: ");
            destino = input.readLine();
            System.out.print("1. largura \n");
            System.out.print("2. custo uniforme \n");
            System.out.print("3. profundidade \n");
            System.out.print("4. A* \n");
            System.out.print("5. sair");

            String a, b;
            escolha = Integer.parseInt(input.readLine());
            if(escolha==0) {
            }
            else if(escolha==1) {
            	novoMapa.bfs(novoMapa.procuraVertice(inicio), novoMapa.procuraVertice(destino));
            }
            else if(escolha==2) {
            	novoMapa.profundidadeIterativa(novoMapa.procuraVertice(inicio), novoMapa.procuraVertice(destino));
            }
            else if(escolha==3) {
            	novoMapa.dfs(novoMapa.procuraVertice(inicio), novoMapa.procuraVertice(destino));
            }
            else if(escolha==4) {
                novoMapa.aEstrela(novoMapa.procuraVertice(inicio), novoMapa.procuraVertice(destino));
            }
            else if(escolha==5) {
                status=false;
                break;
            }
            else {
            }
        }
    }

    
}