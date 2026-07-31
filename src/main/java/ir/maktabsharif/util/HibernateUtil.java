package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class HibernateUtil {
    private static final String PERSISTENCE_UNIT = "course-unit";

    private static EntityManagerFactory emf;

    private static EntityManagerFactory getEmf(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static EntityManager em(){
        return getEmf().createEntityManager();
    }

    public static <T> T inTxResult(Function<EntityManager,T> operation){
        EntityTransaction tx = em().getTransaction();
        try {
            tx.begin();
            T result = operation.apply(em());
            tx.commit();
            return result;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

//    public static void inTxResult(Function<EntityManager, Object> operation) {
//        EntityTransaction tx = em().getTransaction();
//        try {
//            tx.begin();
//            operation.apply(em());
//            tx.commit();
//        } catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//    }
}
