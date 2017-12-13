import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import models.Client;
import models.Friend;

public class HibernateDriver {

	public static void main(String[] args) {
		Client client1 = new Client("Edwin", "Ochoa");
		Client client2 = new Client("Goku", "Supersaiyan");
		Client client3 = new Client("Mark", "Zuckerberg");
		Client client4 = new Client("Arnold", "Schwarzenegger");
		
		Friend edwinAsFriend = new Friend(1);
		Friend gokuAsFriend = new Friend(2);
		Friend markAsFriend = new Friend(3);
		Friend arnoldAsFriend = new Friend(4);
		
		client1.addFriend(gokuAsFriend);
		client1.addFriend(arnoldAsFriend);
		
		client2.addFriend(markAsFriend);
		client2.addFriend(arnoldAsFriend);
		
		client3.addFriend(edwinAsFriend);
		client3.addFriend(arnoldAsFriend);
		
		client4.addFriend(gokuAsFriend);
		client4.addFriend(edwinAsFriend);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction trans = null;
		
		try {
			trans = session.beginTransaction();
			
			session.persist(client1);
			session.persist(client2);
			session.persist(client3);
			session.persist(client4);
			
			//session.save(edwinAsFriend);
			//session.save(gokuAsFriend);
			//session.save(arnoldAsFriend);
			//session.save(markAsFriend);
			
	
			trans.commit();
			
		}catch(Exception e) {
			if (trans != null) trans.rollback();
			   e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		
		

	}

}
