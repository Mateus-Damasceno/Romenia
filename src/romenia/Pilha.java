package romenia;

public class Pilha {

	private final int TAMANHO = 30;
	   private int[] empilha;
	   private int topo;


	   public Pilha() {
	      empilha = new int[TAMANHO];    
	      topo = -1;
	   }

	   public void push(int j){
		   empilha[++topo] = j;
	   }

	   public int pop(){
		   return empilha[topo--]; 
	   }

	   public int peek(){
		   return empilha[topo]; 
	   }

	   public boolean isEmpty(){
		   return (topo == -1); 
	   }

	   public void removeAllStack() {
	       topo = -1;
	   }
}
