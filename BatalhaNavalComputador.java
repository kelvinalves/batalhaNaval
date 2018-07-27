import java.util.Random;

public class BatalhaNavalComputador extends BatalhaNaval {
	private int sorteio;
	private char orientacao;
	private Celula celulaAnterior = "~~~";
	
	public int aleatorioIndice(){
		//instância um objeto da classe Random usando o construtor básico
		Random gerador = new Random();

		int tamanho = getTabuleiro(1).tamanhoTabuleiro;
	
		//sequência entre 0 e tamanho + 1

		int aleatorio = gerador.nextInt(tamanho);
		
		return aleatorio;
	}
	public char orientacao{
				
		if (sorteio < ((tamanho)/2))
			orientacao = 'H';
		else
			orientacao = 'V';
		return orientacao;
	}
	@Override
	public void darTiro(aleatorioIndice(), aleatorioIndice(), 2) throws Exception{
		if(celulaAux.getConteudo().equals(" X ")){

			celulaAnterior = " X ";
		}
	}
	public void tipoTiro(Celula celulaAnterior){
		if(celulaAnterior.getConteudo().equals(" X ")) {

		}
		else
			darTiro(); 
		
	}

	@Override	
	public void posicionaNavio(aleatorioIndice(), aleatorioIndice(), orientacao, Celula[][] tabuleiro)

	}
