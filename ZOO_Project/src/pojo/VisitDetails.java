package pojo;

import java.sql.Date;

public class VisitDetails {
	
	private int visitId;
	private Date visitTime;
	private String animalName;
	private int amount;
	
	public VisitDetails(int visitId, Date visitTime, String animalName, int amount) {
		this.visitId = visitId;
		this.visitTime = visitTime;
		this.animalName = animalName;
		this.amount = amount;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
