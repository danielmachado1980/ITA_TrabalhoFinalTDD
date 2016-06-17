package main;

import java.util.List;

public class Usuario {
	
	private String _nome;
	private List<TipoPonto> _tipoPonto;
	
	public Usuario(String nome, TipoPonto tipoPonto) {
		this._nome = nome;
		this._tipoPonto.add(tipoPonto);
	}



}
