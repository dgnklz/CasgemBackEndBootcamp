package kodlamaio;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Course> courses = new ArrayList<Course>();
		
		
		Category category1 = new Category(1, "Backend", courses);
		Category category2 = new Category(2, "Frontend", courses);
		Category category3 = new Category(3, "Mobile", courses);
		Category category4 = new Category(4, "Embeded", courses);
		Category category5 = new Category(5, "MachineLearning", courses);
		
		Instructor instructor1 = new Instructor(1, "Engin");
		Instructor instructor2 = new Instructor(2, "Ebru");
		Instructor instructor3 = new Instructor(3, "Mustafa");
		Instructor instructor4 = new Instructor(4, "Dogan");
		Instructor instructor5 = new Instructor(5, "Ahmet");
		
		Course course1 = new Course(1, "Java", 40, instructor1, category1);
		Course course2 = new Course(2, "C#", 60, instructor2, category2);
		Course course3 = new Course(3, "Python", 70, instructor3,category3);
		Course course4 = new Course(4, "C++", 75, instructor4,category4);
		Course course5 = new Course(5, "Pascal", 15, instructor5,category5);
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
		courses.add(course5);
		
		
		for (Course course : courses) {
			System.out.println(course.getCategory().getName());
		}
		
	}

}
