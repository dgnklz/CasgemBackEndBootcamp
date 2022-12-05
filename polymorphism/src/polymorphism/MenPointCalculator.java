package polymorphism;

public class MenPointCalculator extends Gamer{
	
	@Override
	public void calculate(int hits, int failures) {
		System.out.println("Women's point calculator : " + ((hits - failures) *10 + 100));
		
	}
	
}
