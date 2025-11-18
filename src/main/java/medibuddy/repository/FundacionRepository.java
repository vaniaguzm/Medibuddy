package medibuddy.repository;

import medibuddy.config.HibernateUtil;
import medibuddy.entity.FundacionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class FundacionRepository {

    public void save(FundacionEntity fundacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(fundacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public FundacionEntity findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(FundacionEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<FundacionEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Fundacion", FundacionEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(FundacionEntity fundacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(fundacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(FundacionEntity fundacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(fundacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}