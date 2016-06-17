package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Armazenamento;
import main.InterfaceArmazenamento;
import main.Placar;
import main.TipoPonto;
import main.TipoPontoCurtida;
import main.TipoPontoEstrela;
import main.Usuario;

public class PlacarTest {

	@Test
	public void registrarTeste() {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		Placar placar = new Placar();
		InterfaceArmazenamento armazenamento = new Armazenamento();
		placar.adicionarArmazenamento(armazenamento);
		placar.registrar(usuario, tipoPonto);
		tipoPonto = new TipoPontoEstrela(5);
		usuario = new Usuario("daniel", tipoPonto);
		placar.registrar(usuario, tipoPonto);
		assertEquals(15, placar.retornarPontos(usuario));
	}

}
