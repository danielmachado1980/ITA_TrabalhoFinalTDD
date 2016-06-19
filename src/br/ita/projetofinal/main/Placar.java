package br.ita.projetofinal.main;

import br.ita.projetofinal.interfaces.InterfaceArmazenamento;

public class Placar {
	
	private InterfaceArmazenamento _armazenamento;

	public InterfaceArmazenamento getArmazenamento() {
		return _armazenamento;
	}

	public void setArmazenamento(Armazenamento _armazenamento) {
		this._armazenamento = _armazenamento;
	}
		
	public Placar(InterfaceArmazenamento armazenamento) throws Exception {
		this._armazenamento = armazenamento;
		this.registrar();
	}

	private void registrar() throws Exception {
		this.getArmazenamento().armazenar();
	}
}
