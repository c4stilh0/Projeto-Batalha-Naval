package batalha_naval;

import java.util.Scanner;

public class FragataPequena {
	String nome = "Fragata Pequena";
	int vida = 100;
	String formato = "***";
	int numeroCanhoes = 2;
	String coordenada1 = "";
	String coordenada2 = "";
	String posicionadoStr = "Não posicionado";
	Boolean posicionadoBoolean = false;
	Scanner entrada = new Scanner(System.in);
	
	void receberDano() {
		
	}
	
	void afundar() {
		
	}
	
	void status() {
		System.out.println("A Fragata Pequena está com " + this.vida + " pontos de vida");
		System.out.println("A Fragata Pequena está posicionada na coordenada: " + this.coordenada1);
		System.out.println("A Fragata Pequena está posicionada na coordenada: " + this.coordenada2);
	}
	void posicionar() {
		System.out.println("Informe a primeira coordenada em que você deseja posicionar a Fragata Pequena:");
		this.coordenada1 = entrada.nextLine();
		System.out.println("Informe a segunda coordenada em que você deseja posicionar a Fragata Pequena:");
		this.coordenada2 = entrada.nextLine();
		
		this.posicionadoStr = "Posicionado";
		this.posicionadoBoolean = true;
		System.out.println("A Fragata Pequena foi posicionada com sucesso nas coordenadas: " + coordenada1 + "," + coordenada2 +".");
	}
}
