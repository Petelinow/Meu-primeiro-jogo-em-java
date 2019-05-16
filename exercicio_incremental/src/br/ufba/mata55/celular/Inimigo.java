package br.ufba.mata55.celular;

import java.util.Random;

public class Inimigo extends Veneno {

	private int velX, velY;
	private Random r = new Random();
	private Direcao direcao = Direcao.values()[r.nextInt(Direcao.values().length)];

	public Inimigo(int x, int y, int tamanho) {
		super(x, y, tamanho);
		velX = r.nextInt(8)+2;
		velY = r.nextInt(8)+2;
	}
	
	public void mover() {		
		if(direcao == Direcao.Horizontal) {
			x += velX;
		} else if(direcao == Direcao.Vertical) {
			y += velY;
		}
		
		if(y <= 0 || y >= Painel.ALTURA-12) velY *= -1;
		if(x <= 0 || x >= Painel.LARGURA-12) velX *= -1;
	}

}
