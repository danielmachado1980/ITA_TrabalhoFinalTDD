package main;

public class Placar {
	
	private Armazenamento _armazenamento;
	
	public Placar(Armazenamento armazenamento) {
		this._armazenamento = armazenamento;
		registrar();
	}

	public Armazenamento getArmazenamento() {
		return _armazenamento;
	}

	public void setArmazenamento(Armazenamento _armazenamento) {
		this._armazenamento = _armazenamento;
	}
	
	private void registrar() {
		this.getArmazenamento().armazenar();
	}
}
