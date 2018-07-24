public class BatalhaNaval implements Imprimivel{
	private Tabuleiro tabuleiro1;
	private Tabuleiro tabuleiro2;
	private boolean fimDeJogo;
	
	public BatalhaNaval(int tamanho){
		tabuleiro1=new Tabuleiro(tamanho);
		tabuleiro2=new Tabuleiro(tamanho);
		fimDeJogo=false;
	}
	
	public void darTiro(int linha, int coluna,int tabuleiro){
		if(tabuleiro==1){
			Celula celulaAux=tabuleiro1.getCelula(linha,coluna);
			celulaAux.setTiro();
			if(celulaAux.getConteudo().equals(" X "){
				tabuleiro1.atiraNoNavio(celulaAux);
			}
		}
		else {
			Celula celulaAux=tabuleiro2.getCelula(linha,coluna);
			celulaAux.setTiro();
			if(celulaAux.getConteudo().equals(" X "){
				tabuleiro1.atiraNoNavio(celulaAux);
			}
		}
		checaNumeroNavios(tabuleiro);
	}
	
	public void checaNumeroNavios(int tabuleiro){
		if(tabuleiro==1)
			if(tabuleiro1.getNaviosAtivos()==0)
				fimDeJogo=true;
		else
			if(tabuleiro2.getNaviosAtivos()==0)
				fimDeJogo=true;
	}
	
	public boolean checaFimDeJogo(){
		if(fimDeJogo)
			return true;
		return false;
	}
	
	@Override
	public String imprimir(){
		for(int i=0;i<tabuleiro1.length;i++){
			for(int j=0;j<tabuleiro1.length;j++){
				System.out.print("|");
				tabuleiro1.getCelula(i,j).imprimir();
				System.out.print("|");
			}
			System.out.println();
		}	
	}
	@Override
	public String imprimirAuxiliar(){
		for(int i=0;i<tabuleiro1.length;i++){
			for(int j=0;j<tabuleiro1.length;j++){
				System.out.print("|");
				tabuleiro1.getCelula(i,j).imprimirAuxiliar();
				System.out.print("|");
			}
			System.out.println();
		}	
	}
	
}