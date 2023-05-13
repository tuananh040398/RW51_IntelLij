package com.tn.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

//            GetData
//            Query<Country> query = session.createQuery("FROM Country ");
//            List<Country> countries = query.list();
//            countries.forEach(country -> {
//                System.out.println(country.getId());
//                System.out.println(country.getCountryName());
//                if (country.getCapital() != null ) {
//                    System.out.println(country.getCapital().getCapitalName());
//                } else {
//                    System.out.println(country.getCapital());
//                }
//            });

//            Save Country & Capital
//            session.beginTransaction();
//
//            Capital capital1 = new Capital();
//            capital1.setCapitalName("Hà Nội");
//            session.save(capital1);
//
//            Country country1 = new Country();
//            country1.setCountryName("Việt Nam");
//            country1.setArea("Châu Á");
//            country1.setCapital(capital1);
//            session.save(country1);
//
//            session.getTransaction().commit();

//            Update
//            session.beginTransaction();
//            Query udcapital =
//                    session.createQuery("UPDATE FROM Capital SET capitalName = 'Bucking' where id = 3");
//            udcapital.executeUpdate();
//
//            Query udcountry =
//                    session.createQuery("UPDATE FROM Country SET countryName = 'Tung Của', " +
//                            "area = 'Châu Á' where id = 3");
//            udcountry.executeUpdate();
//            session.getTransaction().commit();

//            Get Country by Id
//            Country country = session.get(Country.class, 2);
//            System.out.println(country.getArea() + "-" +
//                    country.getCountryName() + "-" + country.getCapital().getCapitalName());

//            Save Category & Product
//            session.beginTransaction();
//
//            Category category1 = new Category();
//            category1.setCategoryName("Gun");
//            session.save(category1);
//
//            Product product1 = new Product();
//            product1.setProductName("Ak47");
//            product1.setCategory(category1);
//            product1.setCreateDate(LocalDateTime.now());
//            product1.setUpdateDate(LocalDateTime.now());
//            session.save(product1);
//
//            session.getTransaction().commit();

//            Update Category & Product
//            session.beginTransaction();
//            Query udCategory = session.createQuery(
//                    "UPDATE FROM Category SET categoryName = 'Dog' where id = 2");
//            udCategory.executeUpdate();
//
//            Query udProduct = session.createQuery(
//                    "update FROM Product SET productName = 'Golden' where id = 2");
//            udProduct.executeUpdate();
//            session.getTransaction().commit();

//            Get Category & Product by Id
            Category category2 = session.get(Category.class, 2);
            System.out.println(category2.getCategoryName());
            Product product2 = session.get(Product.class, 2);
            System.out.println(product2.getCategory().getCategoryName() + "-" + product2.getProductName());

        } finally {

        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Capital.class);
        configuration.addAnnotatedClass(Country.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
