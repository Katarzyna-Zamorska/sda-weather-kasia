package com.sda.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationRepositoryImp implements LocationRepository {

    private final SessionFactory sessionFactory;

    public LocationRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location createLocation(Location location) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);
        transaction.commit();
        session.close();

        return location;
    }
}
