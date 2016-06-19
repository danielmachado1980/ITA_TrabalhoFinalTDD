package br.ita.projetofinal.main;

import br.ita.projetofinal.abstracts.TipoPonto;

public class TipoPontoCurtida extends TipoPonto{

	@Override
	public String toString() {
		return "TipoPontoCurtida";
	}

	public TipoPontoCurtida(long pontos) {
		super(pontos);
	}

}
