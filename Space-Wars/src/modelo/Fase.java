package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RectangularShape;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//Esta clase é o cerebro do jogo, que define oque ira acontecer

public class Fase extends JPanel implements ActionListener{
	
	
	private Player player;
	private Image fundo;
	private Timer timer;
	private List<Inimigo1> inimigo1;
	private List<Estrela> estrela;
	private List<Planeta> planeta;
	private List<Planeta2> planeta2;
	private List<meteoroRapido> mem;
	private List<big> b;
	private boolean emJogo;
	private JLabel local = new JLabel();
	private JLabel arma = new JLabel("Arma:");
	private JLabel pontos = new JLabel("Pontuação :");
	
	//metodo construtor
	public Fase() {
		
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("C:\\Users\\paulo\\eclipse-workspace\\Space-Wars\\src\\res\\background.jpg");
		fundo = referencia.getImage();
	
		player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
	
		timer = new Timer(5, this);
		timer.start();
		
		inicializabig();
		inicializaInimigos();
		inicializaPlaneta();
		inicializaEstrelas();
		
		inicializaPlaneta2();
		inicializaMeteoro();
		emJogo = true;
	}
	
	public void inicializaPlaneta() {
		int cordenadas [] = new int [1];
		planeta = new ArrayList<Planeta> ();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 924+0);
			int y = (int)(Math.random() * 768+ 0);
			planeta.add(new Planeta(x, y));
		}
	}
	
	public void inicializaPlaneta2() {
		int cordenadas [] = new int [1];
		planeta2 = new ArrayList<Planeta2> ();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 724+0);
			int y = (int)(Math.random() * 768+ 0);
			planeta2.add(new Planeta2(x, y));
		}
	}
	public void inicializaMeteoro() {
		int cordenadas [] = new int [1];
		mem = new ArrayList<meteoroRapido> ();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 8000+1024);
			int y = (int)(Math.random() * 650+30);
			mem.add(new meteoroRapido(x, y));
		}
	}
	//quantidade de inimigos
	public void inicializaInimigos() {
		int cordenadas [] = new int [10];
		inimigo1 = new ArrayList<Inimigo1> ();
		
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 8000+1024);
			int y = (int)(Math.random() * 650+30);
			inimigo1.add(new Inimigo1(x, y));
		}
	}
	
	public void inicializabig() {
		int cordenadas [] = new int [1];
		b = new ArrayList<big> ();
		
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 8000+1024);
			int y = (int)(Math.random() * 650+30);
			b.add(new big(x, y));
		}
		
	}
	
	public void inicializaEstrelas() {
		int cordenadas [] = new int [40];
		estrela = new ArrayList<Estrela> ();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 1024+0);
			int y = (int)(Math.random() * 768+ 0);
			estrela.add(new Estrela(x, y));
		}
	}
	
	public void paint (Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if(emJogo == true) {
		
			graficos.drawImage(fundo, 0, 0, null);
			
			for(int p = 0; p < planeta.size(); p++) {
				Planeta q = planeta.get(p);
				q.load();
				graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
			
			}
			
			
			for(int p = 0; p < estrela.size(); p++) {
				Estrela q = estrela.get(p);
				q.load();
				graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
			
			}
			for(int p = 0; p < planeta2.size(); p++) {
				Planeta2 q = planeta2.get(p);
				q.load();
				graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
			
			}
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		
			
			List<Tiro> tiros = player.getTiros();
			for(int i = 0; i < tiros.size(); i++) {
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			
			}
			
			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 in = inimigo1.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
			
			for (int f = 0; f < b.size(); f++) {
				big in = b.get(f);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
			
			for (int o = 0; o < mem.size(); o++) {
				meteoroRapido in = mem.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
			g.dispose();
	
		}else {
			ImageIcon fimJogo = new ImageIcon("C:\\Users\\paulo\\eclipse-workspace\\Space-Wars\\src\\res\\end.jpg");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		player.upadate();
		
		local.setLayout(null);
		
		local.setBounds(10, 10, 200, 120);
		local.setBackground(Color.RED);
		
		for(int p = 0; p < planeta2.size(); p++) {
			Planeta2 on = planeta2.get(p);
				if(on.isVisivel()) {
					on.update();
			}else {
				planeta2.remove(p);
			}
		}
		for(int p = 0; p < planeta.size(); p++) {
			Planeta on = planeta.get(p);
				if(on.isVisivel()) {
					on.update();
			}else {
				planeta.remove(p);
			}
		}
		
		for(int p = 0; p < estrela.size(); p++) {
			Estrela on = estrela.get(p);
				if(on.isVisivel()) {
					on.update();
			}else {
				estrela.remove(p);
			}
		}
		
	
	
		List<Tiro> tiros = player.getTiros();
		for(int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
				if(m.isVisivel()) {
					m.update();
				}else {
					tiros.remove(i);
				}
		}
		
		for (int o = 0; o < inimigo1.size(); o++) {
			Inimigo1 in = inimigo1.get(o);
					if(in.isVisivel()) {
						in.update();
					} else {
						inimigo1.remove(o);
					}
		}
		
		for (int a = 0; a < mem.size(); a++) {
			meteoroRapido in = mem.get(a);
					if(in.isVisivel()) {
						in.update();
					} else {
						mem.remove(a);
					}
		}
		cecarCOlisoes();
		repaint();
		
	}
	
	public void cecarCOlisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaInimigo1 = null;
		Rectangle formaTiro;
		Rectangle formameteoroRapido;
		Rectangle big;
		
		for(int i = 0; i < inimigo1.size(); i++) {
			Inimigo1 tempInimigo1 = inimigo1.get(i);
			formaInimigo1 = tempInimigo1.getBounds();
				if(formaNave.intersects(formaInimigo1)){
					player.setVisivel(false);
					tempInimigo1.setVisivel(false);
					emJogo = false;
				}
		}
		for(int i = 0; i < mem.size(); i++) {
			meteoroRapido tempmeteoroRapido = mem.get(i);
			formameteoroRapido  = tempmeteoroRapido .getBounds();
				if(formaNave.intersects(formameteoroRapido )) {
					player.setVisivel(false);
					tempmeteoroRapido .setVisivel(false);
					emJogo = false;
				}
		}
	
		for (int b = 0; b < mem.size(); b++) {
			meteoroRapido tempMeteoroRapido = mem.get(b);
			
			formameteoroRapido = tempMeteoroRapido.getBounds();
			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 tempInimigo1 = inimigo1.get(o);
				formaInimigo1 = tempInimigo1.getBounds();
				if(formameteoroRapido.intersects(formaInimigo1)) {
					tempInimigo1.setVisivel(false);
					tempMeteoroRapido.setVisivel(true);
				}
			}
		 
			
		//começo
		List<Tiro> tiros = player.getTiros();
		for (int j = 0; j < tiros.size(); j++) {
			Tiro tempTiro = tiros.get(j);
			
			formaTiro = tempTiro.getBounds();
			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 tempInimigo1 = inimigo1.get(o);
				formaInimigo1 = tempInimigo1.getBounds();
				if(formaTiro.intersects(formaInimigo1)) {
					tempInimigo1.setVisivel(false);
					tempTiro.setVisivel(false);
				}
			}
			formaTiro = tempTiro.getBounds();
			for (int o = 0; o < mem.size(); o++) {
				meteoroRapido  tempmeteoroRapido  = mem.get(o);
				formameteoroRapido  = tempmeteoroRapido .getBounds();
				if(formaTiro.intersects(formameteoroRapido )) {
					tempmeteoroRapido .setVisivel(true);
					tempTiro.setVisivel(false);
				}
			}
		}
	}
	}
	//fim
	
	private class TecladoAdapter extends KeyAdapter {
		//Importando os metodos criados na classe player de movimentação do jogador

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
		
	}
}