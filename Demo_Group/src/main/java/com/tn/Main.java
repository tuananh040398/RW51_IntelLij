package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.sql.Array;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

//            GetByName
//            Query<Group> query = session.createQuery("FROM Group Where groupName = :pGroupName");
//            query.setParameter("pGroupName", "group3");
//            Group group = query.uniqueResult();
//            System.out.println(group.getId());
//            System.out.println(group.getGroupName());
//            if (group == null) {
//                System.out.println("Group khong ton tai");
//            } else {
//                System.out.println(group.getGroupName());
//            }




            System.out.println("Sucess!");

        } finally {

        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Group.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
