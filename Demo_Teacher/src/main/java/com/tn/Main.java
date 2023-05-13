package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

//            GetAll
//            Query < Teacher > query = session.createQuery("FROM Teacher ");
//            List<Teacher> teachers = query.list();
//            teachers.forEach(teacher -> {
//                System.out.print("Id: " + teacher.getId() + " - ");
//                System.out.print("Name: " + teacher.getTeacherName() + " - ");
//                System.out.print("Address: " + teacher.getAddress() + " - ");
//                System.out.print("Age: " + teacher.getAge());
//                System.out.println();
//            });

//          AddTeacher
//            session.beginTransaction();
//            Teacher teacher1 = new Teacher(3, "Chu Minh Quang", "Hải Dương", (short) 250);
//            session.save(teacher1);
//            session.getTransaction().commit();

//            DeleteTeacherById
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Teacher WHERE id = 2");
            query.executeUpdate();
            session.getTransaction().commit();

        } finally {

        }
    }


    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Teacher.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}


