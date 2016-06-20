package br.ita.projetofinal.abstracts;

public abstract class TipoPonto {
	private long _pontos;
		
	public TipoPonto(long pontos){
		this._pontos = pontos;
	}
	
	public long getPontos(){
		return this._pontos;
	}
	
	public void setPontos(long pontos){
		this._pontos = pontos;
	}
}
