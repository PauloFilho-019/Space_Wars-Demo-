package modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Planeta2 {
	
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	private List<Planeta2> planeta2;
	
	//Distancia percorrida pelo tiro
	//private static final int LARGURA = 990;
	private static int VELOCIDADE = 1;
	
	public Planeta2(int x, int y) {
		
		//Definindo a onde o tiro vai aparecer 
		this.x = x;
		this.y = y;
		isVisivel = true;
	}
	
	public void load() {
		
		//Definindo a estetica do tiro
		ImageIcon referencia = new ImageIcon("C:\\Users\\paulo\\eclipse-workspace\\Space-Wars\\src\\res\\Planeta agua.gif");
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}
	
	public void update() {
		if(this.x < -2000) {
			this.x = largura;
			Random a = new Random();
			int m = a.nextInt(900);
			this.x = m + 1624;
			Random r = new Random();
			int n = r.nextInt(1268);
			this.y = n;
		}
		
		this.x -= VELOCIDADE;
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
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
	
}
