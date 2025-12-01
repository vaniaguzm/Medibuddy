package medibuddy.repository;

import medibuddy.model.AdultoMayor;
import medibuddy.util.HibernateUtil;
import org.hibernate.Hibernate; // Importante: Necesario para inicializar listas
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AdultoMayorRepository {

    public void save(AdultoMayor adultoMayor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(adultoMayor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<AdultoMayor> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Aquí solo traemos medicamentos con fetch. No traemos actividades para evitar conflicto.
            // Si necesitaras actividades en la tabla principal, habría que usar initialize() también, 
            // pero para el listado general suele bastar con los datos básicos.
            String hql = "SELECT DISTINCT a FROM AdultoMayor a LEFT JOIN FETCH a.medicamentos";
            return session.createQuery(hql, AdultoMayor.class).list();
        }
    }

    // --- MÉTODO CORREGIDO ---
    public AdultoMayor findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // 1. Buscamos al adulto. 
            // Nota: 'medicamentos' se carga solo porque en tu modelo lo pusiste como EAGER.
            AdultoMayor adulto = session.get(AdultoMayor.class, id);
            
            // 2. Inicializamos MANUALMENTE la lista de actividades
            // Esto obliga a Hibernate a hacer una segunda consulta segura para traer las actividades
            // mientras la sesión sigue abierta.
            if (adulto != null) {
                Hibernate.initialize(adulto.getActividadesInscritas());
            }
            
            return adulto;
        }
    }

    public void update(AdultoMayor adultoMayor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(adultoMayor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(AdultoMayor adultoMayor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Limpieza manual de tablas intermedias para evitar errores de FK
            session.createNativeQuery("DELETE FROM inscripciones WHERE adulto_id = :id", Integer.class)
                    .setParameter("id", adultoMayor.getIdUsuario())
                    .executeUpdate();

            session.createNativeQuery("DELETE FROM adulto_medicamento WHERE adulto_id = :id", Integer.class)
                    .setParameter("id", adultoMayor.getIdUsuario())
                    .executeUpdate();

            session.remove(adultoMayor);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}