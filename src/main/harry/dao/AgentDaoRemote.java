package harry.dao;

import javax.ejb.Remote;

import harry.model.Person;
import harry.model.Address;

/**
 * Simple wrapper-IDAO interface to test basic models via JBoss.
 */
@Remote
public interface AgentDaoRemote extends IDAO {}
