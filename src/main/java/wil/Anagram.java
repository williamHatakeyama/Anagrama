package wil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagram {
	public static List<String> palavras = new ArrayList<String>();
	//INFORME O DIRETORIO DO ARQUIVO "PALAVRAS.TXT", NÃO ESQUEÇA DE DEIXAR COM 2 BARRAS ->> \\ !!!
	public static String dir = "C:\\palavras.txt";
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		boolean Incorreto = false;
		CarregaLista();
		do {
		
		System.out.println("escreva uma palavra para pesquisar no anagrama: ");
		String palavaDigitada = ler.next().toString();
		if (palavaDigitada.matches("[a-zA-Z\\s]+") && palavaDigitada.length()<16) {
			isAnagram(palavaDigitada);
			Incorreto = false;
		} else {
			Incorreto = true;
			System.out.println("nao vale caracteres especiais, numericos e nem acentos, e menor que 16 caracteres!!!");
		}
		} while (Incorreto);

	}

	static void CarregaLista() {

		try {
			FileReader arq = new FileReader(dir);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); 
			while (linha != null) {
				palavras.add(linha);

				linha = lerArq.readLine();
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

	static void isAnagram(String s1) {

		String copyOfs1 = s1.replaceAll(" ", "");

		boolean statusTeve = false;
		boolean status = true;
		for (String string1 : palavras) {

			if (copyOfs1.length() != string1.length()) {
				status = false;
			} else {
				char[] s1Array = copyOfs1.toLowerCase().toCharArray();

				char[] s2Array = string1.toLowerCase().toCharArray();

				Arrays.sort(s1Array);

				Arrays.sort(s2Array);

				status = Arrays.equals(s1Array, s2Array);
				if (status) {
					statusTeve = true;
				}
			}
			if (status) {
				System.out.println(
						s1.toUpperCase() + " match com  " + string1.toUpperCase() + " da lista de palavras! =D");
			}
		}
		if (statusTeve == false) {
			System.out.println("lamento, mas temos anagramas com " + s1.toUpperCase() + " na nossa lista =C");
		}

	}

}
