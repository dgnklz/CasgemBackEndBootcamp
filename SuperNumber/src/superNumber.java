
public class superNumber {

	public static void main(String[] args) {
		int temp=0;
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					temp = temp + j;
				}
			}
			if(temp == i*2) {
				System.out.println(i);
			}
			temp = 0;
		}
	}

}