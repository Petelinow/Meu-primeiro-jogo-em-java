package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Veneno extends Entidade{
	
	static LinkedList<Veneno> listaVeneno = new LinkedList<>();
	
	public Veneno(int x, int y, int tamanho) {
		super(x, y, tamanho);
	}
	
	public void desenha(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, tamanho, tamanho);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, tamanho, tamanho);
		
	}
}
