package Entities;

import java.util.Random;
import java.util.Scanner;

public class JogoForca {
	public void jogar() {
		// Lista de palavras para o jogo
	    String[] palavras = {"java", "computador", "programacao", "software", "hardware", "internet", "rede", "teclado"};
	    Random random = new Random();
	    Scanner scanner = new Scanner(System.in);

	    // Escolhe uma palavra aleatória
	    String palavraEscolhida = palavras[random.nextInt(palavras.length)];
	    char[] palavraAdivinhada = new char[palavraEscolhida.length()];
	    for (int i = 0; i < palavraAdivinhada.length; i++) {
	        palavraAdivinhada[i] = '_';
	    }

	    int tentativasRestantes = 6;
	    boolean venceu = false;

	    System.out.println("Bem-vindo ao Jogo da Forca!");
	    System.out.println("Tente adivinhar a palavra. Você tem " + tentativasRestantes + " tentativas.");

	    while (tentativasRestantes > 0 && !venceu) {
	        System.out.println("Palavra: " + new String(palavraAdivinhada));
	        System.out.print("Digite uma letra: ");
	        char palpite = scanner.next().charAt(0);

	        boolean acertou = false;
	        for (int i = 0; i < palavraEscolhida.length(); i++) {
	            if (palavraEscolhida.charAt(i) == palpite && palavraAdivinhada[i] == '_') {
	                palavraAdivinhada[i] = palpite;
	                acertou = true;
	            }
	        }

	        if (acertou) {
	            System.out.println("Boa! Você acertou uma letra.");
	        } else {
	            tentativasRestantes--;
	            System.out.println("Ops! Letra errada. Você ainda tem " + tentativasRestantes + " tentativas.");
	        }

	        // Verifica se o jogador venceu
	        venceu = true;
	        for (int i = 0; i < palavraAdivinhada.length; i++) {
	            if (palavraAdivinhada[i] == '_') {
	                venceu = false;
	                break;
	            }
	        }
	    }

	    if (venceu) {
	        System.out.println("Parabéns! Você adivinhou a palavra: " + palavraEscolhida);
	    } else {
	        System.out.println("Você perdeu! A palavra era: " + palavraEscolhida);
	    }

	    scanner.close();
	}
}
