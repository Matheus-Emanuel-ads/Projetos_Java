package curso_programacao;

public class CalcTriangulo {

	public double a, b, c;
	
	public double area(){
		double p = (a + b + c) / 2.0;
		return Math.sqrt(p* (p - a) * (p - b) * (p - c));
		
	}
	

}
