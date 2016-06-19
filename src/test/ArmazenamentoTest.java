package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Armazenamento;
import main.Placar;
import main.TipoPonto;
import main.TipoPontoCurtida;
import main.TipoPontoEstrela;
import main.Usuario;

public class ArmazenamentoTest {

	@Test
	public void armazenarTeste() {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		Armazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.recuperar(usuario).contains("TipoPontoCurtida:10"));
		tipoPonto = new TipoPontoEstrela(10);
		usuario = new Usuario("daniel", tipoPonto);
		armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.recuperar(usuario).contains("TipoPontoEstrela:10"));
	}
	/*
	@Test
	public void recuperarPorTipoTeste() {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		Armazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertEquals("TipoPontoCurtida:10", armazenamento.recuperar(usuario, tipoPonto));
	}
	
	@Test
	public void recuperarTodosTiposPontoTeste() {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		Armazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		tipoPonto = new TipoPontoEstrela(20);
		usuario = new Usuario("daniel", tipoPonto);
		armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertEquals("TipoPontoCurtida:10", armazenamento.retornarTodosUsuariosComPontos());
	}*/

}
