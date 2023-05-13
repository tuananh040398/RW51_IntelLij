package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


public class main {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();


//            AddData
//            session.beginTransaction();
//
//            Student student = new Student();
//            student.setStudentName("Nam");
//
//            session.save(student);
//
//            session.getTransaction().commit();


//            GetData
//            Query<Student> query = session.createQuery("FROM Student");
//            List<Student> students = query.list();
//            students.forEach(student ->  {
//                System.out.println(student.getStudentName());
//            });

//            GetById
//            Student student = session.get(Student.class, 2);
//            System.out.println(student.getId());
//            System.out.println(student.getStudentName());

//            GetByName
//            Query<Student> query = session.createQuery("FROM Student Where studentName = :pStudentName");
//            query.setParameter("pStudentName", "t3");
//            Student student = query.uniqueResult();
//            System.out.println(student.getId());
//            System.out.println(student.getStudentName());

//            UpdateNameById
//            session.beginTransaction();
//            Query query = session.createQuery("UPDATE Student SET studentName = 't50' WHERE id = 1");
//            query.executeUpdate();
//            session.getTransaction().commit();

//            DeleteById
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Student where id = 3");
            query.executeUpdate();
            session.getTransaction().commit();

            System.out.println("Sucess!");

        } finally {

        }
    }
    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Student.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

}
