package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento{

	private Usuario _usuario;
	
	public Armazenamento(Usuario usuario) {
		this._usuario = usuario;
	}

	public void armazenar() {
		List<String> lista = new ArrayList<String>();
		List<String> listaOutros = new ArrayList<String>();
		long valorAtualizado = 0;
		try {
			lista = procurarUsuario(this.getUsuario());
			listaOutros = retornarOutrosUsuario(this.getUsuario());
			FileWriter arq = new FileWriter(new File(".").getCanonicalPath() + "\\resources\\placar1.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			if(listaOutros!=null)
				for(String item : listaOutros){
					gravarArq.printf(item+"%n");
				}
			
			if(lista==null){
				gravarArq.printf("->" + this.getUsuario().getNome()+"%n");
				gravarArq.printf(this.getUsuario().getTipoPonto().toString()+":"+this.getUsuario().getTipoPonto().getPontos()+"%n");
			}else{
				for(String item : lista){
					if(!item.contains(this.getUsuario().getTipoPonto().toString()))
						gravarArq.printf(item+"%n");
					else{
						valorAtualizado = Long.parseLong(item.substring(item.indexOf(":"))+1+this.getUsuario().getTipoPonto().getPontos());
					}
				}
				gravarArq.printf(this.getUsuario().getTipoPonto().toString()+":"+valorAtualizado+"%n");
			}
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setUsuario(Usuario usuario) {
		this._usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return _usuario;
	}
	
	public List<String> recuperar(Usuario usuario) {
		return procurarUsuario(usuario);
	}
	
	public String recuperar(Usuario usuario, TipoPonto tipoPonto){
		for(String item : procurarUsuario(usuario)){
			if(item.contains(tipoPonto.toString()))
				return item;
		}
		return null;
	}
	
	private List<String> procurarUsuario(Usuario usuario){
		try { 
			FileReader arq = new FileReader(new File(".").getCanonicalPath() + "\\resources\\placar1.txt"); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				if(linha.substring(2).equals(usuario.getNome())){
					return retornarPontos(lerArq, linha);
				}
				linha = lerArq.readLine();
			}
			arq.close(); 
			return null;
		} 
		catch (IOException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
	private List<String> retornarOutrosUsuario(Usuario usuario){
		try { 
			FileReader arq = new FileReader(new File(".").getCanonicalPath() + "\\resources\\placar1.txt"); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				if(!linha.substring(2).equals(usuario.getNome()) && linha.substring(0,2).equals("->")){
					return retornarPontos(lerArq, linha);
				}
				linha = lerArq.readLine();
			}
			arq.close(); 
			return null;
		} 
		catch (IOException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
	private List<String> retornarPontos(BufferedReader lerArq, String nomeUsuario){
		List<String> lista = new ArrayList<String>();
		try {
			lista.add(nomeUsuario);
			String linha = lerArq.readLine();
			while(linha != null){
				lista.add(linha);
				linha = lerArq.readLine();
			}
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<String> retornarTodosUsuariosComPontos(){
		List<String> lista = new ArrayList<String>();
		try { 
			FileReader arq = new FileReader(new File(".").getCanonicalPath() + "\\resources\\placar1.txt"); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha  = lerArq.readLine();
			while(linha != null){
				lista.add(linha);
				linha = lerArq.readLine();
			}
			arq.close(); 
			return lista;
		} 
		catch (IOException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
}
