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

    public void update(Actividad actividad) {
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
    
    public List<Actividad> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Usamos LEFT JOIN FETCH para traer la lista de participantes en la misma consulta
            // DISTINCT evita duplicados si hay muchos participantes
            String hql = "SELECT DISTINCT a FROM Actividad a LEFT JOIN FETCH a.participantes";
            return session.createQuery(hql, Actividad.class).list();
        }
    }

    public Actividad findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // También aquí es útil traer los participantes si vas a mostrar el cupo individualmente
            String hql = "SELECT a FROM Actividad a LEFT JOIN FETCH a.participantes WHERE a.idActividad = :id";
            return session.createQuery(hql, Actividad.class)
                          .setParameter("id", id)
                          .uniqueResult();
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
