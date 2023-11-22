package batalha_naval;

import java.util.Scanner;

public class PortaAviao {
	String nome = "Porta Aviões";
	int vida = 100;
	String formato = "*****";
	int numeroCanhoes = 5;
	String coordenada1 = "";
	String coordenada2 = "";
	String coordenada3 = "";
	String coordenada4 = "";
	String coordenada5 = "";
	String posicionadoStr = "Não posicionado";
	Boolean posicionadoBoolean = false;
	Scanner entrada = new Scanner(System.in);
	
	void receberDano() {
		
	}
	
	void afundar() {
		
	}
	
	void status() {
		System.out.println("O Porta Avião está com " + this.vida + " pontos de vida");
		System.out.println("O Porta Avião está posicionado na coordenada: " + this.coordenada1);
		System.out.println("O Porta Avião está posicionado na coordenada: " + this.coordenada2);
		System.out.println("O Porta Avião está posicionado na coordenada: " + this.coordenada3);
		System.out.println("O Porta Avião está posicionado na coordenada: " + this.coordenada4);
	}
	void posicionar() {
		System.out.println("Informe a primeira coordenada em que você deseja posicionar o Porta Avião:");
		this.coordenada1 = entrada.nextLine();
		System.out.println("Informe a segunda coordenada em que você deseja posicionar o Porta Avião:");
		this.coordenada2 = entrada.nextLine();
		System.out.println("Informe a terceira coordenada em que você deseja posicionar o Porta Avião:");
		this.coordenada3 = entrada.nextLine();
		System.out.println("Informe a quarta coordenada em que você deseja posicionar o Porta Avião:");
		this.coordenada4 = entrada.nextLine();
		System.out.println("Informe a quinta coordenada em que você deseja posicionar o Porta Avião:");
		this.coordenada5 = entrada.nextLine();
		
		this.posicionadoStr = "Posicionado";
		this.posicionadoBoolean = true;
		System.out.println("o Porta Avião foi posicionado com sucesso nas coordenadas: " + coordenada1 + "," + coordenada2 + "," + coordenada3 + "," + coordenada4 + "," + coordenada5 +".");
	}
}