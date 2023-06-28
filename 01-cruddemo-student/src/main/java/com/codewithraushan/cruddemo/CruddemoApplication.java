package com.codewithraushan.cruddemo;

import com.codewithraushan.cruddemo.dao.StudentDao;
import com.codewithraushan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
//			createStudent(studentDao);
			createMultipleStudent(studentDao);
		};
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
