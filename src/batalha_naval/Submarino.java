package batalha_naval;
import java.util.Scanner;

public class Submarino {
	String nome = "Submarino";
	int vida = 100;
	String formato = "*";
	int numeroCanhoes = 1;
	String coordenada1 = "";
	String posicionadoStr = "Não posicionado";
	Boolean posicionadoBoolean = false;
	Scanner entrada = new Scanner(System.in);
	
	void receberDano() {
		
	}
	
	void afundar() {
		
	}
	
	void status() {
		System.out.println("O submarino está com " + this.vida + " pontos de vida");
		System.out.println("O submarino está posicionado na coordenada: " + this.coordenada1);
	}
	
	void posicionar() {
		System.out.println("Informe a coordenada em que você deseja posicionar o Submarino:");
		this.coordenada1 = entrada.nextLine();
		this.posicionadoStr = "Posicionado";
		this.posicionadoBoolean = true;
		System.out.println("O submarino foi posicionado com sucesso na coordenada: " + coordenada1 + ".");
	}
	
}
