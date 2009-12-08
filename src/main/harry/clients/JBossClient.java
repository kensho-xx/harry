package harry.clients;

import harry.dao.IDAO;
import harry.model.Person;
import harry.model.Address;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;


public class JBossClient {
    public static void main(String [] args) throws Exception{
	JBossClient.testCreatingPerson();
    }

    static void testFindingPerson() {
	IDAO dao = JBossClient.getDao();
	System.out.println(dao.find(Person.class, 1L));
    }

    static void testCreatingPerson() {
	IDAO dao = JBossClient.getDao();

	// Creating Person and Address
	Address address = new Address();
	address.setStreet("Gorska");
	address.setNumber("79 d");
	address.setCity("Bielsko-Biala");
	address.setPostalCode("34-324");

	Person person = new Person();
	person.setAddress(address);
	person.setName("Kuba");
	person.setLastName("Janoszek");
	person.setTelephone("661 746 173");
	person.setEmail("kuba.janoszek@gmail.com");

	// cheking.... =>
	System.out.println("Before person creation   ============ ");
	dao.saveOrUpdate(person);
	System.out.println("After person creation    ============ ");
    }

    static IDAO getDao() {
	try{
	    return (IDAO)(new javax.naming.InitialContext())
		.lookup("AgentDaoBean/remote");
	}
	catch(Exception e){
	    e.printStackTrace();
	    System.exit(1);
	}
	return null;
    }
}
