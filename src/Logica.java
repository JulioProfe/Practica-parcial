import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private PApplet app;
	private PImage color;
	private PImage blanco;
	private Agente[] agentes;

	public Logica(PApplet app) {
		this.app = app;
		color = app.loadImage("colorBars.png");
		blanco = app.loadImage("blanco.png");
		agentes = new Agente[100];
		for (int i = 0; i < agentes.length; i++) {
			agentes[i] = new Agente(app);
			agentes[i].start();
		}
	}

	public void ejecutar() {
		app.image(color, 0, 0, 800, 350);
		app.image(blanco, 0, 350);

		for (int i = 0; i < agentes.length; i++) {
			Agente temp = agentes[i];
			temp.pintar();
		}

		leerPixeles();

	}

	private void leerPixeles() {
		color.loadPixels();
		for (int i = 0; i < agentes.length; i++) {
			Agente temp = agentes[i];

			for (int x = 0; x < color.width; x++) {
				for (int y = 0; y < color.height; y++) {
					int loc = x + y * color.width;
					float r = app.red(color.pixels[loc]);
					float g = app.green(color.pixels[loc]);
					float b = app.blue(color.pixels[loc]);
					int posAgente = temp.posAgenteEnArreglo(color, temp.getX(), temp.getY());
					if (posAgente == loc && color.pixels[loc] != 255) {
						cambiarPixeles(posAgente, r, g, b);
						color.pixels[loc] = app.color(255);
					}

				}
			}
		}
		color.updatePixels();

	}

	private void cambiarPixeles(int pos, float r, float g, float b) {
		blanco.loadPixels();
		for (int x = 0; x < blanco.width; x++) {
			for (int y = 0; y < blanco.height; y++) {
				int loc = x + y * blanco.width;
				if (pos == loc) {
					blanco.pixels[loc] = app.color(r, g, b);
				}
			}
		}

		blanco.updatePixels();
	}

}
