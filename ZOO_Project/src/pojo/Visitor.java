package pojo;


public class Visitor {
	
	private String username;
	private String password;
	private String emailId;
	private String country;
	
	
	public Visitor() {
		System.out.print("visitor object created");
	}
	
	public Visitor(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public Visitor(String username,String password,String emailId, String country)
	{
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.country = country;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
