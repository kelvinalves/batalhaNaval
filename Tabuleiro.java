import java.util.Scanner;
public class Tabuleiro {
	private Celula[][] tabuleiro;
	private Navio[] navios;
	private int numeroNavios;
	
	public Tabuleiro (int tamanho){
	
	}
	
	public void inicializaCelulas(){
	
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
	/*
	public void posicionaNavios(int linha, int coluna, char posicao){
		Scanner leitor=new Scanner(System.in);
		System.out.println("Hora de posicionar os Navios: digite a linha, a coluna e a orientacao (H-horizotal e V-vertical)");
		System.out.println("Hora de posicionar um Submarino");
		navios[0].posicionaNavio()
		for(int i=0;i<4;i++){
			System.out.println("Digite 
		}
	}*/
	
	public void procuraAlvo(){
		
	}
		
	public Celula getCelula(int linha, int coluna){
		return tabuleiro[linha][coluna];
	}
	
}