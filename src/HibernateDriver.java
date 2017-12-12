import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import models.Client;

public class HibernateDriver {

	public static void main(String[] args) {
		Client client1 = new Client(1, "Edwin1", "Ochoa");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction trans = null;
		
		try {
			trans = session.beginTransaction();
			session.save(client1);
			trans.commit();
			
		}catch(Exception e) {
			if (trans != null) trans.rollback();
			   e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		
		

	}

}
