package com.celean.crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryInit {
    public static SessionFactory init() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        return factory;
    }
}
