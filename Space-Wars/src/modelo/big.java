package modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;

public class big {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	private List<Tiro> tiros;
	
	//Distancia percorrida pelo tiro
	//private static final int LARGURA = 990;
	private static int VELOCIDADE = 8;
	
	public big(int x, int y) {
		
		//Definindo a onde o tiro vai aparecer 
		this.x = x;
		this.y = y;
		isVisivel = true;
	}
	
	public void load() {
		
		//Definindo a estetica do tiro
		ImageIcon referencia = new ImageIcon("C:\\Users\\paulo\\eclipse-workspace\\Space-Wars\\src\\res\\com.gif");
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}
	
	public void update() {
		this.x -= VELOCIDADE;
			//if(this.x > LARGURA) {
				//isVisivel = false;
			//}		
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

	public Rectangle getBounds() {
	 
		return new Rectangle (x,y,largura,altura);
		}
	}
	
 
