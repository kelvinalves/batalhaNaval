import java.util.Scanner;

public class BatalhaNaval implements Imprimivel{
	private Tabuleiro tabuleiro1;
	private Tabuleiro tabuleiro2;
	private boolean fimDeJogo;
	/*	Contrutor para criar os tabuleiros 
	*/
	public BatalhaNaval() {
		boolean continuaExcecao=true;
		Scanner leitor = new Scanner(System.in);
		while (continuaExcecao){
			try{
				System.out.print("Digite o tamanho do tabuleiro: ");
				int tamanho = leitor.nextInt();
				tabuleiro1=new Tabuleiro(tamanho);
				tabuleiro2=new Tabuleiro(tamanho);
				fimDeJogo=false;
				continuaExcecao=false;
			}
		
			catch (Exception e){
				System.out.println(e.toString());
			}
		}
	}
	/*	Aqui o metodo pega a celula na qual queremos dar tiro e depois checa se acertamos
		um navio, se acertamos precisamos ver em qual foi. No final checa se ja afundamos 
		todo os navios.
	*/
	public void darTiro(int linha, int coluna,int tabuleiro) throws Exception{
		if(tabuleiro==1){
			Celula celulaAux=tabuleiro1.getCelula(linha,coluna);
			if (celulaAux.getTiro()){
				throw new Exception("Ja foi dado tiro nessa celula!");
			}
			celulaAux.setTiro();
			if(celulaAux.getConteudo().equals(" X ")){
				tabuleiro1.atiraNoNavio(celulaAux);
			}
		}
		else {
			Celula celulaAux=tabuleiro2.getCelula(linha,coluna);
			if (celulaAux.getTiro()){
				throw new Exception("Ja foi dado tiro nessa celula!");
			}
			celulaAux.setTiro();
			if(celulaAux.getConteudo().equals(" X ")){
				tabuleiro1.atiraNoNavio(celulaAux);
			}
		}
		checaNumeroNavios(tabuleiro);
	}
	/*	Ve se ja afundamos todos os navios ou nao
	*/
	public void checaNumeroNavios(int tabuleiro){
		if(tabuleiro==1)
			if(tabuleiro1.getNaviosAtivos()==0)
				fimDeJogo=true;
		else
			if(tabuleiro2.getNaviosAtivos()==0)
				fimDeJogo=true;
	}
	/*	Metodo para auxiliar na classe principal: ele vai nos dizer ate quando devemos ficar
		pedindo para que o usuario digite o tiro.
	*/
	public boolean checaFimDeJogo(){
		if(fimDeJogo)
			return true;
		return false;
	}
	/*	Tem dois metodos pra imprimir pois precisamos de um tabuleiro auxiliar para 
		marcar nossos tiros e o que ja afundamos
	*/
	@Override
	public void imprimir(){
		for(int i=0;i<tabuleiro1.tamanhoTabuleiro();i++){
			for(int j=0;j<tabuleiro1.tamanhoTabuleiro();j++)
				System.out.print("|---");
			System.out.println("|");
			for(int j=0;j<tabuleiro1.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiro1.getCelula(i,j).imprimir();
			}
			System.out.println("|");
		}
		for(int j=0;j<tabuleiro1.tamanhoTabuleiro();j++)
				System.out.print("|---");
			System.out.println("|");
	}
	@Override
	public void imprimirAuxiliar(){
		for(int i=0;i<tabuleiro2.tamanhoTabuleiro();i++){
			for(int j=0;j<tabuleiro1.tamanhoTabuleiro();j++)
				System.out.print("|---");
			System.out.println("|");
			for(int j=0;j<tabuleiro2.tamanhoTabuleiro();j++){
				System.out.print("|");
				tabuleiro2.getCelula(i,j).imprimirAuxiliar();
			}
			System.out.println("|");
		}
		for(int j=0;j<tabuleiro2.tamanhoTabuleiro();j++)
				System.out.print("|---");
			System.out.println("|");	
	}
	
}
