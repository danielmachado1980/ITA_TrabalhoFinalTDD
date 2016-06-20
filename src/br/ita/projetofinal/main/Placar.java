package br.ita.projetofinal.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.interfaces.InterfaceArmazenamento;

public class Placar {
	
	private InterfaceArmazenamento _armazenamento;

	public InterfaceArmazenamento getArmazenamento() {
		return _armazenamento;
	}

	public void setArmazenamento(InterfaceArmazenamento _armazenamento) {
		this._armazenamento = _armazenamento;
	}
		
	public Placar(InterfaceArmazenamento armazenamento) throws Exception {
		this._armazenamento = armazenamento;
	}

	public void registrar() throws Exception {
		this.getArmazenamento().armazenar();
	}

	public List<String> retornarTodosTipoPontoUsuarios(Usuario usuario) throws Exception {
		return this.getArmazenamento().recuperar(usuario);
	}

	public List<Usuario> retornarRanking(TipoPonto tipoPonto) throws Exception {
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		String pontuacao;
		Usuario usuario;
		for(String item : this.getArmazenamento().retornarTodosUsuariosComAlgumTipoPontos()){
			usuario = new Usuario(item.substring(2));
			pontuacao = this.getArmazenamento().recuperar(usuario, tipoPonto);
			if(pontuacao!=null){
				usuario.setPontos(Long.parseLong(pontuacao.substring(pontuacao.indexOf(":")+1)));
				lstUsuarios.add(usuario);
			}
		}
		Collections.sort(lstUsuarios);
		return lstUsuarios;
	}
}
