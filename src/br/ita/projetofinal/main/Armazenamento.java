package br.ita.projetofinal.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.ita.projetofinal.abstracts.TipoPonto;
import br.ita.projetofinal.interfaces.InterfaceArmazenamento;

public class Armazenamento implements InterfaceArmazenamento{

	private Usuario _usuario;
	
	public Usuario getUsuario() {
		return _usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this._usuario = usuario;
	}
	
	public Armazenamento(Usuario usuario) {
		this._usuario = usuario;
	}
	
	@Override
	public void armazenar() throws Exception {
		List<String> lista = new ArrayList<String>();
		List<String> listaOutros = new ArrayList<String>();
		try {
			lista = procurarUsuario(this.getUsuario());
			listaOutros = retornarOutrosUsuario(this.getUsuario());
			FileWriter arq = new FileWriter(localizarArquivo());
			PrintWriter gravarArq = new PrintWriter(arq);
			atualizar(lista, listaOutros, gravarArq);
			arq.close();
		} catch (IOException e) {
			throw e;
		}
	}
	
	@Override
	public List<String> recuperar(Usuario usuario) throws Exception {
		return procurarUsuario(usuario);
	}
	
	@Override
	public String recuperar(Usuario usuario, TipoPonto tipoPonto) throws Exception{
		for(String item : procurarUsuario(usuario)){
			if(item.contains(tipoPonto.toString()))
				return item;
		}
		return null;
	}
	
	@Override
	public List<String> retornarTodosUsuariosComAlgumTipoPontos() throws Exception{
		List<String> lista = new ArrayList<String>();
		try { 
			FileReader arq = abriArquivo(); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				if(linha.substring(0,2).equals("->"))
					lista.add(linha);
				linha = lerArq.readLine();
			}
			arq.close(); 
			return lista;
		} 
		catch (IOException e) { 
			throw e;
		}
	}
	
	@Override
	public List<String> retornarTodosTipoPontoParaUsuario(Usuario usuario) throws Exception {
		List<String> lista = new ArrayList<String>();
		try {
			FileReader arq = abriArquivo(); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				if(linha.substring(2).equals(usuario.getNome()))
					return retornarPontos(lerArq, linha);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			throw e;
		}
		return lista;
	}

	private void atualizar(List<String> lista, List<String> listaOutros, PrintWriter gravarArq) {
		long valorAntigo = 0;
		if(listaOutros.size()>0)
			for(String item : listaOutros)
				gravarArq.printf(item+"%n");
		if(lista==null){
			gravarArq.printf("->" + this.getUsuario().getNome()+"%n");
			gravarArq.printf(retornarNomeTipoPonto()+":"+retornarQuantidadePontos()+"%n");
			return;
		}
		for(String item : lista){
			if(!item.contains(retornarNomeTipoPonto()))
				gravarArq.printf(item+"%n");
			else
				valorAntigo = Long.parseLong(item.substring(item.indexOf(":")+1));
		}
		gravarArq.printf(retornarNomeTipoPonto()+":"+(valorAntigo+retornarQuantidadePontos())+"%n");
	}

	private long retornarQuantidadePontos() {
		return this.getUsuario().getTipoPonto().getPontos();
	}

	private String retornarNomeTipoPonto() {
		return this.getUsuario().getTipoPonto().toString();
	}
		
	private List<String> procurarUsuario(Usuario usuario) throws IOException{
		try { 
			FileReader arq = abriArquivo(); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				if(linha.substring(2).equals(usuario.getNome()))
					return retornarPontos(lerArq, linha);
				linha = lerArq.readLine();
			}
			arq.close(); 
			return null;
		} 
		catch (IOException e) { 
			throw e;
		}
	}
	
	private List<String> retornarOutrosUsuario(Usuario usuario) throws IOException{
		try { 
			List<String> lista = new ArrayList<String>();
			FileReader arq = abriArquivo(); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				if(!linha.substring(2).equals(usuario.getNome()) && linha.substring(0,2).equals("->"))
					lista.addAll(retornarPontos(lerArq, linha));
				linha = lerArq.readLine();
			}
			arq.close(); 
			return lista;
		} 
		catch (IOException e) { 
			throw e;
		}
	}

	private FileReader abriArquivo() throws FileNotFoundException, IOException {
		FileReader arq = new FileReader(localizarArquivo());
		return arq;
	}

	private String localizarArquivo() throws IOException {
		return new File(".").getCanonicalPath() + "\\resources\\placar.txt";
	}
	
	private List<String> retornarPontos(BufferedReader lerArq, String nomeUsuario) throws IOException{
		List<String> lista = new ArrayList<String>();
		try {
			lista.add(nomeUsuario);
			String linha = lerArq.readLine();
			while(linha != null && !linha.substring(0,2).equals("->")){
				lista.add(linha);
				lerArq.mark(50);
				linha = lerArq.readLine();
			}
			lerArq.reset();
			return lista;
		} catch (IOException e) {
			throw e;
		}
	}
}
