public class BatalhaNaval implements Imprimivel{
	private Tabuleiro tabuleiro1;
	private Tabuleiro tabuleiro2;
	private boolean fimDeJogo;
	
	public BatalhaNaval(int tamanho){
		tabuleiro1=new Tabuleiro(tamanho);
		tabuleiro2=new Tabuleiro(tamanho);
		fimDeJogo=false;
	}
	
	public void darTiro(){
		
	}
	
	public boolean checaFimDeJogo(){
		if(fimDeJogo)
			return true;
		return false;
	}
	
	@Override
	public String imprimir(Celula celula){
		return "|"+celula.imprimir()+"|";
	}
	
}