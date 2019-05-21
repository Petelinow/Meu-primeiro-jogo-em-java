package br.ufba.mata55.celular;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Painel extends JPanel implements KeyListener, MouseInputListener {
	
	private static final long serialVersionUID = 1L;
	private Random r =  new Random();

	public static int LARGURA = 500;
	public static int ALTURA = 500;
	public static Color COR = Color.BLACK;

	Celula celula = new Celula(Controle.mouseX, Controle.mouseY, 3);
//	LinkedList<Comida> listaComida = new LinkedList<Comida>();
//	LinkedList<Veneno> listaVeneno = new LinkedList<Veneno>();
//	LinkedList<Inimigo> listaInimigo = new LinkedList<Inimigo>();

	public Painel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void atualiza() {
		if(Comida.listaComida.size() < 12) {
			Comida.listaComida.add(new Comida(r.nextInt(Painel.LARGURA - 15), r.nextInt(Painel.ALTURA - 15), r.nextInt(12) + 3));
		}
		if(Veneno.listaVeneno.size() < 5) {
			Veneno.listaVeneno.add(new Veneno(r.nextInt(Painel.LARGURA - 15), r.nextInt(Painel.ALTURA - 15), r.nextInt(12) + 3));
		}
		if(Inimigo.listaInimigo.size() < 4) {
			Inimigo.listaInimigo.add(new Inimigo(r.nextInt(Painel.LARGURA - 35), r.nextInt(Painel.ALTURA - 35), r.nextInt(32) + 3));
		}
		for(int i = 0; i < Inimigo.listaInimigo.size(); i++) {
			Inimigo inimigo = Inimigo.listaInimigo.get(i);
			inimigo.mover();
		}
	}
	
	public void celulaCome() {
		if(!Comida.listaComida.isEmpty()) {
			for(int i = 0; i < Comida.listaComida.size(); i++) {
				double distancia = 0;
				distancia += Math.pow(Comida.listaComida.get(i).getX() - (celula.getX() - 3), 2) + 
						Math.pow(Comida.listaComida.get(i).getY() - (celula.getY() - 3), 2);
				distancia = Math.sqrt(distancia);
				
				double celulaComida = (Comida.listaComida.get(i).getTamanho() + celula.getTamanho()) / 2;
				
				if(distancia < celulaComida) {
					celula.setTamanho(celula.getTamanho() + Comida.listaComida.get(i).getTamanho());
					Comida.listaComida.get(i).setAtivo(false);
					Comida.listaComida.remove(i);
				}
			}	
		}
	}
	
	public void celulaEnvenena() {
		if(!Veneno.listaVeneno.isEmpty()) {
			for(int i = 0; i < Veneno.listaVeneno.size(); i++) {
				double distancia = 0;
				distancia += Math.pow(Veneno.listaVeneno.get(i).getX() - (celula.getX() - 3), 2) + 
						Math.pow(Veneno.listaVeneno.get(i).getY() - (celula.getY() - 3), 2);
				distancia = Math.sqrt(distancia);
				
				double celulaVeneno = (Veneno.listaVeneno.get(i).getTamanho() + celula.getTamanho()) / 2;
				
				if(distancia < celulaVeneno) {
					celula.setTamanho(celula.getTamanho() - Veneno.listaVeneno.get(i).getTamanho());
					Veneno.listaVeneno.get(i).setAtivo(false);
					Veneno.listaVeneno.remove(i);
				}
			}
		}
	}
	
	public void celulaTocaInimigo() {
		if(!Inimigo.listaInimigo.isEmpty()) {
			for(int i = 0; i < Inimigo.listaInimigo.size(); i++) {
				double distancia = 0;
				distancia += Math.pow(Inimigo.listaInimigo.get(i).getX() - (celula.getX() - 3), 2) + 
						Math.pow(Inimigo.listaInimigo.get(i).getY() - (celula.getY() - 3), 2);
				distancia = Math.sqrt(distancia);
				
				double celulaInimigo = (Inimigo.listaInimigo.get(i).getTamanho() + celula.getTamanho()) / 2;
				
				if(distancia < celulaInimigo) {
					celula.setTamanho(celula.getTamanho() - Inimigo.listaInimigo.get(i).getTamanho());
					Inimigo.listaInimigo.get(i).setAtivo(false);
					Inimigo.listaInimigo.remove(i);
				}
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		celulaCome();
		celulaEnvenena();
		celulaTocaInimigo();
		
		if(!Comida.listaComida.isEmpty()) {
			for(int i = 0; i < Comida.listaComida.size(); i++) {
				Comida.listaComida.get(i).desenha(g);
			}
		}
		
		if(!Veneno.listaVeneno.isEmpty()) {
			for(int i = 0; i < Veneno.listaVeneno.size(); i++) {
				Veneno.listaVeneno.get(i).desenha(g);
			}
		}
		
		if(!Inimigo.listaInimigo.isEmpty()) {
			for(int i = 0; i < Inimigo.listaInimigo.size(); i++) {
				Inimigo.listaInimigo.get(i).desenha(g);
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
		} else if (keyChar >= '1' && keyChar <= '3') {
			//this.getCelula().setPoderAtivo(keyChar - '0');
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
