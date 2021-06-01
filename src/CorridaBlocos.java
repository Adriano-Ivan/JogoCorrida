import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class CorridaBlocos extends JFrame{
	JFrame quadro;
	final int ALTURA = 700;
	final int LARGURA = 1350;
	ArrayList<JPanel> quadrados = new ArrayList<JPanel>();
	Container c;
	int delay = 0;
	int interval = 200;
	Timer timer = new Timer();
	Random x = new Random();
	int xParametro = 0;
	int y = 0;
	int flag = 0;
	String gan = "";
	
	public CorridaBlocos() {
		quadro = new JFrame();
		c = getContentPane();
		mostrarQuadro();
		criarQuadrados();
		mostrarQuadrado();
		adicionarQuadrados();
		cronometro();
	}
	public void mostrarQuadro() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		quadro.setSize(LARGURA, ALTURA);
		quadro.setTitle("Tela com JFrame");
		quadro.setLocationRelativeTo(null);
		quadro.setLayout(null);
		c.setBackground(Color.yellow);
		quadro.setContentPane(c);
		quadro.setVisible(true);
	}
	
	public void criarQuadrados() {
		Color[] cores = {Color.GREEN, Color.CYAN, Color.BLACK, Color.BLUE, Color.darkGray,
						Color.GRAY};
	
		for(int i = 0; i < 6; i++) {
			JPanel q = new JPanel();
			q.setBackground(cores[i]);
			quadrados.add(q);
		}
			
	}
	
	public void adicionarQuadrados() {
		for(JPanel quadrado : quadrados) {
			c.add(quadrado);
		}
	}
	public void mostrarQuadrado()  {
		if(flag == 0) {
		for(JPanel quadrado : quadrados) {
			xParametro = x.nextInt(20) + 1;
			quadrado.setBounds(quadrado.getX() + xParametro, y,100, 100);
			quadrado.setLocation(quadrado.getX() + xParametro, y);
			y+=110;
			//c.repaint();
			//c.revalidate();
			if(quadrado.getX() + 100 >= LARGURA) {
				int i = 0;
				for(int c = 0 ; c != quadrado.getY(); c+=110, i++ );
				gan = "O ganhador é o quadrado " + (i+1);
				c.setBackground(Color.RED);
				quadro.setTitle(gan);
				flag = 1;
				break;
			}
		}
		}
		y = 0;
	}
	
	public void cronometro() {
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				mostrarQuadrado();
			}
		}, delay, interval);
	}
}
