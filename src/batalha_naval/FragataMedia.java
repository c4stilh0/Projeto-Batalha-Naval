package batalha_naval;
import java.util.Scanner;
public class FragataMedia {
	String nome = "Fragata Média";
	int vida = 100;
	String formato = "***";
	int numeroCanhoes = 3;
	String coordenada1 = "";
	String coordenada2 = "";
	String coordenada3 = "";
	String posicionadoStr = "Não posicionado";
	Boolean posicionadoBoolean = false;
	Scanner entrada = new Scanner(System.in);
	
	void receberDano() {
		
	}
	
	void afundar() {
		
	}
	
	void status() {
		System.out.println("A Fragata Média está com " + this.vida + " pontos de vida");
		System.out.println("A Fragata Média está posicionada na coordenada: " + this.coordenada1);
		System.out.println("A Fragata Média está posicionada na coordenada: " + this.coordenada2);
		System.out.println("A Fragata Média está posicionada na coordenada: " + this.coordenada3);
	}
	void posicionar() {
		System.out.println("Informe a primeira coordenada em que você deseja posicionar a Fragata Média:");
		this.coordenada1 = entrada.nextLine();
		System.out.println("Informe a segunda coordenada em que você deseja posicionar a Fragata Média:");
		this.coordenada2 = entrada.nextLine();
		System.out.println("Informe a terceira coordenada em que você deseja posicionar a Fragata Média:");
		this.coordenada3 = entrada.nextLine();
		
		this.posicionadoStr = "Posicionado";
		this.posicionadoBoolean = true;
		System.out.println("A Fragata Média foi posicionada com sucesso nas coordenadas: " + coordenada1 + "," + coordenada2 + "," + coordenada3 +".");
	}
}
