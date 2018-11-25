package data;

public class FinalizedRequirementsGateway {

	String idRequirement;
	String idUser;
	
	public FinalizedRequirementsGateway (String idRequirement, String idUser) {
		this.idRequirement = idRequirement;
		this.idUser = idUser;
		
	}
	
	//getters
	public String getIdRequirement() {
		return idRequirement;
	}
	
	public String getIdUser() {
		return idUser;
	}
	
	//setters
	public void setIdRequirement(String idRequirement) {
		this.idRequirement = idRequirement;
	}
	
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	//write
	public void write() {
		System.out.println("ID REQUIREMENT: " + idRequirement + " ID USER: " + idUser);
	}
	
}
