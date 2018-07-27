import java.util.Scanner;

public class BatalhaNaval implements Imprimivel{
    private Tabuleiro tabuleiro1;
    private Tabuleiro tabuleiro2;
    private boolean fimDeJogo;
    /*    Contrutor para criar os tabuleiros
    */
    public BatalhaNaval() {
        boolean continuaExcecao=true;
        Scanner leitor = new Scanner(System.in);
        while (continuaExcecao){
            try{
                System.out.print("Digite o tamanho do tabuleiro (entre 8 e 15, inclusive): ");
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
    
    public void posicionaNaviosTabuleiros(){
        posicionaNavios(tabuleiro1);
        posicionaNavios(tabuleiro2);
    }
    
    
    public void posicionaNavios(Tabuleiro tabuleiro){
        boolean continuaExcecao;
        Scanner leitor=new Scanner(System.in);
        System.out.println("Hora de posicionar os Navios: digite a linha, a coluna e a orientacao (H-horizotal e V-vertical)");
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
    
    public void darTiro(int linha, int coluna,int tabuleiro) throws Exception{
        Tabuleiro tabuleiroAuxiliar;
        if(tabuleiro==1)
            tabuleiroAuxiliar=tabuleiro1;
        else
            tabuleiroAuxiliar=tabuleiro2;

        if (coluna>tabuleiroAuxiliar.tamanhoTabuleiro() || linha>tabuleiroAuxiliar.tamanhoTabuleiro() || linha<1 || coluna<1){
                throw new Exception ("Tiro fora do tabuleiro!");
            }
        Celula celulaAux=tabuleiroAuxiliar.getCelula(linha-1,coluna-1);

         if (celulaAux.getTiro()){
                throw new Exception("\nJa foi dado tiro nessa celula!\n");
            }
            celulaAux.setTiro();
            if(celulaAux.getConteudo().equals(" X ")){
                tabuleiroAuxiliar.atiraNoNavio(celulaAux);
            }
            /*
        }
        else {
            Celula celulaAux=tabuleiro2.getCelula(linha-1,coluna-1);
            if (celulaAux.getTiro()){
                throw new Exception("Ja foi dado tiro nessa celula!");
            }
            celulaAux.setTiro();
            if(celulaAux.getConteudo().equals(" X ")){
                tabuleiro2.atiraNoNavio(celulaAux);
            }
        }*/
        checaNumeroNavios(tabuleiro);
    }
    /*    Ve se ja afundamos todos os navios ou nao
    */
    public void checaNumeroNavios(int tabuleiro){
        if(tabuleiro==1)
            if(tabuleiro1.getNaviosAtivos()==0)
                fimDeJogo=true;
        else
            if(tabuleiro2.getNaviosAtivos()==0)
                fimDeJogo=true;
    }
    /*    Metodo para auxiliar na classe principal: ele vai nos dizer ate quando devemos ficar
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
    /*
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
    }*/

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
            for(int j=0;j<tabuleiro2.tamanhoTabuleiro();j++)
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

