package test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.interfaces.InterfaceArmazenamento;
import br.ita.projetofinal.main.Armazenamento;
import br.ita.projetofinal.main.Placar;
import br.ita.projetofinal.main.TipoPontoCurtida;
import br.ita.projetofinal.main.TipoPontoEstrela;
import br.ita.projetofinal.main.Usuario;

public class PlacarTest {

	/*@Test
	public void registrarPontoCurtidaTeste() {
		Armazenamento armazenamento = new Armazenamento();
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		armazenamento.setUsuario(usuario);
		Placar placar = new Placar(armazenamento);
		assertEquals(10, placar.getArmazenamento().recuperarPorTipo(usuario, tipoPonto));
	}*/
	
	/*@Test
	public void registrarPontoEstrelaTeste() {
		InterfaceArmazenamento armazenamento = new Armazenamento();
		TipoPonto tipoPonto = new TipoPontoEstrela(5);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		Placar placar = new Placar(usuario, armazenamento);
		assertEquals(5, placar.getArmazenamento().recuperar());
	}*/
}
