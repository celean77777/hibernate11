package com.celean.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDao {

    // Добавление нового продукта
    public static void saveProduct(SessionFactory factory, Product anyProduct) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            System.out.println(anyProduct);
            session.persist(anyProduct);
            System.out.println(anyProduct);
            session.getTransaction().commit();
            System.out.println(anyProduct);
        }
    }
// Ищем продукт по id через get
    public static Product getProductById(SessionFactory factory, Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;

        }
    }
//Ищем продукт по id через find
        public static Product findProductById(SessionFactory factory, Long id) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                Product product = session.find(Product.class, id);
                session.getTransaction().commit();
                return product;
            }
        }

        // Удаляем продукт по id
         public static void deleteProduct(SessionFactory factory, Long id) {
             try (Session session = factory.getCurrentSession()) {
                 session.beginTransaction();
                 Product product = session.find(Product.class, id);
                 session.delete(product);
                 session.getTransaction().commit();
             }

    }

        // Переписываем цену выбранного продукта
        public static void updateProductPrice(SessionFactory factory, Long id, int newPrice){
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                Product product = session.get(Product.class, id);
                product.setPrice(newPrice);
                session.getTransaction().commit();
            }
        }



        public static List<Product> findAll(SessionFactory factory){
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                List<Product> productList = session.createQuery("from Product").getResultList();
                session.getTransaction().commit();
                return productList;
            }


        }



}
