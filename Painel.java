package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Painel extends JPanel implements KeyListener, MouseInputListener {
	
	private static final long serialVersionUID = 1L;
	private Random r =  new Random();

	public static int LARGURA = 500;
	public static int ALTURA = 500;
	public static Color COR = Color.BLACK;

	Celula celula = new Celula(Controle.mouseX, Controle.mouseY, 3);
	LinkedList<Comida> listaComida = new LinkedList<Comida>();
	LinkedList<Veneno> listaVeneno = new LinkedList<Veneno>();
	LinkedList<Inimigo> listaInimigo = new LinkedList<Inimigo>();

	public Painel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void atualiza() {
		if(listaComida.size() < 8) {
			listaComida.add(new Comida(r.nextInt(Painel.LARGURA - 15), r.nextInt(Painel.ALTURA - 15), r.nextInt(12) + 3));
		}
		if(listaVeneno.size() < 5) {
			listaVeneno.add(new Veneno(r.nextInt(Painel.LARGURA - 15), r.nextInt(Painel.ALTURA - 15), r.nextInt(12) + 3));
		}
		if(listaInimigo.size() < 3) {
			listaInimigo.add(new Inimigo(r.nextInt(Painel.LARGURA - 35), r.nextInt(Painel.ALTURA - 35), r.nextInt(32) + 3));
		}
		for(int i = 0; i < listaInimigo.size(); i++) {
			Inimigo inimigo = listaInimigo.get(i);
			inimigo.mover();
		}
	}
	
	public void celulaCome() {
		if(!listaComida.isEmpty()) {
			for(int i = 0; i < listaComida.size(); i++) {
				double distancia = 0;
				distancia += Math.pow(listaComida.get(i).getX() - (celula.getX() - 3), 2) + Math.pow(listaComida.get(i).getY() - (celula.getY() - 3), 2);
				distancia = Math.sqrt(distancia);
				
				double celulaComida = (listaComida.get(i).getTamanho() + celula.getTamanho()) / 2;
				
				if(distancia < celulaComida) {
					celula.setTamanho(celula.getTamanho() + listaComida.get(i).getTamanho());
					listaComida.get(i).setAtivo(false);
					listaComida.remove(i);
				}
			}	
		}
	}
	
	public void celulaEnvenena() {
		if(!listaVeneno.isEmpty()) {
			for(int i = 0; i < listaVeneno.size(); i++) {
				double distancia = 0;
				distancia += Math.pow(listaVeneno.get(i).getX() - (celula.getX() - 3), 2) + Math.pow(listaVeneno.get(i).getY() - (celula.getY() - 3), 2);
				distancia = Math.sqrt(distancia);
				
				double celulaVeneno = (listaVeneno.get(i).getTamanho() + celula.getTamanho()) / 2;
				
				if(distancia < celulaVeneno) {
					celula.setTamanho(celula.getTamanho() - listaVeneno.get(i).getTamanho());
					listaVeneno.get(i).setAtivo(false);
					listaVeneno.remove(i);
				}
			}
		}
	}
	
	public void celulaTocaInimigo() {
		if(!listaInimigo.isEmpty()) {
			for(int i = 0; i < listaInimigo.size(); i++) {
				double distancia = 0;
				distancia += Math.pow(listaInimigo.get(i).getX() - (celula.getX() - 3), 2) + Math.pow(listaInimigo.get(i).getY() - (celula.getY() - 3), 2);
				distancia = Math.sqrt(distancia);
				
				double celulaInimigo = (listaInimigo.get(i).getTamanho() + celula.getTamanho()) / 2;
				
				if(distancia < celulaInimigo) {
					celula.setTamanho(celula.getTamanho() - listaInimigo.get(i).getTamanho());
					listaInimigo.get(i).setAtivo(false);
					listaInimigo.remove(i);
				}
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		celulaCome();
		celulaEnvenena();
		celulaTocaInimigo();
		
		if(!listaComida.isEmpty()) {
			for(int i = 0; i < listaComida.size(); i++) {
				listaComida.get(i).desenha(g);
			}
		}
		
		if(!listaVeneno.isEmpty()) {
			for(int i = 0; i < listaVeneno.size(); i++) {
				listaVeneno.get(i).desenha(g);
			}
		}
		
		if(!listaInimigo.isEmpty()) {
			for(int i = 0; i < listaInimigo.size(); i++) {
				listaInimigo.get(i).desenha(g);
			}
		}
		
		if(celula.getAtivo()) {
			celula.desenha(g);
		}
	}

	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();

		if (keyChar == 27) {
			System.exit(0);
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		Controle.mouseX = e.getX();
		Controle.mouseY = e.getY();
	}
}
