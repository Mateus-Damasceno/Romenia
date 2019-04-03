package romenia;

public class Vertice {
   private String nomeCidade;
   public boolean visitado;
   int proximoVizinho;
   private int proximo;
   private int dist[];
   private int aux=0;

   public Vertice(String lab, int proximo) {
       this.nomeCidade=lab;
       this.visitado=false;
       this.proximo=proximo;
   }


   public void setDist(int visitadoPor, int flag) {
       dist[flag] = visitadoPor;
       aux++;
   }
   public String getNomeCidade() {
       return nomeCidade;
   }

  
   public int getProximo() {
       return proximo;
   }

   
   public int[] getDist() {
       return dist;
   }

   public int getAux() {
       return aux;
   }
}
