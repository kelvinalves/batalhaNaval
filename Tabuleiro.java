//lembrar de tirar comentarios antes da apresentação
import java.util.Scanner;
public class Tabuleiro {
	private Celula[][] tabuleiro;
	private Navio[] navios;
	private int naviosAtivos;
	/*	Construtor que cria a matriz e chama um metodo para colocar Celulas nessa matriz,
		pois criar a matriz apenas cria uma matriz de nulls
		O construtor tambem cria os navios 
	*/
	public Tabuleiro (int tamanho){
		tabuleiro=new Celula[tamanho][tamanho];
		inicializaCelulas(tamanho);
		inicializaNavios();
	}
	/*	Esse metodo  apenas cria celulas e as põe na matriz
	*/
	public void inicializaCelulas(int tamanho){
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				tabuleiro[i][j]=new Celula();
	}
	/*	Esse metodo apenas cria os navios
	*/
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
		naviosAtivos=10;
	}
	/*	O metodo abaixo auxilia o usuario e pede para que ele digite a linha, a coluna e a orientacao
		dos navios. O metodo pede a posicao de cada navio do vetor de navios
	*/
	public void posicionaNavios(){
		Scanner leitor=new Scanner(System.in);
		System.out.println("Hora de posicionar os Navios: digite a linha, a coluna e a orientacao (H-horizotal e V-vertical)");
		int linha;
		int coluna;
		char orientacao;
		for(int i=0;i<navios.length;i++){
			System.out.println("Posicione um " + navios[i].getTipo());
			linha=leitor.nextInt();
			coluna=leitor.nextInt();
			orientacao=leitor.nextChar();
			navios[i].posicionaNavio(linha,coluna,posicao,tabuleiro);
		}
	}
	/*	Metodo que pergunta se o navio passado como parametro foi afundado: se foi ele decrementa o 
		numero de navios ativos
	*/
	public void checaAfundou(Navio navio){
		if(navio.checaAfundado())
			naviosAtivos--;
	}
	/*	Ao darmos um tiro devemos saber qual navio atingimos. O metodo abaixo faz isso: procura a 
		qual navio a celula passada como parametro pertence, de outra forma, vê se a celula do parametro
		bate com alguma ocupada pelo navio. Isso e feito pra cada navio do jogo, isto e, para cada navio 
		no vetor navios
	*/
	public Navio procuraAlvo(Celula celula){
		for(int i=0;i<navios.length;i++){
			if(navios[i].checaCelulasOcupadas())
				return navios[i];		
		}
	}
	/*	Aqui sabemos que a celula do parametro e de algum navio. Entao procuramos esse navio alvo, depois 
		diminuimos o numero de celulas ativas dele, pois acertamos uma, e por ultimo checamos se ele afundou
		com esse tiro
	*/
	public void atiraNoNavio(Celula celula){
		Navio navioAux=procuraAlvo(celula);
		navioAux.decrementaCelulasAtivas();
		checaAfundou(navioAux);
	}
	
	/*	Metodo para auxiliar na hora de dar um tiro: o metodo dar tiro ficara numa classe diferente
		poir isso que temos que conseguir passar a celula para tal classe
	*/
	public Celula getCelula(int linha, int coluna){
		return tabuleiro[linha][coluna];
	}
	/*	Retorna a quantidade de navios que ainda restam 
	*/
	public int getNaviosAtivos(){
		return naviosAtivos;
	}
	
}