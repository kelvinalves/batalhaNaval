import java.util.Random;
import java.util.Scanner;

public class BatalhaNavalComputador extends BatalhaNaval {
	private int sorteio, tamanho, linha, coluna;
	private char orientacao;
	private String celulaAnterior = "~~~";
	private int sequencia=5;

	public BatalhaNavalComputador(){
		criaTabuleiros();
	}

	@Override
	public void jogar(){
		posicionaNaviosTabuleiros();
		while(true){
			darTiro(1);
			imprimir(1);
			if(checaFimDeJogo()){
				System.out.println("\t\t-----Parabens! Voce ganhou!------");
				break;
			}
			tipoTiro();
			imprimir(2);
			if(checaFimDeJogo()){
				System.out.println("\t\t-----Computador ganhou! Mais sorte da proxima vez!------");
				break;
			}
		}
	}
	public int aleatorio() {
		Random gerador = new Random();
		tamanho = getTabuleiro(1).tamanhoTabuleiro();
		sorteio = gerador.nextInt(tamanho);
		return sorteio;
	}
	public char orientacao() {
		if (aleatorio() < ((tamanho)/2))
			orientacao = 'h';
		else
			orientacao = 'v';
		return orientacao;
	}
	@Override
	public void darTiroNaCelula(int linha, int coluna, Tabuleiro tabuleiro)throws Exception{
		Celula celula=tabuleiro.getCelula(linha-1, coluna-1);
		if(celula.getTiro())
			throw new Exception("\nJa foi dado tiro nessa celula!\n");
		celula.setTiro();
		if(celula.getConteudo().equals(" X ")){
			tabuleiro.atiraNoNavio(celula);
			celulaAnterior = " X ";
		}
		else {
			if(sequencia==0){
				celulaAnterior = "~~~";
				sequencia=5;
			}
		}
	}
	public void tipoTiro(){
		if(celulaAnterior == " X ")
			darTiroInteligente(linha, coluna);
		else{
			try{
				darTiroAleatorio();
			}
			catch (Exception e){
				tipoTiro();
			}
		}
	}

	public void darTiroAleatorio() throws Exception{ 
		this.linha = aleatorio();
		this.coluna = aleatorio();
		darTiroNaCelula(linha, coluna, getTabuleiro(1));
	}	
	
	public void darTiroInteligente(int linha, int coluna){ 
		boolean continuaExcecao=true;
		while(continuaExcecao){		
			try{
				sequencia--;
				if (sequencia == 4){
					darTiroNaCelula(linha-1, coluna, getTabuleiro(1));
					sequencia--;
				}
				else if (sequencia == 3){
					darTiroNaCelula(linha+1, coluna, getTabuleiro(1));
					sequencia--;
				}
				else if (sequencia == 2){
					darTiroNaCelula(linha, coluna-1, getTabuleiro(1));
					sequencia--;
				}
				else if (sequencia == 1){
					darTiroNaCelula(linha, coluna+1, getTabuleiro(1));
					sequencia--;
				}
				else {
					darTiroAleatorio();
				}
				continuaExcecao=false;
			}
			catch(Exception e){
				
			}
		}
	}

	public void posicionaNaviosTabuleiros(){
		System.out.println("\n\t-------Posicionamento de navios: jogador 1-------\n");
		posicionaNavios(getTabuleiro(1),1);
		System.out.println("\nSeu tabuleiro ficou como segue\n");
		imprimir(1);
		posicionaNavios();
		//imprimir(2);
	}
	public void posicionaNavios(){
		boolean continuaExcecao;
		Navio[] naviosAuxiliar=getTabuleiro(2).getNavios();
		for(int i = 0;i < naviosAuxiliar.length; i++){
			continuaExcecao=true;
			while (continuaExcecao){
				try{
					naviosAuxiliar[i].posicionaNavio(aleatorio(), aleatorio(), orientacao(),getTabuleiro(2));
					continuaExcecao = false;
				}
				catch (Exception e){
				}	
			}
		}
	}
}
