package medibuddy.repository;

import medibuddy.config.HibernateUtil;
import medibuddy.entity.ActividadEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ActividadRepository {

    public void save(ActividadEntity actividad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(actividad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public ActividadEntity findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Usamos fetchGraph para cargar las colecciones N-a-N
            // Esto evita LazyInitializationException si se accede fuera de la sesión
             ActividadEntity act = session.find(ActividadEntity.class, id);
             if (act != null) {
                 act.getParticipantes().size(); // Inicializa la colección
                 act.getFundaciones().size();
                 act.getCentrosAcopio().size();
             }
             return act;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ActividadEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Actividad", ActividadEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(ActividadEntity actividad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(actividad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(ActividadEntity actividad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(actividad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}