package harry.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import harry.model.Person;
import harry.model.Address;

/**
 * Stupid 'AgentDaoRemote' implementation based on
 * Basic 'JBossDAO' class.
 */
@Stateless
public class AgentDaoBean extends JBossDAO implements AgentDaoRemote {}
