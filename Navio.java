//lembrar de tirar comentarios na hora de apresentar

public class Navio {
    private String tipoNavio;
    private Celula[] celulasOcupadas;
    private int celulasAtivas;
    
    public Navio(String tipoNavio, int numeroCelulasOcupadas) {
        inicializaNavio(tipoNavio,numeroCelulasOcupadas);
    }
    //metodo para diminuir o numero de celulas que ainda podem receber tiro
    public void decrementaCelulasAtivas(){
        celulasAtivas--;
    }
    /*    Metodo para criar de fato o navio: coloca seu tipo e
        talvez deixar esse metodo private seja mais interessante
    */
    public void inicializaNavio(String tipoNavio, int numeroCeluasOcupadas) {
        this.tipoNavio=tipoNavio;
        celulasOcupadas=new Celula[numeroCeluasOcupadas];
        celulasAtivas=numeroCeluasOcupadas;
    }
    /*    Simplesmente ve se o navio foi afundado ou nao e retorna true ou false
    */
    public boolean checaAfundado(){
		if(celulasAtivas==0)
            return true;
        return false;
    }
    
    public String getTipo(){
        return tipoNavio;
    }
    /*    O metodo vai posicionar o navio colocando um N nas celulas que ele vai ocupar
        e colocando essa celula no vetor de celulas ocupadas pelo navio. Por exemplo
        vamos posicionar um submarino na posição 1,1 na vertical. Ele tem tamanho 2.
        O que o metodo vai fazer é executar o laco uma vez colocando N na celula 1,1
        (na matriz sera 0,0) e colocar essa celula no vetor de celulas ocupadas pelo
        navio. Depois o metodo vai repetir isso mais uma vez, agora para a celula 1,2.
    */
    public void posicionaNavio(int linha, int coluna, char orientacao, Tabuleiro tabuleiro) throws Exception{
        int tamanho=tabuleiro.tamanhoTabuleiro();
		if(orientacao=='V'){
            if (linha+celulasOcupadas.length-1>tamanho || coluna>tamanho || linha>tamanho || linha<1 || coluna<1){
                throw new Exception ("Posicao fora do tabuleiro!");
            }
            for(int i=0;i<celulasAtivas;i++){
                Celula celulaAux=tabuleiro.getCelula(linha+i-1,coluna-1);
                if (celulaAux.getConteudo().equals(" N ")){
                    throw new Exception("Posicao ja esta ocupada!");                 
                }
                
            }
            
            for(int i=0;i<celulasAtivas;i++){
                Celula celulaAux=tabuleiro.getCelula(linha+i-1,coluna-1);
                celulaAux.setConteudo(" N ");
                celulasOcupadas[i]=celulaAux;
            }
        }

        else{
            if (coluna+celulasOcupadas.length-1>tamanho || coluna>tamanho || linha>tamanho || linha<1 || coluna<1){
                throw new Exception ("Posicao fora do tabuleiro!");
            }
            for(int i=0;i<celulasAtivas;i++){
                Celula celulaAux=tabuleiro.getCelula(linha-1,coluna+i-1);
                if (celulaAux.getConteudo().equals(" N ")){
                    throw new Exception("Posicao ja esta ocupada!");                 
                }
            }
            
            for(int i=0;i<celulasAtivas;i++){
                Celula celulaAux=tabuleiro.getCelula(linha-1,coluna+i-1);
                celulaAux.setConteudo(" N ");
                celulasOcupadas[i]=celulaAux;
            }        
        }
    }
    /*    Esse metodo vai ver se a celula passada como parametro pertence a esse navio
        aqui. Isso auxilia na hora de dar um tiro numa celula e ver qual navio acertamos
    */
    public boolean checaCelulasOcupadas(Celula celula){
        for(int i=0;i<celulasOcupadas.length;i++)
            if(celulasOcupadas[i]==celula)
                return true;
        return false;
    }
	
	public int getCelulasAtivas(){
		return celulasAtivas;
	}
}

