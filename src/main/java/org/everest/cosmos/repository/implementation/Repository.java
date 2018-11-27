package org.everest.cosmos.repository.implementation;

import org.everest.cosmos.repository.contract.IRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public abstract class Repository<T,ID> implements IRepository<T,ID> {

    protected SessionFactory sessionFactory;
    protected Class<T> type;

    public Repository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        type = (Class<T>) ((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];

        if(type == null) {

            throw new NullPointerException("Cette couche ne possède pas de classe d'accès au donné");
        }

    }
    @Override
    public ArrayList<T> List() {

        ArrayList<T> list = new ArrayList<T>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Query query = session.createQuery("select t from "+ type.getSimpleName() + " t");
            list = (ArrayList<T>) query.getResultList();
            session.getTransaction().commit();

        }catch (Exception e) {

            session.getTransaction().rollback();

            throw new RuntimeException("Erreur lors de la géneration de la liste",e);

        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public T FindById(ID id) {

        Session session = sessionFactory.openSession();
        session.getTransaction();
        T t;

        try {

            session.beginTransaction();
            t = session.find(type,id);
            session.getTransaction().commit();

        }catch (Exception e) {

            session.getTransaction().rollback();
            throw new RuntimeException("Erreur lors de la récherche de l'entite "
                    + type.getSimpleName().toLowerCase()+ "id : "+ id
                    ,e);
        }finally {
            session.close();
        }
        return t;
    }

    @Override
    public T Save(T obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction();

        try {

            session.beginTransaction();

            session.save(obj);

            session.getTransaction().commit();

        }catch (Exception e){

            session.getTransaction().rollback();

            throw new RuntimeException("Erreur lors de la sauvegarde de l\'objet "
                    + type.getSimpleName().toLowerCase()
                    ,e);

        }finally {
            session.close();
        }
        return obj;
    }

    @Override
    public T Update(T obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction();

        try {
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        }catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise a jour de l\'obje "
                    + type.getSimpleName().toLowerCase()
                    ,e);
        }

        return obj;
    }

    @Override
    public void Delete(T obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction();

        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        }catch (Exception e) {
            throw new RuntimeException("Erreur lors de la supression de  l\'obje "
                    + type.getSimpleName().toLowerCase()
                    ,e);
        }
    }
}
