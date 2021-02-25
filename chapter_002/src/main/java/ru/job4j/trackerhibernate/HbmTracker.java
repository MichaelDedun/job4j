package ru.job4j.trackerhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public static void main(String[] args) {
        HbmTracker hbmTracker = new HbmTracker();
        hbmTracker.add(new Item("asdfasdf"));
        hbmTracker.add(new Item("nevazna"));
        System.out.println(hbmTracker.findByName("nevazna"));
    }


    @Override
    public Item add(Item item) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            return item;
        }
    }

    @Override
    public boolean replace(Integer id, Item item) {
        try (Session session = sf.getCurrentSession()) {
            Item result = session.get(Item.class, id);
            if (result != null) {
                result.setName(item.getName());
                session.beginTransaction();
                session.save(result);
                session.getTransaction().commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Session session = sf.getCurrentSession()) {
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.beginTransaction();
                session.delete(item);
                session.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            List result = session.createQuery("from ru.job4j.trackerhibernate.Item").list();
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try(Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            List result = session.createNamedQuery("from ru.job4j.trackerhibernate.Item as i where i.name = :n")
                    .setParameter("n", key)
                    .getResultList();
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public Item findById(Integer id) {
        try(Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Item result = (Item) session.createQuery("from ru.job4j.tracker.Item as i where i.id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

}
