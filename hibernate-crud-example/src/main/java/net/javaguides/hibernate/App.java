package net.javaguides.hibernate;


import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;

public class App {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		Student student=new Student("gayatri","khokrale","j7kje@gmail.com");
		studentDao.saveStudent(student);
		
		student.setFirstName("Gauri");
		studentDao.updateStudent(student);
		
		Student student2=studentDao.getStudentById(student.getId());
		
		List<Student> students= studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));
		
		studentDao.deleteStudent(student.getId());
		
		
		
		
	}

}
