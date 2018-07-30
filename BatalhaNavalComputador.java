import java.util.Random;

public class BatalhaNavalComputador extends BatalhaNaval {
	private int sorteio, tamanho, linha, coluna;
	private char orientacao;
	private String celulaAnterior = "~~~";

	public int aleatorio(){
		Random gerador = new Random();
		tamanho = getTabuleiro(1).tamanhoTabuleiro();
		sorteio = gerador.nextInt(tamanho);
		return sorteio;
	}
	public char orientacao(){
		if(aleatorio()<((tamanho)/2))
			orientacao = 'H';
		else
			orientacao = 'V';
		return orientacao;
	}
	@Override
	public void darTiroNaCelula(int linha, int coluna, Tabuleiro tabuleiro){
		Celula celula = tabuleiro.getCelula(linha,coluna);
		if(celula.getTiro())
			celula.setTiro();
		if(celula.getConteudo().equals(" X ")){
			tabuleiro.atiraNoNavio(celula);
			celulaAnterior = " X ";
		}
	}
	public void tipoTiro(){
		if(celulaAnterior == " X ")
			darTiroInteligente(linha, coluna);
		else{
			this.linha = aleatorio();
			this.coluna = aleatorio();
			darTiroNaCelula(linha, coluna, tabuleiro2);
		}
	}
	public void darTiroInteligente(int linha, int coluna){
		int a = aleatorio();
		if (a < tamanho/4)
			darTiroNaCelula(linha-1, coluna, tabuleiro2);
		else if (a < tamanho/2)
			darTiroNaCelula(linha+1, coluna, tabuleiro2);
		else if (a >= tamanho/2)
			darTiroNaCelula(linha, coluna-1, tabuleiro2);
		else
			darTiroNaCelula(linha, coluna+1, tabuleiro2);
	}
	@Override
	public void posicionaNavios(Tabuleiro tabuleiro, int numTabuleiro){
		boolean continuaExcecao;
		Navio[] naviosAuxiliar=tabuleiro.getNavios();
		for(int i=0;i<naviosAuxiliar.length;i++){
			continuaExcecao=true;
			while (continuaExcecao){
				try{
					naviosAuxiliar[i].posicionaNavio(aleatorio(), aleatorio(), orientacao(), tabuleiro2);
					continuaExcecao = false;
				} 
				catch (Exception e)
					posicionaNavios(tabuleiro2, 2);
			}
		}
	}
}

