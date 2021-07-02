package modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import meujogo.Container;

public class Player {

	//definincdo as variaveis do player(caracteristicas)
	private int x,y;
	private int dx, dy;
	private Image imagem;
	private int altura,largura;
	private List <Tiro> tiros;
	private boolean isVisivel;
	
	
	public Player() {
		//definindo aonde o player vai aparecer
		this.x = 100;
		this.y = 100;
		isVisivel = true;
		
		tiros = new ArrayList<Tiro>();
	}
	
	public void load() {
		//definindo a estetica do player
		
		ImageIcon referencia = new ImageIcon("C:\\Users\\paulo\\eclipse-workspace\\Space-Wars\\src\\res\\spaceship.gif");
		imagem = referencia.getImage();
		
		//definindo o tamanho do player pelo tamanho da imagem
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public void upadate() {
		x += dx;
		y += dy;	
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x,y,largura,altura);
	}
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x+largura, y + (altura/2)));
	}
	
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		

		if(codigo == KeyEvent.VK_ENTER) {
			tiroSimples();
		}
		
		if(codigo == KeyEvent.VK_W) {
			dy=-3;
		}
		
		if(codigo == KeyEvent.VK_S) {
			dy=3;
		}
		if(codigo == KeyEvent.VK_A) {
			dx=-3;
		}
		if(codigo == KeyEvent.VK_D) {
			dx=3;
		}
	}
	public void keyReleased(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_W) {
			dy=0;
		}
		if(codigo == KeyEvent.VK_S) {
			dy=0;
		}
		if(codigo == KeyEvent.VK_A) {
			dx=0;
		}
		if(codigo == KeyEvent.VK_D) {
			dx=0;
		}
		if(codigo == KeyEvent.VK_SPACE) {
			
			Container ct = new Container();
			ct.setModal(true);
			ct.setVisible(true);
		}
	
		}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	public void setTiros(List<Tiro> tiros) {
		this.tiros = tiros;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	
}
