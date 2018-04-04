package com.ys.po;

public class Orders {

	private int id;
	private int userId;
	private String number;
	
	private User user;
	
	 public int getId() {
	        return id;
	    }
	 
	 
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public int getUserId() {
	        return userId;
	    }
	 
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	 
	    public String getNumber() {
	        return number;
	    }
	 
	    public void setNumber(String number) {
	        this.number = number;
	    }
	 
	    public User getUser() {
	        return user;
	    }
	 
	    public void setUser(User user) {
	        this.user = user;
	    }
	 
	    @Override
	    public String toString() {
	        return "Orders [id=" + id + ", userId=" + userId + ", number=" + number
	                + ", user=" + user + "]";
	    }
}
