package main;

public abstract class TipoPonto {
	private long _pontos;
	
	public TipoPonto(long pontos){
		this._pontos = pontos;
	}

	public long getPontos(){
		return this._pontos;
	}
}
