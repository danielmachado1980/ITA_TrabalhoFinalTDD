package br.ita.projetofinal.main;

import br.ita.projetofinal.abstracts.TipoPonto;

public class TipoPontoCurtida extends TipoPonto implements Cloneable{

	@Override
	public String toString() {
		return "Curtida";
	}

	public TipoPontoCurtida(long pontos) {
		super(pontos);
	}
}
