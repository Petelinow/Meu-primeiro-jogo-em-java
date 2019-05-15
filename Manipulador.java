package br.ufba.mata55.celular;

import java.awt.Graphics;
import java.util.LinkedList;

public class Manipulador {
	
	LinkedList<Entidade> entidade = new LinkedList<Entidade>();
	
	public void desenha(Graphics g) {
		for(int i = 0; i < entidade.size(); i++) {
			Entidade tempEntidade = entidade.get(i);
			tempEntidade.desenha(g);
		}
	}

	public void novo(Entidade entidade) {
		this.entidade.add(entidade);
	}
	public void remove(Entidade entidade) {
		this.entidade.remove(entidade);
	}

}
