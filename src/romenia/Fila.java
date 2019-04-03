package romenia;

public class Fila {

	private int TAMANHO = 30;
	   private int[] filaArray;
	   private int cabeca;
	   private int cauda;

	   public Fila()           
	      {
	      filaArray = new int[TAMANHO];
	      cabeca = 0;
	      cauda = -1;
	      }

	   public void insere(int j) 
	      {
	      if(getCauda() == getTAMANHO()-1)
	         setCauda(-1);
	        getFilaArray()[++cauda] = j;
	      }

	   public int remove()       
	      {
	      int temp = getFilaArray()[cabeca++];
	      if(getCabeca() == getTAMANHO())
	         setCabeca(0);
	      return temp;
	      }

	   public boolean isEmpty()  
	      {
	      return ( getCauda()+1==getCabeca() || (getCabeca()+getTAMANHO()-1==getCauda()) );
	      }

	   public void removeTudo() {
	      cabeca = 0;
	      cauda = -1;

	   }
	    
	    public int getTAMANHO() {
	        return TAMANHO;
	    }

	    
	    public void setTAMANHO(int TAMANHO) {
	        this.TAMANHO = TAMANHO;
	    }

	    
	    public int[] getFilaArray() {
	        return filaArray;
	    }

	    
	    public void setFilaArray(int[] filaArray) {
	        this.filaArray = filaArray;
	    }

	    public int getCabeca() {
	        return cabeca;
	    }

	    public void setCabeca(int cabeca) {
	        this.cabeca = cabeca;
	    }

	    public int getCauda() {
	        return cauda;
	    }

	    public void setCauda(int cauda) {
	        this.cauda = cauda;
	    }
}
