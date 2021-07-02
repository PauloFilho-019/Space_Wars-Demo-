
package meujogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class menuprincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuJogar, menuSistema;
	private JMenuItem itemConfig, itemSair;
	private ImageIcon fundo = new ImageIcon("C:\\Users\\paulo\\eclipse-workspace\\Space-Wars\\src\\res\\FUNDO.png");
	private JLabel lbFundo = new JLabel();
	private JButton btModoHistoria, btModoArcade;

	menuprincipal() {
		// COnfigurações do Form principal

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Menu do jogo");
		setBounds(110, 50, 600, 358);
		panel = new JPanel();
		setJMenuBar(barraMenu);
		setContentPane(panel);
		setLayout(null);

		
		//btModoHistoria.setFont(new Font("Press Start 2P", Font.BOLD, 18));
		btModoHistoria = new JButton("Modo Historia");
		btModoHistoria.setBounds(159, 175, 125, 35);
		panel.add(btModoHistoria);
		btModoHistoria.addActionListener(this);

		btModoArcade = new JButton("Modo Arcade");
		btModoArcade.setBounds(299, 175, 110, 35);
		panel.add(btModoArcade);
		btModoArcade.addActionListener(this);

		// Barra de Menús
		menuJogar = new JMenu("Controles");
		menuSistema = new JMenu("Sistema");
		barraMenu.add(menuJogar);
		barraMenu.add(menuSistema);
		itemConfig = new JMenuItem("Configurações");
		itemSair = new JMenuItem("Sair do Sistema");
		menuSistema.add(itemConfig);
		menuSistema.add(itemSair);

		// Imagem de fundo
		lbFundo.setIcon(fundo);
		lbFundo.setBounds(0, 0, 600, 305);
		panel.add(lbFundo);

		// Ações do Menú
		itemConfig.addActionListener(this);
		itemSair.addActionListener(this);
	}

	// Ações ao clicar nos ítens do menú.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btModoHistoria) {
			JOptionPane.showMessageDialog(null, "Modo Historia inacabado");
		} else if (e.getSource() == btModoArcade) {
			Container ct = new Container();
			ct.setModal(true);
			ct.setVisible(true);
		} else if (e.getSource() == itemConfig) {
			JOptionPane.showMessageDialog(null, "Configurações inacabadas");
		} else {
			JOptionPane.showMessageDialog(null, "Volte sempre");
			dispose();
		}
	}

	// Método Main que abre o Form principal e carrega os arquivos
	public static void main(String[] args) {
		// Abre o formulário principal
		menuprincipal mf = new menuprincipal();
		mf.setVisible(true);
		mf.setResizable(false);

	}

}