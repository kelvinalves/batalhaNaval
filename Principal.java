import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		BatalhaNaval jogo=new BatalhaNaval();
		jogo.jogar();
		/*
		jogo.posicionaNaviosTabuleiros();
		int i=0;
		while(!jogo.checaFimDeJogo()){ //Teste dos tiros
			jogo.darTiro(1);
			jogo.imprimir(1);
			jogo.darTiro(2);
			jogo.imprimir(2);
			i++;
		}*/
	}
}


