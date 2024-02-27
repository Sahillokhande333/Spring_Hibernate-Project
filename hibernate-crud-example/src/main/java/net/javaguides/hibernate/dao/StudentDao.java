package net.javaguides.hibernate.dao;
import org.hibernate.Session;
//other imports for Hibernate


import org.hibernate.Transaction;

import java.util.List;

import javax.transaction.Transactional;



import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class StudentDao {

	public void saveStudent(Student student)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			/* Start the transaction */
			transaction=session.beginTransaction();
			
			session.save(student);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction !=null)
			{
				transaction.rollback();
			}
		}
	}
	
	
	public void updateStudent(Student student)
	{
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			/* Start the transaction */
			transaction=session.beginTransaction();
			
			session.saveOrUpdate(student);
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction !=null)
			{
				transaction.rollback();
			}
		}
	}
	
	
	public Student getStudentById(long id)
	{
		Transaction transaction=null;
		Student student=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			/* Start the transaction */
			transaction=session.beginTransaction();
			
		student=session.get(Student.class,id);
		/* student=session.load(Student.class,id); */
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction !=null)
			{
				transaction.rollback();
			}
		}
		return student;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents()
	{
		Transaction transaction=null;
		List<Student>students=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			/* Start the transaction */
			transaction=session.beginTransaction();
			
		students=session.createQuery("from student").list();
			
			transaction.commit();
		}catch (Exception e) {
			if(transaction !=null)
			{
				transaction.rollback();
			}
		}
		return students;
	}


public void deleteStudent(long id)
{
	Transaction transaction=null;
	Student student=null;
	try(Session session=HibernateUtil.getSessionFactory().openSession()){
		/* Start the transaction */
		transaction=session.beginTransaction();
		
	student=session.get(Student.class,id);
	session.delete(student);
		
		transaction.commit();
	}catch (Exception e) {
		if(transaction !=null)
		{
			transaction.rollback();
		}
	}
}
}
