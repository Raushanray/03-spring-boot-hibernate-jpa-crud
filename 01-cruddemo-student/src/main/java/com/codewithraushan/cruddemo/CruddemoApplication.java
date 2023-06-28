package com.codewithraushan.cruddemo;

import com.codewithraushan.cruddemo.dao.StudentDao;
import com.codewithraushan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	/*@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{
			System.out.println("Hello World");
		};
	}*/

	/*@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
//			createStudent(studentDao);
			createMultipleStudent(studentDao);
		};
	}*/

	/*@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			readStudent(studentDao);
		};
	}*/

/*	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			queryForStudents(studentDao);
		};
	}*/

	/*@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			queryForStudentsByLastName(studentDao);
		};
	}*/

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			updateStudent(studentDao);
		};
	}

	private void updateStudent(StudentDao studentDao) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting the student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);
		//change the firstname  "Ravi" to "Rahul"
		System.out.println("updating student ...");
		myStudent.setFirstName("Rahul");

		//update the student
		studentDao.update(myStudent);

		//display the updated student
		System.out.println("updated student : " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		//get a list of Students
		List<Student> theStudents = studentDao.findByLastName("Ranjan");
		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of student
		List<Student> theStudents = studentDao.findAll();
		//display list of student
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object

		System.out.println("creating new student object.......");
		Student tempStudent = new Student("Raman","Kumar","raman@gmail.com");

		//save the student
		System.out.println("saving the student object...");
		studentDao.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student.generated id: " + theId);

		//retrieve the student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDao.findById(theId);

		//display student
		System.out.println("Found the Student: " + myStudent);

	}

	private void createMultipleStudent(StudentDao studentDao) {

		//create multiple student
		System.out.println("creating 3 student object.......");
		Student tempStudent1 = new Student("Rahul","Kumar","rahul@gmail.com");
		Student tempStudent2 = new Student("Sumit","Kumar","sumit@gmail.com");
		Student tempStudent3 = new Student("Rashi","Kumari","rashi@gmail.com");

		//save the student object
		System.out.println("saving the student object...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDao studentDao) {

		//create the student object
		System.out.println("creating new student object.......");
		Student tempStudent = new Student("Ravi","Ranjan","ravi@gmail.com");

		//save the student object
		System.out.println("saving the student object...");
		studentDao.save(tempStudent);

		//display id of the saved object
		System.out.println("saved student. Generated Id: " + tempStudent.getId());
	}
}
