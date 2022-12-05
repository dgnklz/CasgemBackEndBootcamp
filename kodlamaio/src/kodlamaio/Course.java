package kodlamaio;

public class Course {
	int id;
	String name;
	int progress;
	private Instructor instructor;
	private Category category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Course(int id, String name, int progress, Instructor instructor, Category category) {
		this();
		this.id = id;
		this.name = name;
		this.progress = progress;
		this.instructor= instructor;
		this.category = category;
		
	}
	public Course() {
		instructor = new Instructor();
		category = new Category();
	}
}
