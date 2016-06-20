package br.ita.projetofinal.main;

import br.ita.projetofinal.abstracts.TipoPonto;

public class TipoPontoEstrela extends TipoPonto {
	
	@Override
	public String toString() {
		return "Estrela";
	}
	
	public TipoPontoEstrela(long pontos) {
		super(pontos);
	}
	
	
}
