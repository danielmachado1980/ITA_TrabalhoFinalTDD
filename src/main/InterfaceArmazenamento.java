package main;

import java.util.List;

public interface InterfaceArmazenamento {
	void armazenar();
	List<Usuario> recuperar();
	void setUsuario(Usuario usuario);
	Object getPontosPorTipoUsuario(Usuario usuario, TipoPonto tipoPonto);
}
