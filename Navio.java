public class Navio {
	private String tipoNavio;
	private Celula[] celulasOcupadas;
	private int celulasAtivas;
	
	public Navio(String tipoNavio, int numeroCeluasOcupadas) {
		inicializaNavio(tipoNavio,numeroCeluasOcupadas);
	}
	//metodo para diminuir o numero de celulas que ainda podem receber tiro
	public void decrementaCelulasAtivas(){
		celulasAtivas--;
	}
	
	public void inicializaNavio(String tipoNavio, int numeroCeluasOcupadas) {
		this.tipoNavio=tipoNavio;
		celulasOcupadas=new Celula[numeroCeluasOcupadas];
		celulasAtivas=numeroCeluasOcupadas;
	}
	
	public boolean checaAfundado(){
		if(celulasAtivas==0)
			return true;
		return false;
	}
	
	public String getTipo(){
		return tipoNavio;
	}
	
	/*public void posicionaNavio(int linha, int coluna, char orientacao){
		
	}*/
	
	
}