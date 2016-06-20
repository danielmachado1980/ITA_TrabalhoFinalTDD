package br.ita.projetofinal.main;

import br.ita.projetofinal.abstracts.TipoPonto;

public class TipoPontoMoeda extends TipoPonto {

	@Override
	public String toString() {
		return "Moeda";
	}
	
	public TipoPontoMoeda(long pontos) {
		super(pontos);
	}
}
