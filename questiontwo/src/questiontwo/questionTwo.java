package questiontwo;

public class questionTwo {

	public static void main(String[] args) {
		
		int number1 = 220;
		int number2 = 284;
		
		int temp1=0;
		int temp2=0;
		
		for(int i=1; i<number1; i++) {
			if(number1 % i==0) {
				temp1 = temp1 + i;
			}
		}
		
		for(int j=1; j<number2; j++) {
			if(number2 % j == 0) {
				temp2 = temp2 +j;
			}
		}
		
		if(number1 == temp2 || number2 == temp1) {
			System.out.println(number1 + " and " +  number2 +" are friend numbers");
		}
	}

}
