package inheritance;

public class IndividualCustomer extends Customer{
	
	private String firstNumber;
	private String lastName;
	private String nationalityId;
	
	public IndividualCustomer() {
		super();
	}
	
	public IndividualCustomer(int id, String number, String firstNumber, String lastName, String nationalityId) {
		super(id, number);
		this.firstNumber = firstNumber;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
	}

	public String getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(String firstNumber) {
		this.firstNumber = firstNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}
	
	
}
