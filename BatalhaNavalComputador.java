import java.util.Random;

public class BatalhaNavalComputador extends BatalhaNaval {
	private int sorteio;
	private char orientacao;
	private Celula celulaAnterior = "~~~";
	
	public int aleatorio(){
		//instancia um objeto da classe Random usando o construtor básico
		Random gerador = new Random();

		int tamanho = getTabuleiro(1).tamanhoTabuleiro;
	
		//sequência entre 0 e tamanho + 1

		int sorteio = gerador.nextInt(tamanho);
		
		return sorteio;
	}
	public char orientacao(){
				
		if (aleatorio() < ((tamanho)/2))
			orientacao = 'H';
		else
			orientacao = 'V';
		return orientacao;
	}
	@Override
	public void darTiro(aleatorioIndice(), aleatorioIndice(), 2) throws Exception{
		if(celulaAux.getConteudo().equals(" X "))
			celulaAnterior = " X ";
	}
	public void tipoTiro(Celula celulaAnterior){
		if(celulaAnterior.getConteudo().equals(" X "))
			darTiroInteligente();
		else
			darTiro(); 
		
	}
	
	public class darTiroInteligente(){
		itens = new Object[3]; // as quatro posições da cruz
		for(int i = 0; i<=3; i++){
			
			itens[i] = 

	}

	@Override	
	public void posicionaNavio(aleatorioIndice(), aleatorioIndice(), orientacao, Celula[][] tabuleiro)

	}
