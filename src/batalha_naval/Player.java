package batalha_naval;
import java.util.Scanner;
public class Player {
	String nome;
	//Navios
	Submarino sub1 = new Submarino();
	Submarino sub2 = new Submarino();
	Submarino sub3 = new Submarino();
	FragataPequena fragP1 = new FragataPequena();
	FragataPequena fragP2 = new FragataPequena();
	FragataMedia fragM1 = new FragataMedia();
	FragataGrande fragG1 = new FragataGrande();
	PortaAviao portaAviao = new PortaAviao();
	Scanner entrada = new Scanner(System.in);
	Scanner posicao = new Scanner(System.in);
	Scanner opcaoReposicionar = new Scanner(System.in);
	int navioSelecionado;
	int reposicionar;
	String coordenada;
	
	void posicionar() {
		System.out.println("O jogo está começando, está na hora de poscionar seus navios.");
		//Quantidade de navios, de 8 a 0
		for(int i = 8; i>0; i--) {
			System.out.println("Você têm " + i + " navios para posicionar.");
			System.out.println("Selecione o navio que você deseja posicionar");
			System.out.println("1 - Submarino 1: " + this.sub1.posicionadoStr + " | Coordenada: " + this.sub1.coordenada1);
			System.out.println("2 - Submarino 2: " + this.sub2.posicionadoStr + " | Coordenada: " + this.sub2.coordenada1);
			System.out.println("3 - Submarino 3 :" + this.sub3.posicionadoStr + " | Coordenada: " + this.sub3.coordenada1);
			System.out.println("4 - Fragata Pequena 1: " + this.fragP1.posicionadoStr 
					+ " | Coornada: " + this.fragP1.coordenada1 +","+this.fragP1.coordenada2);
			System.out.println("5 - Fragata Pequena 2: " + this.fragP2.posicionadoStr 
					+ " | Coornada: " + this.fragP2.coordenada1 +","+this.fragP2.coordenada2);
			System.out.println("6 - Fragata Média 1: " + this.fragM1.posicionadoStr 
					+ " | Coornada: " + this.fragM1.coordenada1 +","+this.fragM1.coordenada2 +","+this.fragM1.coordenada3);
			System.out.println("7 - Fragata Grande 1: " + this.fragG1.posicionadoStr 
					+ " | Coornada: " + this.fragG1.coordenada1 +","+this.fragG1.coordenada2 +","+this.fragG1.coordenada3 +","+this.fragG1.coordenada4 );
			System.out.println("8 - Porta avião 1: "+ this.portaAviao.posicionadoStr 
					+ " | Coornada: " + this.portaAviao.coordenada1 +","+this.portaAviao.coordenada2 +","+this.portaAviao.coordenada3 +","+this.portaAviao.coordenada4 +","+this.portaAviao.coordenada5);
			navioSelecionado = entrada.nextInt();
			
			if(navioSelecionado == 1) {
				if(this.sub1.posicionadoBoolean == false) {
					this.sub1.posicionar();
				}else {
					i += 1;
					System.out.println("O submarino 1 já está posicionado na coordenada: " + this.sub1.coordenada1 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("O submarino 1 foi mantidona posição " + this.sub1.coordenada1 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			} else if(navioSelecionado == 2) {
				if(this.sub2.posicionadoBoolean == false) {
					this.sub2.posicionar();
				}else {
					i += 1;
					System.out.println("O submarino 2 já está posicionado na coordenada: " + this.sub2.coordenada1 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("O submarino 2 foi mantidona posição " + this.sub2.coordenada1 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			} else if(navioSelecionado == 3) {
				if(this.sub3.posicionadoBoolean == false) {
					this.sub3.posicionar();
				}else {
					i += 1;
					System.out.println("O submarino 3 já está posicionado na coordenada: " + this.sub3.coordenada1 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("O submarino 3 foi mantidona posição " + this.sub3.coordenada1 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			} else if(navioSelecionado == 4) {
				if(this.fragP1.posicionadoBoolean == false) {
					this.fragP1.posicionar();
				}else {
					i += 1;
					System.out.println("A Fragata Pequena 1 já está posicionada na coordenada: " + this.fragP1.coordenada1
					+ "," + this.fragP1.coordenada2 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("A Fragata Pequena 1 já está posicionada na coordenada: " + this.fragP1.coordenada1
								+ "," + this.fragP1.coordenada2 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			} else if(navioSelecionado == 5) {
				if(this.fragP2.posicionadoBoolean == false) {
					this.fragP2.posicionar();
				}else {
					i += 1;
					System.out.println("A Fragata Pequena 2 já está posicionado na coordenada: " + this.fragP2.coordenada1
					+ "," + this.fragP2.coordenada2 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("A Fragata Pequena 2 já está posicionada na coordenada: " + this.fragP2.coordenada1
								+ "," + this.fragP2.coordenada2 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			}else if(navioSelecionado == 6) {
				if(this.fragM1.posicionadoBoolean == false) {
					this.fragM1.posicionar();
				}else {
					i += 1;
					System.out.println("A Fragata Média 1 já está posicionada na coordenada: " + this.fragM1.coordenada1
					+ "," + this.fragM1.coordenada2 + "," + this.fragM1.coordenada3 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("A Fragata Média 1 já está posicionada na coordenada: " + this.fragM1.coordenada1
								+ "," + this.fragM1.coordenada2 + "," + this.fragM1.coordenada3 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			}else if(navioSelecionado == 7) {
				if(this.fragG1.posicionadoBoolean == false) {
					this.fragG1.posicionar();
				}else {
					i += 1;
					System.out.println("A Fragata Grande 1 já está posicionada na coordenada: " + this.fragG1.coordenada1
					+ "," + this.fragG1.coordenada2 + "," + this.fragG1.coordenada3 + "," + this.fragG1.coordenada4 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("A Fragata Grande 1 já está posicionada na coordenada: " + this.fragG1.coordenada1
								+ "," + this.fragG1.coordenada2 + "," + this.fragG1.coordenada3 + "," + this.fragG1.coordenada4 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			}else if(navioSelecionado == 8) {
				if(this.portaAviao.posicionadoBoolean == false) {
					this.portaAviao.posicionar();
				}else {
					i += 1;
					System.out.println("O Porta Avião já está posicionado na coordenada: " + this.portaAviao.coordenada1
					+ "," + this.portaAviao.coordenada2 + "," + this.portaAviao.coordenada3 + "," + this.portaAviao.coordenada4 + "," 
					+ this.portaAviao.coordenada5 + ".");
					System.out.println("Você deseja reposicionar on navio?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					reposicionar = entrada.nextInt();
					if(reposicionar == 1) {
						this.sub1.posicionar();
					}else if(reposicionar == 2) {
						System.out.println("O Porta Avião já está posicionado na coordenada: " + this.portaAviao.coordenada1
								+ "," + this.portaAviao.coordenada2 + "," + this.portaAviao.coordenada3 + "," + this.portaAviao.coordenada4 + "," 
								+ this.portaAviao.coordenada5 + ".");
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
			}else {
				i += 1;
				System.out.println("Digite uma opção válida.");
			}
		}
	}
	
	int checkPosicoes() {
		int posicoes = 0;
		
		if(this.sub1.posicionadoBoolean == true) {
			posicoes += 1;
		}
		
		if(this.sub2.posicionadoBoolean == true) {
			posicoes +=1;
		}
		
		if(this.sub3.posicionadoBoolean == true) {
			posicoes +=1;
		}
		
		if(this.fragP1.posicionadoBoolean == true) {
			posicoes +=1;
		}
		
		if(this.fragP2.posicionadoBoolean == true) {
			posicoes +=1;
		}
		
		if(this.fragM1.posicionadoBoolean == true) {
			posicoes +=1;
		}
		
		if(this.fragG1.posicionadoBoolean == true) {
			posicoes += 1;
		}
		
		if(this.portaAviao.posicionadoBoolean == true) {
			posicoes += 1;
		}
		
		return posicoes;
	}
	
	void atacar() {
		
	}
	
	void ganhar() {
		
	}
	
	void perder() {
		
	}
}
