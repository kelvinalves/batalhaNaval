import java.util.Scanner;

public class BatalhaNaval implements Imprimivel{
    private Tabuleiro tabuleiro1;
    private Tabuleiro tabuleiro2;
    private boolean fimDeJogo;
	/*
	public static void jogar(){
		System.out.prinln()
	}*/
    public BatalhaNaval() {
        boolean continuaExcecao=true;
        Scanner leitor = new Scanner(System.in);
        while (continuaExcecao){
            try{
                System.out.print("\nDigite o tamanho do tabuleiro (entre 8 e 15, inclusive): ");
                int tamanho = leitor.nextInt();
                tabuleiro1=new Tabuleiro(tamanho);
                tabuleiro2=new Tabuleiro(tamanho);
                fimDeJogo=false;
                continuaExcecao=false;
            }
        
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    /*    Aqui o metodo pega a celula na qual queremos dar tiro e depois checa se acertamos
        um navio, se acertamos precisamos ver em qual foi. No final checa se ja afundamos
        todo os navios.
    */
    
    public void posicionaNavios(Tabuleiro tabuleiro){
        boolean continuaExcecao;
        Scanner leitor=new Scanner(System.in);
        System.out.println("Digite a linha, a coluna e a orientacao (h-horizotal e v-vertical)");
        int linha;
        int coluna;
        char orientacao;
        Navio[] naviosAuxiliar=tabuleiro.getNavios();

        for(int i=0;i<naviosAuxiliar.length;i++){
            continuaExcecao=true;
            while (continuaExcecao)
            try{
                System.out.println("Posicione um " + naviosAuxiliar[i].getTipo());
                linha=leitor.nextInt();
                coluna=leitor.nextInt();
                orientacao=leitor.next().charAt(0);
                naviosAuxiliar[i].posicionaNavio(linha,coluna,orientacao,tabuleiro);
                continuaExcecao = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());    
            }        
        }
    }    
    
	public Tabuleiro escolherTabuleiro(int tabuleiro){
		if(tabuleiro==1)
			return tabuleiro1;
		return tabuleiro2;
	}
	
	public void darTiroNaCelula(int linha, int coluna, Tabuleiro tabuleiro)throws Exception{
		Celula celula=tabuleiro.getCelula(linha-1,coluna-1);
		if(celula.getTiro())
			throw new Exception("\nJa foi dado tiro nessa celula!\n");
		celula.setTiro();
		if(celula.getConteudo().equals(" X "))
			tabuleiro.atiraNoNavio(celula);
	}
	
    public void darTiro(int linha, int coluna,int tabuleiro) throws Exception{
        Tabuleiro tabuleiroAuxiliar=escolherTabuleiro(tabuleiro);
        if (coluna>tabuleiroAuxiliar.tamanhoTabuleiro() || linha>tabuleiroAuxiliar.tamanhoTabuleiro() || linha<1 || coluna<1){
			throw new Exception ("Tiro fora do tabuleiro!");
		}
        darTiroNaCelula(linha,coluna,tabuleiroAuxiliar);
        checaNumeroNavios(tabuleiro);
    }
	
    /*	Ve se ja afundamos todos os navios ou nao
    */
    public void checaNumeroNavios(int tabuleiro){
        Tabuleiro tabuleiroAuxiliar;
		if(tabuleiro==1)
			tabuleiroAuxiliar=tabuleiro1;
		else 
			tabuleiroAuxiliar=tabuleiro2;
		if(tabuleiroAuxiliar.getNaviosAtivos()==0){
			fimDeJogo=true;
			System.out.println("\t\t-----Jogador " + (3-tabuleiro) + " ganhou!------");
		}
	
    }
    /*	Metodo para auxiliar na classe principal: ele vai nos dizer ate quando devemos ficar
        pedindo para que o usuario digite o tiro.
    */
    public boolean checaFimDeJogo(){
        if(fimDeJogo)
            return true;
        return false;
    }
    /*    Tem dois metodos pra imprimir pois precisamos de um tabuleiro auxiliar para
        marcar nossos tiros e o que ja afundamos
    */
    
    public Tabuleiro getTabuleiro(int tabuleiro){
        if(tabuleiro==1)
            return tabuleiro1;
        return tabuleiro2;
    }
    
    @Override
    public void imprimirAuxiliar(){
        Tabuleiro tabuleiroAuxiliar=getTabuleiro(1);
        for(int j=0;j<tabuleiroAuxiliar.tamanhoTabuleiro();j++)
                System.out.print("|---");
            System.out.print("|");
    }
    
    @Override
    public void imprimir(){
        imprimirAuxiliar();
        System.out.print("  ");
        imprimirAuxiliar();
    }
}

