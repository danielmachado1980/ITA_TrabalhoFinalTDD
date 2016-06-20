package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.main.Armazenamento;
import br.ita.projetofinal.interfaces.InterfaceArmazenamento;
import br.ita.projetofinal.main.TipoPontoCurtida;
import br.ita.projetofinal.main.TipoPontoEstrela;
import br.ita.projetofinal.main.Usuario;

public class ArmazenamentoTest {
	
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

	@Test
	public void armazenarTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.recuperar(usuario).contains("Curtida:10"));
		tipoPonto = new TipoPontoEstrela(10);
		usuario = new Usuario("daniel", tipoPonto);
		armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.recuperar(usuario).contains("Estrela:10"));
	}
	
	@Test
	public void recuperarPorTipoPontoParaUsuarioTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertEquals("Curtida:10", armazenamento.recuperar(usuario, tipoPonto));
	}
	
	@Test
	public void retornarTodosUsuariosComAlgumTipoPontoTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		tipoPonto = new TipoPontoEstrela(20);
		usuario = new Usuario("roberto", tipoPonto);
		armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.retornarTodosUsuariosComAlgumTipoPontos().contains("->roberto"));
		assertTrue(armazenamento.retornarTodosUsuariosComAlgumTipoPontos().contains("->daniel"));
	}
	
	@Test
	public void armazenarNegativoTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.recuperar(usuario).contains("Curtida:10"));
		tipoPonto = new TipoPontoCurtida(-2);
		usuario = new Usuario("daniel", tipoPonto);
		armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.recuperar(usuario).contains("Curtida:8"));
	}
	
	@Test
	public void retornarTodosTipoPontoParaUsuarioTeste() throws Exception {
		TipoPonto tipoPonto = new TipoPontoCurtida(10);
		Usuario usuario = new Usuario("daniel", tipoPonto);
		InterfaceArmazenamento armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		tipoPonto = new TipoPontoEstrela(20);
		usuario = new Usuario("daniel", tipoPonto);
		armazenamento = new Armazenamento(usuario);
		armazenamento.armazenar();
		assertTrue(armazenamento.retornarTodosTipoPontoParaUsuario(usuario).contains("Curtida:10"));
		assertTrue(armazenamento.retornarTodosTipoPontoParaUsuario(usuario).contains("Estrela:20"));
	}
}
