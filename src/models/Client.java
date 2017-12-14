package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Clients")
public class Client {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int clientId;
	
	private String first, last;
	private Date joinDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Friend> friends = new ArrayList<>();
	
	public Client() {}
	
	public Client(String first, String last) {
		this.first = first;
		this.last = last;
		this.joinDate= new Date();
			
	}
	
	public void addFriend(Friend f) {
		this.friends.add(f);
		f.getClients().add(this);
		
	}

	

	public Collection<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Collection<Friend> friends) {
		this.friends = friends;
	}



	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
