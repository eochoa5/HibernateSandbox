package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Friend {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int friendshipId;
	
	@ManyToMany (mappedBy="friends")
	private Collection<Client> clients = new ArrayList<>();
	
	private int friendId;
	private Date dateFriended;
	
	public Friend(int friendId) {
		this.friendId = friendId;
		this.dateFriended = new Date();
		
	}
	
	public Friend() {
		
	}
	
	
	public Collection<Client> getClients() {
		return clients;
	}



	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}



	public int getFriendshipId() {
		return friendshipId;
	}


	public void setFriendshipId(int friendshipId) {
		this.friendshipId = friendshipId;
	}


	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public Date getDateFriended() {
		return dateFriended;
	}
	public void setDateFriended(Date dateFriended) {
		this.dateFriended = dateFriended;
	}
	
	
	

}
