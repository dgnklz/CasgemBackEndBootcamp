package playground1;

public class Main {

	public static void main(String[] args) {
		
		String[] cities = {"Ankara", "Istanbul", "Izmir"};
		
		String newCity = "Eskisehir";
		
		String[] tempCities = cities;
		
		
		
		for (String city : cities) {
			System.out.println(city);
		}
		
		
		MyList<String> myList = new MyList<String>();
		myList.add("Ankara");
		System.out.println(myList.size());
	}

}
