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
