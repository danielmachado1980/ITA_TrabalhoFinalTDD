package test;

import java.util.ArrayList;
import java.util.List;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.interfaces.InterfaceArmazenamento;
import br.ita.projetofinal.main.Usuario;

public class MockArmazenamento implements InterfaceArmazenamento {
	
	private Usuario _usuario;
	private boolean erro = false;
	
	public MockArmazenamento(Usuario usuario) {
		this._usuario = usuario;
	}

	@Override
	public void armazenar() throws Exception {
		if(erro)
			throw new Exception("Erro acessar arquivo");
	}

	@Override
	public List<String> recuperar(Usuario usuario) throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("->daniel");
		lista.add("Curtida:10");
		lista.add("Estrela:25");
		return lista;
	}

	@Override
	public String recuperar(Usuario usuario, TipoPonto tipoPonto) throws Exception {
		return "Curtida:8";
	}

	@Override
	public List<String> retornarTodosUsuariosComAlgumTipoPontos() throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("->daniel");
		lista.add("Curtida:8");
		lista.add("->roberto");
		lista.add("Curtida:7");
		return lista;
	}

	@Override
	public List<String> retornarTodosTipoPontoParaUsuario(Usuario usuario) throws Exception {
		List<String> lista = new ArrayList<String>();
		lista.add("->daniel");
		lista.add("Curtida:8");
		lista.add("Estrela:7");
		return lista;
	}
	
	public void lancarExcecao() {
		this.erro = true;
	}

}
