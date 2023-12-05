package facul;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String namePlayer1, namePlayer2;
		int opcaoMenuInicial;
		
		
		while(true){
			Boolean jogoRodando = true;//Declarada aqui para quando sair do loop de fim do jogo ser possível inciar novamente
			opcaoMenuInicial = menuInicial();
			
			if(opcaoMenuInicial == 1) {			
				
				System.out.println("Digite o nome do jogador 1:");
				namePlayer1 = entrada.nextLine();
				String[][] tabuleiroPlayer1 = criarTabuleiro(10);
				String [][] tabuleiroAtaquePlayer1 = criarTabuleiro(10);
				menuJogador(namePlayer1, tabuleiroPlayer1);
				
				
				System.out.println("Digite o nome do jogador 2:");
				namePlayer2 = entrada.nextLine();
				String[][] tabuleiroPlayer2 = criarTabuleiro(10);
				String [][] tabuleiroAtaquePlayer2 = criarTabuleiro(10);
				menuJogador(namePlayer2, tabuleiroPlayer2);
				
				System.out.println();
				System.out.println("O jogo está iniciando!");
				System.out.println();
				
				while(jogoRodando == true) {
					if(verificaFimJogo(tabuleiroPlayer2) == true) {
						System.out.println();
						System.out.println("Parábens "+ namePlayer1 + " você venceu essa batalha!");
						jogoRodando = false;
						break;
					}	
					for(int i = 0; i < 3; i++) {						
						atacar(tabuleiroAtaquePlayer1,tabuleiroPlayer2, tabuleiroPlayer1, namePlayer1);
						if(verificaFimJogo(tabuleiroPlayer2) == true) {
							System.out.println();
							System.out.println("Parábens "+ namePlayer1 + " você venceu essa batalha!");
							jogoRodando = false;
							break;
						}
					}
					
					if(verificaFimJogo(tabuleiroPlayer1) == true) {
						System.out.println();
						System.out.println("Parábens "+ namePlayer2 + " você venceu essa batalha!");
						jogoRodando = false;
						break;
					}
					
					for(int i = 0; i < 3; i++) {
						atacar(tabuleiroAtaquePlayer2,tabuleiroPlayer1,tabuleiroPlayer2, namePlayer2);
						if(verificaFimJogo(tabuleiroPlayer1) == true) {
							System.out.println();
							System.out.println("Parábens "+ namePlayer2 + " você venceu essa batalha!");
							jogoRodando = false;
							break;
						}
					}
					
				}
				
			}else if(opcaoMenuInicial == 2) {
				verRegras();
			}else if(opcaoMenuInicial == 3) {
				System.out.println("Obrigado por jogar! Estamos te aguardando para a próxima batalha naval!");
				break;
			}else {
				if(opcaoMenuInicial <= 0 || opcaoMenuInicial > 3) {
					System.out.println("Digite uma opção válida! Entre 1 e 3");
					System.out.println();
				}
			}
			
			
		}
	}
	
	public static int menuInicial() {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		
		System.out.println("Bem vindo à Batalha Naval - A3 - 2/2023");
		System.out.println();
		System.out.println("Menu Inicial");
		System.out.println("	1 - Jogar");
		System.out.println("	2 - Regras/Como Jogar");
		System.out.println("	3 - Sair");	
		System.out.println();
		System.out.println("Escolha uma opção");
		return opcao = entrada.nextInt();
	}
	
	public static void menuJogador(String nome, String [][] tabuleiro) {
		Scanner entrada = new Scanner(System.in); //Entrada de dados
		int opcao;//Armazena a opcao do menu
		int opcaoNavio; //Armazena a opcao do menu de posicao dos navios
		int tamanho = 0 ;//Inicia a var de tamanho dos navios, 
		int linha = 0; //Inicia a var de linhas
		Boolean linhaOK = false;
		int coluna = 0; //Inicia a var de colunas;
		Boolean colunaOK = false;
		String navio = "",nomeNavio = "", linhaTabuleiro, colunaTabuleiro;
		String navioPosicionado;
		String posicaoSub1 = "Não posicionado", posicaoSub2 = "Não posicionado", posicaoSub3 = "Não posicionado";
		String posicaoFragataP1 = "Não posicionado", posicaoFragataP2 = "Não posicionado";
		String posicaoFragataM1 = "Não posicionado", posicaoFragataG1 = "Não posicionado";
		String posicaoPortaA1 = "Não posicionado";
		
		while(true) {
			System.out.println("Bem vindo, " + nome + ".Seleciona uma opção abaixo:");
			System.out.println();
			System.out.println("	1 - Posicionar navios;");
			System.out.println("	2 - Regras/Como Jogar;");
			System.out.println("	3 - Pronto para iniciar");
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				verTabuleiro(tabuleiro);
				for(int i = 8; i > 0; i--) {
				
					System.out.println();
					System.out.println("Você têm " + i + " navios para posicionar.");
					System.out.println();
					System.out.println("	1-Submarino 1 - " + posicaoSub1);
					System.out.println("	2-Submarino 2 - " + posicaoSub2);
					System.out.println("	3-Submarino 3 - " + posicaoSub3);
					System.out.println("	4-Fragata Pequena 1 - " + posicaoFragataP1);
					System.out.println("	5-Fragata Pequena 2 - " + posicaoFragataP2);
					System.out.println("	6-Fragata Média - "+ posicaoFragataM1);
					System.out.println("	7-Fragata Grande - "+ posicaoFragataG1);
					System.out.println("	8-Porta Aviões - " + posicaoPortaA1);
					System.out.println("	9-Retornar ao menu anterior");
					System.out.println();
					System.out.println("Selecione o navio que você deseja posicionar");
					opcaoNavio = entrada.nextInt();
					
					if(opcaoNavio <= 0 || opcaoNavio > 9) {
						System.out.println();
						System.out.println("Digite uma opção válida! Entre 1 e 8");
						i = i + 1;
					}
					
					//Verificar qual navio vai ser selecionado
					if(opcaoNavio == 1) { 
						
						navio = "SUB1|";
						tamanho = 1;
						nomeNavio = "submarino";
						if(posicaoSub1 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
					
						}
						//Define o navio selecionado como posicionado
						posicaoSub1 = "Posicionado";
					}else if(opcaoNavio == 2) { 
						
						navio = "SUB2|";
						tamanho = 1;
						nomeNavio = "submarino";
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						if(posicaoSub2 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoSub2 = "Posicionado";
					}else if(opcaoNavio == 3) { 
						
						navio = "SUB3|";
						tamanho = 1;
						nomeNavio = "submarino";
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						if(posicaoSub3 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoSub3 = "Posicionado";
					}else if(opcaoNavio == 4) { 						
				
						navio = "FGP4|";
						tamanho = 2;
						nomeNavio = "fragata pequena";
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						if(posicaoFragataP1 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoFragataP1 = "Posicionado";
					}else if(opcaoNavio == 5) { 				
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						navio = "FGP5|";
						tamanho = 2;
						nomeNavio = "fragata pequena";
						if(posicaoFragataP2 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoFragataP2 = "Posicionado";
					}else if(opcaoNavio == 6) {
						
						navio = "FGM6|";
						tamanho = 3;
						nomeNavio = "fragata média";
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						if(posicaoFragataM1 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoFragataM1 = "Posicionado";
					}else if(opcaoNavio == 7) {
		
						navio = "FGG7|";
						tamanho = 4;
						nomeNavio = "fragata grande";
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						if(posicaoFragataG1 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoFragataG1 = "Posicionado";
					}else if(opcaoNavio == 8) {
						
						navio = "PTA8|";
						tamanho = 5;
						nomeNavio = "porta aviões";
						//Checka se o navio já está posicionado para não subtrair um número na quantidade de navios
						if(posicaoPortaA1 == "Posicionado") {
							i = i + 1;
							for (int a = 0; a < 10; a++) {
					            for (int b = 0; b < 10; b++) {
					            	navioPosicionado = tabuleiro[a][b];
					            	if (navioPosicionado == navio) {
					            		tabuleiro[a][b] = " ~~ |"; //Limpa a posição antiga do navio
					                }
					            }
							}
						}
						//Define o navio selecionado como posicionado
						posicaoPortaA1 = "Posicionado";
					}else if(opcaoNavio == 9) {
						break;
					}
					
					//Lógica para definir as coordenadas(linhas e colunas do navio)
					for(int x = 0; x < tamanho; x++) {
						System.out.println("O navio "+ nomeNavio + " ocupa o espaço de: " + tamanho + " casas.");
						
						//Estrutura de repetição que só encerrada quando é digitado uma posição não ocupada
						while(true){
							
							while(true){
								System.out.println("Informe o número da linha da coordenada número "+ (x+1) + " do navio " + nomeNavio + ":");
								linha = entrada.nextInt();
								if(linha >= 0 && linha < 10) {
									linhaOK = true;
									break;
								}
								System.out.println();
								System.out.println("Digite uma opção válida!");
							}
						
							
							while(true) {
								System.out.println("Informe o número da coluna da coordenada número "+ (x+1) + " do navio " + nomeNavio + ":");
								coluna = entrada.nextInt();
								if(coluna >= 0 && coluna < 10) {
									colunaOK = true;
									break;
								}
								System.out.println();
								System.out.println("Digite uma opção válida!");
							}
							 
							//Checka se as coordendas estão com água
							if(tabuleiro[linha][coluna] == " ~~ |") {
								break;
							}else {
								System.out.println("Digite uma coordenada válida! A coordenada já está ocupada por outro navio");
							
							}
						}
						tabuleiro[linha][coluna] = navio;
					}

			        // Imprimir o tabuleiro de ataque
			        System.out.println("================ Tabuleiro de " + nome +" ================");
			        verTabuleiro(tabuleiro);
				}
			}else if(opcao == 2) {
						verRegras();
			}else if(opcao == 3) {
				while(true) {
					if(posicaoSub1 == "Posicionado" && posicaoSub2 == "Posicionado" && posicaoSub3 == "Posicionado" &&
							posicaoFragataP1 == "Posicionado" && posicaoFragataP2 == "Posicionado" && 
							posicaoFragataM1 == "Posicionado" && posicaoFragataG1 == "Posicionado" &&
							posicaoPortaA1 == "Posicionado") 
					{
						System.out.println("O jogo já irá começar! Aguarde o jogador 2, posicionar seus navios");
						return;
					}
					System.out.println("Você não posicionou todos os navios. Primeiro posicione os navios para iniciar o jogo.");
					break;
				}
				
			}else{
				System.out.println("O opção selecionada: " + opcao	+" não existe ou não é válida. Digite uma opção válida");	
			}
		}
	}
	public static void verRegras() {
		System.out.println(
		"Regras e Como jogar:" 
				+"\n O tabuleiro tem o tamanho de 10x10, sendo:"
				+"\n    - O eixo vertical formado por números de '0 a 9';"
				+"\n    - O eixo horizontal formado por letras de '0 a 9';"
				+"\n    - A junção de número e letra, forma uma coordenada. Exemplo: linha 1| coluna 9."
				+"\n"
				+"\n Cada jogador conta com a seguinte lista de navios que deverão ser posicionados no tabuleiro:"
				+"\n     - 3 submarino(s), cada submarino tem 1 canhão;"
				+"\n     - 2 fragata(s) pequena(s), cada fragata pequena tem 2 canhões;"
				+"\n     - 1 fragata(s) média(s), cada fragata média tem 3 canhões;"
				+"\n     - 1 fragata(s) grande(s), cada fragata grande tem 4 canhões;"
				+"\n     - 1 porta aviões, o porta aviões tem 5 canhões."
				+"\n Para que um navio seja considerado afundado, é necessário que todos os canhoões do navio, sejam destruídos."
				+"\n"
				+"\n Todos os navios deverão ser posicionados no tabuleiro seguindo as seguintes regras:"
				+"\n     - Os navios não podem, em nenhuma hipótese se sobreporem;"
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
	public static String[][] criarTabuleiro(int tamanho) {
        String[][] tabuleiro = new String[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
        	
            for (int x = 0; x < tamanho; x++) {
            	
                tabuleiro[i][x] = " ~~ |"; 
            }
        }
        return tabuleiro;
    }
	
	 public static void verTabuleiro(String[][] tabuleiro) {
		 	System.out.print("  ");
	        for (int i = 0; i < tabuleiro.length; i++) {
	        	System.out.print("  " + i + "  ");
	        }
	        System.out.println();
	        for (int i = 0; i < tabuleiro.length; i++) {
	            System.out.print(i + " ");
	            for (int x = 0; x < tabuleiro[i].length; x++) {
	                System.out.print(tabuleiro[i][x]);
	            }
	            System.out.println();
	        }
	        System.out.println();
	        System.out.println("Legenda Navios: SUB > Submarino | FGP > Fragata Pequena | FGM > Fragata Média | FGG > Fraga Grande | PTA > Porta Avião");
	        System.out.println("Legenda Tabuleio: ~~ > Água | OO > Tiro na água | XX > Navio atingido ou afundado ");
	        System.out.println();
	    }
	 
	 public static void atacar(String[][] tabuleiroAtaques, String[][] tabuleiroAdversario, String[][] tabuleiroJogador, String nome) {
		 	Scanner entrada = new Scanner(System.in); //Entrada de dados
		 	Boolean navioAtivo = true;
		 	int linhaAtaque, colunaAtaque;
		 	 System.out.println();
	        System.out.println(nome + ", é sua vez de atacar!");
	        // Perguntar ao jogador onde ele quer atacar
	       
	        while(true) {
	        	System.out.print("Informe a linha para o ataque: ");
	 	        linhaAtaque = entrada.nextInt();
		        if(linhaAtaque >= 0 && linhaAtaque < 10) {
					break;
				}
		        System.out.println();
				System.out.println("Digite uma linha para atacar válida!");
	        }

	        while(true) {
	        	System.out.print("Informe a coluna para o ataque: ");
	        	colunaAtaque = entrada.nextInt();
		        if(colunaAtaque >= 0 && colunaAtaque < 10) {
					break;
				}
		        System.out.println();
				System.out.println("Digite uma coluna para atacar válida!");
	        }
	        
	        

	        //Marca o tabuleiro de ataque e o tabuleiro do adversário 
	        
	        if(tabuleiroAdversario[linhaAtaque][colunaAtaque] == " ~~ |") {
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " OO |"; 
	            tabuleiroAdversario[linhaAtaque][colunaAtaque] = " OO |"; 
	        	System.out.println();
	            System.out.println("Esse ataque acertou a água!");
	            System.out.println();
	        }else if (
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] == "SUB1|" || tabuleiroAdversario[linhaAtaque][colunaAtaque] == "SUB2|" || tabuleiroAdversario[linhaAtaque][colunaAtaque] == "SUB3|") {
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " XX |"; 
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] = " XX |";
        		
	        	System.out.println();
        		System.out.println("Esse ataque afundou um navio adversário!");
        		System.out.println();
	            
	        }else if(tabuleiroAdversario[linhaAtaque][colunaAtaque] == "FGP4|"){
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " XX |"; 
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] = " XX |";
        		
        		for (int a = 0; a < 10; a++) {
		            for (int b = 0; b < 10; b++) {
		            	if (tabuleiroAdversario[a][b] == "FGP4|") {
		            		navioAtivo = true;
		            		break;
		                }else {
		                	navioAtivo = false;
		                }
		            }
				}
        		if(navioAtivo == false) {
            		System.out.println();
            		System.out.println("Esse ataque afundou um navio adversário!");
            		System.out.println();
        		}
        		if(navioAtivo == true) {
	            	System.out.println();
    	            System.out.println("Esse ataque acertou um navio!");
    	            System.out.println();
	            }
        	
	        	
	        }else if(tabuleiroAdversario[linhaAtaque][colunaAtaque] == "FGP5|"){
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " XX |"; 
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] = " XX |";
        		
        		for (int a = 0; a < 10; a++) {
		            for (int b = 0; b < 10; b++) {
		            	if (tabuleiroAdversario[a][b] == "FGP5|") {
		            		navioAtivo = true;
		            		break;
		                }else {
		                	navioAtivo = false;
		                }
		            }
				}
        		if(navioAtivo == false) {
            		System.out.println();
            		System.out.println("Esse ataque afundou um navio adversário!");
            		System.out.println();
        		}
        		if(navioAtivo == true) {
	            	System.out.println();
    	            System.out.println("Esse ataque acertou um navio!");
    	            System.out.println();
	            }
	        }else if(tabuleiroAdversario[linhaAtaque][colunaAtaque] == "FGM6|"){
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " XX |"; 
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] = " XX |";
        		
        		for (int a = 0; a < 10; a++) {
		            for (int b = 0; b < 10; b++) {
		            	if (tabuleiroAdversario[a][b] == "FGM6|") {
		            		navioAtivo = true;
		            		break;
		                }else {
		                	navioAtivo = false;
		                }
		            }
				}
        		if(navioAtivo == false) {
            		System.out.println();
            		System.out.println("Esse ataque afundou um navio adversário!");
            		System.out.println();
        		}
        		if(navioAtivo == true) {
	            	System.out.println();
    	            System.out.println("Esse ataque acertou um navio!");
    	            System.out.println();
	            }
	        }else if(tabuleiroAdversario[linhaAtaque][colunaAtaque] == "FGG7|"){
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " XX |"; 
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] = " XX |";
        		
        		for (int a = 0; a < 10; a++) {
		            for (int b = 0; b < 10; b++) {
		            	if (tabuleiroAdversario[a][b] == "FGG7|") {
		            		navioAtivo = true;
		            		break;
		                }else {
		                	navioAtivo = false;
		                }
		            }
				}
        		if(navioAtivo == false) {
            		System.out.println();
            		System.out.println("Esse ataque afundou um navio adversário!");
            		System.out.println();
        		}
        		if(navioAtivo == true) {
	            	System.out.println();
    	            System.out.println("Esse ataque acertou um navio!");
    	            System.out.println();
	            }
	        }else if(tabuleiroAdversario[linhaAtaque][colunaAtaque] == "PTA8|"){
	        	tabuleiroAtaques[linhaAtaque][colunaAtaque] = " XX |"; 
        		tabuleiroAdversario[linhaAtaque][colunaAtaque] = " XX |";
        		
        		for (int a = 0; a < 10; a++) {
		            for (int b = 0; b < 10; b++) {
		            	if (tabuleiroAdversario[a][b] == "PTA8|") {
		            		navioAtivo = true;
		            		break;
		                }else {
		                	navioAtivo = false;
		                }
		            }
				}
        		if(navioAtivo == false) {
            		System.out.println();
            		System.out.println("Esse ataque afundou um navio adversário!");
            		System.out.println();
        		}
        		if(navioAtivo == true) {
	            	System.out.println();
    	            System.out.println("Esse ataque acertou um navio!");
    	            System.out.println();
	            }
	        }
			System.out.println("===== " + nome + ", este é o seu tabuleiro de ataques ======");
	        verTabuleiro(tabuleiroAtaques);
	        
	        System.out.println("===== " + nome + ", este é o seu tabuleiro de navios ======");
	        verTabuleiro(tabuleiroJogador);
	    }
	 
	 public static boolean verificaFimJogo(String[][] tabuleiro) {
	        for (int i = 0; i < tabuleiro.length; i++) {
	            for (int x = 0; x < tabuleiro[i].length; x++) {
	                if (
	                		tabuleiro[i][x] == "SUB1|" ||
	        				tabuleiro[i][x] == "SUB2|" ||
    						tabuleiro[i][x] == "SUB3|" ||
							tabuleiro[i][x] == "FGP4|" ||
							tabuleiro[i][x] == "FGP5|" ||
							tabuleiro[i][x] == "FGM6|" ||
							tabuleiro[i][x] == "FGG7|" ||
							tabuleiro[i][x] == "PTA8|"
                		) {
	                    return false; //Navios ainda ativos no tabuleiro
	                }
	            }
	        }
	        return true; // Nenhum navio ativo no tabuleiro
	    }
}
