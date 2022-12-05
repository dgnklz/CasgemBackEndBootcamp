package polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		WomenPointCalculator womenPointCalculator = new WomenPointCalculator();
		MenPointCalculator menPointCalculator = new MenPointCalculator();
		
		Gamer gamer1 = new Gamer();
		gamer1.setId(1);
		gamer1.setFirstName("Engin");
		gamer1.setLastName("Demirog");
		gamer1.setGender("M");
		gamer1.setNickName("Qorqusuz");
		gamer1.setPointCalculator(menPointCalculator);
		
		Gamer gamer2 = new Gamer();
		gamer2.setId(2);
		gamer2.setFirstName("Berna");
		gamer2.setLastName("Ozgen");
		gamer2.setGender("F");
		gamer2.setNickName("Iddiali");
		gamer2.setPointCalculator(womenPointCalculator);
		
		List<Gamer> gamers = new ArrayList<Gamer>();
		gamers.add(gamer1);
		gamers.add(gamer2);
		
		for (Gamer gamer : gamers) {
			System.out.print(gamer.getFirstName() + " : ");
			System.out.print(gamer.getGender() + " : ");
			gamer.getPointCalculator().calculate(10, 5);
		}
		
	}

}
