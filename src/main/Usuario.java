package main;

import java.util.List;

public class Usuario {
	
	private String _nome;
	private List<TipoPonto> _tipoPonto;
	
	public Usuario(String nome, TipoPonto tipoPonto) {
		this._nome = nome;
		this._tipoPonto.add(tipoPonto);
	}

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public List<TipoPonto> get_tipoPonto() {
		return _tipoPonto;
	}

	public void set_tipoPonto(List<TipoPonto> _tipoPonto) {
		this._tipoPonto = _tipoPonto;
	}
}
