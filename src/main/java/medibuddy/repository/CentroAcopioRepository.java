package medibuddy.repository;

import medibuddy.config.HibernateUtil;
import medibuddy.entity.CentroAcopio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CentroAcopioRepository {

    public void save(CentroAcopio centroAcopio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(centroAcopio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public CentroAcopio findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(CentroAcopio.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CentroAcopio> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM CentroAcopio", CentroAcopio.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(CentroAcopio centroAcopio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(centroAcopio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(CentroAcopio centroAcopio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(centroAcopio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}