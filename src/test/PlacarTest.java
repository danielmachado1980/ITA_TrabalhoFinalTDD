package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.TipoPonto;
import main.TipoPontoCurtida;
import main.Usuario;

public class PlacarTest {

	@Test
	public void registrarTeste() {
		TipoPonto tipo = new TipoPontoCurtida(10);
		Usuario user = new Usuario("daniel");
	}

}
