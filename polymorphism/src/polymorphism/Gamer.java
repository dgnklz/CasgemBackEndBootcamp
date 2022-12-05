package polymorphism;

public class Gamer extends PointCalculator{
	
	private int id;
	private String firstName;
	private String lastName;
	private String nickName;
	private String gender;
	private PointCalculator pointCalculator;
	public Gamer() {
		super();
	}
	public Gamer(int id, String firstName, String lastName, String nickName, String gender,
			PointCalculator pointCalculator) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.gender = gender;
		this.pointCalculator = pointCalculator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public PointCalculator getPointCalculator() {
		return pointCalculator;
	}
	public void setPointCalculator(PointCalculator pointCalculator) {
		this.pointCalculator = pointCalculator;
	}
	
}
