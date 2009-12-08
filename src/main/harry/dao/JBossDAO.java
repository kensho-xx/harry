package harry.dao;

import java.util.List;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import harry.model.Person;
import harry.model.Address;


/**
 * Core JBoss DAO implementation.
 * Not tested yet (no method only - for creation).
 */
public class JBossDAO implements IDAO {

    @PersistenceUnit(unitName="harry") 
    private EntityManagerFactory factory;

    @PersistenceContext(unitName="harry")
    private EntityManager manager;

    public void save(Object person) {
	manager.persist(person);
	manager.flush();
    }

    public void saveOrUpdate(Object person) {
	manager.persist(person);
	manager.flush();
    }

    public void delete(Object domainObject){
	manager.remove(domainObject);
    }

    public <T> T find(Class<T> clazz, Serializable pk){
	return (T) manager.find(clazz, pk);
    }
}
