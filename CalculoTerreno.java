package curso_programacao;
import java.util.Scanner;
import java.util.Locale;

public class CalculoTerreno {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a largura do terreno:");
		Double largura = sc.nextDouble();

		System.out.println("Digite o comprimento do terreno:");
		Double comprimento = sc.nextDouble();
		
		System.out.println("Digite o preco por metro quadrado do terreno:");
		Double preco = sc.nextDouble();
		
		Double area = largura * comprimento;
		Double precoTotal = preco * area;
		
		System.out.println("A area total do terreno:" + area);
		System.out.println("Preco do terreno:" + precoTotal);
		
	}
}
