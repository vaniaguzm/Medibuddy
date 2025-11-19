package medibuddy.repository;

import medibuddy.model.Actividad;
import medibuddy.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ActividadRepository {
public void save(Actividad actividad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(actividad);
            transaction.commit(); // Asegúrate de hacer commit antes de cerrar la sesión
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback en caso de error
            }
            e.printStackTrace();
        }
    }

    public List<Actividad> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Actividad", Actividad.class).list();
        }
    }

    public Actividad findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Actividad.class, id);
        }
    }

    public void delete(Actividad actividad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(actividad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
