import java.util.Scanner;
public class BatalhaNavalJogadores extends BatalhaNaval{
	/*public void posicionaNaviosTabuleiros(){
		System.out.println("\n-------Posicionamento de navios: jogador 1-------\n");
		Tabuleiro tabuleiroAuxiliar=getTabuleiro(1);
		tabuleiroAuxiliar.posicionaNavios();
		
		System.out.println("\n-------Posicionamento de navios: jogador 2-------\n");
		tabuleiroAuxiliar=getTabuleiro(2);
		tabuleiroAuxiliar.posicionaNavios();
	}	
	/*	Agora esse imprimir so imprime as "divisorias horizontais" do tabuleiro
	*/
	
	public void darTiro(int jogador){
		Scanner leitor=new Scanner(System.in);
		boolean continuaAtirando=true;
		int coluna;
		int linha;
		while(continuaAtirando){
			try{
				System.out.println("----Vez do Jogador " + jogador+ "----");
				System.out.println("Onde quer dar o tiro? ");
				linha=leitor.nextInt();
				coluna=leitor.nextInt();
				if(jogador==1)
					darTiro(linha,coluna,2);
				else
					darTiro(linha,coluna,1);
				continuaAtirando=false;
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void imprimirTabuleiro(Tabuleiro tabuleiro,Tabuleiro tabuleiroAuxiliar){
		for(int i=0;i<tabuleiro.tamanhoTabuleiro();i++){
			imprimir();
			System.out.println();
			for(int j=0;j<tabuleiro.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiro.getCelula(i,j).imprimir();
			}
			System.out.print("|  ");
			for(int j=0;j<tabuleiroAuxiliar.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiroAuxiliar.getCelula(i,j).imprimirAuxiliar();
			}
			System.out.println("|");
		}
		imprimir();
		System.out.println();
	}
	/*
	public void imprimirTabuleiroAuxiliar(Tabuleiro tabuleiro){
		for(int i=0;i<tabuleiro.tamanhoTabuleiro();i++){
			imprimirAuxiliar();
			System.out.println();
			for(int j=0;j<tabuleiro.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiro.getCelula(i,j).imprimirAuxiliar();
			}
			System.out.println("|");
		}
		imprimirAuxiliar();
		System.out.println();
	}*/	
	
	public void imprimir(int tabuleiro){
		if(tabuleiro==1){
			imprimirTabuleiro(getTabuleiro(1),getTabuleiro(2));
			System.out.println();
			//imprimirTabuleiroAuxiliar(getTabuleiro(2),getTabuleiro(1));
		}
		else{
			imprimirTabuleiro(getTabuleiro(2),getTabuleiro(1));
			System.out.println();
			//imprimirTabuleiroAuxiliar(getTabuleiro(1),getTabuleiro(2));
		}
	}
}