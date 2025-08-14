package curso_programacao;
import java.util.Scanner;
import curso_programacao.CalcTriangulo;

public class TriangulosN {
	
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	CalcTriangulo x, y;
	
	x = new CalcTriangulo();
	y = new CalcTriangulo();
	
	System.out.println("Enter the measure of triangle X:");
	x.a = sc.nextDouble();
	x.b = sc.nextDouble();
	x.c = sc.nextDouble();
	
	System.out.println("Enter the measure of triangle Y:");
	y.a = sc.nextDouble();
	y.b = sc.nextDouble();
	y.c = sc.nextDouble();
	
	double p = (x.a + x.b + x.c) / 2.0;
	double areaX = Math.sqrt(p* (p - x.a) * (p - x.b) * (p - x.c));
	
	p = (y.a + y.c + y.c) / 2.0;
	double areaY = Math.sqrt(p* (p - y.a) * (p - y.b) * (p - y.c));
	
	System.out.printf("Triangle X area: %.4f%n", areaX);
	System.out.printf("Triangle Y area: %.4f%n", areaY);
	
	if(areaX > areaY ) {
		System.out.println("Larger area: X");
	}
	else{
		System.out.println("Larger area: y");
	}
	sc.close();
	}
}
