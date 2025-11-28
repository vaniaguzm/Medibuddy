package medibuddy.repository;

import medibuddy.model.Fundacion;
import medibuddy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class FundacionRepository {

    
    // 1. Guardar una nueva fundación
    public void save(Fundacion fundacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(fundacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    // 2. Listar todas las fundaciones
    public List<Fundacion> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Fundacion", Fundacion.class).list();
        }
    }

    public Fundacion findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Hibernate traerá las actividades asociadas cuando se accedan (Lazy Loading)
            // o inmediatamente si configuraste EAGER.
            return session.get(Fundacion.class, id);
        }
    }

    public void update(Fundacion fundacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(fundacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Fundacion fundacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(fundacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public Fundacion buscarPorIdConActividades(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // LEFT JOIN FETCH carga la lista 'actividades' en la misma consulta
            String hql = "SELECT f FROM Fundacion f LEFT JOIN FETCH f.actividades WHERE f.id = :id";
            return session.createQuery(hql, Fundacion.class)
                        .setParameter("id", id)
                        .uniqueResult();
        }
    }
}