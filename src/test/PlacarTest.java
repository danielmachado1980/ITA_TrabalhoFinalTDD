package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.interfaces.InterfaceArmazenamento;
import br.ita.projetofinal.main.Armazenamento;
import br.ita.projetofinal.main.Placar;
import br.ita.projetofinal.main.TipoPontoCurtida;
import br.ita.projetofinal.main.TipoPontoEstrela;
import br.ita.projetofinal.main.Usuario;

public class PlacarTest {
	
	static final String caminho = "\\resources\\placar.txt";
	
	@Before
	public void inicializarTeste() throws IOException{
		File file = null;
		FileWriter arq = null;
		try {
			file = new File(new File(".").getCanonicalPath() + caminho);
			if ( file.exists()) {
			   file.delete();
			   
				arq = new FileWriter(new File(".").getCanonicalPath() + caminho);
				arq.close();
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
	@Test(expected=Exception.class)
	public void registrarPontoCurtidaMockTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		MockArmazenamento armazenamento = new MockArmazenamento(usuario);
		armazenamento.lancarExcecao();
		Placar placar = new Placar(armazenamento);
		placar.registrar();
		assertTrue(placar.getArmazenamento().recuperar(usuario).contains("Curtida:10"));
	}
	
	@Test
	public void retornarTodosPontosUsuarioMockTeste() throws Exception {
		TipoPonto tipoPontoCurtida = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPontoCurtida);
		InterfaceArmazenamento armazenamento = new MockArmazenamento(usuario);
		Placar placar = new Placar(armazenamento);
		placar.registrar();
		TipoPonto tipoPontoEstrela = new TipoPontoEstrela(20);
		usuario = new Usuario("daniel", tipoPontoEstrela);
		armazenamento = new MockArmazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		tipoPontoEstrela = new TipoPontoEstrela(5);
		usuario = new Usuario("daniel", tipoPontoEstrela);
		armazenamento = new MockArmazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		assertTrue(placar.retornarTodosTipoPontoUsuarios(usuario).contains("Curtida:10"));
		assertTrue(placar.retornarTodosTipoPontoUsuarios(usuario).contains("Estrela:25"));
	}
	
	@Test
	public void registrarPontoCurtidaTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		Placar placar = new Placar(armazenamento);
		placar.registrar();
		assertTrue(placar.getArmazenamento().recuperar(usuario).contains("Curtida:10"));
	}
	
	@Test
	public void retornarTodosPontosUsuarioTeste() throws Exception {
		TipoPonto tipoPontoCurtida = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPontoCurtida);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		Placar placar = new Placar(armazenamento);
		placar.registrar();
		TipoPonto tipoPontoEstrela = new TipoPontoEstrela(20);
		usuario = new Usuario("daniel", tipoPontoEstrela);
		armazenamento = new Armazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		tipoPontoEstrela = new TipoPontoEstrela(5);
		usuario = new Usuario("daniel", tipoPontoEstrela);
		armazenamento = new Armazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		assertTrue(placar.retornarTodosTipoPontoUsuarios(usuario).contains("Curtida:10"));
		assertTrue(placar.retornarTodosTipoPontoUsuarios(usuario).contains("Estrela:25"));
	}
	
	@Test
	public void retornarRankingTeste() throws Exception {
		TipoPonto tipoPontoCurtida = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPontoCurtida);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		Placar placar = new Placar(armazenamento);
		placar.registrar();
		tipoPontoCurtida = new TipoPontoCurtida(-2);
		usuario = new Usuario("roberto", tipoPontoCurtida);
		armazenamento = new Armazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		tipoPontoCurtida = new TipoPontoCurtida(20);
		usuario = new Usuario("roberto", tipoPontoCurtida);
		armazenamento = new Armazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		tipoPontoCurtida = new TipoPontoCurtida(15);
		usuario = new Usuario("maria", tipoPontoCurtida);
		armazenamento = new Armazenamento(usuario);
		placar = new Placar(armazenamento);
		placar.registrar();
		assertEquals("roberto com 18 pontos",placar.retornarRanking(tipoPontoCurtida).get(0).toString());
		assertEquals("maria com 15 pontos",placar.retornarRanking(tipoPontoCurtida).get(1).toString());
		assertEquals("daniel com 10 pontos",placar.retornarRanking(tipoPontoCurtida).get(2).toString());
	}
}
