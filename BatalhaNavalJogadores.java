import java.util.Scanner;
public class BatalhaNavalJogadores extends BatalhaNaval{
	
	public BatalhaNavalJogadores(){
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
				System.out.println("\t\t-----Jogador 1 ganhou!------");
				break;
			}
			darTiro(2);
			imprimir(2);
			if(checaFimDeJogo()){
				System.out.println("\t\t-----Jogador 2 ganhou!------");
				break;
			}
		}
	}
		
	public void posicionaNaviosTabuleiros(){
        System.out.println("\n\t-------Posicionamento de navios: jogador 1-------\n");
		posicionaNavios(getTabuleiro(1));
		imprimir(1);
		System.out.println("\n\t-------Posicionamento de navios: jogador 2-------\n");
        posicionaNavios(getTabuleiro(2));
		imprimir(2);
    }
	
	public int[] pedeCoordenadas(int jogador){
		Scanner leitor=new Scanner(System.in);
		int[] coordenadas=new int[2];
		System.out.println("\n\t\t----Vez do Jogador " + jogador+ "----\n");
		System.out.println("Onde quer dar o tiro? ");
		coordenadas[0]=leitor.nextInt();
		coordenadas[1]=leitor.nextInt();
		return coordenadas;		
	}
	
	
	public void darTiro(int jogador){
		boolean continuaAtirando=true;
		int[] coordenadas=new int[2];
		while(continuaAtirando){
			try{
				coordenadas=pedeCoordenadas(jogador);
				if(jogador==1)
					darTiro(coordenadas[0],coordenadas[1],2);
				else
					darTiro(coordenadas[0],coordenadas[1],1);
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
	
	public void imprimir(int tabuleiro){
		System.out.println("\t\t----------Tabuleiro " + tabuleiro +"----------\n");		
		if(tabuleiro==1){
			imprimirTabuleiro(getTabuleiro(1),getTabuleiro(2));
			System.out.println();
		}
		else{
			imprimirTabuleiro(getTabuleiro(2),getTabuleiro(1));
			System.out.println();
		}
	}
}