import java.util.Random;
import java.util.Scanner;

public class BatalhaNavalComputador extends BatalhaNaval {
	private int sorteio, tamanho, linha, coluna;
	private char orientacao;
	private String celulaAnterior = "~~~";

	public BatalhaNavalComputador(){
		boolean continuaExcecao=true;
        	Scanner leitor = new Scanner(System.in);
        	while (continuaExcecao){
			try{
				System.out.print("\nDigite o tamanho do tabuleiro (entre 8 e 15, inclusive): ");
				int tamanho = leitor.nextInt();
				setTabuleiro(1,new Tabuleiro(tamanho));
				setTabuleiro(2,new Tabuleiro(tamanho));
				setFimDeJogo(false);
				continuaExcecao=false;
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void jogar(){
		posicionaNaviosTabuleiros();
		while(true){
			darTiro(1);
			imprimir(1);
			if(checaFimDeJogo()){
				System.out.println("\t\t-----Não fez mais do que a sua obrigação------");
				break;
			}
			tipoTiro();
			if(checaFimDeJogo()){
				System.out.println("\t\t-----Você é fraco!------");
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
		else
			celulaAnterior = "~~~";
	}
	public void tipoTiro(){
		if(celulaAnterior == " X ")
			darTiroInteligente(linha, coluna);
		else{
			try{
				this.linha = aleatorio();
				this.coluna = aleatorio();
				darTiroNaCelula(linha, coluna, tabuleiro1);
			}
			catch (Exception e){
				tipoTiro();
			}
		}
	}
	public void darTiroInteligente(int linha, int coluna){
		int a = aleatorio();
		try{
			if (a < tamanho/4){
				darTiroNaCelula(linha-1, coluna, tabuleiro1);}
			else if (a < tamanho/2){
				darTiroNaCelula(linha+1, coluna, tabuleiro1);}
			else if (a < 3*tamanho/2){
				darTiroNaCelula(linha, coluna-1, tabuleiro1);}
			else{
				darTiroNaCelula(linha, coluna+1, tabuleiro1);}
		}
		catch(Exception e){
			darTiroInteligente(linha, coluna);
		}
	}
	public void posicionaNaviosTabuleiros(){
		System.out.println("\n\t-------Posicionamento de navios: jogador 1-------\n");
		posicionaNavios(getTabuleiro(1),1);
		System.out.println("\nSeu tabuleiro ficou como segue\n");
		imprimir(1);
		posicionaNavios();
		imprimir(2);
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
