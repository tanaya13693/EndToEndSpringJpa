package com.tanaya.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tanaya.student.dal.entities.Student;
import com.tanaya.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testCreateSturent(){
		
		Student student = new Student();
		student.setId(1);
		student.setName("Tanaya");
		student.setCourse("Java WebService");
		student.setFee(5000);
		
		studentRepository.save(student);
		
	}
	
	@Test
	public void testFindStudentById(){
		
		Student student = studentRepository.findById(1l).get();
		System.out.println("student" + student);
		
	}
	
	@Test
	public void testUpdateStudent(){
		
		Student student = studentRepository.findById(1l).get();
		student.setFee(6000);
		studentRepository.save(student);
		
	}
	
	@Test
	public void deleteStudent(){
		
		Student student = new Student();
		student.setId(1);
		studentRepository.delete(student);
		
	}

}
