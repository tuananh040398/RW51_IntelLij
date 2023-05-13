package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

//            GetAll
//            Query query = session.createQuery("FROM Teacher ");
//            List<Teacher> teachers = query.list();
//            teachers.forEach(teacher -> {
//                System.out.println(teacher.getTeacherName());
//                System.out.println(teacher.getAge());
//                System.out.println(teacher.getMajor());
//                for (Student student : teacher.getStudents()) {
//                    System.out.println(student.getStudentName());
//                    System.out.println(student.getClassName());
//                }
//            });

//            Save
//            session.beginTransaction();
//
//            Teacher teacher1 = new Teacher();
//            teacher1.setTeacherName("NTAAAA");
//
//            Student student1 = new Student();
//            student1.setStudentnName("Chiến");
//
//            Student student2 = new Student();
//            student2.setStudentnName("Chiếnnnnnnnn");
//
//            session.save(student1);
//            session.save(student2);
//
//            List<Student> students = new ArrayList<>();
//            students.add(student1);
//            students.add(student2);
//            teacher1.setStudents(students);
//            session.save(teacher1);
//
//            session.getTransaction().commit();

//            Update
//            session.beginTransaction();
//
//            Teacher teacher2 = session.get(Teacher.class, 2);
//            Student student3 = session.get(Student.class, 3);
//            Student student4 = session.get(Student.class, 4);
//            List<Student> students = new ArrayList<>();
//            students.add(student3);
//            students.add(student4);
//
//            teacher2.setStudents(students);
//            session.save(teacher2);
//
//            session.getTransaction().commit();

//            GetById
            Teacher teacher4 = session.get(Teacher.class, 4);
            if (teacher4 != null) {
                System.out.println(teacher4.getTeacherName());
                for (Student student : teacher4.getStudents()) {
                    System.out.println(student.getStudentName());
                }
            }

            Student student2 = session.get(Student.class, 2);
            if (student2 != null) {
                System.out.println(student2.getStudentName());
                for (Teacher teacher : student2.getTeachers()) {
                    System.out.println(teacher.getTeacherName());
                }
            }
        } finally {

        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Teacher.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
