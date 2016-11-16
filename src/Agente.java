import processing.core.PApplet;
import processing.core.PImage;

public class Agente extends Thread {

	private PApplet app;
	private int x;
	private int y;
	private int rx;
	private int ry;

	public Agente(PApplet app) {
		this.app = app;

		x = (int) (app.random(0, 800));
		y = (int) (app.random(0, 350));
	}

	public void run() {
		while (true) {
			rx = (int) (app.random(-20, 20));
			ry = (int) (app.random(-20, 20));
			if ((x + rx) < (800-rx)) {
				x += rx;
			}
			if ((y + ry) < (340-ry)) {
				y += ry;
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar() {
		mover();
		app.ellipse(x, y, 5, 5);
	}

	private void mover() {
		rx = (int) (app.random(-5, 5));
		ry = (int) (app.random(-5, 5));
		if ((x + rx) < (800-rx)) {
			x += rx;
		}
		if ((y + ry) < (340-ry)) {
			y += ry;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int posAgenteEnArreglo(PImage imagen, int agentePosX, int agentePosY) {
		int posAgente = (agentePosY * imagen.width) + agentePosX;
		return posAgente;
	}

}
