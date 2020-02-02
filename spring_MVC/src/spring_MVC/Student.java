package spring_MVC;

import java.util.LinkedHashMap;

/**
 * @author Cathie
 *
 */
public class Student {
	
	private String firstName;

	private String lastName;
	private String country;
	private LinkedHashMap<String,String> countries;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	public Student(){
		
		countries= new LinkedHashMap<>();
		countries.put("br","br");
		countries.put("brd","bbb");
		countries.put("brde","bbbb");
		countries.put("brerw","bbbbb");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}


	
	

}
