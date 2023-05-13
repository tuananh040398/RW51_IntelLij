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

//            UpdateByName
//            session.beginTransaction();
//            Query query = session.createQuery("UPDATE Department SET numOfMember = 8 WHERE departmentName = 'sale'");
//            query.executeUpdate();
//            session.getTransaction().commit();

//            DeleteById
//            session.beginTransaction();
//            Query query = session.createQuery("DELETE FROM Department where id = 2");
//            query.executeUpdate();
//            session.getTransaction().commit();

//            GetById
//            Department department = session.get(Department.class, 3);
//            System.out.println(department.getId());
//            System.out.println(department.getDepartmentName());
//            System.out.println(department.getNumOfMember());

//            GetByName
//            Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :pDepartmentName");
//            query.setParameter("pDepartmentName", "HCNS");
//            Department department = query.uniqueResult();
//            System.out.println(department.getId());
//            System.out.println(department.getDepartmentName());
//            System.out.println(department.getNumOfMember());

//            GetAll
            Query<Department> query = session.createQuery("FROM Department");
            List<Department> departments = query.list();
            departments.forEach(department -> {
                System.out.print("Id: " + department.getId() + " - ");
                System.out.print("Name: " + department.getDepartmentName() + " - ");
                System.out.print("NumOfMember: " + department.getNumOfMember());
                System.out.println();
            });
            System.out.println("Sucess!");

        } finally {

        }

    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Department.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
