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

            Query<Department> query = session.createQuery("from Department");
            List<Department> departmentList = query.list();
            departmentList.forEach(department ->  {
                System.out.print("Id: " + department.getId() + " - ");
                System.out.print("Name: " + department.getDepartmentName() + " - ");
                System.out.print("NumOfMember: " + department.getNumOfMember());
                System.out.println();
            });
        } finally {
            if (session!=null) {
                session.close();
            }
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
