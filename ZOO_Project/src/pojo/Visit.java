package pojo;

import java.util.ArrayList;

public class Visit {
	
	private int userId;
	private ArrayList<Integer> animalIds = new ArrayList<>();
	
	public Visit() {
		System.out.println("Visit object created");
	}
	
	public Visit(int userId)
	{
		this.userId = userId;
	}
	
	public Visit(int userId, ArrayList<Integer> animalIds)
	{
		this.userId = userId;
		this.animalIds = animalIds;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}
	
	public ArrayList<Integer> getanimalIds() {
		return animalIds;
	}
	
	public void setanimalIds(ArrayList<Integer> animalIds) {
		this.animalIds = animalIds;
	}
}
	
	