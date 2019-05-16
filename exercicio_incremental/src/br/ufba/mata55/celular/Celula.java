package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;

public class Celula extends Entidade {
	
	public Celula(int x, int y, int tamanho) {
		super(x, y, tamanho);
	}
	
	public void desenha(Graphics g) {
		x = Controle.mouseX;
		y = Controle.mouseY;
		
		g.setColor(Color.WHITE);
		g.fillOval(x - tamanho/2, y - tamanho/2, tamanho, tamanho);

		if(tamanho < 3) {
			ativo = false;
		}
	}
}
