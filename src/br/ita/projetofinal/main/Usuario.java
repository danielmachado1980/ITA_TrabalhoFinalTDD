package br.ita.projetofinal.main;

import br.ita.projetofinal.abstracts.TipoPonto;

public class Usuario implements Comparable<Usuario>{
	
	private String _nome;
	private long _pontos;
	private TipoPonto _tipoPonto;
	
	public Usuario(String nome, TipoPonto tipoPonto) {
		this._nome = nome;
		this._tipoPonto = tipoPonto;
	}

	public Usuario(TipoPonto tipoPonto) {
		this._tipoPonto = tipoPonto;
	}

	public Usuario(String nome) {
		this._nome = nome;
	}
	
	public long getPontos() {
		return this._pontos;
	}

	public void setPontos(long pontos) {
		this._pontos = pontos;
	}
	
	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		this._nome = nome;
	}

	public TipoPonto getTipoPonto() {
		return _tipoPonto;
	}

	@Override
	public String toString() {
		return _nome + " com " + getPontos() + " pontos";
	}

	public void setTipoPonto(TipoPonto _tipoPonto) {
		this._tipoPonto = _tipoPonto;
	}

	@Override
	public int compareTo(Usuario usuario) {
		if(this.getPontos() > usuario.getPontos())
			return -1;
		return 1;
	}
}
