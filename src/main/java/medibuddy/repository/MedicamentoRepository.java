package medibuddy.repository;

import medibuddy.config.HibernateUtil;
import medibuddy.entity.MedicamentoEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MedicamentoRepository {

    public void save(MedicamentoEntity medicamento) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(medicamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public MedicamentoEntity findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(MedicamentoEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MedicamentoEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Medicamento", MedicamentoEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(MedicamentoEntity medicamento) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(medicamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(MedicamentoEntity medicamento) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(medicamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}