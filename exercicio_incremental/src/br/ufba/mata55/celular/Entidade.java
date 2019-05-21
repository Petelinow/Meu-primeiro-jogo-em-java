package br.ufba.mata55.celular;

import java.awt.Graphics;

public abstract class Entidade {
	
	protected int x, y, tamanho;
	protected boolean ativo = true;
		
	public Entidade(int x, int y, int tamanho) {
		this.x = x;
		this.y = y;
		this.tamanho = tamanho;
	}

	protected abstract void desenha(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getTamanho() {
		return tamanho;
	}
	public boolean getAtivo() {
		return ativo;
	}

}
