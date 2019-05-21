package br.ufba.mata55.celular;

import java.util.Collection;
import java.util.LinkedList;

public class Poder1 implements Poder {

	public void acionar(Celula celula, Collection<Entidade> vizinhos) {
		vizinhos = new LinkedList<Entidade>();
		for (int i = celula.getX() - 50; i < celula.getX() + 50; i++) {
			for (int j = celula.getY() - 50; j < celula.getY() + 50; j++) {
				/*if(i == Comida.getX() && j == Comida.getY()) {
					
				}*/
			}
		}
	}

}
