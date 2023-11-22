package batalha_naval;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Scanner nome = new Scanner(System.in);
		int opcaoMenuInicial, opcaoJogar, posicoes;
		Player player1 = new Player();
		Player player2 = new Player();
		String nomePlayer1 = "", nomePlayer2 = "";
	
		while(true){
			System.out.println("Boas vindas à Batalha Naval - ALB");
			System.out.println("Menu Inicial");
			System.out.println("1 - Jogar");
			System.out.println("2 - Regras/Como Jogar");
			System.out.println("3 - Sair");	
			System.out.println("Digite o número de uma das opções acima.");
			opcaoMenuInicial = entrada.nextInt();
			
			if(opcaoMenuInicial == 1) {
				System.out.println("Digite o nome do jogador 1:");
				nomePlayer1 = nome.nextLine();
				player1.nome = nomePlayer1;
				while(true) {
					System.out.println("Bem vindo, " + nomePlayer1 + ". Selecione uma das opções abaixo:");
					System.out.println("1 - Posicionar navios;");
					System.out.println("2 - Regras/Como Jogar;");
					System.out.println("3 - Pronto para iniciar");
					opcaoJogar = entrada.nextInt();
				
					if(opcaoJogar == 1) {
						player1.posicionar();
					}else if(opcaoJogar == 2) {
						regra();
					}else if(opcaoJogar == 3) {
						//Check se todos os navios estão posicionados
						posicoes = player1.checkPosicoes();
						if( posicoes == 8) {
							System.out.println("Pronto! Aguarde o jogador 2 posicionar seus navios");
							System.out.println("O jogo começará em breve!");
							break;
						}else {
							System.out.println("Você ainda não posicionou todos os navios. Posicione todos os navios para continuarmos!");
						}
						
					}else {
						System.out.println("Digite uma opção válida");
					}
				}
				
				System.out.println("Digite o nome do jogador 2:");
				nomePlayer2 = nome.nextLine();
				player2.nome = nomePlayer2;
				System.out.println("1-Posicionar navios;");
				System.out.println("2-Reposicionar navios;");
				System.out.println("3-Pronto para iniciar");
				opcaoJogar = entrada.nextInt();
				
				//player2.posicionar();
				
			}else if(opcaoMenuInicial ==2) {
				regra();
			}else if(opcaoMenuInicial == 3) {
				
			}else{
				System.out.println("O opção selecionada: " + opcaoMenuInicial 
						+" não existe ou não é válida. Digite uma opção válida");	
			}
			
		}
		
	}
	
	public static void regra(){
		System.out.println(
		"Regras e Como jogar:" 
		+"\n O tabuleiro tem o tamanho de 10x10, sendo:"
		+"\n    - O eixo vertical formado por números de '0 a 10';"
		+"\n    - O eixo horizontal formado por letras de 'A a J';"
		+"\n    - A junção de número e letra, forma uma coordenada. Exemplo: 1A, 6F,9G."
		+"\n"
		+"\n Cada jogador conta com a seguinte lista de navios que deverão ser posicionados no tabuleiro:"
		+"\n     - 3 submarino(s), cada submarino tem 1 canhão;"
		+"\n     - 2 fragata(s) pequena(s), cada fragata pequena tem 2 canhões;"
		+"\n     - 1 fragata(s) média(s), cada fragata média tem 3 canhões;"
		+"\n     - 1 fragata(s) grande(s), cada fragata grande tem 4 canhões;"
		+"\n     - 1 porta aviões, o porta aviões tem 5 canhões."
		+"\n Para que um navio seja considerado afundado, é necessário que todos os canhões do navio, sejam destruídos."
		+"\n"
		+"\n Todos os navios deverão ser posicionados no tabuleiro seguindo as seguintes regras:"
		+"\n     - Os navios só podem ser posicionados na vertical ou na horizontal;"
		+"\n     - Os navios não podem, em nenhuma hipótese se sobreporem;"
		+"\n     - Os navios não podem ser posicionados encostados uns aos outros, ou seja, deverão ter, no mínimo, 1 coordenada de distância entre si."
		+"\n"
		+"\n Cada jogador tem por rodada 3 tiros, o jogador deverá informar a coordenada de cada tiro."
		+"\n Toda vez que o jogador atirar em uma coordenada, será informado se o tiro acertou:"
		+"\n    - A água, ou seja, não acertou nenhum navio;"
		+"\n    - Se afundou um navio, ou seja, o tiro afundou um navio mas não será informado de qual tipo;"
		+"\n    - Se o tiro atingiu um alvo."
		+"\n"
		+"Vence o jogador que conseguir afundar todos os navios do adversário primeiro. "
		+"\n Bom jogo!"
		);
		
	}
}
