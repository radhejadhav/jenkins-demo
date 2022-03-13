package com.bootwithpgsql.daos;

import com.bootwithpgsql.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;


//    @Transactional
    public Student addStudent(Student student){

        Session session = null;

        try {

            session = this.sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(student);
            transaction.commit();

            return student;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            session.close();
        }
    }
    public List<Student> getAllStudent(){

        Session session = null;

        try {
            session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();

            List<Student> students = session.createQuery("from Student").list();

            return students;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            session.close();
        }
    }
    public Student getStudentById(long id){
        Session session =null;
        try {
            session = sessionFactory.openSession();
            Query query =  session.createQuery("from Student where id= :id");
            query.setLong("id",id);

            return (Student) query.uniqueResult();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            session.close();
        }
    }
}
