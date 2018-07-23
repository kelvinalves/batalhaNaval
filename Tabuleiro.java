import java.util.Scanner;
public class Tabuleiro {
	private Celula[][] tabuleiro;
	private Navio[] navios;
	private int numeroNavios;
	
	public Tabuleiro (int tamanho){
		tabuleiro=new Celula[tamanho][tamanho];
		inicializaCelulas(tamanho);
		inicializaNavios();
	}
	
	public void inicializaCelulas(int tamanho){
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				tabuleiro[i][j]=new Celula();
	}
	
	public void inicializaNavios(){
		navios=new Navio[10];
		int i=0;
		for(i;i<4;i++)
			navios[i]=new Submario();
		for(i;i<7;i++)
			navios[i]=new ContraTorpedeiro();
		for(i;i<9;i++)
			navios[i]=new NavioTanque();
		navios[i]=new PortaAviao();
	}
	
	public void posicionaNavios(/*int linha, int coluna, char posicao*/){
		Scanner leitor=new Scanner(System.in);
		int i=0;
		System.out.println("Hora de posicionar os Navios: digite a linha, a coluna e a orientacao (H-horizotal e V-vertical)");
		System.out.println("Hora de posicionar um Submarino");
		int linha=leitor.nextInt();
		int coluna=leitor.nextInt();
		char orientacao=leitor.nextChar();
		navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		i++;
		for(i;i<4;i++){
			System.out.println("Posicione mais um Submarino");
			linha=leitor.nextInt();
			coluna=leitor.nextInt();
			orientacao=leitor.nextChar();
			navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		}
		System.out.println("Hora de posicionar um Contra torpedeiro");
		linha=leitor.nextInt();
		coluna=leitor.nextInt();
		orientacao=leitor.nextChar();
		navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		i++;
		
		for(i;i<7;i++){
			System.out.println("Posicione mais um Contra torpedeiro");
			linha=leitor.nextInt();
			coluna=leitor.nextInt();
			orientacao=leitor.nextChar();
			navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		}
		System.out.println("Hora de posicionar um Navio-tanque");
		linha=leitor.nextInt();
		coluna=leitor.nextInt();
		orientacao=leitor.nextChar();
		navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		i++;
		
		for(i;i<9;i++){
			System.out.println("Posicione mais um Navio-tanque");
			linha=leitor.nextInt();
			coluna=leitor.nextInt();
			orientacao=leitor.nextChar();
			navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		}
		System.out.println("Hora de posicionar um Porta aviao");
		linha=leitor.nextInt();
		coluna=leitor.nextInt();
		orientacao=leitor.nextChar();
		navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		i++;
	}
	
	public void procuraAlvo(Celula celula){
		for(int i=0;i<navios.length;i++){
			if(navios[i].checaCelulaOcupada(celula)){
				navios[i].decrementaCelulasAtivas();
				return;
			}
		}
	}
		
	public Celula getCelula(int linha, int coluna){
		return tabuleiro[linha][coluna];
	}
	
}