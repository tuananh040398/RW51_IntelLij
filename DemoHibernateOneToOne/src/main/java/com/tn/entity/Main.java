package com.tn.entity;

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

//            Query<Account> query = session.createQuery("FROM Account ");
//            List<Account> accounts = query.list();
//            System.out.println(accounts.size());
//
//            accounts.forEach(account -> {
//                System.out.println(account.getUsername());
//                if ( account.getAddress() != null ) {
//                    System.out.println(account.getAddress().getAddressName());
//                } else {
//                    System.out.println(account.getAddress());
//                }
//            });

//            Query<Address> query2 = session.createQuery("FROM Address ");
//            List<Address> addresses = query2.list();
//            System.out.println(addresses.size());

//            Tạp addr mới và acc mới
//            session.beginTransaction();
//
//            Address address1  = new Address();
//            address1.setAddressName("Hà Nội");
//            session.save(address1);
//
//            Account account1 = new Account();
//            account1.setUsername("TA");
//            account1.setAddress(address1);
//            session.save(account1);
//
//            session.getTransaction().commit();

//            Tạo acc mới dùng addr cũ
//            session.beginTransaction();
//
//            Address address2 = session.get(Address.class, 2);
//
//            Account account2 = new Account();
//            account2.setUsername("TB");
//            account2.setAddress(address2);
//            session.save(account2);
//
//            session.getTransaction().commit();

//            Udate acc đã có vào addr đã có
            session.beginTransaction();
            Account account3 = session.get(Account.class,1);
            Address address3 = session.get(Address.class, 1);
            account3.setAddress(address3);
            session.save(account3);
            session.getTransaction().commit();

        } finally {

        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
