package spring_MVC;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	
	private String firstName;
	
	@NotNull(message="is requiered")
	@Size(min=1,message="Is requiered")
	private String lastName;
	
	@NotNull(message="is requiered")
	@Min(value=0,message="min is 0")
	@Max(value=10,message="max is 10")
	private Integer freePass;
	//gebruik Integer ipv in omdat je dan de NotNull validatie kan gebruiken is een wrapperclass voor int
	
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 char/digits")
	private String postalCode;
	
	
	
	public Customer() {
		
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

	public Integer getFreePass() {
		return freePass;
	}

	public void setFreePass(Integer freePass) {
		this.freePass = freePass;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
