public class Celula implements Imprimivel{
	private String nuvem="oOo";
	private String conteudo;
	private boolean tiro;
	
	public Celula(){
		tiro=false;
	}
	
	public void setConteudo(String conteudo){
		this.conteudo=conteudo;
	}
	
	public String getConteudo(){
		return conteudo;
	}
	
	public boolean getTiro(){
		return tiro;
	}
	
	public void setTiro(){
		if(conteudo!="~~~")
			conteudo=" X ";
		tiro=true;
	}
	
	public String getNuvem(){
		return nuvem;
	}
	@Override
	public void imprimir(){
		if(tiro)
			System.out.print(getConteudo());
		else
			System.out.print(getNuvem());
	}
}