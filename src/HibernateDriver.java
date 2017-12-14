import java.util.ArrayList;
import java.util.List;

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
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction trans = null;
		
		try {
			trans = session.beginTransaction();
			
			session.save(client1);
			session.save(client2);
			session.save(client3);
			session.save(client4);
			
			Friend edwinAsFriend = new Friend(client1.getClientId());
			Friend gokuAsFriend = new Friend(client2.getClientId());
			Friend markAsFriend = new Friend(client3.getClientId());
			Friend arnoldAsFriend = new Friend(client4.getClientId());
			
			client1.addFriend(gokuAsFriend);
			client1.addFriend(arnoldAsFriend);
			
			client2.addFriend(markAsFriend);
			client2.addFriend(arnoldAsFriend);
			
			client3.addFriend(edwinAsFriend);
			client3.addFriend(arnoldAsFriend);
			
			client4.addFriend(gokuAsFriend);
			client4.addFriend(edwinAsFriend);
			
			session.save(client1);
			session.save(client2);
			session.save(client3);
			session.save(client4);
			
			trans.commit();
			
		}catch(Exception e) {
			if (trans != null) trans.rollback();
			   e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		
		retrieveData(sessionFactory);
		
		
		
	}
	
	public static void retrieveData(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		Transaction trans = null;
		
		try {
			trans = session.beginTransaction();
			
			Client c = (Client) session.get(Client.class, 1);
			
			System.out.println("\n\n\n\n" + c.getFirst() + ", "+ c.getLast());
			
			System.out.println("Friends: ");
			
			for(Friend f: c.getFriends()) {
				Client c1 = (Client) session.get(Client.class, f.getFriendId());
				
				System.out.println(c1.getFirst() + ", " + c1.getLast());
			}
			
			
			
		}catch(Exception e) {
			if (trans != null) trans.rollback();
			   e.printStackTrace();
			
		}finally {
			session.close();
		}
		
	}

}
