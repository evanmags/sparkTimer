package sparkTimer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import java.lang.reflect.Type;
import java.util.List;

public abstract class CrudDao<T> {
    protected EntityManagerFactory entityManagerFactory;
    protected String entityTypeName;
    protected Class entityClass;

    public CrudDao(EntityManagerFactory emf, Type entityType) {
        this.entityManagerFactory = emf;
        this.entityTypeName = entityType.getTypeName();
        try {
            this.entityClass = Class.forName(this.entityTypeName);
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
            System.exit(1);
        }
    }

    public EntityManager getEntityManager() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        return entityManager;
    }

    public void returnEntityManager(EntityManager entityManager) throws RollbackException {
        EntityTransaction transaction = entityManager.getTransaction();
        if(transaction.isActive()) {
            transaction.commit();
        }
        entityManager.close();
    }

    public List<T> get() {
        EntityManager entityManager = getEntityManager();
        List meetList = entityManager.createQuery(
                String.format("from %s", entityTypeName), entityClass
        ).getResultList();
        returnEntityManager(entityManager);

        return meetList;
    }

    public T get(int id) {
        EntityManager entityManager = getEntityManager();
        T meet = (T) entityManager.find(entityClass, id);
        returnEntityManager(entityManager);

        return meet;
    }

    public T create(T newInstance) {
        EntityManager entityManager = getEntityManager();
        entityManager.persist(newInstance);
        returnEntityManager(entityManager);

        return newInstance;
    }

    public T update(T mergeInstance) {
        EntityManager entityManager = getEntityManager();
        T merged = entityManager.merge(mergeInstance);
        returnEntityManager(entityManager);

        return merged;
    }

    public void delete(T deleteInstance) {
        EntityManager entityManager = getEntityManager();
        entityManager.remove(entityManager.contains(deleteInstance) ? deleteInstance : entityManager.merge(deleteInstance));
        returnEntityManager(entityManager);
    }

}

