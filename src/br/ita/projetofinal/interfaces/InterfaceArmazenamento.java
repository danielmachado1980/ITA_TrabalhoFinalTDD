package br.ita.projetofinal.interfaces;

import java.util.List;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.main.Usuario;

public interface InterfaceArmazenamento {
	void armazenar() throws Exception;
	List<String> recuperar(Usuario usuario) throws Exception;
	String recuperar(Usuario usuario, TipoPonto tipoPonto) throws Exception;
	List<String> retornarTodosUsuariosComAlgumTipoPontos() throws Exception;
	List<String> retornarTodosTipoPontoParaUsuario(Usuario usuario) throws Exception;
}
