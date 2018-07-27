import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		int linha;
		int coluna;
		boolean continuaAtirando=true;
		
		Scanner leitor = new Scanner(System.in);
		BatalhaNavalJogadores jogo = new BatalhaNavalJogadores();
		
		jogo.posicionaNaviosTabuleiros();
		System.out.println("\t\t\t----------tabuleiro 1----------\n");
		jogo.imprimir(1);
		System.out.println();
		
		System.out.println("\t\t\t----------tabuleiro 2----------\n");
		jogo.imprimir(2);
		System.out.println();
		
		while(true){
			jogo.darTiro(1);
			jogo.imprimir(1);
			System.out.println();
			if(jogo.checaFimDeJogo())
				break;
			jogo.darTiro(2);
			jogo.imprimir(2);
			System.out.println();
			if(jogo.checaFimDeJogo())
				break;
		}
		System.out.println("Fim de jogo!");
		/*
		while(continuaAtirando){   //Teste dos tiros
		
			try{
				System.out.println("Onde quer dar o tiro?");
				linha = leitor.nextInt();
				coluna = leitor.nextInt();
		
				jogo.darTiro(linha,coluna,1);
				continuaAtirando=false;
				jogo.imprimir(2);
			}

			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		*/
	}
}
