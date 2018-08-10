package com.foriba.library;

import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BaseRepository<E> {

    private final static String SELECT="select %s from %s as %s";
    private static EntityManagerFactory entityManagerFactory;
    protected final Class<E> entityClass;
    protected final EntityManager entityManager;
    
    public BaseRepository(Class<E> entityClass){
        this.entityClass=entityClass;
        entityManager=getEntityManagerFactory().createEntityManager();
    }
    public void close(){
        entityManager.close();
    }
    public void persist(E entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }
    public void merge(E entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
    public void remove(long entityId){
        E entity=entityManager.find(entityClass, entityId);
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
    public E find(long entityId){
        return entityManager.find(entityClass, entityId);
    }
    protected String createSelectJpql(){
        String entityName=entityClass.getSimpleName();
        String variableName=entityName.toLowerCase(Locale.US);
        return String.format(SELECT, variableName,entityName,variableName);
    }
    public List<E> list(){
        String jpql=createSelectJpql();
        Query query=entityManager.createQuery(jpql);
        return query.getResultList();
    }
    private static EntityManagerFactory getEntityManagerFactory(){  
        if(entityManagerFactory==null){
            entityManagerFactory= Persistence
                    .createEntityManagerFactory("EczaneOtomasyonuPU");
        }
        return entityManagerFactory;
    }

}
