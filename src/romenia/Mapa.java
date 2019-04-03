package romenia;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

	private final int MAX_VERTICE = 20;
	private Vertice verticeLista[];
	private int adjMatriz[][];
	private int nVertice;
	private Fila nFila;
	private Fila temp;
	private Pilha pilha;
	private int totalProfundidade;
	private int totalLargura;
	private int distancia[];
	private boolean encontrar;
	private boolean chamar;
	private boolean estado[]= new boolean[MAX_VERTICE];
	private Fila fechado = new Fila();
	
	public Mapa() {
		verticeLista = new Vertice[MAX_VERTICE];
		adjMatriz = new int [MAX_VERTICE][MAX_VERTICE];
		distancia = new int [MAX_VERTICE];
		nVertice = 0;
		for (int i = 0; i < MAX_VERTICE; i++) {
			for (int j = 0; j < MAX_VERTICE; j++) {
				adjMatriz[i][j]=0;
			}
		}
		
		for(int j=0; j <MAX_VERTICE;j++) {
			distancia[j]=1000000;
		}
		nFila= new Fila();
		pilha = new Pilha();
	}
	
	public void addVertice(String nomeCidade, int proximo) {
		verticeLista[nVertice++]=new Vertice(nomeCidade, proximo);
	}
	
	public void addBorda (int inicio, int fim, int custo) {
		adjMatriz[inicio][fim]= custo;
		adjMatriz[fim][inicio]=custo;
	}
	
	public void mostraVertice(int v) {
		System.out.print(verticeLista[v].getNomeCidade() + " ");
	}
	
	  public int procuraVertice(String nome) {
	        for(int j=0; j<nVertice; j++) {
	            if (verticeLista[j].getNomeCidade().equalsIgnoreCase(nome)) {
	                return verticeLista[j].getProximo();
	            }
	          }
	        return -1;
	    }
	  
	    public int getAdjUnvisitedVerticeLargura(int v){
	        for(int j=0; j<nVertice; j++)
	            if(adjMatriz[v][j]!=0 && verticeLista[j].visitado==false){
	                System.out.println(" " + getCusto(v, j) + " ");
	                totalLargura += getCusto(v, j);
	                return j;
	            }
	        return -1;
	    }

	   public int getAdjUnvisitedVerticeProfundiade(int v){
	        for(int j=0; j<nVertice; j++) {
	            if(adjMatriz[v][j] !=0 && verticeLista[j].visitado==false) {
	                System.out.println(" " +getCusto(v, j) + " ");
	                totalProfundidade += getCusto(v, j);
	                return j;
	            }
	        }
	        return -1;
	    }

	    public int getCusto(int x, int y) {
	        return adjMatriz[x][y];
	    }

	    public void mostra() {
	        System.out.println();

	        System.out.println("Adj. Matriz");
	        for (int i=0; i<nVertice; i++) {
	            for (int j=0; j<nVertice; j++) {
	                System.out.println(adjMatriz[i][j] +" ");

	            }
	            System.out.println();
	        }
	        System.out.println();

	    }

	    public int finalBorda(int fim) {
	        int aux=0;
	        for(int i=0; i<nVertice; i++) {

	                if(adjMatriz[fim][i] != 0) {
	                    aux++;
	            }
	        }
	        return aux;

	    }

	    public void DLS(int node, int destino, int profundidade) {

	        boolean[] visitado = new boolean[MAX_VERTICE];
	        for(int i=0; i<MAX_VERTICE; i++) {
	            visitado[i] = false;
	            pilha.push(node);
	        }
	        int v2 = nFila.remove();
	        while((v2 = getAdjUnvisitedVerticeLargura(node)) != -1) {

	            profundidade--;
	            if(v2==destino) {
	                fechado.insere(v2);
	               encontrar=true;

	            }

	            else if (visitado[v2] == false) {
	                visitado[v2]=true;
	                temp.insere(v2);

	                for(int i=0; i<temp.getTAMANHO(); i++) {
	                    if(visitado[i]==false) {
	                        pilha.push(i);
	                    }
	                }

	                fechado.insere(v2);
	            }


	            if(encontrar) {
	                String caminho = "Rota: ";
	                int enter=0;
	                for(int i=0; i<fechado.getTAMANHO(); i++) {
	                    caminho = caminho + " " + fechado.remove();
	                    enter++;
	                    if((enter %5) == 0)
	                        caminho = caminho + "\n";
	                }

	                System.out.println(caminho);
	            }
	        }
	    }
	    public void profundidadeIterativa(int cabeca, int cauda) {
	        int profundidade = 0;
	        encontrar = false;
	        DLS(cabeca, cauda, profundidade);

	        while (true) {
	            if (encontrar) break;
	            else{
	                profundidade++;
	               DLS(cabeca, cauda, profundidade);
	            }
	        }
	        System.out.println("profundidade iterativa: " + String.valueOf(profundidade));
	    }

		  public void aEstrela (int cabeca, int cauda) {
			  List <Vertice> lista = new ArrayList<Vertice>();
			  estado[cabeca]=true;
			
		  }
	    public void bfs(int cabeca, int cauda) {

	        verticeLista[cabeca].visitado = true;
	        mostraVertice(cabeca);
	        nFila.insere(cabeca);
	        int v2;
	        while( !nFila.isEmpty())
	        {
	         int v1 = nFila.remove();

	         while((v2 = getAdjUnvisitedVerticeLargura(v1)) != -1)
	            {
	            verticeLista[v2].visitado = true;

	            mostraVertice(v2);
	            nFila.insere(v2);

	            if(v2==cauda) {
	            
	                nFila.removeTudo();
	            }
	         }


	    }
	        for(int j=0; j<nVertice; j++)
	         verticeLista[j].visitado = false;

	      int y = nFila.getTAMANHO();
	      System.out.println();

	      System.out.println("total custo Largura: " + totalLargura );
	    }

	     public void dfs(int inicio, int fim){

	         try {
	            verticeLista[inicio].visitado=true;
	            mostraVertice(inicio);
	            pilha.push(inicio);
	            while (!pilha.isEmpty()){

	                int v=getAdjUnvisitedVerticeProfundiade(pilha.peek());
	                if (v==-1)
	                    pilha.pop();
	                else {
	                    verticeLista[v].visitado=true;
	                    mostraVertice(v);
	                    pilha.push(v);
	                }

	                if(v==fim) {
	                   pilha.removeAllStack();
	                    System.out.println(" " + fim);
	                }

	            }

	            for(int j=0;j<nVertice;j++)
	                    verticeLista[j].visitado=false;

	           System.out.println();

	           System.out.print("total custo DFS: " + totalProfundidade);

	         }
	         catch (Exception x) {
	            System.out.println("Cidade nao Existe");
	         }
	    }
}
