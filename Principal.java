import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		int linha;
		int coluna;
		boolean continuaAtirando=true;

		Scanner leitor = new Scanner(System.in);
		BatalhaNavalJogadores jogo = new BatalhaNavalJogadores();
		
		jogo.posicionaNaviosTabuleiros();
		
		jogo.imprimir(2);
		System.out.println();

		while(continuaAtirando){   //Teste dos tiros
		
			try{
				System.out.println("Onde quer dar o tiro?");
				linha = leitor.nextInt();
				coluna = leitor.nextInt();
		
				jogo.darTiro(linha,coluna,1);
				continuaAtirando=false;
			}

			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}
}
