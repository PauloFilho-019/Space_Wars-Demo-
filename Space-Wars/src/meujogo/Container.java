package meujogo;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import modelo.Fase;

//Container será o terreno para "criação" do nosso game

public class Container extends JFrame {
	
	public static String gamestate = "MENU";

	
	//metodo construtor "a aba que o jogo vai rodar"
	public Container() {
		add(new Fase());
		setTitle("Space-Wars");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Comando que decide aonde o personagem vai nascer na tela
		setLocationRelativeTo(null);
		
		//Comando que decide se a tela vai ser redimencionada
		this.setResizable(true);
		
		//Comando que deixa a tela visivel
		setVisible(true);
	}
	public static void main (String []args) {
		new Container();
	}

	
	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
