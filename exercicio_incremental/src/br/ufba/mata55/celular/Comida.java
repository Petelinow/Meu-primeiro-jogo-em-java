package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Comida extends Entidade{

	public Comida(int x, int y, int tamanho) {
		super(x, y, tamanho);
	}

	public void desenha(Graphics g) {
		g.fillRect(x, y, tamanho, tamanho);
		g.setColor(Color.GREEN);
	}
}
