package data;


public class UserGateway {

	String id;
	String name;
	String password;
	
	String id_profile;
	
	//constructors
	public UserGateway (String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	//getters
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	//setters
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	

	//write
	public void Write() {
		System.out.println("ID: " + this.id + " NAME: " + name + " PASS: " + password);
	}
	
	//add
	public void add() {
		
	}
	
}
