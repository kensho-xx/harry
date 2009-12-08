package harry.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * Core hibernate implementation to simply
 * fast testing domain models.
 * See 'src/resources/hibernate.cfg.xml' file for connection details.
 */
public class HibernateDAO implements IDAO {
    private static String configFile = "hibernate.cfg.xml";
    private static SessionFactory sessionFactory;

    public static void setUpConfigFile(String pathToFile){
        if (sessionFactory == null)
            configFile = pathToFile;
    }

    private static final Logger logger = Logger.getAnonymousLogger();
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    protected static Session getSession(){
        Session session = (Session)HibernateDAO.threadLocal.get();
        if(session == null){
            if( sessionFactory == null )
                sessionFactory = new AnnotationConfiguration()
		    .configure(configFile)
		    .buildSessionFactory();
            session = sessionFactory.openSession();
            HibernateDAO.threadLocal.set(session);
        }
        return session;
    }

    protected void begin(){
        getSession().beginTransaction();
    }

    protected void commit(){
        getSession().getTransaction().commit();
    }

    protected void rollback(){
        try{
            getSession().getTransaction().rollback();
        }catch(HibernateException he){
            logger.log(Level.WARNING, "Cannot rollback", he);
        }
        try{
            getSession().close();
        }catch(HibernateException he){
            logger.log(Level.WARNING, "Cannot close", he);
        }
        HibernateDAO.threadLocal.set(null);
    }

    public void close(){
        getSession().close();
        HibernateDAO.threadLocal.set(null);
    }

    public void save(Object domainObject){
	this.begin();
	HibernateDAO.getSession().save(domainObject);
	this.commit();
    }

    public <T> T find(Class<T> clazz, Serializable pk){
	return (T)HibernateDAO.getSession().get(clazz, pk);
    }

    public void saveOrUpdate(Object modelObject){
	this.begin();
	HibernateDAO.getSession().saveOrUpdate(modelObject);
	this.commit();
    }

    public void delete(Object modelObject){
	this.begin();
	HibernateDAO.getSession().delete(modelObject);
	this.commit();	
    }
}
