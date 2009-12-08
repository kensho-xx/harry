package harry.dao;

import java.io.Serializable;

/**
 * Abstract interface for all DAO object.
 * Defines basic operations on domain objects.
 */
public interface IDAO {
    /**
     * Save domain object.
     */
    public void save(Object domainObject);

    /**
     * Save or updates domain object.
     */
    public void saveOrUpdate(Object domainObject);

    /**
     * Completely removes domain object from DB.
     */    
    public void delete(Object domainObject);

    /**
     * Find's specific domain object with given
     * primary key.
     */
    public <T> T find(Class<T> clazz, Serializable pk);
}
