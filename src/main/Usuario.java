package main;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String _nome;
	private TipoPonto _tipoPonto;
	
	public Usuario(String nome, TipoPonto tipoPonto) {
		this._nome = nome;
		this._tipoPonto = tipoPonto;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String _nome) {
		this._nome = _nome;
	}

	public TipoPonto getTipoPonto() {
		return _tipoPonto;
	}

	public void setTipoPonto(TipoPonto _tipoPonto) {
		this._tipoPonto = _tipoPonto;
	}
}
