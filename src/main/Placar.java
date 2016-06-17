package main;

import java.util.List;

public class Placar {
	
	private List<Usuario> _lstUsuarios;
	private InterfaceArmazenamento _armazenamento;
	
	public void registrar(Usuario usuario, TipoPonto tipoPonto) {
		this._lstUsuarios.add(usuario);
	}

	public void adicionarArmazenamento(InterfaceArmazenamento armazenamento) {
		this._armazenamento = armazenamento;
	}

}
